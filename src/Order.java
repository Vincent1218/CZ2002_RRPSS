package Project;

import java.util.*;
import java.text.DateFormat;

public class Order {
	private int orderId;
	//IDK how to do the staff portionvoid updateOrderId(int newid)	
	private double totalPrice;
	private double finalPrice = 0;
	private String date;
	private String time;
	private int isMember;
	private boolean isPaid;
	private ArrayList<MenuItems> orderArr;
	private int numOfItems;
	private Staff staff = new Staff(0,"Temp");
	private Tables table = new Tables(0,0);
	private int resID;

	public Order(Staff staff, int resID)
	{
		this.orderArr = new ArrayList<MenuItems>();
		this.numOfItems=0;
		this.totalPrice=0;
		this.orderId =0;
		this.staff= staff;
		this.time = "";
		this.date = "";
		this.isMember = 0;
		this.resID = resID;
		this.isPaid = false;

	}

	public int getResID() { return resID;}
	public String getDate(){ return date; }
	public String getTime() { return time; }
	public boolean getPaid() {return isPaid;}
	public void updatePaid(boolean status) {this.isPaid = status;}
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
  	public void updateMembership(int status) { this.isMember= status ; }
	public void updateDate()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date in DD MMM YYYY:");
		date = sc.nextLine();
		System.out.println("Enter the time in HH:MM AM/PM:");
		time = sc.nextLine();
	}
	public void updateOrderId(int newid) { this.orderId=newid; }
	public int displayStaffId() { return this.staff.getStaffID(); }
	public String displayStaffName() { return this.staff.getStaffName();}
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

	public double getTotalPrice()
	{
		this.totalPrice = 0;
		for (int i = 0; i < orderArr.size(); i++)
		{
			this.totalPrice += this.orderArr.get(i).getQuantity()*this.orderArr.get(i).getPrice();
		}
		this.totalPrice = Math.round(this.totalPrice * 100.0)/100.0;
		return this.totalPrice;
	}

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