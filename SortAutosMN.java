
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
 * @name        Auto
 * @category    class
 * @description The class Auto has three private fields: make, model, and year. This object will 
 *      be the data element of the node in the binary tree
 ************************************************************************************************/
    private static class Auto{
        private String make;
        private String model;
        private int year;

        /*****************************************************************************************
         * @name        Auto
         * @category    method
         * @description Constructor that initializes the make, model, and year to empty strings 
         *      and 0.
         ****************************************************************************************/
        public Auto(){
            this.make = "";
            this.model = "";
            this.year = 0;
        }// end Auto Constructor

        /**
         * @name        setMake
         * @category    method
         * @param       make
         * @description This is a setter method that sets the make of the car.
         */
        public void setMake(String make){
            this.make = make;
        }// end setMake method

        /**
         * @name        getMake
         * @category    method
         * @return      make of the car
         * @description This is a getter method that returns the make of the car.
         */
        public String getMake(){
            return this.make;
        }// end getMake method

        /**
         * @name        setModel
         * @category    method
         * @param       model
         * @description This is a setter method that sets the model of the car.
         */
        public void setModel(String model){
            this.model = model;
        }// end setModel method

        /**
         * @name        getModel
         * @category    method
         * @return      model of the car.
         * @description This function returns the model of the car
         */
        public String getModel(){
            return this.model;
        }// end getModel method 

        /**
         * @name        setYear
         * @category    method
         * @param       year
         * @description This is a setter method that sets the year of the car.
         */
        public void setYear(int year){
            this.year = year;
        }// end setYear method

        /**
         * @name        getYear
         * @category    method
         * @return      year of the car
         * @description This is a getter method that returns the year of the car.
         */
        public int getYear(){
            return this.year;
        }//end setYear method



    }// end class Auto
    /************************************************************************************************
     * @name Tree
     * @category class
     * @description The Tree class has a private static class called Node.
     ************************************************************************************************/
    private static class Tree {

        /************************************************************************************************
         * @name Node
         * @category class
         * @description The Node class is a private static class that is used to create
         *              a node object that contains a data
         *              field and a next field
         */
        private static class Node {
            private Auto vehicle;   // object containing three data fields(make, model, year)
            private Node leftPtr;
            private Node rightPtr;

            /************************************************************************************************
             * @name        Node
             * @category    constructor
             * @description A constructor that initializes the vehicle object with the default constructor and sets
             *      the left and right pointers to null.
             ************************************************************************************************/
            public Node(){
                this.vehicle = new Auto();  // allocate memory for vehicle object and initialize with
                                            // - the default vehicle constructor
                this.leftPtr = null;
                this.rightPtr = null;
            }// end Node default constructor

            /************************************************************************************************
             * @name        setVehicle
             * @category    method
             * @param       model
             * @param       make
             * @param       year
             * @description A setter method that sets the make, model, and year of the car.
             ************************************************************************************************/
            public void setVehicle(String model, String make, int year){
                this.vehicle.setMake(make);
                this.vehicle.setModel(model);
                this.vehicle.setYear(year);
            }// end setVehicle method

            /************************************************************************************************
             * @name        getVehicle
             * @category    method
             * @return      this.vehicle
             * @description A getter method that returns the vehicle object.
             ************************************************************************************************/
             public Auto getVehicle(){
                return this.vehicle;
            }// end getModel method

            /************************************************************************************************
             * @name        setLeftPtr
             * @category    method
             * @param       node
             * @description A setter method that sets the left pointer of the node to the node passed in as a
             *     parameter.
             ************************************************************************************************/
            public void setLeftPtr(Node node){
                this.leftPtr = node;
            }// end setLeftPtr method

            /************************************************************************************************
             * @name        getLeftPtr
             * @category    method
             * @return      this.leftPtr
             * @description This is a getter method that returns the left pointer of the node.
             ************************************************************************************************/
            public Node getLeftPtr(){
                return this.leftPtr;
            }// end getLeftPtr method

            /************************************************************************************************
             * @name setRightPtr
             * @category method
             * @param node
             * @description This is a setter method that sets the right pointer of the node to the node passed in as
             *      a parameter.
             ************************************************************************************************/
            public void setRightPtr(Node node){
                this.rightPtr = node;
            }// end setRightPtr method

            /************************************************************************************************
             * @name        getRightPtr
             * @category    method
             * @return      this.rightPtr
             * @description This is a getter method that returns the right pointer of the node.
             ************************************************************************************************/ 
            public Node getRightPtr(){
                return this.rightPtr;
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

    }// end main(String[] args)

}// end class SortAutosMN
