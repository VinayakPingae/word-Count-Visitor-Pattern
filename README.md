# word-Count-Visitor-Pattern

CS542 Design Patterns

Spring 2015

PROJECT ASSIGNMENT NUMBER 04 README FILE

Due Date: Friday, April 22nd.

Submission Date: Friday, April 22nd.

Author   : Vinayak Subhash Pingale

e-mail   : vpingal1@binghamton.edu

IDEA FOR PERFORMANCE IMPROVEMENT

There can be many ways you can achieve performance optimization. Here the question is not about whether you can achieve it through your data structure or data elements or data parsing.

There are various point you should remeber when optimization comes into picture, acheiving a performance boost is one of the most vital concern.

1. Reading of file - BufferedReader will take a constant amount of time of 6/7 seconds to parse 878 MB file. How can you reduce it ?

a. You can go through RandomAccessChannel API in java which has reduced it to 0.16/0.19 seconds for the same file.

b. Asynchronous File Reads on a particular file.

2. Dealing with data processing

a. using Runtime available processor API's you can get the number of processor available on your particular machine and spawn that many threads for data processing.

b. Multi threading play's a major role in achieving performance

The above mentioned are few point you can spend time on to reduce the performcance

PURPOSE

Design an develop the following 2 visitors:
A visitor that reads an input file, input.txt, and populates a tree data structure with all the words in the file. Use the tree data structure that will maximize performance for the second visitor. Store the words in the tree using the insert criteria for that tree data structure.
A visitor that counts the number of words, number of unique words, and number of characters in the tree and stores it in a file named output.txt.
The words from the input file should be stored/inserted in the tree using the tree property. So, if you use a BST, then you need to check newWord < currentNodeWord, etc.
It is acceptable to use data structure(s) within each tree node to store information about that node's content. However, you cannot use a separate data structure to keep track of the entire tree's data.


This is the implementation of the use of Data Structures and performing word count with a finesse of Visitor pattern.

JUSTIFICATION

I have used BST for inserting data into the tree as the data provided in the file is not random and hence BST has given more performance concern as compared to other trees.
I have thought of using TreeMap but it has taken more efforts while inserting the data and hence I have dropped the idea about the same. I have used multithreading for insertion in the trees and hence achieved commmendable performance reduction while doing the same.
While going through this assignment i came across the concept of Memory mapped i/o and threading .
I need a suggestion regarding the implementation of the project 4.

It seems to me as a classic example of MapReduce implementation, i have implemented similar kind of requirement in the last semester in the subject "System programming" regarding the implementation of Google Map Reduce framework in C.
What i feel is can we divide the file into virtual chunks and perform the individual operations such as building a tree, word count, character count etc on those splits on the given input file and write the intermediate results to the final file.
Is it feasible to go through this approach cause right now i have implemented a plain solution which uses visitor pattern and builds a tree and populate visitor as well as perform the word count.


