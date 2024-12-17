// Assignment #: 1
//         Name: Kaytlyn Daffern
//    StudentID: 1221263225
//      Lecture: 1:30-2:45pm Tu-Th
// Time took you to complete the assignment: 45 Minutes
//  Description: This class reads an integer from a keyboard and prints it out
//               along with other messages.

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment1
 {
  public static void main (String[] args)
   {
     int number;

     Scanner console = new Scanner(System.in); //create scanner to take in users input

     number = console.nextInt();     // read an integer entered by a user


     // display the number with other messages
	     System.out.print("This program reads an integer from a keyboard\n"
	                    + "and prints it out on the display screen.\n"
	                    + "Make sure that you get the exact same output as the expected one.\n"
                   + "The read number is: " + number + "\n");
   }
 }


