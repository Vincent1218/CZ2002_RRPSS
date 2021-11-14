package Project;

import java.util.*;
import java.text.DateFormat;

/**
 * Represents an order in order list.
 */

public class Order {
	/**
	 * The ID of the order in order list, starts with 1.
	 */
	private int orderId;

	/**
	 * The total price of items.
	 */
	private double totalPrice;

	/**
	 * The final price of order after discount, service tax, gst.
	 */
	private double finalPrice;

	/**
	 * The date of order paid.
	 */
	private String date;

	/**
	 * The time of order paid.
	 */
	private String time;

	/**
	 * The record to check if the order is made by a member.
	 */
	private int isMember;

	/**
	 * The record to check if order is paid.
	 */
	private boolean isPaid;

	/**
	 * The list of ordered menu items.
	 */
	private ArrayList<MenuItems> orderArr;

	/**
	 * The number of ordered items.
	 */
	private int numOfItems;

	/**
	 * The Staff that take the order.
	 */
	private Staff staff = new Staff(0,"Temp");

	/**
	 * The table that the customer eats at.
	 */
	private Tables table = new Tables(0,0);

	/**
	 * The reservation ID of the customer that makes the order.
	 */
	private int resID;

	/**
	 * Creates an Order with the given parameters.
	 * @param staff The Staff that take the order.
	 * @param resID The reservation ID of the customer that makes the order.
	 */
	public Order(Staff staff, int resID)
	{
		this.orderArr = new ArrayList<MenuItems>();
		this.numOfItems=0;
		this.totalPrice=0;
		this.finalPrice=0;
		this.orderId =0;
		this.staff= staff;
		this.time = "";
		this.date = "";
		this.isMember = 0;
		this.resID = resID;
		this.isPaid = false;

	}

	/**
	 * Gets the reservation ID of the order.
	 * @return Reservation ID of the order.
	 */
	public int getResID() { return resID;}

	/**
	 * Gets the date of order paid.
	 * @return Date of order paid.
	 */
	public String getDate(){ return date; }

	/**
	 * Gets the time of order paid.
	 * @return Time of order paid.
	 */
	public String getTime() { return time; }

	/**
	 * Gets the paid status of the order.
	 * @return Paid status of the order.
	 */
	public boolean getPaid() {return isPaid;}

	/**
	 * Gets the string with both date and time
	 * @return String with both date and time
	 */
	public String getDateTime() //get a string with both date and time
	{
		if (date == null || date.length() == 0)
		{
			Date curdate = new Date();
			date= DateFormat.getDateInstance().format(curdate);
			time = DateFormat.getTimeInstance(DateFormat.SHORT).format(curdate);
			return date + " " + time;
		}
		else
		{
			return date + " " + time;
		}
	}

	/**
	 * Sets the paid status of the order.
	 * @param status The paid status of the order.
	 */
	public void updatePaid(boolean status) {this.isPaid = status;}

	/**
	 * Sets the membership status of the order.
	 * @param status The membership status of the order.
	 */
  	public void updateMembership(int status) { this.isMember= status ; }

	/**
	 * Update the date of the order.
	 */
	public void updateDate()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date in DD MMM YYYY:");
		date = sc.nextLine();
		System.out.println("Enter the time in HH:MM AM/PM:");
		time = sc.nextLine();
	}

	/**
	 * Sets the order ID of the order.
	 * @param newid The order id of the order.
	 */
	public void updateOrderId(int newid) { this.orderId=newid; }

	/**
	 * Get the staff ID that takes this order.
	 * @return Staff ID that takes this order.
	 */
	public int displayStaffId() { return this.staff.getStaffID(); }

	/**
	 * Get the staff name that takes this order.
	 * @return Staff name that takes this order.
	 */
	public String displayStaffName() { return this.staff.getStaffName();}

	/**
	 * Ask for menu items that customer wants to order.
	 * Check for information validity before adding to the record.
	 * @param menu The complete menu of the restaurant.
	 */
	public void addOrderItem(Menu menu)
	{
		int quan = 0;
		int check =0;
		int counter=0;
		menu.displayMenu();
		 System.out.println("What dishes would you like (Please key in its Item ID)");
		 Scanner sc = new Scanner(System.in);
		 String choice = sc.next();
		 
//		 Check for same Id first, even we can do that with updateQuantity()
		if(this.numOfItems>0)
		{
			for(int i=0;i<this.numOfItems;i++)
			{
				if(choice.equals(this.orderArr.get(i).getItemID()))
				{
					while(counter<3)
					{
						System.out.println("Item exists, what is the quantity that you would like to add?");
						try 
						{ 
							quan = sc.nextInt(); 
							sc.nextLine();
							if (quan<=0)
							{
								System.out.println("Incorrect Entry.Please Try Again..");
								System.out.println("");
								++counter;
								continue;
							}
						}
						catch(InputMismatchException ex)
						{
							if(counter<2)
							{
								System.out.println("Incorrect Entry.Please Try Again..");
								System.out.println("");
							}
							sc.next();
							++counter;
							continue;
						}
						counter = 0;
						if(counter == 0) { break; }
					}
					if(counter == 3) 
					{ 
						counter=0;
						System.out.println("Too many Attempts.Return to main program..");
						return;
					}
					this.orderArr.get(i).updateQuantity(quan + this.orderArr.get(i).getQuantity());
					return;
				}
			}
		}
		switch (choice.charAt(0)) {
			case 'M': {
				for (int i = 0; i < menu.getNumOfMain(); i++) {
					if (choice.equals((menu.getMain().get(i).getItemID()))) {
						orderArr.add((menu.getMain().get(i)).clone());
						while(counter<3)
						{
							System.out.println("How many servings would you like?");	
							try 
							{ 
								quan = sc.nextInt(); 
								sc.nextLine();
								if (quan<=0)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
									++counter;
									continue;
								}
							}
							catch(InputMismatchException ex)
							{
								if(counter<2)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
								}
								sc.next();
								++counter;
								continue;
							}
							counter = 0;
							if(counter == 0) { break; }
						}
						if(counter == 3) 
						{ 
							counter=0;
							System.out.println("Too many Attempts.Return to main program..");
							return;
						}
						orderArr.get(this.numOfItems++).updateQuantity(quan);
						check = 1;
					}
				}
			}
			break;
			case 'B': {
				for (int i = 0; i < menu.getNumOfBev(); i++) {
					if (choice.equals((menu.getBev().get(i).getItemID()))) {
						orderArr.add((menu.getBev().get(i)).clone());
						while(counter<3)
						{
							System.out.println("How many servings would you like?");	
							try 
							{ 
								quan = sc.nextInt(); 
								sc.nextLine();
								if (quan<=0)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
									++counter;
									continue;
								}
							}
							catch(InputMismatchException ex)
							{
								if(counter<2)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
								}
								sc.next();
								++counter;
								continue;
							}
							counter = 0;
							if(counter == 0) { break; }
						}
						if(counter == 3) 
						{ 
							counter=0;
							System.out.println("Too many Attempts.Return to main program..");
							return;
						}
						orderArr.get(this.numOfItems++).updateQuantity(quan);
						check = 1;
					}
				}
			}
			break;
			case 'D': {
				for (int i = 0; i < menu.getNumOfDes(); i++) {
					if (choice.equals((menu.getDes().get(i).getItemID()))) {
						orderArr.add((menu.getDes().get(i)).clone());
						while(counter<3)
						{
							System.out.println("How many servings would you like?");	
							try 
							{ 
								quan = sc.nextInt(); 
								sc.nextLine();
								if (quan<=0)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
									++counter;
									continue;
								}
							}
							catch(InputMismatchException ex)
							{
								if(counter<2)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
								}
								sc.next();
								++counter;
								continue;
							}
							counter = 0;
							if(counter == 0) { break; }
						}
						if(counter == 3) 
						{ 
							counter=0;
							System.out.println("Too many Attempts.Return to main program..");
							return;
						}
						orderArr.get(this.numOfItems++).updateQuantity(quan);
						check = 1;
					}
				}
			}
			break;
			case 'P': {
				for (int i = 0; i < menu.getNumOfPro(); i++) {
					if (choice.equals((menu.getPro().get(i).getItemID()))) {
						orderArr.add((menu.getPro().get(i)).clone());
						while(counter<3)
						{
							System.out.println("How many servings would you like?");	
							try 
							{ 
								quan = sc.nextInt(); 
								sc.nextLine();
								if (quan<=0)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
									++counter;
									continue;
								}
							}
							catch(InputMismatchException ex)
							{
								if(counter<2)
								{
									System.out.println("Incorrect Entry.Please Try Again..");
									System.out.println("");
								}
								sc.next();
								++counter;
								continue;
							}
							counter = 0;
							if(counter == 0) { break; }
						}
						if(counter == 3) 
						{ 
							counter=0;
							System.out.println("Too many Attempts.Return to main program..");
							return;
						}
						orderArr.get(this.numOfItems++).updateQuantity(quan);
						check = 1;
					}
				}
			}
			break;
			default:
			 {
				 System.out.println("");
				 System.out.println("Incorrect Entry. Please try again...");
				 System.out.println("");
			 }
			 break;
		}
		 if (check ==0)
		 {
			 System.out.println("Adding order Failed..");
		 }
	}

	/**
	 * Update item quantity of a menu item in the order.
	 * Ask for ID of menu item to be updated.
	 * Check for information validity before changing the record.
	 */
	public void updateOrderItemQuantity()
	{
		int check =0;
		int quan=0;
		int counter =0;
		System.out.println("What is the Item ID of the Dish that needs its quantity to be updated?");
		Scanner sc =new Scanner(System.in);
		String id = sc.next();
		for(int i=0;i<this.numOfItems;i++)
		{
			if(id.equals(this.orderArr.get(i).getItemID()))
 			{
				while(counter<3)
				{
					System.out.println("What is the new quantity that you would like?");
					try
					{ 
						quan = sc.nextInt(); 
						sc.nextLine();
						if (quan<=0)
						{
							System.out.println("Incorrect Entry.Please Try Again..");
							System.out.println("");
							++counter;
							continue;
						}
					}
					catch(InputMismatchException ex)
					{
						if(counter<2)
						{
							System.out.println("Incorrect Entry.Please Try Again..");
							System.out.println("");
						}
						sc.next();
						++counter;
						continue;
					}
					counter = 0;
					if(counter == 0) { break; }
				}
				if(counter == 3) 
				{ 
					counter=0;
					System.out.println("Too many Attempts.Return to main program..");
					return;
				}
				this.orderArr.get(i).updateQuantity(quan);
				check=1;
 			}
		}
		if (check ==0)
		 {
			 System.out.println("");
			 System.out.println("Incorrect Entry. Please try again...");
			 System.out.println("");
			 System.out.println("Adding order Failed..");
		 }
	}

	/**
	 * Delete menu item from order.
	 * Ask for ID of menu item to be deleted.
	 * Check for information validity before deleting the record.
	 */
	public void deleteOrderItem()
	{
		int check =0;
		ArrayList<MenuItems> neworder = new ArrayList<>();
		int j=0;
		System.out.println("What is the Item ID of the Dish to be deleted?");
		Scanner sc =new Scanner(System.in);
		String id = sc.next();
		for(int i=0;i<this.numOfItems;i++)
		{
			if(id.equals(this.orderArr.get(i).getItemID()))
 			{
				
				check=1;
 			}
			else
			{
				neworder.add(this.orderArr.get(i));
			}
		}
		if (check ==0)
		 {
			 System.out.println("Deleting order Failed..");
			 return;
		 }
		this.orderArr = neworder;
		this.numOfItems--;
		
	}

	/**
	 * Print invoice for the order.
	 */
	public void printOrder()
	{
		//sort order based on itemid first
		this.totalPrice = 0;
		for(int i =0; i<this.numOfItems;i++)
		{
			 System.out.println(i+1 + "\t\t" + this.orderArr.get(i).getItemID() + "\t\t" + this.orderArr.get(i).getName() + "\t\t" + this.orderArr.get(i).getQuantity() + "\t\t" + this.orderArr.get(i).getQuantity()*this.orderArr.get(i).getPrice());
			 this.totalPrice += this.orderArr.get(i).getQuantity()*this.orderArr.get(i).getPrice();
		}
		totalPrice = Math.round(totalPrice * 100.0)/100.0;
		System.out.println("");
	    System.out.println("Total Price is: $" + this.totalPrice);
	    System.out.println("");
	    
		if(this.isMember ==1)
		{
			System.out.println("This order is eligible for the 10% membership discount");
			System.out.println("");
			double tempprice = 1.17*this.totalPrice;
			tempprice = Math.round(tempprice * 100.0)/100.0;
			System.out.println("Price after 17% GST is now: $" + (tempprice));
			System.out.println("");
			this.finalPrice = 0.9*tempprice;
			this.finalPrice = Math.round(this.finalPrice * 100.0)/100.0;
			System.out.println("Price after 10% Membership discount is now: $" + (this.finalPrice));
			System.out.println("");
			System.out.println("Final Price is : $" + (this.finalPrice));
			System.out.println("");
		}
		else
		{
			System.out.println("This order is not eligible for the discount");
			System.out.println("");
			double tempprice = 1.17*this.totalPrice;
			tempprice = Math.round(tempprice * 100.0)/100.0;
			System.out.println("Price after 17% GST is now: $" + (tempprice));
			System.out.println("");
			this.finalPrice = tempprice;
		}

	}


	/**
	 * Gets the final price of the order.
	 * @return Final price of the order.
	 */
	public double getFinalPrice()
	{
		if (this.finalPrice == 0)
		{
			System.out.println("Final Price of this order has not been calculated. Print the order invoice to get the final price.");
			return 0;
		}
		return this.finalPrice;
	}
	
}