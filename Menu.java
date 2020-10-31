package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FoodDao;
import entity.Food;

@SuppressWarnings("unused")
public class Menu {

	private FoodDao foodDao = new FoodDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Foods",
			"Display a Food",
			"Enter a Food",
			"Delete a Food");
	
	public void start() throws SQLException {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				displayFoods();
			} else if (selection.equals("2")) {
				displayFood();
			} else if (selection.equals("3")) {
				enterFood();
			} else if (selection.equals("4")) {
				deleteFood();
			}
			
			System.out.println("Press enter to continue..");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	private void printMenu() {
		System.out.println("Select an Option:\n ---------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	private void displayFoods() throws SQLException {
		List<Food> foods = foodDao.getFoods();
		for (Food food : foods) {
			System.out.println(food.getFoodId() + ": " + food.getFoodName());
		}
	}
	private void displayFood() throws SQLException {
		System.out.print("Enter food id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Food food = foodDao.getFoodById(id);
		System.out.println(food.getFoodId() + ": " + food.getFoodName());
	}	
	private void enterFood() throws SQLException {
		System.out.print("Enter new food item:");
		String foodName = scanner.nextLine();
		foodDao.createNewFood(foodName);
	}	
	private void deleteFood() throws SQLException {
		System.out.print("Enter food id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		foodDao.deleteFoodByID(id);
		
	}
}
