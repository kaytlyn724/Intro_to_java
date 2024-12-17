// Assignment: 8
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 days
// Description: This reviewratingcomparator compares two restaurants based on stars, name, location or review.

import java.util.Comparator;

public class ReviewRatingComparator implements Comparator<Restaurant> {
	
	public int compare(Restaurant r1, Restaurant r2) {
		if(r1.getStars() > r2.getStars()) {
			return r1.getStars() - r2.getStars();
		}
		else if(r1.getStars() < r2.getStars()) {
			return r1.getStars() - r2.getStars();
		}
		else {
			if(r1.getRestaurantName().compareTo(r2.getRestaurantName()) < 0) {
				return r1.getRestaurantName().compareTo(r2.getRestaurantName());
			}
			else if(r1.getRestaurantName().compareTo(r2.getRestaurantName()) > 0) {
				return r1.getRestaurantName().compareTo(r2.getRestaurantName());
			}
			else {
				if(r1.getLocation().compareTo(r2.getLocation()) < 0) {
					return r1.getLocation().compareTo(r2.getLocation());
				}
				else if(r1.getLocation().compareTo(r2.getLocation()) > 0) {
					return r1.getLocation().compareTo(r2.getLocation());
				}
				else {
					if(r1.getReview().compareTo(r2.getReview()) < 0) {
						return r1.getReview().compareTo(r2.getReview());
					}
					else if(r1.getReview().compareTo(r2.getReview()) > 0) {
						return r1.getReview().compareTo(r2.getReview());
					}
					else {
						return 0;
					}
				}
			}
		}
	}
}