package Project;

import java.util.*;

public class OrderList {
	private ArrayList<Order> orderListArray;

	public OrderList()
	{
		this.orderListArray =new ArrayList<>();
	}
	public ArrayList<Order> getOrderListArray()
	{
		return orderListArray;
	}
	public Order getOrder(int orderId)
	{
		return orderListArray.get(orderId-1);
	}
	public void viewAllOrder()
	{
		for(int i=0 ; i<orderListArray.size(); i++)
		{
			System.out.println("Order Number  " + (i+1));
			System.out.println("----------------------------------");
			System.out.println("");
			orderListArray.get(i).printOrder();
			System.out.println("");
		}
	}
	public void viewOrder(int orderId)
	{
		if(orderId<0 || orderId>orderListArray.size())
		{
			return;
		}
		System.out.println("Order Number  " + orderId);
		System.out.println("----------------------------------");
		System.out.println("");
		orderListArray.get(orderId-1).printOrder();
	}
	public void payOrder(int orderId)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Total amount to be paid: " + orderListArray.get(orderId - 1).getFinalPrice());
		System.out.println("Enter any key once payment has been made.");
		orderListArray.get(orderId-1).updatePaid(true);
		String fill = sc.next();
		System.out.println("Processing...");
		System.out.println("Payment made!");
	}
	public int getSize(){ return orderListArray.size();}
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
		 orderListArray.add(orders);
		 orderListArray.get(orderListArray.size()-1).updateOrderId(orderListArray.size());
		 while(counter<3)
			{
			 System.out.println("May I enquire on your membership status?");
			 System.out.println("(1)Yes, I am a Member, (2)No, I am not a member");
				try
				{
					choice = sc.nextInt();
					sc.nextLine();
					if (choice<1||choice>2)
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
			 orderListArray.get(orderListArray.size()-1).printOrder();
			 System.out.println("Your order was created by " + staff.getStaffName());
			 System.out.println("");
			 System.out.println("Your order Id is " + orderListArray.size());
			 resList.getReservation(resid).updateOrderID(orderListArray.size());
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
				 try {
					memberList.getMember(memberId);
				 }
				 catch(IndexOutOfBoundsException ex)
				 {
					 System.out.println("Invalid Member ID/Contact No. Try Again");
					 ++countermain;
					 if(countermain == 3)
					 {
						System.out.println("Too many Attempts. Your Order will not be entitled to Membership rights");
						break;
					 }
					 continue;
				 }
				 break;
			 }
		 }

		 if (countermain != 3){
			 orderListArray.get(orderListArray.size()-1).updateMembership(1);
		 }
		 // add the final order
		 //and the name of the staff that did it.
		 System.out.println("---------------Your Final order is-------------------");
		 System.out.println("");
		 orderListArray.get(orderListArray.size()-1).printOrder();
		 System.out.println("");
		 System.out.println("Your order was created by " + staff.getStaffName());
		 System.out.println("");
		 System.out.println("Your order Id is " + orderListArray.size());
		 resList.getReservation(resid).updateOrderID(orderListArray.size());
		 System.out.println("");
	}

	public boolean checkDuplicate(int resid) //prevents the creation of duplicate orders with the same resid (same table)
	{
		int count = 0;
		for (int i = 0; i < orderListArray.size(); i++)
		{
			if (orderListArray.get(i).getResID() == resid)
			{
				count += 1;
				if (count > 0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void printOrderInvoice(int orderId)
	{
		// this would be print order but with sales person details and time etcetc
		orderListArray.get(orderId-1).printOrder();
		System.out.println(" ");
		System.out.println("This order was done by " + orderListArray.get(orderId - 1).displayStaffName() );
		System.out.println("Staff number: " + orderListArray.get(orderId - 1).displayStaffId() );
		System.out.println(orderListArray.get(orderId - 1).getDateTime());
		System.out.println(" ");
	}
}