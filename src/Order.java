package Project;

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
	private MenuItems[] orderarr;
	private int numofitems;
	public Order()
	{
		this.orderarr = new MenuItems[20];
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
		 switch(choice.charAt(0))
		 {
		 	case 'M':
		 	{
		 		for(int i=0;i<menu.getnumofMain();i++)
		 		{
		 			if(choice.equals((menu.getMain())[i].getitemID()))
		 			{
		 				orderarr[this.numofitems++] = (menu.getMain())[i];
		 				System.out.println("How many servings would you like?");
		 				orderarr[this.numofitems-1].quantity = sc.nextInt();
		 				check =1;
		 			}
		 		}
		 	}
		 	break;
		 	case 'B':
		 	{
		 		for(int i=0;i<menu.getnumofBev();i++)
		 		{
		 			if(choice.equals((menu.getBev())[i].getitemID()))
		 			{
		 				orderarr[this.numofitems++] = (menu.getBev())[i];
		 				System.out.println("How many servings would you like?");
		 				orderarr[this.numofitems-1].quantity = sc.nextInt();
		 				check =1;
		 			}
		 		}
		 	}
		 	break;
		 	case 'D':
		 	{
		 		for(int i=0;i<menu.getnumofDes();i++)
		 		{
		 			if(choice.equals((menu.getDes())[i].getitemID()))
		 			{
		 				orderarr[this.numofitems++] = (menu.getDes())[i];
		 				System.out.println("How many servings would you like?");
		 				orderarr[this.numofitems-1].quantity = sc.nextInt();
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
			if(id.equals(this.orderarr[i].getitemID()))
 			{
				System.out.println("What is the new quantity that you would like?");
				int quan = sc.nextInt();
				this.orderarr[i].quantity = quan;
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
		MenuItems[] neworder = new MenuItems[20];
		int j=0;
		System.out.println("What is the Item ID of the Dish to be deleted?");
		Scanner sc =new Scanner(System.in);
		String id = sc.next();
		for(int i=0;i<this.numofitems;i++)
		{
			if(id.equals(this.orderarr[i].getitemID()))
 			{
				
				check=1;
 			}
			else
			{
				neworder[j++]=this.orderarr[i];
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
		for(int i =0; i<this.numofitems;i++)
		{
			 System.out.println(i+1 + "\t\t" + this.orderarr[i].getitemID() + "\t\t" + this.orderarr[i].getName() + "\t\t" + this.orderarr[i].quantity + "\t\t" + this.orderarr[i].quantity*this.orderarr[i].getPrice());
			 this.totalprice += this.orderarr[i].quantity*this.orderarr[i].getPrice();
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

