Implement the IDict interface backed by a list and binary search tree. Name the list backed implementation "Dict" and the BST backed implementation "BSTree". The files "shortlist.txt" and "words_alpha.txt" should not be committed to your repository.

You should copy over your best list implementation from day 4 to use as the list in the Test program.

Files:
Test.java  - A program that reads in words and randomly searches for them
IList.java - An interface for a list implementation (matches day4)
IDict.java - An interface for dictionaries
shortlist.txt - a 50000 word list
words_alpha.txt - a 370098 word list
BinaryTree.java - A binary tree structure that BSTree is based on
BSTree.java     - A binary search tree based dictionary
Dict.java  - A linear dictionary based on doubly linked list
DictItem.java   - Dictionary cells for Dict.java
DLink.java - Link cells for DoubleLinkList.java
DoubleLinkList.java  - A doubly linked list for Dict.java to be based on
IDLink.java     - An interface for DLink.java
Node.java  - Cells for BinaryTree.java