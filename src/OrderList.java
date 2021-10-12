package Project;
import java.util.Scanner;

public class OrderList {
	private Order[] orderlistarray;
	private int numoforders;
	
	public OrderList()
	{
		this.orderlistarray =new Order[20];
		this.numoforders =0;
	}
	public Order getOrder(int orderid)
	{
		return this.orderlistarray[orderid-1];
	}
	public void viewAllOrder()
	{
		for(int i=0;i<numoforders;i++)
		{
			System.out.println("Order Number  " + i);
			System.out.println("----------------------------------");
			System.out.println("");
			orderlistarray[i].printOrder();
			System.out.println("");
		}
	}
	public void viewOrder(int orderid)
	{
			System.out.println("Order Number  " + orderid);
			System.out.println("----------------------------------");
			System.out.println("");
			orderlistarray[orderid-1].printOrder();
	}
	public void payOrder(int orderid)
	{
		//sales revenue part havent do so i wont add yet
	}
	public void createOrder(Menu mainmenu)
	{
		 int a =1;
		 Scanner sc = new Scanner(System.in);
		 Order orders = new Order();
		 while(a==1)
		 {
			 orders.addOrderItem(mainmenu);
			 System.out.println("Do you still intend to add Items (Yes 1)(No 0)?");
			 a = sc.nextInt();
		 }
		 orderlistarray[this.numoforders++]=orders;
		 orderlistarray[this.numoforders-1].updateOrderId(this.numoforders);
		 System.out.println("Your order Id is" + this.numoforders);
	}
	public void printOrderInvoice(int orderid)
	{
		// this would be print order but with sales person details and time etcetc
	}
}
