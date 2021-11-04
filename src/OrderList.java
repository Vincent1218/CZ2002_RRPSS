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
		String fill = sc.next();
		System.out.println("Processing...");
		System.out.println("Payment made!");
	}
	
	public void createOrder(Menu mainmenu, Staff staff, MemberList memberList,ReservationList resList, int resid)
	{
		 int a =1;
		 int member=0;
		 int memberId=0;
		 Scanner sc = new Scanner(System.in);
		 Order orders = new Order(staff, resid);
		 while(a==1)
		 {
			 orders.addOrderItem(mainmenu);
			 System.out.println("Do you still intend to add Items (Yes 1)(No 0)?");
			 a = sc.nextInt();
		 }
		 orderlistarray.add(orders);
		 orderlistarray.get(orderlistarray.size()-1).updateorderId(orderlistarray.size());
		 System.out.println("May I enquire on your membership status?");
		 System.out.println("(1)Yes, I am a Member, (2)No, I am not a member");
		 int mem = sc.nextInt();
		 int count = 0;
		 if(mem==2)
		 {
			 System.out.println("Your order Id is " + orderlistarray.size());
			 resList.getReservation(resid).updateOrderID(orderlistarray.size());
			 System.out.println("");
			 return;
		 }
		 else if(mem==1) {
			 while ( true ){
				 System.out.println("Please enter your Member ID: ");
				 memberId = sc.nextInt();
				 System.out.println("Please enter your Contact Number: ");
				 String contact = sc.next();
				 member = memberList.checkMember(memberId, contact);
				 if(member==0) {
					 System.out.println("Invalid Member ID/Contact No. Try Again");
					 count++;
					 if(count>3) System.out.println("Failed 3 times. Proceeding...");
					 else memberList.getMember(memberId);
				 }
				 else{
					 break;
				 }
			 }
		 }
		 //Testing Branch
		 orderlistarray.get(orderlistarray.size()-1).updateMembership(member);
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