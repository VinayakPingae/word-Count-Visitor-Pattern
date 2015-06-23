/**
 * 
 */
package wordCount.visitors;

import wordCount.treesForStrings.FileWordInfoSupport;
import wordCount.util.FileProcessorSupport;
import wordCount.util.LoggerDebug;
/**
 * Description - Visitor that determines the total number of words, total number of unique words, and characters in the tree
 * @author Vinayak Subhash Pingale
 * @since 18th April 2015
 * @version 1.0
 *
 */
public class WordCountVisitor implements Visitor, WordCountVisitorSupport {

	private FileWordInfoSupport fileWordInfoSupport = null;
	private FileProcessorSupport fileProcessorSupport = null;
	private StringBuilder contenStringBuilder = null;
	private LoggerDebug logger = null;
	public WordCountVisitor(FileProcessorSupport fileProcessorSupport_In) {
		this.fileProcessorSupport = fileProcessorSupport_In;
		this.contenStringBuilder = new StringBuilder();
		this.logger = LoggerDebug.getInstance();
		this.logger.printToStdout(1, "Method has been consturcted");
	}
	/* (non-Javadoc)
	 * @see wordCount.visitors.Visitor#visit(wordCount.treesForStrings.FileWordInfoSupport)
	 */
	/**
	 * This is the visit method which will be called for performing the visit operations called by different visitors
	 * @param fileWordInfoSupport
	 */
	
	@Override
	public void visit(FileWordInfoSupport fileWordInfoSupport_In) {
		this.setFileWordInfoSupport(fileWordInfoSupport_In);
		this.getContenStringBuilder().append("Total Words: "+this.getTotalWords()+System.getProperty("line.separator")+"Total Unique Words: "
				+ ""+this.getTotalUniqueWords()+System.getProperty("line.separator")+"Total Characters: "+this.getTotalCharacters()+System.getProperty("line.separator"));
		//this.logger.printToStdout(1, this.getContenStringBuilder().toString());
		this.fileProcessorSupport.openForWriting();
		this.fileProcessorSupport.writeToFile(this.getContenStringBuilder().toString());
		this.fileProcessorSupport.getFileHandleWriterandClose();
		
	}

	/* (non-Javadoc)
	 * @see wordCount.visitors.WordCountVisitorSupport#getTotalWords()
	 */
	/**
	 * This method is used for getting the total words from the tree data structure and print them in the file.
	 * @return integer
	 */
	
	@Override
	public int getTotalWords() {
		//logger.printToStdout(3, "Called getTotalWords method");
		return this.getFileWordInfoSupport().totalWordsFile();
	}

	/* (non-Javadoc)
	 * @see wordCount.visitors.WordCountVisitorSupport#getTotalUniqueWords()
	 */
	/**
	 * This method is used for getting the total unique words from the tree data structure and print them in the file.
	 * @return integer
	 */
	
	@Override
	public int getTotalUniqueWords() {
		//logger.printToStdout(3, "Called getTotalUniqueWords method");
		return this.getFileWordInfoSupport().totalUniqueWords();
	}

	/* (non-Javadoc)
	 * @see wordCount.visitors.WordCountVisitorSupport#getTotalCharacters()
	 */
	/**
	 * This method is used for getting the total characters from the tree data structure and print them in the file.
	 * @return integer
	 */
	
	@Override
	public int getTotalCharacters() {
		//logger.printToStdout(3, "Called getTotalCharacters method");
		return this.getFileWordInfoSupport().totalCharacters();
	}

	public FileWordInfoSupport getFileWordInfoSupport() {
		return fileWordInfoSupport;
	}

	public void setFileWordInfoSupport(FileWordInfoSupport fileWordInfoSupport) {
		this.fileWordInfoSupport = fileWordInfoSupport;
	}
	public StringBuilder getContenStringBuilder() {
		return contenStringBuilder;
	}
	public void setContenStringBuilder(StringBuilder contenStringBuilder) {
		this.contenStringBuilder = contenStringBuilder;
	}

}
