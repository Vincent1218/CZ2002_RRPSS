package Project;

import java.util.Scanner;

public class MenuItems {
			private String name;
			private String description;
			private double price;
			
			public MenuItems(String name, String description, double price)
			{
				this.name = name;
				this.description = description;
				this.price = price;
			}
			public double getPrice() {
				return this.price;
			}
			public String getName() {
				return this.name;
			}
			public String getDescription() {
				return this.description;
			}
			public void updateName(String newname)
			{
				this.name=newname;
			}
			public void updateDescription(String newdes)
			{
				this.description=newdes;
			}
			public void updatePrice(double newPrice)
			{
				this.price=newPrice;
			}
}
