// Assignment: 8
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 days
// Description: Review Manager class used to check that a given restaurant or cuisine is available, as well as adding or removing reviews and sorting.

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Restaurant> reviewList;

    public ReviewManager() {
        reviewList = new ArrayList<>();
    }
    public int restaurantExists(String name, String location) {
    	
    	for (int i = 0; i < reviewList.size(); i++) {
    		if ((reviewList.get(i).getRestaurantName().equals(name)) && (reviewList.get(i).getLocation().equals(location))) {
    			return reviewList.indexOf(reviewList.get(i));
    		}
    	}
    	return -1;
    }
    
    public ArrayList<Integer> cuisineExists(String cName) {
    	ArrayList<Integer> sameCuisine = new ArrayList<Integer>();
    	
    	for (int i = 0; i < reviewList.size(); i++) {
    		if (reviewList.get(i).getCuisine().getName().equals(cName)) {
    			sameCuisine.add(reviewList.indexOf(reviewList.get(i)));
    		}
    	}
    	if (sameCuisine.isEmpty()) {
    		sameCuisine.add(-1);
    	}
    	return sameCuisine;
    }
    
    public Restaurant getRestaurant(int r) {
    	return reviewList.get(r);
    }
    
    /**
     * Add a Restaurant object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two restaurants are
     * considered duplicated if they have exactly the same restaurant name and
     * cuisine name.
     * 
     * @param  restaurantName the name of the restaurant
     * @param  stars the number of stars for the restaurant
     * @param  review   the restaurant review
     * @param  priceRange    the integer price range
     * @param  cuisineName  the Cuisine's name
     * @param  location   the restaurant location (street address)
     * @param  signatureDish  most famous dish
     * @return            true if the operation is successful; false otherwise
     */
    public boolean addReview(String restaurantName, int stars, String review, String priceRange, String cuisineName, String location, String signatureDish) {
        if (restaurantExists(restaurantName, location) == -1) {
            int price = priceRange.length();
            Cuisine newCuisine = new Cuisine(signatureDish, cuisineName);
            Restaurant newRestaurant = new Restaurant(restaurantName, stars, review, price, location, newCuisine);
            reviewList.add(newRestaurant);
            return true;
        }
        return false;
    }
    
    public boolean removeReview(String name, String location) {
    	if (restaurantExists(name, location) >= 0) {
    		reviewList.remove(restaurantExists(name, location));
    		return true;
    	}
    	return false;
    }
    
    public void sortByRating() {
    	ReviewRatingComparator compareRating1 = new ReviewRatingComparator();
    	Sorts.sort(reviewList, compareRating1);
    }
    
    public void sortByCuisine() {
    	ReviewCuisineComparator compareRating2 = new ReviewCuisineComparator();
    	Sorts.sort(reviewList, compareRating2);
    }
    
    public String listReviews() {
    	String list = "";
    	
    	for(int i = 0; i < reviewList.size(); i++) {
    		list += reviewList.get(i).toString();
    	}
    	
    	return list;
    }
    
    public void closeReviewManager() {
    	reviewList.clear();
    }

}
