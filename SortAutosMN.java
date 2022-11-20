
/************************************************************************************************
 * @author  Michael Nguyen
 * @class   COSC 2436
 * @version Quiz3 Extra Credit Problem 1
 * @description The local college newspaper is writing an article on the most driven vehicles on 
 *      all the campuses. The newspaper has already collected data regarding the make, model, and year 
 *      of each student’s individual vehicle. Write a program that will sort all the data alphabetically 
 *      by make, model, then year and displays the breakdown of each vehicle by make, model and year. 
 *      Input from a data file starts with a line containing an integer N in the range [1,40] which 
 *      is the number of students who drive a car at school. The following N lines will contain the 
 *      make, model, year for each vehicle collected. The make, model, year will be separated by a 
 *      comma. Output to the screen the data in four parts:
 *              • Data Sorted
 *              • Make Breakdown
 *              • Model Breakdown
 *              • Year Breakdown
 *      The data sorted portion is displayed alphabetically by make, with the tiebreaker being model. 
 *      If there is then a tie between both make and model, the final tiebreaker is year which is
 *      displayed from lowest to highest. For the make, model, and year breakdowns, output the number 
 *      of occurrences of each. The make and model are sorted alphabetically, and the year is sorted 
 *      numerically from lowest to highest. Let the user input the file name from the keyboard. Use 
 *      any sort/search technique.
 ************************************************************************************************/

import java.util.*;
import java.io.*;

/************************************************************************************************
 * @name SortAutosMN
 * @category class
 * @description Parent class for the autos
 ***********************************************************************************************/
public class SortAutosMN {
    /************************************************************************************************
     * @name Tree
     * @category class
     * @description The Tree class has a private static class called Node.
     ************************************************************************************************/
    private static class Tree {
        private Node root;

        public Tree() {
            root = null;
        }

        /************************************************************************************************
         * @name Node
         * @category class
         * @description The Node class is a private static class that is used to create
         *              a node object that contains a data
         *              field and a next field
         ************************************************************************************************/
        private class Node {
            private static int makeCnt; // stores count of make
            private static int modelCnt; // stores count of model
            private static int yearCnt; // stores count of year
            private int year;
            private int height; // stores count of height
            private int count; // stores count of count
            private String make;
            private String model;
            private Node makePtr; // pointer to make subtrees
            private Node lPtr;
            private Node rPtr;
            
            /************************************************************************************************
             * @name Node (AVL)
             * @category constructor
             * @description A constructor that initializes the vehicle object with the
             *              default constructor and sets
             *              the left and right pointers to null.
             ************************************************************************************************/
            public Node() {
                SortAutosMN.Tree.Node.makeCnt = 0;
                SortAutosMN.Tree.Node.modelCnt = 0;
                SortAutosMN.Tree.Node.yearCnt = 0;
                this.year = 0;
                this.height = 0;
                this.count = 0;
                this.make = "";
                this.model = "";
                this.makePtr = null;
                this.lPtr = null;
                this.rPtr = null;
                
            }// end Node default constructor
            
            /***********************************************************************************************
             * @name Node (AVL)
             * @param year
             * @param make
             * @param model
             * @category constructor
             * @description This is a constructor for the Node class. It is initializing the
             *              variables year, make, and model. This is the constructor for the
             *              Node class. It is setting the values of the instance variables
             *              to the values passed in as parameters.
             ************************************************************************************************/
            public Node(int year, String make, String model) {
                this.year = year;
                this.height = 0;
                this.make = make;
                this.model = model;
                this.makePtr = null;
                this.lPtr = null;
                this.rPtr = null;
                
                // increment the count to make it greater than 0 to indicate tree is not empty
                this.count++;
                
            }// end of parameterized constructor
            
            
            
            /************************************************************************************************
             * @name getMakeCnt
             * @return makeCnt the total number of same models found in the tree
             ************************************************************************************************/
            public int getMakeCnt() {
                return makeCnt;
            }// end of getMakeCnt
            
            /************************************************************************************************
             * @name getModelCnt
             * @return modelCnt the total number of same models in the tree
             ************************************************************************************************/
            public int getModelCnt() {
                return modelCnt;
            }// end of getModelCnt
            
            /************************************************************************************************
             * @name getYearCnt
             * @return yearCnt the total number of same years found in the tree
             * @description This function returns the number of times the make function has
             *              been called
             ************************************************************************************************/
            public int getYearCnt() {
                return yearCnt;
            }// end of getYearCnt
            
            /************************************************************************************************
             * @name getYear
             * @return the year of the car
             ************************************************************************************************/
            public int getYear() {
                return year;
            }// end of getYear
            
            /************************************************************************************************
             * @name setYear
             * @param year The year
             * @description This function sets the year of the car
             ************************************************************************************************/
            public void setYear(int year) {
                this.year = year;
            }// end of setYear
            
            /************************************************************************************************
             * @name getHeight
             * @return height the height of the tree
             * @description this function returns the height of the trees
             ************************************************************************************************/
            public int getHeight() {
                return this.height;
            }// end of getHeight
            
            
            /*************************************************************************************************
             * @name getCount
             * @return count number of items in the list.
             * @description function returns the value of the count variable.
             ************************************************************************************************/
            public int getCount() {
                return this.count;
            }// end of getCount
            
            /************************************************************************************************
             * @name setHeight
             * @param height The height of the image in pixels.
             * @description this function sets the height of the rectangle to the value of
             *              the parameter
             *              height.
             ************************************************************************************************/
            public void setHeight(int height) {
                this.height = height;
            }// end of setHeight
            
            /************************************************************************************************
             * @name getMake()
             * @return make The make of the car
             ************************************************************************************************/
            public String getMake() {
                return make;
            }// end of getMake()
            
            /************************************************************************************************
             * @name setMake
             * @param make the make of the car
             * @description set the make of the car
             ************************************************************************************************/
            public void setMake(String make) {
                this.make = make;
            } // end of setMake()
            
            /************************************************************************************************
             * @name getModel
             * @return model the model name of the car
             ************************************************************************************************/
            public String getModel() {
                return model;
            }// end of getModel()
            
            /************************************************************************************************
             * @name setModel
             * @param model The name of the model to use.
             * @description This function sets the model of the car
             ************************************************************************************************/
            public void setModel(String model) {
                this.model = model;
            }// end of setModel
            
            /************************************************************************************************
             * @name getMakePtr
             * @return makePtr of the car
             ************************************************************************************************/
            public Node getMakePtr() {
                return makePtr;
            }// emd of getMakePtr
            
            /************************************************************************************************
             * @name setMakePtr
             * @param makePtr pointer to the make of the car
             * @description set the pointer to the make of the car
             ************************************************************************************************/
            public void setMakePtr(Node node) {
                this.makePtr = node.makePtr;
            }// end of setMakePtr
            
            /************************************************************************************************
             * @name setLPtr
             * @category method
             * @param node
             * @description A setter method that sets the left pointer of the node to the
             *              node passed in as a
             *              parameter.
             ************************************************************************************************/
            public void setLPtr(Node node) {
                this.lPtr = node.lPtr;
            }// end setLeftPtr method
            
            /************************************************************************************************
             * @name getLptr
             * @category method
             * @return this.Lptr
             * @description This is a getter method that returns the left pointer of the
             *              node.
             ************************************************************************************************/
            public Node getLPtr() {
                return this.lPtr;
            }// end getLeftPtr method
            
            /************************************************************************************************
             * @name setRPtr
             * @category method
             * @param node
             * @description This is a setter method that sets the right pointer of the node
             *              to the node passed in as a parameter.
             ************************************************************************************************/
            public void setRPtr(Node node) {
                this.rPtr = node.rPtr;
            }// end setRPtr method
            
            /************************************************************************************************
             * @name getRPtr
             * @category method
             * @return this.rPtr
             * @description This is a getter method that returns the right pointer of the
             *              node.
             ************************************************************************************************/
            public Node getRPtr() {
                return this.rPtr;
            }// end getRightPtr method
            
        }// end class Node

        /************************************************************************************************
         * @name height
         * @param node the node to be checked
         * @return The height of the node.
         * @description gets the total height of the tree or subtree
         ************************************************************************************************/
        public int height(Node node) {
            if (node == null) {
                return 0;
            }
            return node.getHeight();
        }// end of getHeight
        
        /************************************************************************************************
         * @name max
         * @param x The first number to compare
         * @param y The y coordinate of the point.
         * @return The maximum value between x and y.
         * @description the function takes two integers as input and returns the larger
         *              of the two.
         ************************************************************************************************/
        public int max(int x, int y) {
            if (x > y) {
                return x;
            } // end if
            else {
                return y;
            } // end else
        }// end of max
        
        /************************************************************************************************
         * 
         * @param year  the year of the car
         * @param make  The make of the car
         * @param model The model of the car
         * @return A new node with the given year, make, and model.
         * @description this function that helps in creating memory for new node and
         *              sets the make, model, and year to the node. It also sets the
         *              height of the node and count of node to 1. All pointers are set
         *              to null
         ************************************************************************************************/
        public Node newAvlNode(int year, String make, String model) {

            Node avlNode = new Node(year, make, model);
            avlNode.height = 1;
            avlNode.count = 1;

            return avlNode;
            
        }// end of newAvlNode
        
        /*************************************************************************************************
         * @name rotateRight
         * @param r1 the root of the tree
         * @return The new root of the tree after the rotation.
         * @description The right child of the root node becomes the new root node, and
         *              the old root node
         *              becomes the left child of the new root node
         */
        public Node rotateRight(Node r1) {
            Node r2 = r1.getLPtr();
            Node subT2 = r2.getRPtr();
            
            // starting the first rotation of tree
            r2.setRPtr(r1);
            r1.setLPtr(subT2);
            
            // perform update of the new height after the rotation
            r1.setHeight(max(height(r1.getLPtr()), height(r1.getRPtr()) + 1));
            r2.setHeight(max(height(r2.getLPtr()), height(r2.getRPtr()) + 1));
            
            // pass back new root after the rotation
            return r2;
            
        }// end of rotateRight
        
        /*************************************************************************************************
         * @name rotateLeft
         * @param r2 the root of the tree
         * @return The new root of the tree after the rotation.
         * @description The right child of the root node becomes the new root node, and
         *              the old root node
         *              becomes the left child of the new root node
         */
        public Node rotateLeft(Node r2) {
            Node r1 = r2.getRPtr();
            Node subT2 = r1.getLPtr();
            
            // starting the first rotation of tree
            r1.setLPtr(r2);
            r2.setRPtr(subT2);
            
            // perform update of the new height after the rotation
            r2.setHeight(max(height(r2.getLPtr()), height(r2.getRPtr()) + 1));
            r1.setHeight(max(height(r1.getLPtr()), height(r1.getRPtr()) + 1));
            
            // pass back new root after the rotation
            return r1;
            
        }// end of rotateRight
        
        
        /*****************************************************************************************************
         * @name balance
         * @param node the node to be balanced
         * @return The height of the left subtree minus the height of the right subtree.
         * @description this function returns the difference between the height of the
         *              left subtree and the
         *              height of the right subtree
         ****************************************************************************************************/
        public int balance(Node node) {
            if (node == null) {
                return 0;
            } // end if

            return height(node.getLPtr()) - height(node.getRPtr());

        }// end of balance

        /*****************************************************************************************************
         * @name insert
         * @param node  the node to insert the car into
         * @param make  the make of the car
         * @param model The model of the car
         * @param year  the year of the car
         * @return A new node with the car info.
         * @description the function is used to insert the car with info into the tree
         ****************************************************************************************************/
        public Node insert(Node root, String make, String model, int year) {

            
            // check for empty node
            if (root == null) {
                root = newAvlNode(year, make, model);
                // return new node with car info
                return root;

            } // end if

            // Start to compare values in the node and traverse down the tree
            if (make.compareTo(root.getMake()) <= 0) {
                // if the make already exists in the tree then increment count of makeCnt, send
                // to compare function
                if (autoCompare(root)) {
                    return root;
                }
                root.setLPtr(insert(root.getLPtr(), make, model, year));
            } // end if(make.compareTo(node.getMake()) <= 0)
            else{
                // if the make already exists in the tree then increment count of makeCnt, send
                // to compare function
                if (autoCompare(root)) {
                    return root;
                }
                root.setRPtr(insert(root.getRPtr(), make, model, year));
            } // end else
          

            // update the height of the nodes of ancestors
            root.setHeight(1 + max(height(root.getLPtr()), height(root.getRPtr())));

            // get the balance factor of the node
            int balance = balance(root);

            // if the node is unbalanced then there are 4 cases

            // left left case
            if (balance > 1 && make.compareTo(root.getLPtr().getMake()) < 0) {
                return rotateRight(root);
            } // end left left case

            // right right case
            if (balance < -1 && make.compareTo(root.getRPtr().getMake()) > 0) {
                return rotateLeft(root);
            } // end right right case

            // left right case
            if (balance > 1 && make.compareTo(root.getLPtr().getMake()) > 0) {
                root.setLPtr(rotateLeft(root.getLPtr()));
                return rotateRight(root);
            } // end left right case

            // right left case
            if (balance < -1 && make.compareTo(root.getRPtr().getMake()) < 0) {
                root.setRPtr(rotateRight(root.getRPtr()));
                return rotateLeft(root);
            } // end right left case

            // return the node
            return root;

        }// end insert method

        /************************************************************************************************
         * @name inOrderPrint
         * @param node the node that is being passed in
         *             The function takes a node as a parameter and prints the make and
         *             makeCnt of the node and all of its children
         ************************************************************************************************/
        public void inOrderPrint(Node root) {
            if (root != null) {
                inOrderPrint(root.getLPtr());
                System.out.println(root.getMake() + " " + root.getMakeCnt());
                inOrderPrint(root.getRPtr());
            } // end if

        }// end inOrderPrint

        /*****************************************************************************************************
         * @name autoCompare
         * @param node the node that is being compared to the tree
         * @description function compares the model, year, and make of the node to the
         *              model, year, and make of the node's parent. If the model, year,
         *              or make of the node is the same as the model, year, or make of
         *              the node's parent, then the modelCnt, yearCnt, or makeCnt is
         *              incremented
         *****************************************************************************************************/
        public boolean autoCompare(Node node) {

            boolean exists = false;
            // if the make already exists in the tree then increment the makeCnt
            if (node.make == node.getMake()) {
                SortAutosMN.Tree.Node.makeCnt++;

                // sets exists flag to true do indicate make exists and for calling function to
                // return.
                exists = true;

            }
            // if the model already exists in the tree then increment the modelCnt
            if (node.model == node.getModel()) {
                SortAutosMN.Tree.Node.modelCnt++;
            }
            // if the year already exists in the tree then increment the yearCnt
            if (node.year == node.getYear()) {
                SortAutosMN.Tree.Node.yearCnt++;
            }

            return exists;

        }// end of autoCompare

    }// end class Tree

    /************************************************************************************************
     * @name main
     * @category method
     * @param args
     * @description The main method
     * 
     ************************************************************************************************/
    public static void main(String[] args) {

        // Instantiate a new Tree
        Tree cars = new Tree();
        cars.root = cars.insert(cars.root, "Ford", "F150", 2010);
        cars.root = cars.insert(cars.root, "Chevy", "Cruz", 2019);
        cars.root = cars.insert(cars.root, "Chevy", "Silverado", 2006);

        cars.root = cars.insert(cars.root, "Dodge", "Durango", 2020);
        cars.root = cars.insert(cars.root, "Dodge", "Ram1500", 2000);

        System.out.println("\nIn order print of the tree\n");

        cars.inOrderPrint(cars.root);

    }// end main(String[] args)

}// end class SortAutosMN
