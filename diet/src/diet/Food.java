package diet;

import java.util.Collection;
import java.util.TreeMap;

public class Food {
	
	private TreeMap<String, RawMaterial> raw = new TreeMap<>();
	private TreeMap<String, Product> products = new TreeMap<>();
	private TreeMap<String, Recipe> recipes = new TreeMap<>();
	
	public void defineRawMaterial(String name, double calories, double proteins, double carbs, double fat) {
		RawMaterial rm = new RawMaterial (name, calories, proteins, carbs, fat);
		raw.put(name, rm);
	}
	
	public Collection<RawMaterial> rawMaterials() {
		return raw.values();
	}
	
	public NutritionalElement getRawMaterial(String name) {
		return raw.get(name);
	}
	
	public void defineProduct(String name, double calories, double proteins, double carbs, double fat) {
		Product p = new Product (name, calories, proteins, carbs, fat);
		products.put(name, p);
	}
	
	public Collection<Product> products() {
		return products.values();
	}
	
	public NutritionalElement getProduct(String name) {
		return (NutritionalElement) products.get(name);
	}
	
	public void createRecipe(String name) {
		Recipe r = new Recipe(name, this);
		recipes.put(name, r);
	}
	
	public Collection<Recipe> recipe() {
		return recipes.values();
	}
	
	public NutritionalElement getRecipe(String name) {
		return recipes.get(name);
	}
	
	public void createMenu (String name) {
		Menu m = new Menu (name, this);
	}
	
}
