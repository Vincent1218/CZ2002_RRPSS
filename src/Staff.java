package Project;

import java.util.Scanner;

public class Staff {
	private int staffID;
	private String staffName;

	public int getStaffID() { return staffID;}
	public String getStaffName() { return staffName;}

	public Staff(int staffID, String staffName)
	{
		this.staffID=staffID;
		this.staffName=staffName;
	}


}