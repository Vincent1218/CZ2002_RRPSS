package Project;

import java.util.Scanner;

/**
 * Represents a menu items in the menu.
 */

public class MenuItems {
	/**
	 * The name of the menu item.
	 */
	private String name;

	/**
	 * The description of menu item.
	 */
	private String description;

	/**
	 * The price of menu item.
	 */
	private double price;

	/**
	 * The unique ID of menu item.
	 */
	private String itemId;

	/**
	 * The quantity of menu item.
	 * Used to record quantity in an order.
	 */
	private int quantity;

	/**
	 * Creates a menu item with the given parameters.
	 * @param itemId The ID of the menu item.
	 * @param name The name of the menu item.
	 * @param description The contact number of the customer.
	 * @param price The memberId of the customer.
	 */
	public MenuItems(String itemId,String name, String description, double price)
	{
		this.itemId=itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = 0;
	}

	/**
	 * Gets the price of the menu item.
	 * @return Price of the menu item.
	 */
	public double getPrice() { return this.price; }

	/**
	 * Gets the ID of the menu item.
	 * @return ID of the menu item.
	 */
	public String getItemID() { return this.itemId; }

	/**
	 * Gets the name of the menu item.
	 * @return Name of the menu item.
	 */
	public String getName() { return this.name; }

	/**
	 * Gets the description of the menu item.
	 * @return Description of the menu item.
	 */
	public String getDescription() { return this.description; }

	/**
	 * Gets the quantity of the menu item.
	 * @return Quantity of the menu item.
	 */
	public int getQuantity() { return this.quantity; }

	/**
	 * Sets the name of the menu item.
	 * @param name The name of the menu item.
	 */
	public void updateName(String name) { this.name=name; }

	/**
	 * Sets the description of the menu item.
	 * @param des The description of the menu item.
	 */
	public void updateDescription(String des) { this.description=des; }

	/**
	 * Sets the price of the menu item.
	 * @param price The price of the menu item.
	 */
	public void updatePrice(double price) { this.price=price; }

	/**
	 * Sets the ID of the menu item.
	 * @param id The ID of the menu item.
	 */
	public void updateItemID(String id) { this.itemId=id; }

	/**
	 * Sets the quantity of the menu item.
	 * @param quan The quantity of the menu item.
	 */
	public void updateQuantity(int quan) { this.quantity=quan; }

	/**
	 * Clone a menu items to be added into order list.
	 * @return MenuItems with quantity 0.
	 */
	public MenuItems clone() { return new MenuItems(this.itemId, this.name, this.description, this.price); }
}