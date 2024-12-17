// Assignment #: 2
//         Name: Kaytlyn Daffern
//    StudentID: 1221263225
//      Lecture: 1:30-2:45pm
// Time took you to complete the assignment: 5 hours
//  Description: This class will read an unspecified number of integers from standard input and will output the result of some calculations on the inputted numbers.

import java.util.Scanner;  // import Scanner for use

public class Assignment2
 {
  public static void main (String[] args)
   {
    int i = 0;
    int greatestInt = 0;
    int largestEvenInt = 0;
    int positiveInts = 0;
    int sumOfInts = 0;
    int consoleValue;

    Scanner console = new Scanner(System.in); //create scanner to take in users input

    while(console.hasNextInt())  // integers from console still inputted until a 0
     {
        consoleValue = console.nextInt();
        if(consoleValue == 0) 
         {
            break;
         }
        else
         {
            if (consoleValue > greatestInt) //find greatest integer of integers inputted
             {
               greatestInt = consoleValue; // if the current value is larger than the greatest integer it becomes it
             }
            
            if (consoleValue % 2 == 0) //if value is even (has no remainder) it will run through this if statement
             {
                if (consoleValue > largestEvenInt) //find greatest even integer of integers inputted
                 {
                  largestEvenInt = consoleValue; // if the current value is larger than the greatest even integer it becomes it
                 }
             }

        	    if (consoleValue > 0) //find how many positive integers there are of the integers inputted by testing if they are greater than 0
             {
                positiveInts++; // add one to the posititve integers if the value is positive 
             }
        
             sumOfInts = sumOfInts + consoleValue; // add value to the sum of all integers
         }
     }

     System.out.println("The largest integer in the sequence is " + greatestInt);
     System.out.println("The largest even integer in the sequence is " + largestEvenInt);
     System.out.println("The count of positive integers in the sequence is " + positiveInts);
     System.out.println("The sum of all integers is " + sumOfInts);
   }
 }
