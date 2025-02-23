package model.domain;

public class Review {
	private int reviewId;
    private int studentId;
    private int reviewPoint;
    private String reviewContent;
    private int restaurantId;
    private String ownerId;
    // 추가
    private String restName = null;
    
    public Review() { this(-1, -1, null, -1, null); }
    public Review(int studentId, int reviewPoint, 
            String reviewContent, int restaurantId, String ownerId) {
        this.studentId = studentId;
        this.reviewPoint = reviewPoint;
        this.reviewContent = reviewContent;
        this.restaurantId = restaurantId;
        this.ownerId = ownerId;
    }
    
    // 추가
    public String getRestName() {
    	return restName;
    }
    public void setRestName(String restName) {
    	this.restName = restName;
    }
    
    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getReviewPoint() {
        return reviewPoint;
    }
    public void setReviewPoint(int reviewPoint) {
        this.reviewPoint = reviewPoint;
    }
    public String getReviewContent() {
        return reviewContent;
    }
    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
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
}
