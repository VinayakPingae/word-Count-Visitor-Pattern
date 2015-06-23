/**
 * 
 */
package wordCount.treesForStrings;

import wordCount.visitors.Visitor;
/**
 * Description - This is the Fileword info support interface which is used to perform the operations related to the data structure.
 * @author Vinayak Subhash Pingale
 * @since April 18th 2015
 * @version 1.0
*/
public interface FileWordInfoSupport {
	/**
	 * Description - this is the most important function of the data structure which is used to insert the data in the tree data structure,
	 * it accepts the string that has been passed from the PopulateTreeVisitor class
	 * @param wordFromFile
	 */
	public void insert(String wordFromFile);
	/**
	 * Description- the total words that has been used for performing the task of finding out the total counts required for the operations
	 * @return integer count for the total number of words that has been used.
	 */
	public int totalWordsFile();
	/**
	 * Description - This method is called by total words count to perform the operations
	 * @param NodeData
	 * @return integer count for the total number of words that has been used.
	 */
	public int totalWords(NodeData NodeData);
	/**
	 * Description- the total unique words that has been used for performing the task of finding out the total counts required for the operations
	 * @return integer count for the total number of words that has been used.
	 */
	public int totalUniqueWords();
	/**
	 * Description - This method is called by total unique words count to perform the operations
	 * @param NodeData
	 * @return integer count for the total number of words that has been used.
	 */
	
	public int totalUniqueWordsforNodes(NodeData NodeData);
	/**
	 * Description- the total characters that has been used for performing the task of finding out the total counts required for the operations
	 * @return integer count for the total number of words that has been used.
	 */
	public int totalCharacters();
	/**
	 * Description - This method is called by total characters count to perform the operations
	 * @param NodeData
	 * @return integer count for the total number of words that has been used.
	 */
	
	public int totalCharactersForNodes(NodeData NodeData);
	/**
	 * Description - Accept method that has been used by the visitor pattern
	 * @param visitor
	 */
	public void accept(Visitor visitor);
	
	public static int WORD = 1;
}
