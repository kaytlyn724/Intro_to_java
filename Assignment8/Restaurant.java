// Assignment: 8
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 days
// Description: Restaurant class makes the restaurant object available to offer a review for every restaurant available and puts them in reviewList.

import java.io.Serializable;

public class Restaurant implements Serializable {
	
	private static final long serialVersionUID = 205L;
	
	private String restaurantName;
	private int stars;
	private String review;
	private int priceRange;
	private String location;
	private Cuisine cuisine;
	
	public Restaurant(String restaurantName, int stars, String review, int priceRange, String location, Cuisine cuisine) {
		this.restaurantName = restaurantName;
		this.stars = stars;
		this.review = review;
		this.priceRange = priceRange;
		this.location = location;
		this.cuisine = cuisine;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public int getStars() {
		return stars;
	}
	
	public int getPriceRange() {
		return priceRange;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getReview() {
		return review;
	}
	
	public Cuisine getCuisine() {
		return cuisine;
	}
	
	public String toString() {
		String starString = "";
		String priceString = "";
		for(int i = 0; i < getStars(); i++) {
			starString = starString + "*";
		}
		
		for(int j = 0; j < getPriceRange(); j++) {
			priceString = priceString + "$";
		}
		
		return restaurantName + " restaurant\n" + starString + "\t\t" + priceString + "\n" + cuisine.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
	}
}