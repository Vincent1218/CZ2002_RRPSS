package Project;

import java.util.*;

public class RestaurantApplication {
	public static void main(String[] args) {
		int choice;
		Menu mainmenu = new Menu();
		StaffList staffList = new StaffList();
		// Prepopulating.....
		PrePopulate.prepopulate(mainmenu,staffList);

		OrderList orderlistarr = new OrderList();
		TableList tables = new TableList();
		MemberList memberList = new MemberList();
		ReservationList resList = new ReservationList();
		SalesRecord totalsales = new SalesRecord(); //keep track of all sales
		Scanner sc = new Scanner(System.in);
		Staff staff = staffList.getStaff();

		if (staff == null)
		{
		System.out.println("Unauthorised access. Program exiting...");
		return;
		}
		System.out.println("");
		System.out.println("Welcome " + staff.getStaffName() + " to the use of the Restaurant Application" );
		System.out.println("");
		do
		{
			System.out.println("---------Menu Changes--------");
			System.out.println("(1) Create/Update/Remove menu item");
			System.out.println("(2) Create/Update/Remove promotion");
			System.out.println("---------Customer Order--------");
			System.out.println("(3) View Full Menu");
			System.out.println("(4) Create order");
			System.out.println("(5) Add/Remove order item/s to/from order");
			System.out.println("---------Reservation--------");
			System.out.println("(6) Create reservation booking");
			System.out.println("(7) View/Remove reservation booking");
			System.out.println("(8) Check table availability");
			System.out.println("---------Make Payment--------");
			System.out.println("(9) Print order invoice");
			System.out.println("---------Restaurant Self Use--------");
			System.out.println("(10) Print sale revenue report by period (eg day or month)");
			System.out.println("(11) Change Staff User");
			System.out.println("(12) Register New Member");
			System.out.println("(13) Register New Staff");
			System.out.println("(14) Exit");
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
				mainmenu.displayLessMenu();
				System.out.println("Would you like to Create(1)/Update(2)/Remove(3) Promo item");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice)
				{
					case 1:
					{
						mainmenu.addPromoItem();
					}
					break;
					case 2:
					{
						mainmenu.updatePromoItem();
					}
					break;
					case 3:
					{
						mainmenu.deletePromoItem();
					}
					break;
				}
			}
			break;
			case 3:
			{
				//View Full menu
				System.out.println("----------------------------------------------------- Full Menu -----------------------------------------------------");
				mainmenu.displayMenu();
			}
			break;
			case 4:
			{
				System.out.println("Have you made a prior Reservation? (1 Yes)(0 No)");
				choice = sc.nextInt();
				if (choice == 1)
				{
					System.out.println("What is your Reservation ID");
					int resid = sc.nextInt();
					orderlistarr.createOrder(mainmenu,staff,memberList,resList,resid);
				}
				else
				{
					System.out.println("Would you like to make a Reservation first? (1 Yes)(0 No)");
					choice = sc.nextInt();
					if (choice == 1)
					{
						resList.makeRes(tables);
					}
				}
			}
			break;
			case 5:
			{
				System.out.println("What is the Reservation Id of the order to be updated");
				int resid = sc.nextInt();
				int orderid = resList.getReservation(resid).getOrderID();
				orderlistarr.viewOrder(orderid);
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
				resList.viewReservation(orderlistarr);
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
				// Print order invoice
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
				// Remove reservation and unassign Table
				resList.removeReservation(orderlistarr.getOrder(num).getResID(), tables);
				//after payment is made, add order to sales revenue
				totalsales.addSalesRecord(orderlistarr.getOrder(num));
			}
			break;
			case 10:
			{
				//Print sale revenue report by period (eg day or month) function
				System.out.println("(1)Print by day (2)Print by month (3)Print by year (4)Quit");
				int option = sc.nextInt();
				sc.nextLine();
				while (option != 4)
				{
					switch(option)
					{
						case 1: {
							System.out.println("Enter the day (eg:3 Mar 2021 or 15 Oct 2019): ");
							String date = sc.nextLine();
							totalsales.printByDay(date);
							break;
						}
						case 2: {
							System.out.println("Enter the month and year(eg:Mar 2021): ");
							String period = sc.nextLine();
							totalsales.printByMonth(period);
							break;
						}
						case 3: {
							System.out.println("Enter the year(eg:2021): ");
							String year = sc.nextLine();
							totalsales.printByYear(year);
							break;
						}
						case 4: {
							break;
						}
						default: {
							System.out.println("Please choose an option from 1 to 4.");
						}
					}
					if (option == 4)
					{
						break;
					}
					else
					{
						System.out.println("(1)Print by day (2)Print by month (3)Print by year (4)Quit");
						option = sc.nextInt();
						sc.nextLine();
					}
				}
			}
			break;
			case 11:
			{
				staff = staffList.updateStaffId();
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
			case 13:
			{
				staffList.addStaff();
			}
			break;
			case 14: System.out.println("Program terminating ...");
			}
		} while (choice < 13);
	}
}