package Project;

import java.util.Scanner;

public class Staff {
	private int staffID;
	private String staffName;
	private String[] staffList = {"Ali", "Bob", "Charlie", "Dawn", "Emily"};
	
	public Staff()
	{
		this.staffID=0;
		this.staffName=null;
	}
	public String getStaffName(int staffID)
	{
		switch(staffID)
		 {
		 	case 1: return staffList[0];
			case 2: return staffList[1];
			case 3: return staffList[2];
			case 4: return staffList[3];
			default: return staffList[4];
		 }
	}
	
	public int getStaffId()
	{
		System.out.println("What is your staffID Number? (1-5)");
		Scanner sc =new Scanner(System.in);
		int id = sc.nextInt();
		if (id<1 || id>5) return 0;
		this.staffID = id;
		return this.staffID;
	}
	public int updateStaffId()
	{
		System.out.println("What is your staffID Number New User? (1-5)");
		Scanner sc =new Scanner(System.in);
		int id = sc.nextInt();
		if (id<1 || id>5) return 0;
		this.staffID = id;
		return this.staffID;
	}
}
