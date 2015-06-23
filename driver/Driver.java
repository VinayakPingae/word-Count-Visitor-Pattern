package wordCount.driver;

import wordCount.treesForStrings.FileWordInfo;
import wordCount.treesForStrings.FileWordInfoSupport;
import wordCount.util.FileProcessor;
import wordCount.util.FileProcessorSupport;
import wordCount.util.LoggerDebug;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCountVisitor;

/**
 * Descritpion - Holds the driver code</h1> The following should be read from command
 * line: input file name, output file name, and the value of NUM_ITERATIONS.,
 * The starting function of the program
 * <p>
 * 
 * @author Vinayak Subhash Pingale
 * @version 1.0
 * @since 04-02-2015
 */

public class Driver {

	/**
	 * The program will start from here.The command line argument will help the
	 * user to determine the input file entered and the output achieved , in
	 * addition to the debug value
	 * 
	 * @return Nothing.
	 */

	public static void main(String[] args) {

		String fileNameInput = null;
		String fileNameOutput = null;
		if (args.length != 4) {
			System.err
					.println("Please provide the command line arguments in build.xml properly. \n");
			System.exit(1);
		}
		try {
			if (args[0] == null || args[1] == null) {
				throw new NullPointerException(
						"The Value entered for Argument 0/1 is null or it is Empty");
			} else {
				if (args[0].endsWith(".txt")) {
					fileNameInput = args[0];
				} else {
					System.err
							.println("The value entered should end with .txt for the Input file name provided");
					System.exit(1);
				}
				if (args[1].endsWith(".txt")) {
					fileNameOutput = args[1];
				} else {
					System.err
							.println("The value entered should end with .txt for the Output file name provided");
					System.exit(1);
				}
				int debugValue = Integer.parseInt(args[3]);
				if (debugValue > 4) {
					System.err
							.println("The value entered is greater than expected debug value");
					System.exit(1);
				} else {
					LoggerDebug.setDEBUG_VALUE(Integer.parseInt(args[3]));
				}
			}
		} catch (NullPointerException ex) {
			System.err.println("Usage:" + ex.getMessage());
			System.exit(1);
		} catch (NumberFormatException ex) {
			System.err
					.println("Usage: The value entered is not of Integer type : Debug value only accepts integer value");
			System.exit(1);
		}
		int i = 0;
		int Num_Iterations = Integer.parseInt(args[2]);
		long startTime = System.currentTimeMillis();
		while (i != Num_Iterations) {
			FileProcessorSupport fileProcessorSupport = new FileProcessor(
					fileNameInput, fileNameOutput);
			FileWordInfoSupport fileWordInfoSupport = new FileWordInfo();
			Visitor populateTreeVisitor = new PopulateTreeVisitor(
					fileProcessorSupport);
			Visitor wordCountVisitor = new WordCountVisitor(
					fileProcessorSupport);
			fileWordInfoSupport.accept(populateTreeVisitor);
			fileWordInfoSupport.accept(wordCountVisitor);
			i++;
		}
		long endTime = System.currentTimeMillis();
		long time2 = (endTime - startTime)/(Num_Iterations);
		System.out.printf("Took %.3f seconds to read and insert", time2/1e3);

	}
}
