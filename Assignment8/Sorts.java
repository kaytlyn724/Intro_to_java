// Assignment: 8
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 days
// Description: Sorts class sorts the given reviewList arraylist using Insertion sort.

import java.util.Comparator;

import javax.print.attribute.SetOfIntegerSyntax;

import java.util.ArrayList;

public class Sorts {
	public static void sort(ArrayList<Restaurant> reviewList, Comparator<Restaurant> xComparator) {
		
		for (int i = 1; i < reviewList.size(); i++) {
			
			Restaurant r1 = reviewList.get(i);
			
			int check = i;
			
			while (check > 0 && xComparator.compare(reviewList.get(check - 1), r1) > 0) {
				reviewList.set(check, reviewList.get(check-1));
				check--;
			}
			
			reviewList.set(check, r1);
		}
	}
}