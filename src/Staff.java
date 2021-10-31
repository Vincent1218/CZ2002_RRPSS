package Project;

import java.util.Scanner;

public class Staff {
	private int StaffID;
	private String staffName;
	private String[] StaffList = {"Ali", "Bob", "Charlie", "Dawn", "Emily"};
	
	public Staff()
	{
		this.StaffID=0;
		this.staffName=null;
	}
	public String getStaffName(int StaffID)
	{
		switch(StaffID)
		 {
		 	case 1: return StaffList[0];
			case 2: return StaffList[1];
			case 3: return StaffList[2];
			case 4: return StaffList[3];
			default: return StaffList[4];
		 }
	}
	
	public int getStaffId()
	{
		System.out.println("What is your StaffID Number? (1-5)");
		Scanner sc =new Scanner(System.in);
		int id = sc.nextInt();
		if (id<1 || id>5) return 0;
		this.StaffID = id;
		return this.StaffID;
	}
	public int updateStaffId()
	{
		System.out.println("What is your StaffID Number New User? (1-5)");
		Scanner sc =new Scanner(System.in);
		int id = sc.nextInt();
		if (id<1 || id>5) return 0;
		this.StaffID = id;
		return this.StaffID;
	}
}
