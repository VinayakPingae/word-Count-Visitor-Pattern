/**
 * 
 */
package wordCount.visitors;

import wordCount.treesForStrings.FileWordInfoSupport;
import wordCount.util.FileProcessorSupport;
import wordCount.util.LoggerDebug;
/**
 * Description - Visitor class that reads words from a file and populates a tree data structure
 * @author Vinayak Subhash Pingale
 * @version 1.0
 * @date 18th APril 2015
 *
 */
public class PopulateTreeVisitor implements Visitor {

	/*
	 * (non-Java doc)
	 * 
	 * @see wordCount.visitors.Visitor#visit(wordCount.treesForStrings.
	 * FileWordInfoSupport)
	 */
	private FileProcessorSupport fileProcessorSupport = null;
	private FileWordInfoSupport fileWordInfoSupport = null;
	private LoggerDebug logger = LoggerDebug.getInstance(); 
	public PopulateTreeVisitor(FileProcessorSupport fileProcessorSupport_In) {
		this.fileProcessorSupport = fileProcessorSupport_In;
		this.logger.printToStdout(1, "PopulateTreeVisitor has been consturcted");
	}
	
	/**
	 * This is the visit method which will be called for performing the visit operations called by different visitors
	 * @param fileWordInfoSupport
	 */
	
	@Override
	public void visit(FileWordInfoSupport fileWordInfoSupport) {
		//logger.printToStdout(3, "Called visit method");
		this.fileProcessorSupport.openFile();
		this.fileWordInfoSupport = fileWordInfoSupport;
		int processors = Runtime.getRuntime().availableProcessors();
		int i = 0;
		Thread thread = null;
		while (i != processors) {
			thread = new Thread(new ThreadedClass(this.fileProcessorSupport,this.fileWordInfoSupport));
			thread.start();
			i++;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.err.println("Interrupted exception has occurred while perfoming operation");
			System.exit(0);
		}

	}
}

class ThreadedClass implements Runnable {
	private String inlineString = null;
	private FileProcessorSupport fileProcessorSupport = null;
	private FileWordInfoSupport fileWordInfoSupport = null;
	public ThreadedClass(FileProcessorSupport fileProcessorSupport, FileWordInfoSupport fileWordInfoSupport) {
		this.fileProcessorSupport = fileProcessorSupport;
		this.fileWordInfoSupport = fileWordInfoSupport;
	} 
	public void run() {
		try {
			while ((this.inlineString = this.fileProcessorSupport.readFromFile()) != null) {
					this.fileWordInfoSupport.insert(this.inlineString);
			}
			return;
		} catch (Exception e) {
			System.err.println("Exception has occured while performing operation");
			System.exit(0);
		}

	}
}

