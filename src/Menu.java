package Project;
import java.util.*;

public class Menu {
	private ArrayList<MenuItems> maindish;
	private ArrayList<MenuItems> beverages;
	private ArrayList<MenuItems> desserts;
	//private int numofmain;
	//private int numofbev;
	//private int numofdes;

	public Menu()
	{
		this.maindish = new ArrayList<>();
		this.beverages = new ArrayList<>();
		this.desserts = new ArrayList<>();
		//this.numofmain=0;
		//this.numofdes=0;
		//this.numofbev=0;
	}
	public int getnumofMain()
	{
		return maindish.size();
		//return this.numofmain;
	}
	public int getnumofDes()
	{
		return desserts.size();
		//return this.numofdes;
	}
	public int getnumofBev()
	{
		return beverages.size();
		//return this.numofbev;
	}
	public ArrayList<MenuItems> getMain()
	{
		return this.maindish;
	}
	public ArrayList<MenuItems> getDes()
	{
		return this.desserts;
	}
	public ArrayList<MenuItems> getBev()
	{
		return this.beverages;
	}
	public void displayMenu()
	{
		System.out.printf("%s %15s %15s %15s", "Item ID", "Menu Item","Description","Price");
		System.out.println("");
		System.out.println("Main Dishes---------------------------------------");
		for(int i=0;i<maindish.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", maindish.get(i).getitemID(), maindish.get(i).getName(), maindish.get(i).getDescription(), maindish.get(i).getPrice());
			//maindish[i].getitemID(), maindish[i].getName(), maindish[i].getDescription(), maindish[i].getPrice()
		}
		System.out.println("");
		System.out.println("Desserts-----------------------------------------");
		for(int i=0;i<desserts.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", desserts.get(i).getitemID(), desserts.get(i).getName(), desserts.get(i).getDescription(), desserts.get(i).getPrice());
			//System.out.println(desserts[i].getName() + "\t\t" + desserts[i].getDescription() + "\t\t" + desserts[i].getPrice());
		}
		System.out.println("");
		System.out.println("Beverages----------------------------------------");
		for(int i=0;i<beverages.size();i++)
		{
			System.out.printf("%s %20s %20s %20.2f\n", beverages.get(i).getitemID(), beverages.get(i).getName(), beverages.get(i).getDescription(), beverages.get(i).getPrice());
			//System.out.println(beverages[i].getName() + "\t\t" + beverages[i].getDescription() + "\t\t" + beverages[i].getPrice());
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
				//numofmain++;
				//maindish[this.numofmain++]=newitem;
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
				//numofbev++;
				//beverages[this.numofbev++]=newitem;
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
				//numofdes++;
				//desserts[this.numofdes++]=newitem;
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
					if (id.equals(maindish.get(i).getitemID()))
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
					if (id.equals(beverages.get(i).getitemID()))
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
					if (id.equals(desserts.get(i).getitemID()))
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
				 /*MenuItems[] newmains = new MenuItems[12];
				 int j=0;
				 System.out.println("What is the itemID of the Main Dish to be deleted?");
				 id = sc.nextLine();
				 int check =0;
				 for(int i=0;i<this.numofmain;i++)
				 {
					 if (id.equals(maindish[i].getitemID()))
					 {
						 check =1;
					 }
					 else
					 {
						 newmains[j++]=maindish[i];
						 newmains[j-1].updateitemID("M" +(j));
					 }
				 }
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
				this.numofmain--;
				maindish = newmains;*/
				System.out.println("What is the itemID of the Main Dish to be deleted?");
				id = sc.nextLine();
				int check = 0;
				for(int i=0;i<maindish.size();i++)
				{
					if (id.equals(maindish.get(i).getitemID()))
					{
						check = 1;
						maindish.remove(i);
						for (int j = i; j < maindish.size(); j++)
						{
							maindish.get(j).updateitemID("M" + (j + 1));
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
				 /*MenuItems[] newbevs = new MenuItems[12];
				 int j=0;
				 System.out.println("What is the name of the Beverage to be deleted?");
				 id = sc.nextLine();
				 int check =0;
				 for(int i=0;i<this.numofbev;i++)
				 {
					 if (id.equals(beverages[i].getitemID()))
					 {
						 check =1;
					 }
					 else
					 {
						 newbevs[j++]=beverages[i];
						 newbevs[j-1].updateitemID("M" +(j));
					 }
				 }
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
				this.numofbev--;
				beverages = newbevs;*/
				System.out.println("What is the itemID of the Beverage to be deleted?");
				id = sc.nextLine();
				int check = 0;
				for(int i=0;i<beverages.size();i++)
				{
					if (id.equals(beverages.get(i).getitemID()))
					{
						check = 1;
						beverages.remove(i);
						for (int j = i; j < beverages.size(); j++)
						{
							beverages.get(j).updateitemID("M" + (j + 1));
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
				 /*MenuItems[] newdesserts = new MenuItems[12];
				 int j=0;
				 System.out.println("What is the name of the Beverage to be deleted?");
				 id = sc.nextLine();
				 int check =0;
				 for(int i=0;i<this.numofdes;i++)
				 {
					 if (id.equals(desserts[i].getitemID()))
					 {
						 check =1;
					 }
					 else
					 {
						 newdesserts[j++]=desserts[i];
						 newdesserts[j-1].updateitemID("M" +(j));
					 }
				 }
				if(check ==0)
				{
					System.out.println("Deleting Failed...");
				}
				this.numofdes--;
				desserts = newdesserts;*/
				System.out.println("What is the itemID of the Beverage to be deleted?");
				id = sc.nextLine();
				int check = 0;
				for(int i=0;i<desserts.size();i++)
				{
					if (id.equals(desserts.get(i).getitemID()))
					{
						check = 1;
						desserts.remove(i);
						for (int j = i; j < desserts.size(); j++)
						{
							desserts.get(j).updateitemID("M" + (j + 1));
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
