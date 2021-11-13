package Project;

public class Reservation {
	private int resID;
	private String time;
	private int pax;
	private String name;
	private int contact;
	private int tableID;
	private int orderID;
	private boolean valid;
	
	public Reservation(String name, int contact, int pax, String time, int tableId, int resId) {
		this.time = time;
		this.pax = pax;
		this.name = name;
		this.contact = contact;
		this.resID = resId;
		this.tableID = tableId;
		this.valid = true;
	}
	public boolean getValid(){return this.valid;}
	public void setValid(boolean v) { this.valid = v;}
	public String getResName() {return this.name;}
	public int getResContact() {return this.contact;}
	public String getResTime() {return this.time;}
	public int getResPax() {return this.pax;}
	public int getResTableID() {return this.tableID;}
	public int getResID() {return this.resID;}
	public int getOrderID() {return this.orderID;}
	public void updateOrderID(int orderid) {this.orderID = orderid;}
	public void updateTableID(int tableid) {this.tableID = tableid;}
	
}
