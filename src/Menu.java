package Project;

import java.util.*;

public class Menu {
	private ArrayList<MenuItems> maindish;
	private ArrayList<MenuItems> beverages;
	private ArrayList<MenuItems> desserts;

	public Menu()
	{
		this.maindish = new ArrayList<>();
		this.beverages = new ArrayList<>();
		this.desserts = new ArrayList<>();
	}
	public int getNumOfMain() { return maindish.size(); }
	public int getNumOfDes() { return desserts.size(); }
	public int getNumOfBev() { return beverages.size(); }
	public ArrayList<MenuItems> getMain() { return this.maindish; }
	public ArrayList<MenuItems> getDes() { return this.desserts; }
	public ArrayList<MenuItems> getBev() { return this.beverages; }

	public void displayMenu()
	{
		System.out.printf("%s %15s %15s %15s", "Item ID", "Menu Item","Description","Price");
		System.out.println("");
		System.out.println("Main Dishes---------------------------------------");
		for(int i=0;i<maindish.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", maindish.get(i).getItemID(), maindish.get(i).getName(), maindish.get(i).getDescription(), maindish.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Desserts-----------------------------------------");
		for(int i=0;i<desserts.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", desserts.get(i).getItemID(), desserts.get(i).getName(), desserts.get(i).getDescription(), desserts.get(i).getPrice());
		}
		System.out.println("");
		System.out.println("Beverages----------------------------------------");
		for(int i=0;i<beverages.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", beverages.get(i).getItemID(), beverages.get(i).getName(), beverages.get(i).getDescription(), beverages.get(i).getPrice());
		}
		System.out.println("");
	}
	
	public void addMenuItem()
	{
		String name,description;
		name = "";
		description = "";
		double price;
		System.out.println("What type of item is the new menu item(Main 1)/(Beverage 2)/(Dessert 3)?");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice)
		{
			case 1:
			{
				System.out.println("What is the name of the new Main Dish?");
				name += sc.nextLine();
				System.out.println("What is the price of this item?");
				price = sc.nextDouble();
				sc.nextLine();
				System.out.println("What is the description of the item?");
				description += sc.nextLine();
				MenuItems newitem =new MenuItems("M"+(maindish.size() + 1),name,description,price);
				maindish.add(newitem);
			}
			break;
			case 2:
			{
				System.out.println("What is the name of the new Beverage?");
				name += sc.nextLine();
				System.out.println("What is the price of this item?");
				price = sc.nextDouble();
				sc.nextLine();
				System.out.println("What is the description of the item?");
				description += sc.nextLine();
				MenuItems newitem =new MenuItems("B"+(beverages.size() + 1),name,description,price);
				beverages.add(newitem);
			}
			break;
			case 3:
			{
				System.out.println("What is the name of the new Dessert?");
				name += sc.nextLine();
				System.out.println("What is the price of this item?");
				price = sc.nextDouble();
				sc.nextLine();
				System.out.println("What is the description of the item?");
				description += sc.nextLine();
				MenuItems newitem =new MenuItems("D"+(desserts.size() + 1),name,description,price);
				desserts.add(newitem);
			}
			break;
		}
	}
	
	public void updateMenuItem()
	{
		String id;
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
				System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				choice = sc.nextInt();
				sc.nextLine();
				int check =0;
				for(int i=0;i<maindish.size();i++)
				{
					if (id.equals(maindish.get(i).getItemID()))
					{
						switch (choice)
						{
							case 1:
							{
								System.out.println("What is the new name of the Main Dish?");
								String newname = sc.nextLine();
								maindish.get(i).updateName(newname);
							}
							break;
							case 2: {
								System.out.println("What is the new description of the Main Dish?");
								String newdes = sc.nextLine();
								maindish.get(i).updateDescription(newdes);
							}
							break;
							case 3: {
								System.out.println("What is the new price of the Main Dish?");
								double newprice = sc.nextDouble();
								maindish.get(i).updatePrice(newprice);
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
				System.out.println("What is the Item ID of the Beverage to be updated?");
				id = sc.nextLine();
				System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				choice = sc.nextInt();
				sc.nextLine();
				int check =0;
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
								System.out.println("What is the new price of the Beverage?");
								double newprice = sc.nextDouble();
								beverages.get(i).updatePrice(newprice);
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
				System.out.println("What is the Item ID of the Dessert to be updated?");
				id += sc.nextLine();
				System.out.println("What of it would you like to update (Name 1)/(Description 2)/(Price 3)?");
				choice = sc.nextInt();
				sc.nextLine();
				int check =0;
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
								System.out.println("What is the new price of the Dessert?");
								double newprice = sc.nextDouble();
								desserts.get(i).updatePrice(newprice);
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
				for(int i=0;i<maindish.size();i++)
				{
					if (id.equals(maindish.get(i).getItemID()))
					{
						check = 1;
						maindish.remove(i);
						for (int j = i; j < maindish.size(); j++)
						{
							maindish.get(j).updateItemID("M" + (j + 1));
						}
					}
				}
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
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
					System.out.println("Deleting Failed...");
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
					System.out.println("Deleting Failed...");
				}
			}

		}
	}
}