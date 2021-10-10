package Project;

import java.util.Scanner;

public class McWings extends FoodItems{
	private double price = 4.00;
	private int quantity;
	private String name = "McWings";
	private String description = "A delicious 4piece Chicken Wings";
	
	
	public void getQuantity() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter quantity of " + name + ": ");
		this.quantity = sc.nextInt();
	}
	public double displayIndPrice() {
		return this.price;
	}
	public double getTotPrice() {
		return this.price * this.quantity;
	}
	public int displayQuantity() {
		return this.quantity;
	}
	public String displayName() {
		return this.name;
	}
	public String displayDescription() {
		return this.description;
	}
}
