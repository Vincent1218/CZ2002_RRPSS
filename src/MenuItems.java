package Project;

import java.util.Scanner;

public class MenuItems {
			private String name;
			private String description;
			private double price;
			private String itemid;
			public int quantity;
			
			public MenuItems(String itemid,String name, String description, double price)
			{
				this.itemid=itemid;
				this.name = name;
				this.description = description;
				this.price = price;
				this.quantity =0;
			}
			public double getPrice() {
				return this.price;
			}
			public String getitemID() {
				return this.itemid;
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
			public void updateitemID(String id)
			{
				this.itemid=id;
			}
}
