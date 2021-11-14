package Project;

import java.util.*;

/**
 * Represents a list of staff of the restaurant.
 */
public class StaffList {
	/**
	 * The list of record of staff.
	 */
    private ArrayList<Staff> staffArray;

	/**
	 * Creates an empty staff list.
	 */
    public StaffList() {
        this.staffArray =new ArrayList<>();
    }

	/**
	 * Gets staff list of the restaurant.
	 * @return List of staff.
	 */
    public ArrayList<Staff> getStaffArray() { return staffArray; }

	/**
	 * Ask for staff require information (Name)
	 */
    public void addStaff(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter new staff's name?");
        String name = sc.nextLine();
        int staffId = staffArray.size();
        Staff newStaff =new Staff(staffId, name);
        staffArray.add(newStaff);
		System.out.println("Registration successful. The Staff ID is: " + (staffId+1));
    }

	/**
	 * Gets specific staff by his/her ID
	 * @return Staff by staff ID.
	 */
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

	/**
	 * Change the staff(user) that is operating the device.
	 * Mimic a logout action.
	 * @return Staff chosen.
	 */
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
