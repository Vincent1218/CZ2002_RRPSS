package Project;
import java.util.Scanner;

public class Menu {
	private MenuItems[] maindish;
	private MenuItems[] beverages;
	private MenuItems[] desserts;
	private static int numofmain=0;
	private static int numofbev=0;
	private static int numofdes=0;
	
	public Menu()
	{
		this.maindish = new MenuItems[12];
		this.beverages = new MenuItems[12];
		this.desserts = new MenuItems[12];
	}
	public void displayMenu()
	{
		System.out.println("Menu Item--------------Description--------------Price");
		System.out.println("");
		System.out.println("Main Dishes---------------------------------------");
		System.out.print(numofmain);
		 for(int i=0;i<numofmain;i++)
		 {
			 System.out.println(maindish[i].getName());
		 }
		 System.out.println("");
		 System.out.println("Desserts-----------------------------------------");
		 for(int i=0;i<numofdes;i++)
		 {
			 System.out.println(desserts[i].getName() + "\t\t" + desserts[i].getDescription() + "\t\t" + desserts[i].getPrice());
		 }
		 System.out.println("");
		 System.out.println("Beverages----------------------------------------");
		 for(int i=0;i<numofbev;i++)
		 {
			 System.out.println(beverages[i].getName() + "\t\t" + beverages[i].getDescription() + "\t\t" + beverages[i].getPrice());
		 }
		 System.out.println("");
	}
	public void addMenuItem()
	{
		String name,description;
		double price;
		 System.out.println("What type of item is the new menu item(Main 1)/(Beverage 2)/(Dessert 3)?");
		 Scanner sc = new Scanner(System.in);
		 int choice = sc.nextInt();
		 
		 switch (choice)
		 {
		 case 1:
		 {
			 System.out.println("What is the name of the new Main Dish?");
			 name = sc.next();
			 System.out.println("What is the price of this item?");
			 price = sc.nextDouble();
			 System.out.println("What is the description of the item?");
			 description =sc.next();
			 MenuItems newitem =new MenuItems(name,description,price);
			 maindish[numofmain++]=newitem;
			 
		 }
		 break;
		 case 2:
		 {
			 System.out.println("What is the name of the new Beverage?");
			 name = sc.next();
			 System.out.println("What is the price of this item?");
			 price = sc.nextDouble();
			 System.out.println("What is the description of the item?");
			 description =sc.next();
			 MenuItems newitem =new MenuItems(name,description,price);
			 beverages[numofbev++]=newitem;
		 }
		 break;
		 case 3:
		 {
			 System.out.println("What is the name of the new Dessert?");
			 name = sc.next();
			 System.out.println("What is the price of this item?");
			 price = sc.nextDouble();
			 System.out.println("What is the description of the item?");
			 description =sc.next();
			 MenuItems newitem =new MenuItems(name,description,price);
			 desserts[numofdes++]=newitem;
		 }
		 break;
		 }
	}
	public void updateMenuItem()
	{
		String name;
		System.out.println("What type of item is the menu item to be updated(Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
		 int choice = sc.nextInt();
		 
		 switch (choice) 
		 {
			 case 1:
			 {
				 System.out.println("What is the name of the Main Dish to be updated?");
				 name = sc.next();
				 System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				 choice = sc.nextInt();
				 int check =0;
				 for(int i=0;i<numofmain;i++)
				 {
					 if (name.equals(maindish[i].getName()))
					 {
						 switch (choice) 
						 {
							 case 1: 
							 {
								 System.out.println("What is the new name of the Main Dish?");
								 String newname = sc.next();
								 maindish[i].updateName(newname);
							 }
							 break;
							 case 2: {
								 System.out.println("What is the new description of the Main Dish?");
								 String newdes = sc.next();
								 maindish[i].updateDescription(newdes);
							 }
							 break;
							 case 3: {
								 System.out.println("What is the new price of the Main Dish?");
								 double newprice = sc.nextDouble();
								 maindish[i].updatePrice(newprice);
							 }
							 break;
						 }
						 check =1;
					 }
				 }
				if(check ==0)
				{
					System.out.println("Updating Failed...");
				}
				 
			 }
			 break;
			 case 2:
			 {
				 System.out.println("What is the name of the Beverage to be updated?");
				 name = sc.next();
				 System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				 choice = sc.nextInt();
				 int check =0;
				 for(int i=0;i<numofbev;i++)
				 {
					 if (name.equals(beverages[i].getName()))
					 {
						 switch (choice) 
						 {
							 case 1: 
							 {
								 System.out.println("What is the new name of the Beverage?");
								 String newname = sc.next();
								 beverages[i].updateName(newname);
							 }
							 break;
							 case 2: {
								 System.out.println("What is the new description of the Beverage?");
								 String newdes = sc.next();
								 beverages[i].updateDescription(newdes);
							 }
							 break;
							 case 3: {
								 System.out.println("What is the new price of the Beverage?");
								 double newprice = sc.nextDouble();
								 beverages[i].updatePrice(newprice);
							 }
							 break;
						 }
						 check =1;
					 }
				 }
				if(check ==0)
				{
					System.out.println("Updating Failed...");
				}
			 }
			 break;
			 case 3:
			 {
				 System.out.println("What is the name of the Dessert to be updated?");
				 name = sc.next();
				 System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				 choice = sc.nextInt();
				 int check =0;
				 for(int i=0;i<numofdes;i++)
				 {
					 if (name.equals(desserts[i].getName()))
					 {
						 switch (choice) 
						 {
							 case 1: 
							 {
								 System.out.println("What is the new name of the Dessert?");
								 String newname = sc.next();
								 desserts[i].updateName(newname);
							 }
							 break;
							 case 2: {
								 System.out.println("What is the new description of the Dessert?");
								 String newdes = sc.next();
								 desserts[i].updateDescription(newdes);
							 }
							 break;
							 case 3: {
								 System.out.println("What is the new price of the Dessert?");
								 double newprice = sc.nextDouble();
								 desserts[i].updatePrice(newprice);
							 }
							 break;
						 }
						 check =1;
				 }
			 }
				if(check ==0)
				{
					System.out.println("Updating Failed...");
				}
			 }
		 }
	}
	public void deleteMenuItem()
	{
		String name;
		System.out.println("What type of item is the menu item to be deleted (Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		 switch (choice) 
		 {
			 case 1:
			 {
				 MenuItems[] newmains = new MenuItems[12];
				 int j=0;
				 System.out.println("What is the name of the Main Dish to be deleted?");
				 name = sc.next();
				 int check =0;
				 for(int i=0;i<numofbev;i++)
				 {
					 if (name.equals(maindish[i].getName()))
					 {
						 check =1;
					 }
					 else
					 {
						 newmains[j++]=maindish[i];
					 }
				 }
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
				numofmain--;
				maindish = newmains;
				 
			 }
			 break;
			 case 2:
			 {
				 MenuItems[] newbevs = new MenuItems[12];
				 int j=0;
				 System.out.println("What is the name of the Beverage to be deleted?");
				 name = sc.next();
				 int check =0;
				 for(int i=0;i<numofbev;i++)
				 {
					 if (name.equals(beverages[i].getName()))
					 {
						 check =1;
					 }
					 else
					 {
						 newbevs[j++]=desserts[i];
					 }
				 }
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
				numofbev--;
				beverages = newbevs;
			 }
			 break;
			 case 3:
			 {
				 MenuItems[] newdesserts = new MenuItems[12];
				 int j=0;
				 System.out.println("What is the name of the Beverage to be deleted?");
				 name = sc.next();
				 int check =0;
				 for(int i=0;i<numofbev;i++)
				 {
					 if (name.equals(beverages[i].getName()))
					 {
						 check =1;
					 }
					 else
					 {
						 newdesserts[j++]=desserts[i];
					 }
				 }
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
				numofdes--;
				desserts = newdesserts;
			 }	
	
		 }
	}
}
