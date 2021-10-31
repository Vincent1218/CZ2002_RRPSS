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
	public Order getOrder(int orderid)
	{
		return orderlistarray.get(orderid-1);
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
	public void viewOrder(int orderid)
	{
			System.out.println("Order Number  " + orderid);
			System.out.println("----------------------------------");
			System.out.println("");
			orderlistarray.get(orderid-1).printOrder();
	}
	public void payOrder(int orderid)
	{
		//sales revenue part havent do so i wont add yet
	}
	public void createOrder(Menu mainmenu, int staffid)
	{
		 int a =1;
		 Scanner sc = new Scanner(System.in);
		 Order orders = new Order(staffid);
		 while(a==1)
		 {
			 orders.addOrderItem(mainmenu);
			 System.out.println("Do you still intend to add Items (Yes 1)(No 0)?");
			 a = sc.nextInt();
		 }
		 orderlistarray.add(orders);
		 orderlistarray.get(orderlistarray.size()-1).updateOrderId(orderlistarray.size());
		 System.out.println("Your order Id is " + orderlistarray.size());
		 System.out.println("");
	}
	public void printOrderInvoice(int orderid)
	{
		// this would be print order but with sales person details and time etcetc
		orderlistarray.get(orderid-1).printOrder();
		System.out.println(" ");
		System.out.println("This order was done by " + orderlistarray.get(orderid - 1).displayStaffname() );
		System.out.println("Staff number: " + orderlistarray.get(orderid - 1).displayStaffid() );
		System.out.println(" ");
	}
}
