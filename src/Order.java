package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	private int orderid;
	//IDK how to do the staff portion
	private int staffid;
	private String staffname;
	private double totalprice;
	private double finalprice;
	private String date;
	private int memberID;
	private boolean ispaid;
	private ArrayList<MenuItems> orderarr;
	private int numofitems;
	public Order()
	{
		this.orderarr = new ArrayList<MenuItems>();
		this.numofitems=0;
		this.totalprice=0;
		this.orderid =0;
	}
	public void updateOrderId(int newid)
	{
		this.orderid=newid;
	}
	
	public void addOrderItem(Menu menu)
	{
		int check =0;
		 System.out.println("What dishes would you like (Please key in its Item ID?");
		 Scanner sc = new Scanner(System.in);
		 String choice = sc.next();
		 
		// Check for same Id first, even we can do that with updateQuantity()
		for(int i=0;i<this.numofitems;i++)
		{
			if(choice.equals(this.orderarr.get(i).getitemID()))
			{
				System.out.println("Item exists, what is the quantity that you would like to add?");
				int quan = sc.nextInt();
				this.orderarr.get(i).updateQuantity(quan + this.orderarr.get(i).getQuantity());
				check=1;
			}
		}

		 switch(choice.charAt(0))
		 {
		 	case 'M':
		 	{
		 		for(int i=0;i<menu.getnumofMain();i++)
		 		{
		 			if(choice.equals((menu.getMain().get(i).getitemID())))
		 			{
		 				orderarr.add((menu.getMain().get(i)).clone());
		 				System.out.println("How many servings would you like?");
		 				orderarr.get(this.numofitems++).updateQuantity(sc.nextInt());
		 				check =1;
		 			}
		 		}
		 	}
		 	break;
		 	case 'B':
		 	{
		 		for(int i=0;i<menu.getnumofBev();i++)
		 		{
		 			if(choice.equals((menu.getBev().get(i).getitemID())))
		 			{
		 				orderarr.add(menu.getBev().get(i));
		 				System.out.println("How many servings would you like?");
		 				orderarr.get(this.numofitems++).updateQuantity(sc.nextInt());
		 				check =1;
		 			}
		 		}
		 	}
		 	break;
		 	case 'D':
		 	{
		 		for(int i=0;i<menu.getnumofDes();i++)
		 		{
		 			if(choice.equals((menu.getDes().get(i).getitemID())))
		 			{
		 				orderarr.add(menu.getDes().get(i));
		 				System.out.println("How many servings would you like?");
		 				orderarr.get(this.numofitems++).updateQuantity(sc.nextInt());
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
		for(int i=0;i<this.numofitems;i++)
		{
			if(id.equals(this.orderarr.get(i).getitemID()))
 			{
				System.out.println("What is the new quantity that you would like?");
				int quan = sc.nextInt();
				this.orderarr.get(i).updateQuantity(quan);
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
		for(int i=0;i<this.numofitems;i++)
		{
			if(id.equals(this.orderarr.get(i).getitemID()))
 			{
				
				check=1;
 			}
			else
			{
				neworder.add(this.orderarr.get(i));
			}
		}
		if (check ==0)
		 {
			 System.out.println("Deleting order Failed..");
			 return;
		 }
		this.orderarr = neworder;
		this.numofitems--;
		
	}
	public void printOrder()
	{
		//sort order based on itemid first
		this.totalprice = 0;
		for(int i =0; i<this.numofitems;i++)
		{
			 System.out.println(i+1 + "\t\t" + this.orderarr.get(i).getitemID() + "\t\t" + this.orderarr.get(i).getName() + "\t\t" + this.orderarr.get(i).getQuantity() + "\t\t" + this.orderarr.get(i).getQuantity()*this.orderarr.get(i).getPrice());
			 this.totalprice += this.orderarr.get(i).getQuantity()*this.orderarr.get(i).getPrice();
		}
		 System.out.println("Total Price is: " + this.totalprice);

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

