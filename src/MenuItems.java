package Project;

import java.util.Scanner;

public class MenuItems {
	private String name;
	private String description;
	private double price;
	private String itemId;
	private int quantity;

	public MenuItems(String itemid,String name, String description, double price)
	{
		this.itemId=itemid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = 0;
	}

	public double getPrice() { return this.price; }
	public String getItemID() { return this.itemId; }
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	public int getQuantity() { return this.quantity; }
	public void updateName(String name) { this.name=name; }
	public void updateDescription(String des) { this.description=des; }
	public void updatePrice(double price) { this.price=price; }
	public void updateItemID(String id) { this.itemId=id; }
	public void updateQuantity(int quan) { this.quantity=quan; }
	public MenuItems clone() { return new MenuItems(this.itemId, this.name, this.description, this.price); }
}