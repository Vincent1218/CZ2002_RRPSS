package Project;

import java.util.*;

public class Menu {
	private ArrayList<MenuItems> mainDish;
	private ArrayList<MenuItems> beverages;
	private ArrayList<MenuItems> desserts;
	private ArrayList<MenuItems> promo;

	public Menu()
	{
		this.mainDish = new ArrayList<>();
		this.beverages = new ArrayList<>();
		this.desserts = new ArrayList<>();
		this.promo = new ArrayList<>();
	}
	public int getNumOfMain() { return mainDish.size(); }
	public int getNumOfDes() { return desserts.size(); }
	public int getNumOfBev() { return beverages.size(); }
	public int getNumOfPro() { return promo.size(); }
	public ArrayList<MenuItems> getMain() { return this.mainDish; }
	public ArrayList<MenuItems> getDes() { return this.desserts; }
	public ArrayList<MenuItems> getBev() { return this.beverages; }
	public ArrayList<MenuItems> getPro() { return this.promo; }

	public void displayMenu()
	{
		System.out.printf("%s %45s %60s %20s", "Item ID", "Menu Item","Description","Price");
		System.out.println("");
		System.out.println("Main Dishes---------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<mainDish.size();i++)
		{
			System.out.printf("%s %50s %60s %20.2f\n", mainDish.get(i).getItemID(), mainDish.get(i).getName(), mainDish.get(i).getDescription(), mainDish.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Desserts------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<desserts.size();i++)
		{
			System.out.printf("%s %50s %60s %20.2f\n", desserts.get(i).getItemID(), desserts.get(i).getName(), desserts.get(i).getDescription(), desserts.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Beverages------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<beverages.size();i++)
		{
			System.out.printf("%s %50s %60s %20.2f\n", beverages.get(i).getItemID(), beverages.get(i).getName(), beverages.get(i).getDescription(), beverages.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Promotion Bundles----------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<promo.size();i++)
		{
			System.out.printf("%s %50s %60s %20.2f\n", promo.get(i).getItemID(), promo.get(i).getName(), promo.get(i).getDescription(), promo.get(i).getPrice());
		}
		System.out.println("");
	}
	public void displayLessMenu()
	{
		System.out.printf("%s %45s %60s %20s", "Item ID", "Menu Item","Description","Price");
		System.out.println("");
		System.out.println("Main Dishes--------------------------------------------");
		for(int i=0;i<mainDish.size();i++)
		{
			System.out.printf("%s %50s %60s %20.2f\n", mainDish.get(i).getItemID(), mainDish.get(i).getName(), mainDish.get(i).getDescription(), mainDish.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Desserts----------------------------------------------");
		for(int i=0;i<desserts.size();i++)
		{
			System.out.printf("%s %50s %60s %20.2f\n", desserts.get(i).getItemID(), desserts.get(i).getName(), desserts.get(i).getDescription(), desserts.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Beverages---------------------------------------------");
		for(int i=0;i<beverages.size();i++)
		{
			System.out.printf("%s %50s %60s %20.2f\n", beverages.get(i).getItemID(), beverages.get(i).getName(), beverages.get(i).getDescription(), beverages.get(i).getPrice());
		}
		System.out.println("");
	}
	
	public void addMenuItem()
	{
		String name,description;
		name = "";
		description = "";
		double price=0;
		int counter =0;
		int choice=0;
		Scanner sc = new Scanner(System.in);
		while(counter<3)
		{
			System.out.println("What type of item is the new menu item(Main 1)/(Beverage 2)/(Dessert 3)?");
			try { choice = sc.nextInt();
			sc.nextLine();}
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
		switch (choice)
		{
			case 1:
			{
				System.out.println("What is the name of the new Main Dish?");
				name += sc.nextLine();
				while(counter<3)
				{
					System.out.println("What is the price of this item?");
					try { price = sc.nextDouble();
					sc.nextLine();}
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
				System.out.println("What is the description of the item?");
				description += sc.nextLine();
				MenuItems newitem =new MenuItems("M"+(mainDish.size() + 1),name,description,price);
				mainDish.add(newitem);
				System.out.println("Main Dish item added...");
			}
			break;
			case 2:
			{
				System.out.println("What is the name of the new Beverage?");
				name += sc.nextLine();
				while(counter<3)
				{
					System.out.println("What is the price of this item?");
					try { price = sc.nextDouble();
					sc.nextLine();}
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
				System.out.println("What is the description of the item?");
				description += sc.nextLine();
				MenuItems newitem =new MenuItems("B"+(beverages.size() + 1),name,description,price);
				beverages.add(newitem);
				System.out.println("Beverage item added...");
			}
			break;
			case 3:
			{
				System.out.println("What is the name of the new Dessert?");
				name += sc.nextLine();
				while(counter<3)
				{
					System.out.println("What is the price of this item?");
					try { price = sc.nextDouble();
					sc.nextLine();}
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
				System.out.println("What is the description of the item?");
				description += sc.nextLine();
				MenuItems newitem =new MenuItems("D"+(desserts.size() + 1),name,description,price);
				desserts.add(newitem);
				System.out.println("Dessert item added...");
			}
			break;
		}
	}
	
	public void updateMenuItem()
	{
		int check =0;
		int counter=0;
		String id;
		double newprice =0;
		id = "";
		System.out.println("What type of item is the menu item to be updated(Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice)
		{
			case 1:
			{
				System.out.println("What is the Item ID of the Main Dish to be updated?");
				id = sc.nextLine();
				for(int i=0;i<mainDish.size();i++)
				{
					if (id.equals(mainDish.get(i).getItemID()))
					{
						check =1;
					}
				}
				if(check == 0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					break;
				}
				if(check==1)check=0;
				while(counter<3)
				{
					System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
					
					try { choice = sc.nextInt();
					sc.nextLine();}
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
					if(counter==0) {break;}
				}
				if(counter == 3) 
				{ 
					counter=0;
					System.out.println("Too many Attempts.Return to main program..");
					return;
				}
				for(int i=0;i<mainDish.size();i++)
				{
					if (id.equals(mainDish.get(i).getItemID()))
					{
						switch (choice)
						{
							case 1:
							{
								System.out.println("What is the new name of the Main Dish?");
								String newname = sc.nextLine();
								mainDish.get(i).updateName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Main Dish?");
								String newdes = sc.nextLine();
								mainDish.get(i).updateDescription(newdes);
							}
							break;
							case 3: {
								while(counter<3)
								{
									System.out.println("What is the new price of the Main Dish?");
									try { newprice = sc.nextDouble();
									sc.nextLine();}
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
								mainDish.get(i).updatePrice(newprice);
							}
							break;
						}
						check =1;
					}
				}
				if(check ==0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					System.out.println("");
					System.out.println("Updating Failed...");
					System.out.println("");
				}

			}
			break;
			case 2:
			{
				System.out.println("What is the Item ID of the Beverage to be updated?");
				id = sc.nextLine();
				for(int i=0;i<beverages.size();i++)
				{
					if (id.equals(beverages.get(i).getItemID()))
					{
						check =1;
					}
				}
				if(check == 0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					break;
				}
				if(check==1)check=0;
				while(counter<3)
				{
					System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
					
					try { choice = sc.nextInt(); 
					sc.nextLine();}
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
					if(counter==0) {break;}
				}
				if(counter == 3) 
				{ 
					counter=0;
					System.out.println("Too many Attempts.Return to main program..");
					return;
				}
				for(int i=0;i<beverages.size();i++)
				{
					if (id.equals(beverages.get(i).getItemID()))
					{
						switch (choice)
						{
							case 1:
							{
								System.out.println("What is the new name of the Beverage?");
								String newname = sc.nextLine();
								beverages.get(i).updateName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Beverage?");
								String newdes = sc.nextLine();
								beverages.get(i).updateDescription(newdes);
							}
							break;
							case 3: {
								while(counter<3)
								{
									System.out.println("What is the new price of the Beverage?");
									try { newprice = sc.nextDouble();
									sc.nextLine();}
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
								beverages.get(i).updatePrice(newprice);
							}
							break;
						}
						check =1;
					}
				}
				if(check ==0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					System.out.println("");
					System.out.println("Updating Failed...");
					System.out.println("");
				}
			}
			break;
			case 3:
			{
				System.out.println("What is the Item ID of the Dessert to be updated?");
				id += sc.nextLine();
				for(int i=0;i<desserts.size();i++)
				{
					if (id.equals(desserts.get(i).getItemID()))
					{
						check =1;
					}
				}
				if(check == 0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					break;
				}
				if(check==1)check=0;
				while(counter<3)
				{
					System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
					
					try { choice = sc.nextInt(); 
					sc.nextLine();}
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
					if(counter==0) {break;}
				}
				if(counter == 3) 
				{ 
					counter=0;
					System.out.println("Too many Attempts.Return to main program..");
					return;
				}
				for(int i=0;i<desserts.size();i++)
				{
					if (id.equals(desserts.get(i).getItemID()))
					{
						switch (choice)
						{
							case 1:
							{
								System.out.println("What is the new name of the Dessert?");
								String newname = sc.nextLine();
								desserts.get(i).updateName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Dessert?");
								String newdes = sc.nextLine();
								desserts.get(i).updateDescription(newdes);
							}
							break;
							case 3: {
								while(counter<3)
								{
									System.out.println("What is the new price of the Dessert?");
									try { newprice = sc.nextDouble();
									sc.nextLine();}
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
								desserts.get(i).updatePrice(newprice);
							}
							break;
						}
						check =1;
					}
				}
				if(check ==0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					System.out.println("");
					System.out.println("Updating Failed...");
					System.out.println("");
				}
			}
			break;
		}
	}
	public void deleteMenuItem()
	{
		String id = "";
		System.out.println("What type of item is the menu item to be deleted (Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice)
		{
			case 1:
			{
				System.out.println("What is the itemID of the Main Dish to be deleted?");
				id = sc.nextLine();
				int check = 0;
				for(int i=0;i<mainDish.size();i++)
				{
					if (id.equals(mainDish.get(i).getItemID()))
					{
						check = 1;
						mainDish.remove(i);
						for (int j = i; j < mainDish.size(); j++)
						{
							mainDish.get(j).updateItemID("M" + (j + 1));
						}
					}
				}
				if(check ==0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					System.out.println("");
					System.out.println("Deleting Failed...");
					System.out.println("");
				}
			}
			break;
			case 2:
			{
				System.out.println("What is the itemID of the Beverage to be deleted?");
				id = sc.nextLine();
				int check = 0;
				for(int i=0;i<beverages.size();i++)
				{
					if (id.equals(beverages.get(i).getItemID()))
					{
						check = 1;
						beverages.remove(i);
						for (int j = i; j < beverages.size(); j++)
						{
							beverages.get(j).updateItemID("M" + (j + 1));
						}
					}
				}
				if(check ==0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					System.out.println("");
					System.out.println("Deleting Failed...");
					System.out.println("");
				}
			}
			break;
			case 3:
			{
				System.out.println("What is the itemID of the Beverage to be deleted?");
				id = sc.nextLine();
				int check = 0;
				for(int i=0;i<desserts.size();i++)
				{
					if (id.equals(desserts.get(i).getItemID()))
					{
						check = 1;
						desserts.remove(i);
						for (int j = i; j < desserts.size(); j++)
						{
							desserts.get(j).updateItemID("M" + (j + 1));
						}
					}
				}
				if(check ==0)
				{
					System.out.println("");
					System.out.println("Incorrect Entry. Please try again...");
					System.out.println("");
					System.out.println("Deleting Failed...");
					System.out.println("");
				}
			}
			break;
		}
	}
	
	public void addPromoItem()
	{
		String mainname = "";
		String desname= "";
		String bevname= "";
		String maindes = "";
		String desdes= "";
		String bevdes= "";
		double mainprice=0;
		double bevprice=0;
		double desprice=0;
		int check=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("What combination of Menu Items will be for the Promotion?");
		System.out.println("");
		System.out.println("What is the ID of Main Dish in Promotion Bundle " + ( promo.size() +1 )+ " ?");
		String mainid = sc.nextLine();
		for(int i =0;i<mainDish.size();i++)
		{
			if (mainid.equals(mainDish.get(i).getItemID()))
			{
				mainname= mainDish.get(i).getName();
				mainprice = mainDish.get(i).getPrice();
				maindes = mainDish.get(i).getDescription();
				check=1;
			}
		}
		if(check==0)
		{
			 System.out.println("");
			 System.out.println("Incorrect Entry. Please try again...");
			 System.out.println("");
			 return;
		}
		check=0;
		System.out.println("What is the ID of Beverage in Promotion Bundle " + ( promo.size() +1 )+ " ?");
		String bevid = sc.nextLine();
		for(int i =0;i<beverages.size();i++)
		{
			if (bevid.equals(beverages.get(i).getItemID()))
			{
				bevname= beverages.get(i).getName();
				bevprice = beverages.get(i).getPrice();
				bevdes = beverages.get(i).getDescription();
				check=1;
			}
		}
		if(check==0)
		{
			 System.out.println("");
			 System.out.println("Incorrect Entry. Please try again...");
			 System.out.println("");
			 return;
		}
		check=0;
		System.out.println("What is the ID of Desserts in Promotion Bundle " + ( promo.size() +1 )+ " ?");
		String desid = sc.nextLine();
		for(int i =0;i<desserts.size();i++)
		{
			if (desid.equals(desserts.get(i).getItemID()))
			{
				desname= desserts.get(i).getName();
				desprice = desserts.get(i).getPrice();
				desdes= desserts.get(i).getDescription();
				check=1;
			}
		}
		if(check==0)
		{
			 System.out.println("");
			 System.out.println("Incorrect Entry. Please try again...");
			 System.out.println("");
			 return;
		}
		check=0;
		String Promoname =  mainname + " & " +  bevname + " & " + desname ;
		double promoprice = 0.9*(mainprice+bevprice+desprice);
		String Promodes =  "Set Meal";
		MenuItems newitem =new MenuItems("P"+(promo.size() + 1),Promoname,Promodes,promoprice);
		promo.add(newitem);
		System.out.println("");
		System.out.println("Promotion item added...");
		System.out.println("");
	}
	public void updatePromoItem()
	{
		int choice =0 ;
		int counter = 0;
		int check=0;
		double newprice = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the Item ID of the Promotion to be updated?");
		String id = sc.nextLine();
		for(int i=0;i<promo.size();i++)
		{
			if (id.equals(promo.get(i).getItemID()))
			{
				check =1;
			}
		}
		if(check == 0)
		{
			System.out.println("");
			System.out.println("Incorrect Entry. Please try again...");
			return;
		}
		if(check==1)check=0;
		while(counter<3)
		{
			System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
			try { choice = sc.nextInt(); 
			sc.nextLine();}
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
			if (counter==0) {break;}
		}
		if (counter==3)
		{
			counter=0;
			return;
		}
		for(int i=0;i<promo.size();i++)
		{
			if (id.equals(promo.get(i).getItemID()))
			{
				switch (choice)
				{
					case 1:
					{
						System.out.println("What is the new name of the Promo Dish?");
						String newname = sc.nextLine();
						promo.get(i).updateName(newname);
					}
					break;
					case 2: {
						System.out.println("What is the new description of the Promo Dish?");
						String newdes = sc.nextLine();
						promo.get(i).updateDescription(newdes);
					}
					break;
					case 3: {
						while(counter<3)
						{
							System.out.println("What is the new price of the Promo Dish?");
							try { newprice = sc.nextDouble();
							sc.nextLine();}
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
						promo.get(i).updatePrice(newprice);
					}
					break;
					default:
					 {
						 System.out.println("");
						 System.out.println("Incorrect Entry. Please try again...");
						 System.out.println("");
						 return;
					 }
				}
				check =1;
			}
		}
		if(check ==0)
		{
			System.out.println("");
			System.out.println("Updating Failed...");
			System.out.println("");
		}
	}
	public void deletePromoItem()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the itemID of the Promotion Bundle to be deleted?");
		String id = sc.nextLine();
		int check = 0;
		for(int i=0;i<promo.size();i++)
		{
			if (id.equals(promo.get(i).getItemID()))
			{
				check = 1;
				promo.remove(i);
				for (int j = i; j < promo.size(); j++)
				{
					promo.get(j).updateItemID("P" + (j + 1));
				}
			}
		}
		if(check ==0)
		{
			System.out.println("");
			System.out.println("Deleting Failed...");
			System.out.println("");
		}
	}
}