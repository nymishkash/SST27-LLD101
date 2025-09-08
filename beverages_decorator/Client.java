package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		


		
		Beverage coffee = new Cappuccino();
        System.out.println("Coffee");
		System.out.println(coffee.cost());
		
		Beverage coffeeWithMilk = new Milk(new Cappuccino());
		System.out.println("Cappuccino with Milk");
		System.out.println(coffeeWithMilk.cost());
		
		Beverage coffeeWithMilkAndSugar = new Sugar(new Milk(new Cappuccino()));
		System.out.println("Cappuccino with Milk and Sugar");
		System.out.println(coffeeWithMilkAndSugar.cost());
		
		Beverage deluxeCoffee = new WhippedCream(new Sugar(new Milk(new Latte())));
		System.out.println("Deluxe Latte (with Milk, Sugar, and Whipped Cream)");
		System.out.println(deluxeCoffee.cost());
		
		Beverage simpleLatte = new Latte();
		System.out.println("Plain Latte");
		System.out.println(simpleLatte.cost());


	}

}