package model.domain;

public class Menu {
	   private int menuId;
	   private int restaurantId;
	   private String ownerId;
	   private String name;
	   private int price;
	   
	   public Menu() {
	      
	   }
	   
	   public int getMenuId() {
	      return menuId;
	   }
	   public void setMenuId(int menuId) {
	      this.menuId = menuId;
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
	   public int getPrice() {
	      return price;
	   }
	   public void setPrice(int price) {
	      this.price = price;
	   }
}
