/**
 * 
 */
package wordCount.visitors;
/**
 * Description - Visitor that determines the total number of words, total number of unique words, and characters in the tree
 * @author Vinayak Subhash Pingale
 * @since 18th April 2015
 * @version 1.0
 *
 */
public interface WordCountVisitorSupport {
	/**
	 * This method is used for getting the total words from the tree data structure and print them in the file.
	 * @return integer
	 */
	public int getTotalWords();
	/**
	 * This method is used for getting the total unique words from the tree data structure and print them in the file.
	 * @return integer
	 */
	public int getTotalUniqueWords();
	/**
	 * This method is used for getting the total characters from the tree data structure and print them in the file.
	 * @return integer
	 */
	public int getTotalCharacters();
}
