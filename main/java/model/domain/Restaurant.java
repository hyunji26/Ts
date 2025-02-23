package model.domain;

public class Restaurant {
	   private int restaurantId;
	   private String ownerId;
	   private String name;
	   private String location;
	   private float rating;
	   
	   public Restaurant() {
	      
	   }

	   public int getRestaurantId() {
	      return restaurantId;
	   }

	   public void setRestaurantId(int restaurantId) {
	      this.restaurantId = restaurantId;
	   }

	   public String getOwnerId() {
	      return ownerId;
	   }

	   public void setOwnerId(String ownerId) {
	      this.ownerId = ownerId;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getLocation() {
	      return location;
	   }

	   public void setLocation(String location) {
	      this.location = location;
	   }

	   public float getRating() {
	      return rating;
	   }

	   public void setRating(float rating) {
	      this.rating = rating;
	   }
}
