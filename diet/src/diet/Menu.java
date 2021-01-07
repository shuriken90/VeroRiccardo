package diet;

import java.util.LinkedList;
import java.util.List;

public class Menu implements NutritionalElement{
	
	private String name;
	private Food food;
	private double calories;
	private double proteins;
	private double fat;
	private double carbs;
	private List<NutritionalElement> menu = new LinkedList<>();

	public Menu(String name, Food food) {
		this.food=food; this.name=name;
	}
	
	public void addRecipe(String recipeName, double qty) {
		NutritionalElement ne = food.getRecipe(recipeName);
		menu.add(ne);
	}
	
	public void addProduct(String productName) {
		NutritionalElement ne = food.getProduct(productName);
		menu.add(ne);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories;
	}

	@Override
	public double getProteins() {
		return proteins;
	}

	@Override
	public double getCarbs() {
		return carbs;
	}

	@Override
	public double getFat() {
		return fat;
	}

	@Override
	public boolean per100g() {
		return false;
	}

}
