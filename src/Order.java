package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	private int orderId;
	//IDK how to do the staff portion
	private int staffID;
	private String staffName;
	private double totalPrice;
	private double finalPrice;
	private String date;
	private int memberID;
	private boolean isPaid;
	private ArrayList<MenuItems> orderArr;
	private int numOfItems;
	Staff staff = new Staff();	
	public Order(int staffID)	
	{	
		this.orderArr = new ArrayList<MenuItems>();	
		this.numOfItems=0;	
		this.totalPrice=0;	
		this.orderId =0;	
		this.staffID= staffID;	
		this.staffName= staff.getStaffName(staffID);	
	}	
	public void updateorderId(int newid)	
	{	
		this.orderId=newid;	
	}	
	public int displaystaffID()	
	{	
		return this.staffID;	
	}	
	public String displayStaffName()	
	{	
		return this.staffName;	
	}
	public void addOrderItem(Menu menu)
	{
		int check =0;
		 System.out.println("What dishes would you like (Please key in its Item ID?");
		 Scanner sc = new Scanner(System.in);
		 String choice = sc.next();
		 
		// Check for same Id first, even we can do that with updateQuantity()
		for(int i=0;i<this.numOfItems;i++)
		{
			if(choice.equals(this.orderArr.get(i).getItemID()))
			{
				System.out.println("Item exists, what is the quantity that you would like to add?");
				int quan = sc.nextInt();
				this.orderArr.get(i).updateQuantity(quan + this.orderArr.get(i).getQuantity());
				check=1;
			}
		}

		 switch(choice.charAt(0))
		 {
		 	case 'M':
		 	{
		 		for(int i=0;i<menu.getNumOfMain();i++)
		 		{
		 			if(choice.equals((menu.getMain().get(i).getItemID())))
		 			{
		 				orderArr.add((menu.getMain().get(i)).clone());
		 				System.out.println("How many servings would you like?");
		 				orderArr.get(this.numOfItems++).updateQuantity(sc.nextInt());
		 				check =1;
		 			}
		 		}
		 	}
		 	break;
		 	case 'B':
		 	{
		 		for(int i=0;i<menu.getNumOfBev();i++)
		 		{
		 			if(choice.equals((menu.getBev().get(i).getItemID())))
		 			{
		 				orderArr.add((menu.getBev().get(i)).clone());
		 				System.out.println("How many servings would you like?");
		 				orderArr.get(this.numOfItems++).updateQuantity(sc.nextInt());
		 				check =1;
		 			}
		 		}
		 	}
		 	break;
		 	case 'D':
		 	{
		 		for(int i=0;i<menu.getNumOfDes();i++)
		 		{
		 			if(choice.equals((menu.getDes().get(i).getItemID())))
		 			{
		 				orderArr.add((menu.getDes().get(i)).clone());
		 				System.out.println("How many servings would you like?");
		 				orderArr.get(this.numOfItems++).updateQuantity(sc.nextInt());
		 				check =1;
		 			}
		 		}
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
		System.out.println("What is the Item ID of the Dish that needs its quantity to be updated?");
		Scanner sc =new Scanner(System.in);
		 String id = sc.next();
		for(int i=0;i<this.numOfItems;i++)
		{
			if(id.equals(this.orderArr.get(i).getItemID()))
 			{
				System.out.println("What is the new quantity that you would like?");
				int quan = sc.nextInt();
				this.orderArr.get(i).updateQuantity(quan);
				check=1;
 			}
		}
		if (check ==0)
		 {
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
		 System.out.println("Total Price is: " + this.totalPrice);

	}
	public void calcfinalPrice()
	{
		//DK about the pricing and all so left it blank (should be easy to do though)
	}
	public void sortOrder()
	{
		//sort based on type of dish this one can use previous lab sorting mechanism
	}
	
}