package Project;

import java.util.Scanner;

public class RestaurantApplication {
	public static void main(String[] args) {
		int choice;
		Menu mainmenu = new Menu();
		OrderList orderlistarr = new OrderList();
		Staff staff=new Staff();
		Scanner sc = new Scanner(System.in);
		int staffid = staff.getStaffId();
		if (staffid ==0)
		{
			System.out.println("Unauthorised access. Program exiting...");
			return;
		}
		System.out.println("");
		System.out.println("Welcome " +staff.getStaffName(staffid) + " to the use of the Restaurant Application" );
		System.out.println("");
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
		System.out.println("(11) Change Staff User");
		System.out.println("(12) Exit");
		System.out.println("");
		System.out.print("Enter your Choice: ");
		choice = sc.nextInt();
		switch (choice) {
		 case 1: 
		 {
			 //Create/Update/Remove menu item function
			 System.out.println("Would you like to Create(1)/Update(2)/Remove(3) menu item");
			 choice = sc.nextInt();
			 switch (choice) 
			 {
				 case 1:
				 {
					 mainmenu.addMenuItem();
				 }
				 break;
				 case 2:
				 {
					 mainmenu.updateMenuItem();
				 }
				 break;
				 case 3:
				 {
					 mainmenu.deleteMenuItem();
				 }
				 break;
			 }
		 }
		 break;
		 case 2: 
		 {
			//Create/Update/Remove promotion function
		 }
		 break;
		 case 3:
		 {
			 mainmenu.displayMenu();
			 orderlistarr.createOrder(mainmenu,staffid);
		 }
		 break;
		 case 4: 
		 {
			 System.out.println("Would you like to (View all orders 1)/(Specific Order 2)");
			 choice = sc.nextInt();
			 if (choice ==1)
			 {
				 orderlistarr.viewAllOrder();
			 }
			 else if (choice==2)
			 {
				 System.out.println("What is the orderId?");
				 int orderid = sc.nextInt();
				 orderlistarr.viewOrder(orderid);
			 }
		 } 
		 break;
		 case 5:
		 {
			 System.out.println("What is the orderId of the order to be updated");
			 int orderid = sc.nextInt();
			 do
			 {
				 System.out.println("Would you like to (Add 1)/(Remove 2)/(Update Quantity 3)/(Done 4)");
				 choice = sc.nextInt();
				 switch (choice) 
				 {
					 case 1:
					 {
						 orderlistarr.getOrder(orderid).addOrderItem(mainmenu);
					 }
					 break;
					 case 2:
					 {
						 orderlistarr.getOrder(orderid).deleteOrderItem();
					 }
					 break;
					 case 3:
					 {
						 orderlistarr.getOrder(orderid).updateOrderItemQuantity();
					 }
					 break;
					 case 4:
					 {
						 System.out.println("Order" + orderid + "is updated");
					 }
					 break;
				 }
			 }
			 while (choice <4);
		 }
		 break;
		 case 6:
		 {
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
			 
			 System.out.println(" ");
			 System.out.println("What is the orderId of the order invoice");
			 int num = sc.nextInt();
			 System.out.println(" ");
			 System.out.println("Order Number  " + num);
			 System.out.println("----------------------------------");
			 orderlistarr.printOrderInvoice(num);
			 //
		 }
		 break;
		 case 10: 
		 {
			//Print sale revenue report by period (eg day or month) function
		 }
		 break;
		 case 11: 
		 {
			 staffid = staff.updateStaffId();
		 }
		 break;
		 case 12: System.out.println("Program terminating ….");
		}
		} while (choice < 12);
	}
}
