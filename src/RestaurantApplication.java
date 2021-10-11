import java.util.Scanner;

public class RestaurantApplication {
	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);		
		do {
		System.out.println("(1) Create/Update/Remove menu item");
		System.out.println("(2) Create/Update/Remove promotion");
		System.out.println("(3) Create order");
		System.out.println("(4) View order");
		System.out.println("(5) Add/Remove order item/s to/from order");
		System.out.println("(6) Create reservation booking");
		System.out.println("(7) Check/Remove reservation booking");
		System.out.println("(8) Check table availability");
		System.out.println("(9) Print order invoice");
		System.out.println("(10) Print sale revenue report by period (eg day or month)");
		System.out.println("(11) Exit");
		System.out.println("");
		System.out.print("Enter your Choice: ");
		choice = sc.nextInt();
		int numoffooditems = 0;
		FoodItems[] order = new FoodItems[numoffooditems];
		switch (choice) {
		 case 1: 
		 {
			 //Create/Update/Remove menu item function
		 }
		 break;
		 case 2: {
			//Create/Update/Remove promotion function
		 }
		 break;
		 case 3: {
			//Create order function
			 //display menu lets person choose based on switch function number
			 //append to the array
		 }
		 }
		 break;
		 case 4: 
		 {
			//View order function
			  double totalprice=0;
			 System.out.print("Menu Item--------------Quantity--------------Price");
			 for(int i=0;i<numoffooditems;i++)
			 {
				 System.out.println(order[i].displayName() + "\t\t" + order[i].displayQuantity() + "\t\t" + order[i].getTotPrice());
				 totalprice += order[i].getTotPrice();
			 }
			 System.out.println("\t\t\t\t\t" + totalprice);

			 
		 } 
		 break;
		 case 5:
		 {
			//Add/Remove order item/s to/from order function
			 //justdelete the array slot and move pack the array up eg, if array slot[2] is deleted move slot[3] to slot[2]etc etc

		 }
		 break;
		 case 6:
		 {
			//Create reservation booking function
			 //Create reservation booking function
			 System.out.println("Whose name will the reservation be under?");
			 String name = sc.next();
			 System.out.println("Number of Pax?");
			 int numofpax = sc.nextInt();
			 System.out.println("Time of Reservation?");
			 double time = sc.nextDouble();
			 System.out.println("May I get your Contact Number?");
			 int contactnum = sc.nextInt();
			 //Attach this uinfo to array somehow probably to an overarching array. sop one array anmd in that 1 array slot has the array of food and contact details.
		 }
		 break;	 
		 case 7: 
		 {
			 //Check/Remove reservation booking function
		 }
		 break;
		 case 8: {
			//Check table availability function
		 }
		 break;
		 case 9: {
			//Print order invoice function
			 double totalprice=0;
			 System.out.print("Menu Item--------------Quantity--------------Price");
			//View order function
			 for(int i=0;i<numoffooditems;i++)
			 {
				 System.out.println(order[i].displayName() + "\t\t" + order[i].displayQuantity() + "\t\t" + order[i].getTotPrice());
				 totalprice += order[i].getTotPrice();
			 }
			 System.out.println("\t\t\t\t\t" + totalprice);
			 //add cahiername and time of pruchase and reservation booking details
		 }
		 break;
		 case 10: 
		 {
			//Print sale revenue report by period (eg day or month) function
		 }
		 break;
		 case 11: System.out.println("Program terminating �.");
		}
		} while (choice < 11);
	}
}
