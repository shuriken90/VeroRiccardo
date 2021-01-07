package diet;

import java.util.LinkedList;
import java.util.List;

public class Recipe implements NutritionalElement{
	
	private Food food;
	private String name;
	private double calories= 0.0;
	private double proteins=0.0;
	private double carbs=0.0;
	private double fat=0.0;
	private double weight=0.0;
	private List<Ingredient> ingredients = new LinkedList<>();
	
	private static class Ingredient {
		
		final NutritionalElement ne;
		final double qty;
		
		public Ingredient(NutritionalElement rawMaterial, double qty) {
			this.ne=rawMaterial; this.qty=qty;
		}
		
	}

	public Recipe(String name, Food food) {
		this.name=name; this.food=food;
	}

	public Recipe addIngredient(String rawName, double qty) {
		NutritionalElement ne = food.getRawMaterial(rawName);
		Ingredient i = new Ingredient(ne,qty);
		ingredients.add(i);
		weight += qty;
		calories+= ne.getCalories()/100*qty;
		proteins+=ne.getProteins()/100*qty;
		carbs+= ne.getCarbs()/100*qty;
		fat+=ne.getFat()/100*qty;
		return this;
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories/weight*100;
	}

	@Override
	public double getProteins() {
		return proteins/weight*100;
	}

	@Override
	public double getCarbs() {
		return carbs/weight*100;
	}

	@Override
	public double getFat() {
		return fat/weight*100;
	}

	@Override
	public boolean per100g() {
		return true;
	}

}
