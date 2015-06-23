/**
 * 
 */
package wordCount.treesForStrings;
/**
 * Description - This class has been used for performing operations related to the node data that has been inserted into the tree
 * @author Vinayak Subhash Pingale
 * @since April 18th 2015
 * @version - 1.0
 */
class NodeData{
	
	String word;
	int noOfWord;
	int noOfChar;
	NodeData leftChild;
	NodeData rightChild;
	
	public NodeData(String inPutKey){
		this.word = inPutKey.toString();
		this.noOfWord = 1;
		this.noOfChar = (inPutKey.toString().length());
		this.leftChild = null;
		this.rightChild = null;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getNoOfWord() {
		return noOfWord;
	}

	public void setNoOfWord(int noOfWord) {
		this.noOfWord = noOfWord;
	}

	public NodeData getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeData leftChild) {
		this.leftChild = leftChild;
	}

	public NodeData getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeData rightChild) {
		this.rightChild = rightChild;
	}

	public int getNoOfChar() {
		return noOfChar;
	}

	public void setNoOfChar(int noOfChar) {
		this.noOfChar = noOfChar;
	}

		
}
