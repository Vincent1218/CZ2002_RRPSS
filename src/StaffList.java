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
        System.out.println("What is your staffID Number?");
        Scanner sc =new Scanner(System.in);
        int id = sc.nextInt();
        if(id>0 && id<=staffArray.size()){
            return staffArray.get(id-1);
        }
        else{
            return null;
        }
    }

    public Staff updateStaffId()
    {
        System.out.println("What is your staffID Number New User?");
        Scanner sc =new Scanner(System.in);
        int id = sc.nextInt();
        if(id>0 && id<=staffArray.size()){
            return staffArray.get(id-1);
        }
        else{
            return null;
        }
    }
}
