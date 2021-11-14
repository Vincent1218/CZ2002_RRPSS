package Project;

import java.util.Scanner;

/**
 * Represents a staff of the restaurant with his/her information.
 */
public class Staff {
	/**
	 * The id of the staff of the restaurant, starts with 1.
	 */
	private int staffID;

	/**
	 * The name of the staff of restaurant.
	 */
	private String staffName;

	/**
	 * Gets the ID of the staff.
	 * @return ID of the staff.
	 */
	public int getStaffID() { return staffID;}

	/**
	 * Gets the name of the staff.
	 * @return Name of the staff.
	 */
	public String getStaffName() { return staffName;}

	/**
	 * Creates a staff with the given parameters.
	 * @param staffName The full name of the staff.
	 * @param staffID The staffId of the staff.
	 */
	public Staff(int staffID, String staffName)
	{
		this.staffID=staffID;
		this.staffName=staffName;
	}


}