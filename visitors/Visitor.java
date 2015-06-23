/**
 * 
 */
package wordCount.visitors;

import wordCount.treesForStrings.FileWordInfoSupport;

/**
 * Description - This interface Visitor has been defined in the visitors package
 * @author Vinayak Subhash Pingale
 * @Date April 18, 2015
 * @version 1.0
 * @class Visitor.java
 */
public interface Visitor {
	/**
	 * This is the visit method which will be called for performing the visit operations called by different visitors
	 * @param fileWordInfoSupport
	 */
	public void visit(FileWordInfoSupport fileWordInfoSupport);
	
}
