import java.util.*;

public class RestaurantApplication {
	public static void main(String[] args) {
		int choice;
		Menu mainmenu = new Menu();
		OrderList orderlistarr = new OrderList();
		TableList tables = new TableList();
		Staff staff=new Staff();
		MemberList memberList = new MemberList();
		ReservationList resList = new ReservationList();
		SalesRecord totalsales = new SalesRecord(); //keep track of all sales
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
		System.out.println("(12) Register New Member");
		System.out.println("(13) Exit");
		System.out.println("");
		System.out.print("Enter your Choice: ");
		choice = sc.nextInt();
		switch (choice) {
		 case 1: 
		 {
			 ///Create/Update/Remove menu item function
			 System.out.println("Would you like to Create(1)/Update(2)/Remove(3) menu item");
			 choice = sc.nextInt();
			 sc.nextLine();
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
			 orderlistarr.createOrder(mainmenu,staffid,memberList);
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
			 resList.makeRes(tables);
			 //Attach this info to array somehow probably to an overarching array. so one array and in that 1 array slot has the array of food and contact details.
		 }
		 break;	 
		 case 7: 
		 {
			 //Check/Remove reservation booking function
			 resList.getReservation();
			 System.out.println("Would you like to remove any reservations?");
			 System.out.println("(1)Yes (2)No");
			 int check = sc.nextInt();
			 if(check==1) {
				 System.out.println("Reservation ID of reservation to be removed?");
				 int resId = sc.nextInt();
				 resList.removeReservation(resId, tables);
			 }
		 }
		 break;
		 case 8: {
			//Check table availability function
			 tables.viewAllTableStatus();
		 }
		 break;
		 case 9: {
			 System.out.println(" ");
			 System.out.println("What is the orderId of the order invoice");
			 int num = sc.nextInt();
			 System.out.println("Do you wish to use the current date and time or to input your own date and time?");
			 System.out.println("(1)Current date and time, (2)Input date and time");
			 int opt = sc.nextInt();
			 sc.nextLine();
			 if (opt == 2)
			 {
				 orderlistarr.getOrder(num).updateDate();
			 }
			 System.out.println(" ");
			 System.out.println("Order Number  " + num);
			 System.out.println("----------------------------------");
			 orderlistarr.printOrderInvoice(num);
			 orderlistarr.payOrder(num);
			 //after payment is made, add order to sales revenue
			 totalsales.addSalesRecord(orderlistarr.getOrder(num));
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
		 case 12:
		 {
			//register member
			 int memberId = memberList.registerMember();
			 if(memberId<=(memberList.getSize()+1000)) System.out.println("Contact number already registered. Member ID is " + memberId);
			 else System.out.println("Registration successful. The Member ID is: " + memberId);
		 }
		 break;
		 case 13: System.out.println("Program terminating ...");
		}
		} while (choice < 13);
	}
}