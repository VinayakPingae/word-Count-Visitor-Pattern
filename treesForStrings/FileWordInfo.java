package wordCount.treesForStrings;

import wordCount.util.LoggerDebug;
import wordCount.visitors.Visitor;

/**
 * Description - This is the File wordInfo data strcutre which works for
 * performing the file operations and consist of tree data structure to be
 * performed.
 * 
 * @author Vinayak Subhash Pingale
 * @since April 18th 2015
 * @version 1.0
 */
public class FileWordInfo implements FileWordInfoSupport {
	private NodeData root = null;
	//private LoggerDebug logger = null;
	public FileWordInfo() {
		this.root = null;
		//this.logger = LoggerDebug.getInstance();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * wordCount.treesForStrings.FileWordInfoSupport#accept(wordCount.visitors
	 * .Visitor)
	 */
	/**
	 * Description - Accept method that has been used by the visitor pattern
	 * 
	 * @param visitor
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Description - this is the most important function of the data structure
	 * which is used to insert the data in the tree data structure, it accepts
	 * the string that has been passed from the PopulateTreeVisitor class
	 * @param wordFromFile
	 */

	public void insert(String wordFromFile) {
		NodeData temp = null;
		if (this.root == null) {
			synchronized (this) {
				if (this.root == null) {
					this.root = new NodeData(wordFromFile);
					return;
				} else {
					insert(wordFromFile);
				}
			}
		} else {
			temp = this.root;
			while (wordFromFile != null) {
				if (wordFromFile.equals(temp.getWord())) {
					synchronized (this) {
						temp.setNoOfWord(temp.getNoOfWord() + FileWordInfoSupport.WORD);
						temp.setNoOfChar(temp.getNoOfChar()
								+ wordFromFile.length());
						return;
					}
				} else if (wordFromFile.compareTo(temp.getWord()) > 0) {
					if (temp.getRightChild() != null) {
						temp = temp.getRightChild();
					} else if (temp.getRightChild() == null) {
						synchronized (this) {
							if (temp.getRightChild() == null) {
								temp.rightChild = new NodeData(wordFromFile);
								return;
							} else {
								temp = temp.getRightChild();
							}
						}

					}
				} else {
					if (temp.getLeftChild() != null) {
						temp = temp.getLeftChild();
					} else if (temp.getLeftChild() == null) {
						synchronized (this) {
							if (temp.getLeftChild() == null) {
								temp.leftChild = new NodeData(wordFromFile);
								return;
							} else {
								temp = temp.getLeftChild();
							}

						}
					}
				}
			}
		}
	}

	/**
	 * Description- the total words that has been used for performing the task
	 * of finding out the total counts required for the operations
	 * 
	 * @return integer count for the total number of words that has been used.
	 */

	public int totalWordsFile() {
		if (this.root == null) {
			return 0;
		}
		return totalWords(this.root);
	}

	/**
	 * Description - This method is called by total words count to perform the
	 * operations
	 * 
	 * @param NodeData
	 * @return integer count for the total number of words that has been used.
	 */

	public int totalWords(NodeData NodeData) {
		int totalCount, leftCount, rightCount;
		if (NodeData == null) {
			return 0;
		}
		leftCount = totalWords(NodeData.getLeftChild());
		rightCount = totalWords(NodeData.getRightChild());
		totalCount = leftCount + NodeData.getNoOfWord() + rightCount;
		return totalCount;
	}

	/**
	 * Description- the total unique words that has been used for performing the
	 * task of finding out the total counts required for the operations
	 * 
	 * @return integer count for the total number of words that has been used.
	 */

	public int totalUniqueWords() {
		if (this.root == null) {
			return 0;
		}
		return totalUniqueWordsforNodes(this.root);
	}

	/**
	 * Description - This method is called by total unique words count to
	 * perform the operations
	 * 
	 * @param NodeData
	 * @return integer count for the total number of words that has been used.
	 */

	public int totalUniqueWordsforNodes(NodeData NodeData) {
		int totalCount, leftCount, rightCount;
		if (NodeData == null) {
			return 0;
		}
		leftCount = totalUniqueWordsforNodes(NodeData.getLeftChild());
		rightCount = totalUniqueWordsforNodes(NodeData.getRightChild());
		totalCount = leftCount + FileWordInfoSupport.WORD + rightCount;
		return totalCount;
	}

	/**
	 * Description- the total characters that has been used for performing the
	 * task of finding out the total counts required for the operations
	 * 
	 * @return integer count for the total number of words that has been used.
	 */

	public int totalCharacters() {
		if (this.root == null) {
			return 0;
		}
		return totalCharactersForNodes(this.root);
	}

	/**
	 * Description - This method is called by total characters count to perform
	 * the operations
	 * 
	 * @param NodeData
	 * @return integer count for the total number of words that has been used.
	 */

	public int totalCharactersForNodes(NodeData NodeData) {
		int totalCount, leftCount, rightCount;
		if (NodeData == null) {
			return 0;
		}
		leftCount = totalCharactersForNodes(NodeData.getLeftChild());
		rightCount = totalCharactersForNodes(NodeData.getRightChild());
		totalCount = leftCount + NodeData.getNoOfChar() + (rightCount);
		return totalCount;
	}

	
}