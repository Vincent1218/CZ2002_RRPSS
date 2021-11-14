package Project;

/**
 * Represents a reservation made by customer.
 */

public class Reservation {
	/**
	 * The ID of the reservation made by customer, starts with 1.
	 */
	private int resID;

	/**
	 * The time of the reservation made by customer.
	 */
	private String time;

	/**
	 * The number of pax in reservation made by customer, limited to (1-8)
	 */
	private int pax;

	/**
	 * The name of the customer who made the reservation.
	 */
	private String name;

	/**
	 * The contact number of customer who made the reservation.
	 */
	private int contact;

	/**
	 * The table ID that is reserved to this reservation, (1 to 1 relationship).
	 */
	private int tableID;

	/**
	 * The order ID that will be assigned after order id made.
	 */
	private int orderID;

	/**
	 * The valid(expiry) status of reservation.
	 * "False" will be set if a reservation expire (After 10 minutes).
	 */
	private boolean valid;

	/**
	 * Creates a reservation.
	 * @param name Customer name who make the reservation.
	 * @param contact Customer contact number who make the reservation.
	 * @param pax Number of pax reserved.
	 * @param time Time of customer reserved.
	 * @param tableId Table ID that is assigned to customer for the reservation.
	 * @param resId Reservation ID for customer.
	 */
	public Reservation(String name, int contact, int pax, String time, int tableId, int resId) {
		this.time = time;
		this.pax = pax;
		this.name = name;
		this.contact = contact;
		this.resID = resId;
		this.tableID = tableId;
		this.orderID = 0;
		this.valid = true;
	}

	/**
	 * Gets valid(expiry) status of the reservation.
	 * @return Boolean valid status.
	 */
	public boolean getValid(){return this.valid;}

	/**
	 * Sets valid(expiry) status of the reservation.
	 */
	public void setValid(boolean v) { this.valid = v;}

	/**
	 * Gets the customer name who made the reservation.
	 * @return Name of customer.
	 */
	public String getResName() {return this.name;}

	/**
	 * Gets the contact number of customer who made the reservation.
	 * @return Contact number of customer.
	 */
	public int getResContact() {return this.contact;}

	/**
	 * Gets the time of the reservation made by customer.
	 * @return Time of reservation.
	 */
	public String getResTime() {return this.time;}

	/**
	 * Gets the number of pax in reservation made by customer.
	 * @return Number of pax.
	 */
	public int getResPax() {return this.pax;}

	/**
	 * Gets the table ID that is reserved to this reservation.
	 * @return Table ID reserved.
	 */
	public int getResTableID() {return this.tableID;}

	/**
	 * Gets the ID of the reservation made by customer.
	 * @return Reservation ID.
	 */
	public int getResID() {return this.resID;}

	/**
	 * Gets the order ID of the reservation after the order is made.
	 * @return Order ID.
	 */
	public int getOrderID() {return this.orderID;}
	/**
	 * Sets the order ID after order is made for a Reservation ID.
	 */
	public void updateOrderID(int orderId) {this.orderID = orderId;}

	/**
	 * Sets the table ID after an empty table at the particular time is found.
	 */
	public void updateTableID(int tableId) {this.tableID = tableId;}

}
