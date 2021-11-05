//import java.text.DateFormat;
package Project;

public class Reservation {
	private int resID;
	private String date;
	private String time;
	private int pax;
	private String name;
	private int contact;
	private int tableID;
	private int orderID;
	
	public Reservation(String name, int contact, int pax, String date,String time, int tableId, int resId) {
		//this.date = DateFormat.getInstance().format(java.time.LocalDate.now());
		this.time = time;
		this.date = date;
		this.pax = pax;
		this.name = name;
		this.contact = contact;
		this.resID = resId;
		this.tableID = tableId;
	}
	
	public String getResName() {return this.name;}
	public int getResContact() {return this.contact;}
	public String getResTime() {return this.time;}
	public String getResDate() {return this.date;}
	public int getResPax() {return this.pax;}
	public int getResTableID() {return this.tableID;}
	public int getResID() {return this.resID;}
	public int getOrderID(){return this.orderID;}
	public void updateOrderID(int orderid){this.orderID = orderid;}
	
}
