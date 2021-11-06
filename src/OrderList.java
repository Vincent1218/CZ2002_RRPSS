package Project;

import java.util.*;

public class OrderList {
	private ArrayList<Order> orderlistarray;
	//private int numoforders;
	
	public OrderList()
	{
		this.orderlistarray =new ArrayList<>();
		//this.numoforders =0;
	}
	public ArrayList<Order> getOrderlistarray()
	{
		return orderlistarray;
	}
	public Order getOrder(int orderId)
	{
		return orderlistarray.get(orderId-1);
	}
	public void viewAllOrder()
	{
		for(int i=0 ; i<orderlistarray.size(); i++)
		{
			System.out.println("Order Number  " + (i+1));
			System.out.println("----------------------------------");
			System.out.println("");
			orderlistarray.get(i).printOrder();
			System.out.println("");
		}
	}
	public void viewOrder(int orderId)
	{
		if(orderId<0 || orderId>orderlistarray.size())
		{
			return;
		}
		System.out.println("Order Number  " + orderId);
		System.out.println("----------------------------------");
		System.out.println("");
		orderlistarray.get(orderId-1).printOrder();
	}
	public void payOrder(int orderId)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Total amount to be paid: " + orderlistarray.get(orderId - 1).getFinalPrice());
		System.out.println("Enter any key once payment has been made.");
		orderlistarray.get(orderId-1).updatePaid(true);
		String fill = sc.next();
		System.out.println("Processing...");
		System.out.println("Payment made!");
	}
	
	public void createOrder(Menu mainmenu, Staff staff, MemberList memberList,ReservationList resList, int resid)
	{	
		 int choice =1;
		 int member=0;
		 int memberId=0;
		 int counter=0;
		 int check=1;
		 int countermain = 0;
		 int contact =0;
		 Scanner sc = new Scanner(System.in);
		 Order orders = new Order(staff, resid);
		 while(check==1)
		 {
			 orders.addOrderItem(mainmenu);
			 while(counter<3)
				{
				 System.out.println("Do you still intend to add Items (Yes 1)(No 0)?");	
					try 
					{ 
						choice = sc.nextInt();
						sc.nextLine();
						if (choice<0||choice>1)
						{
							System.out.println("Incorrect Entry.Please Try Again..");
							System.out.println("");
							++counter;
							continue;
						}
					}
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
				if(choice==0)
				{
					break;
				}
		 }
		 orderlistarray.add(orders);
		 orderlistarray.get(orderlistarray.size()-1).updateorderId(orderlistarray.size());
		 while(counter<3)
			{
			 System.out.println("May I enquire on your membership status?");
			 System.out.println("(1)Yes, I am a Member, (2)No, I am not a member");
				try 
				{ 
					choice = sc.nextInt();
					sc.nextLine();
					if (choice<0||choice>1)
					{
						System.out.println("Incorrect Entry.Please Try Again..");
						System.out.println("");
						++counter;
						continue;
					}
				}
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
		 if(choice==2)
		 {
			 // add the final order
			 //and the name of the staff that did it.
			 System.out.println("");
			 System.out.println("---------------Your Final order is-------------------");
			 System.out.println("");
			 orderlistarray.get(orderlistarray.size()-1).printOrder();
			 System.out.println("Your order was created by " + staff.getStaffName());
			 System.out.println("");
			 System.out.println("Your order Id is " + orderlistarray.size());
			 resList.getReservation(resid).updateOrderID(orderlistarray.size());
			 System.out.println("");
			 return;
		 }
		 else if(choice==1) {
			 while ( true ){
				 while(counter<3)
					{
					 System.out.println("Please enter your Member ID: ");
						try 
						{ 
							memberId = sc.nextInt();
							sc.nextLine();
						}
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
				 while(counter<3)
					{
					 System.out.println("Please enter your Contact Number: ");
						try 
						{ 
							 contact = sc.nextInt();
							sc.nextLine();
						}
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
					try {
						member = memberList.checkMember(memberId, contact);
						memberList.getMember(memberId);
					}
					catch(IndexOutOfBoundsException ex)
					{
						System.out.println("Invalid Member ID/Contact No. Try Again");
						++countermain;
						if(countermain == 3) 
						{ 
							countermain=0;
							System.out.println("Too many Attempts. Your Order will not be entitled to Membership rights");
							break;
						}
						continue;
					}
			 }
		 }

		 orderlistarray.get(orderlistarray.size()-1).updateMembership(member);
		// add the final order
		 //and the name of the staff that did it.
		 System.out.println("---------------Your Final order is-------------------");
		 System.out.println("");
		 orderlistarray.get(orderlistarray.size()-1).printOrder();
		 System.out.println("");
		 System.out.println("Your order was created by " + staff.getStaffName());
		 System.out.println("");
		 System.out.println("Your order Id is " + orderlistarray.size());
		 resList.getReservation(resid-1).updateOrderID(orderlistarray.size());
		 System.out.println("");
	}
	
	public void printOrderInvoice(int orderId)
	{
		// this would be print order but with sales person details and time etcetc
		orderlistarray.get(orderId-1).printOrder();
		System.out.println(" ");
		System.out.println("This order was done by " + orderlistarray.get(orderId - 1).displayStaffName() );
		System.out.println("Staff number: " + orderlistarray.get(orderId - 1).displaystaffID() );
		System.out.println(orderlistarray.get(orderId - 1).getDateTime());
		System.out.println(" ");
	}
}