
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

        /************************************************************************************************
         * @name insertData
         * @category method
         * @param root the root node of the tree
         * @param data the Auto object with values for make, model, year
         * @return root node of the tree
         * @description A recursive method that inserts data into the tree.
         ************************************************************************************************/
        public Node insertData(Node root, Auto data) {

            // if the root is null, then create a new root and populate with the data
            if (root == null) {
                root = new Node();
                root.vehicle.setMake(data.make);
                root.vehicle.setModel(data.model);
                root.vehicle.setYear(data.year);
                return root;
            } // end if(root == null)

            // compare to see if the make of the vehicle is less than or equal to the make
            // of the new vehicle lexicographically
            if (root.vehicle.getMake().compareTo(data.getMake()) <= 0) {
                // make recursive call to traverse down left side of tree
                root.setLeftPtr(insertData(root.leftPtr, data));
                return root;

            } // end if(root.vehicle.getMake().compareTo(data.getMake()) <= 0)
            else if(root.vehicle.getMake().compareTo(data.getMake()) > 0){
                // make recursive call to traverse down right side of tree
                root.setRightPtr(insertData(root.rightPtr, data));
                return root;

            }// end if(root.vehicle.getMake().compareTo(data.getMake()) > 0)

            return root;
        }// end insertData method

        /************************************************************************************************
         * @name add
         * @category method
         * @param data
         * @description The add method to start the recursive function call of the
         *              insertData method above
         ************************************************************************************************/
        public void add(Auto data) {
            root = insertData(root, data);
        }// end add method

        /************************************************************************************************
         * @name Node
         * @category class
         * @description The Node class is a private static class that is used to create
         *              a node object that contains a data
         *              field and a next field
         ************************************************************************************************/
        private static class Node {
            private String make;
            private String model;
            private int year;
            private Node makePtr;   // pointer to make subtrees
            private Node lPtr;
            private Node rPtr;
            
            
            /************************************************************************************************
             * @name Node
             * @category constructor
             * @description A constructor that initializes the vehicle object with the
             *              default constructor and sets
             *              the left and right pointers to null.
             ************************************************************************************************/
            public Node() {
                this.make = "";
                this.model = "";
                this.year = 0;
                this.makePtr = null;
                this.lPtr = null;
                this.rPtr = null;
                
            }// end Node default constructor
            
            /************************************************************************************************
             * @name Node
             * @category parameterized constructor
             * @description A constructor that initializes the node with the make, model, and year.
             ************************************************************************************************/
            public Node(String make, String model, int year, Node makePtr, Node lPtr, Node rPtr){
                this.make = make;
                this.model = model;
                this.year = year;
                this.makePtr = makePtr;
                this.lPtr = lPtr;
                this.rPtr = rPtr;
                
            }// end of parameterized constructor 
            
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
            public void setMakePtr(Node makePtr) {
                this.makePtr = makePtr;
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
                this.lPtr = node;
            }// end setLeftPtr method
            
            /************************************************************************************************
             * @name getLptr
             * @category method
             * @return this.Lptr
             * @description This is a getter method that returns the left pointer of the
             *              node.
             ************************************************************************************************/
            public Node getLptr() {
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
                this.rPtr = node;
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
        Tree myTree = new Tree();

    }// end main(String[] args)

}// end class SortAutosMN
