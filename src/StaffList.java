package Project;

import java.util.*;


public class StaffList {
    private ArrayList<Staff> staffArray;

    public StaffList() {
        this.staffArray =new ArrayList<>();
    }

    public ArrayList<Staff> getStaffArray() { return staffArray; }
    public int getStaffSize() {return staffArray.size();}

    public void addStaff(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter new staff's name?");
        String name = sc.nextLine();
        int staffId = staffArray.size(); //memberID to start from 1001
        Staff newStaff =new Staff(staffId, name);
        staffArray.add(newStaff);
    }

    public Staff getStaff()
    {
    	
    	int id=0;
    	int counter=0;
    	while(counter<3)
    	{
    		try 
            {
            	System.out.println("What is your staffID Number? (1 - " + staffArray.size() +")");
                Scanner sc =new Scanner(System.in);
                id = sc.nextInt();
                return staffArray.get(id-1);
            }
            catch(InputMismatchException|IndexOutOfBoundsException|NullPointerException ex) {
            	if(counter<2)
            	{
            		System.out.println("Incorrect Entry.Please Try Again..");
        			System.out.println("");
            	}
    			++counter;
            }
    	}
    	return null;
    }

    public Staff updateStaffId()
    {
    	int staffid=0;
    	int counter =0;
    	Scanner sc =new Scanner(System.in);
    	while(counter<3)
    	{
    		System.out.println("What is your staffID Number New User?");
	    	try
	    	{ 
	    		staffid = sc.nextInt();
	    		sc.nextLine();
	    		return staffArray.get(staffid-1);
			}
	    	catch(InputMismatchException|IndexOutOfBoundsException|NullPointerException ex)
			{
				if(counter<2)
				{
					System.out.println("Incorrect Entry.Please Try Again..");
					System.out.println("");
				}
				++counter;
				continue;
			}
    	}
		counter=0;
		System.out.println("Too many Attempts.Return to main program..");
		return null;
    	
    }
}
