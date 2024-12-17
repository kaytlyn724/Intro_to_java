// Assignment: 9
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 3 hours
// Description: Assignment 9 offers 4 options, 1 finding the largest number in the array, 
//the second finding the product of all primes in the array, the third finding the largest sum of digits in the array, 
//and the fourth removing duplicate letters.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment9 {

	public static void main(String[] args) {
		
		char option = 0;
		String inputLine;
	    	
	    try {
	    	InputStreamReader input = new InputStreamReader(System.in);
	        BufferedReader buffRead = new BufferedReader(input);
	    	
	    	do {
	    		printMenu();
	    		inputLine = buffRead.readLine().trim();
	    		if (inputLine.isEmpty()) {
                    continue;
                }
		        option = inputLine.charAt(0);
	        
		        switch (option) {
		        	
		        	case '1': //Find the largest number in an array of integers
		        		int startVal1 = 0;
		        		int[] buffList1 = parseInts(buffRead);
		        		int endVal1 = buffList1.length - 1;
		        		
		        		System.out.println("The largest number in the array is: " + largestNum(buffList1, startVal1, endVal1));
		        		break;
		        	
		        	case '2': //Calculate the product of all prime numbers in an array of integers
		        		int[] buffList2 = parseInts(buffRead);
		        		int length = buffList2.length - 1;
		        		
		        		System.out.println("The product of all prime numbers in the array is: " + productOfPrimes(buffList2, length));
		        		break;
		        	
		        	case '3': //Find the element with the largest sum of digits in an array of integers
		        		int startVal3 = 0;
		        		int[] buffList3 = parseInts(buffRead);
		        		int endVal3 = buffList3.length - 1;
		        		System.out.println("The largest sum of digits in the array is: " + largestSumOfDigits(buffList3, startVal3, endVal3));
		        		break;
		        	
		        	case '4': //Remove adjacent duplicate characters in a String 
		        		System.out.print("Please enter String:\n");
		        		String userString = buffRead.readLine().trim();
		        		String outputString = "";
		        		int i = 0;
		        		int sLength = userString.length() - 1;
		        		System.out.println("String after adjacent duplicate characters were removed: " + removeDuplicate(userString, outputString, i, sLength));
		        		
		        		break;
		        	
		        	case '5': //Quit
		        	
		        		break;
		        	
		        	default: //Not a case given
		        		
		        		System.out.print("Please choose a number between 1 and 5.\n");
		        		break;
		        }
	    	
	    	} while(option != '5');
	    }
    
    catch (IOException exception) {
    	System.out.print("IO Exception\n");
    } 
	
}
    

    // Utility method for printing the menu 
    public static void printMenu() {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest number in an array of integers\n");
        System.out.print("2: Calculate the product of all prime numbers in an array of integers\n");
        System.out.print("3: Find the element with the largest sum of digits in an array of integers\n");
        System.out.print("4: Remove adjacent duplicate characters in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader) {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = Integer.parseInt(line);

            while (num > 0) {
                container.add(num);
                line = reader.readLine();
                num = Integer.parseInt(line);
            }

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
         for(int i = 0; i < container.size(); i++){
             result[i] = container.get(i);
         }
        return result;
    }
    
    public static int largestNum(int[] buffList, int startVal, int endVal) {
    	
    	int maxVal;
    	if(startVal == endVal) {
    		return buffList[startVal];
    	}
    	else {
    		maxVal = largestNum(buffList, startVal + 1, endVal);
    		if (buffList[startVal] >= maxVal) {
    			return buffList[startVal];
    		}
    		else {
    			return maxVal;
    		}
    	}
    }
    
    
    public static int productOfPrimes(int[] buffList, int i) {
        int p = 1;
    	if((buffList.length == 1) && (primeNum(buffList[0], buffList[0] - 1) == false)) {
    		return p;
    	}
    	else if((buffList.length == 1) && (primeNum(buffList[0], buffList[0] - 1) == true)) {
    		return p * buffList[0];
    	}
    	if(i < 0) {
    	    return p;
    	}
    	else {
    		if (primeNum(buffList[i], buffList[i] - 1) == true) {
    			return buffList[i] * productOfPrimes(buffList, i - 1);
    		}
    		else {
    		    return productOfPrimes(buffList, i - 1);
    		}
    	}
    }
    
    
    public static boolean primeNum(int arrNum, int i) {
    	
    	if (arrNum <= 1) {
    		return false;
    	}
    	if (i == 1) {
    		return true;
    	}
    	else {
    		if (arrNum % i == 0) {
    			return false;
    		}
    		else {
    			return primeNum(arrNum, i - 1);
    		}
    	}
    	
    }
    
    public static int largestSumOfDigits(int[] buffList, int startVal, int endVal) {
    	
    	int maxVal;
    	if(startVal == endVal) {
    		return sumOfDigits(buffList[startVal]);
    	}
    	else {
    		maxVal = largestSumOfDigits(buffList, startVal + 1, endVal);
    		if (sumOfDigits(buffList[startVal]) >= maxVal) {
    			return sumOfDigits(buffList[startVal]);
    		}
    		else {
    			return maxVal;
    		}
    	}
    }
    
    public static int sumOfDigits(int n) {
    	
    	if(n % 10 == n) {
    		return n;
    	}
    	else {
    		return (n % 10) + sumOfDigits(n / 10);
    	}
    }
    
    public static String removeDuplicate(String input, String output, int i, int length) {
    	
    	if(i <= length) {
    		
    		if (i == length) {
    		    if(input.charAt(i) == input.charAt(i - 1)) {
    		        return output;
    		    }
    		    else {
    		        return output + input.charAt(i);
    		    }
    			
    		}
    		else if(i == 0) {
    		    return output + input.charAt(i) + removeDuplicate(input, output, i + 1, length);
    		}
    		else if (input.charAt(i) == input.charAt(i - 1)) {
    			return output + removeDuplicate(input, output, i + 1, length);
    		}
    		else {
    			return output + input.charAt(i) + removeDuplicate(input, output, i + 1, length);
    		}
    	}
    	else {
    		return output;
    	}
    }
    

}
