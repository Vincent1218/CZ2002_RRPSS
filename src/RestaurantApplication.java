package Project;

import java.util.*;

public class RestaurantApplication {
	public static void main(String[] args) {
		int choice=0;
		int resid=0;
		int counter=0;
		int orderid=0;
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
		if(staff==null)
		{
			System.out.println("");
			System.out.println("Unauthorised access. Exiting Program..");
			return;
		}
		System.out.println("");
		System.out.println("Welcome " + staff.getStaffName() + " to the use of the Restaurant Application" );
		System.out.println("");
		do
		{
			if(counter == 3){
				System.out.println("Too many Attempts.Return to main program..");
				counter = 0;
//				return;
			}
			System.out.println("---------Menu Changes--------");
			System.out.println("(1) Create/Update/Remove menu item");
			System.out.println("(2) Create/Update/Remove promotion");
			System.out.println("---------Customer Order--------");
			System.out.println("(3) View Full Menu");
			System.out.println("(4) Create order");
			System.out.println("(5) Add/Remove order item/s to/from order");
			System.out.println("(6) View All/Specific Order");
			System.out.println("---------Reservation--------");
			System.out.println("(7) Create reservation booking");
			System.out.println("(8) View/Remove reservation booking");
			System.out.println("(9) Check table availability");
			System.out.println("---------Make Payment--------");
			System.out.println("(10) Print order invoice");
			System.out.println("---------Restaurant Self Use--------");
			System.out.println("(11) Print sale revenue report by period (eg day or month)");
			System.out.println("(12) Change Staff User");
			System.out.println("(13) Register New Member");
			System.out.println("(14) Register New Staff");
			System.out.println("(15) Exit");
			System.out.println("");
			System.out.print("Enter your Choice: ");
			while(counter<3)
			{
				try { choice = sc.nextInt(); }
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
			if(counter==3)
			{
				System.out.println("Too many Attempts.Exiting Program..");
				return;
			}
			switch (choice) {
			case 1:
			{
				///Create/Update/Remove menu item function
				while(counter<3)
				{
					System.out.println("Would you like to Create(1)/Update(2)/Remove(3) menu item");
					try { choice = sc.nextInt(); }
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
					if(counter == 0) { break; }
				}
			}
			break;
			case 2:
			{
				//Create/Update/Remove promotion function
				mainmenu.displayLessMenu();
				while(counter<3)
				{
					System.out.println("Would you like to Create(1)/Update(2)/Remove(3) Promo item");
					try { choice = sc.nextInt(); }
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
					if(counter == 0) { break; }
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
				while(counter<3)
				{
					System.out.println("Have you made a prior Reservation? (1 Yes)(0 No)");
					try { choice = sc.nextInt(); }
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
				if (choice == 1)
				{
					while(counter<3)
					{
						System.out.println("What is your Reservation ID");
						try {resid = sc.nextInt(); }
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
					System.out.println("");
					if(resid>resList.getSize()||resid<0)
					 {
						 System.out.println("Incorrect Entry. Please try again...");
						 System.out.println("");
						 break;
					 }
					orderlistarr.createOrder(mainmenu,staff,memberList,resList,resid);
				}
				else
				{
					while(counter<3)
					{
						System.out.println("Would you like to make a Reservation first? (1 Yes)(0 No)");
						try { choice = sc.nextInt(); }
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
					if (choice == 1)
					{
						resList.makeRes(tables);
					}
					else
					{
						 System.out.println("");
						 System.out.println("Incorrect Entry. Please try again...");
						 System.out.println("");
					}
				}
			}
			break;
			case 5:
			{
				//delete bottom line once all the other classes have exception handling
				while(counter<3)
				{
					System.out.println("What is the Order Id of the order to be updated");
					try{orderid = sc.nextInt();}
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
					counter=0;
					if(counter == 0) { break; }
				}
				orderlistarr.viewOrder(orderid);
				do
				{
					while(counter<3)
					{
						System.out.println("Would you like to (Add 1)/(Remove 2)/(Update Quantity 3)/(Done 4)");
						try { choice = sc.nextInt(); }
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
						 default:
						 {
							 System.out.println("");
							 System.out.println("Incorrect Entry. Please try again...");
							 System.out.println("");
						 }
						 break;
					 }
				}while (choice <4);
			}
			break;
			case 6:
			{
				while(counter<3)
				{
					System.out.println("What Order would you like to view");
					System.out.println("(1)All (2)Specific");
					try { choice = sc.nextInt(); }
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
				switch (choice)
				 {
					 case 1:
					 {
						 orderlistarr.viewAllOrder();
					 }
					 break;
					 case 2:
					 {
						 while(counter<3)
						 {
							 System.out.println("What is the Reservation Id of the order to be updated");
							 try {resid = sc.nextInt(); }
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
						if(resid>resList.getSize()||resid<0)
						 {
							 System.out.println("Incorrect Entry. Please try again...");
							 System.out.println("");
							 break;
						 }
						orderid = resList.getReservation(resid).getOrderID();
						orderlistarr.viewOrder(orderid);
					 }
					 break;
					 default:
					 {
						 System.out.println("");
						 System.out.println("Incorrect Entry. Please try again...");
						 System.out.println("");
					 }
				 }
			}
			break;
			case 7:
			{
				//Create reservation booking function
				resList.makeRes(tables);
				//Attach this info to array somehow probably to an overarching array. so one array and in that 1 array slot has the array of food and contact details.
			}
			break;
			case 8:
			{
				//Check/Remove reservation booking function
				resList.viewReservation();
				while(counter<3)
				{
					System.out.println("Would you like to remove any reservations?");
					System.out.println("(1)Yes (2)No");
					try { choice = sc.nextInt(); }
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
				switch (choice)
				 {
					 case 1:
					 {
						 	while(counter<3)
							{
							    System.out.println("Reservation ID of reservation to be removed?");
							    try {resid = sc.nextInt(); }
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
							resList.removeReservation(resid, tables);
					 }
					 break;
					 case 2:
					 {
						 System.out.println("");
					 }
					 break;
					 default:
					 {
						 System.out.println("");
						 System.out.println("Incorrect Entry. Please try again...");
						 System.out.println("");
					 }
				 }
			}
			break;
			case 9: {
				//Check table availability function
				tables.viewAllTableStatus();
			}
			break;
			case 10: {
				// Print order invoice
				System.out.println("");
				while (counter<3)
				{
					System.out.println("What is the orderId of the order invoice");
					try{orderid = sc.nextInt();}
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
					counter=0;
					if(counter == 0) { break; }
				}
				while (counter<3)
				{
					System.out.println("Do you wish to use the current date and time or to input your own date and time?");
					System.out.println("(1)Current date and time, (2)Input date and time");
					try { choice = sc.nextInt(); }
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
				if (choice == 2)
				{
					orderlistarr.getOrder(orderid).updateDate();
				}
				int TempResID= orderlistarr.getOrder(orderid).getResID();
				resList.viewInvoiceReservationReservation(TempResID);
				System.out.println("");
				System.out.println("Order Number  " + orderid);
				System.out.println("----------------------------------");
				orderlistarr.printOrderInvoice(orderid);
				orderlistarr.payOrder(orderid);
				// Remove reservation and unassign Table
				resList.removeReservation(orderlistarr.getOrder(orderid).getResID(), tables);
				//after payment is made, add order to sales revenue
				totalsales.addSalesRecord(orderlistarr.getOrder(orderid));
			}
			break;
			case 11:
			{
				//Print sale revenue report by period (eg day or month) function
				while (counter<3)
				{
					System.out.println("(1)Print by day (2)Print by month (3)Print by year (4)Quit");
					try { choice = sc.nextInt(); }
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
				while (choice != 4)
				{
					switch(choice)
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
					if (choice == 4)
					{
						break;
					}
					else
					{
						System.out.println("(1)Print by day (2)Print by month (3)Print by year (4)Quit");
						choice = sc.nextInt();
						sc.nextLine();
					}
				}
			}
			break;
			case 12:
			{
				staff = staffList.updateStaffId();
			}
			break;
			case 13:
			{
				//register member
				int memberId = memberList.registerMember();
				if(memberId<=(memberList.getSize()+1000)) System.out.println("Contact number already registered. Member ID is " + memberId);
				else System.out.println("Registration successful. The Member ID is: " + memberId);
			}
			break;
			case 14:
			{
				staffList.addStaff();
			}
			break;
			case 15: 
			{
				System.out.println("Program terminating ...");
				return;
			}
		}
		} while (choice < 15);
	}
}