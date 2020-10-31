package entity;

import java.util.List;

public class Food {

	private int foodId;
	private String foodName;
	private List<Food> food;
	
	public Food(int foodId, String foodName) {
		this.setFoodId(foodId);
		this.setFoodName(foodName);
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}
	
}
