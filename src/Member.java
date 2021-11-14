package Project;

/**
 * Represents a member of the restaurant with his/her information.
 */

public class Member {
	/**
	 * The name of the restaurant member.
	 */
	private String name;
	/**
	 * The id of the member in the restaurant, starts with 1001.
	 */
	private int memberId;
	/**
	 * The contact number for the customer.
	 */
	private int contact;

	/**
	 * Creates a Member with the given parameters.
	 * @param name The full name of the customer.
	 * @param contact The contact number of the customer.
	 * @param memberId The memberId of the customer.
	 */
	public Member(String name, int contact, int memberId) {
		this.name = name;
		this.contact = contact;
		this.memberId = memberId;
	}

	/**
	 * Gets the contact number of the member.
	 * @return Contact number of the member.
	 */
	public int getContact() {return this.contact;}

	/**
	 * Gets the name of the member.
	 * @return Name of the member.
	 */
	public String getName() {return this.name;}

	/**
	 * Gets the ID of the member.
	 * @return ID of the member.
	 */
	public int getMemberId() {return this.memberId;}
	
}
