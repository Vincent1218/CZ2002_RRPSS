package Project;

import java.util.*;

public class ReservationList {
	private ArrayList<Reservation> resList;
	
	public ReservationList()
	{
		this.resList =new ArrayList<>();
	}
	public int getSize()
	{
		return resList.size();
	}
	public void makeRes(TableList tables) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Whose name will the reservation be under?");
		String name = sc.next();
		System.out.println("Number of Pax?");
		int pax = sc.nextInt();
		int tableId = tables.checkAvailability(pax);
		if(tableId==0) System.out.println("Sorry, we have no available tables at the moment. Please try again later.");
		else {
			System.out.println("Enter the Date in DD MMM YYYY:");
			String date = sc.nextLine();
			System.out.println("Enter the Time in HH:MM AM/PM:");
			String time = sc.nextLine();
			System.out.println("Please enter your Contact Number");
			String contact = sc.nextLine();
			int resId = resList.size() + 1;
			Reservation newRes = new Reservation(name, contact, pax, date,time, tableId, resId);
			resList.add(newRes);
			System.out.println("");
			System.out.println("Reservation successful. Your Reservation ID is " + resId + " and your Table ID is " + tableId);
			System.out.println("");
		}
	}
	
	public void viewReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to view all reservations or a specific reservation?");
		System.out.println("(1)View all (2)View specific");
		int check = sc.nextInt();
		if(check==1) {
			if(resList.size()==0) System.out.println("There are no reservations.");
			else 
				for(int i=0;i<resList.size();i++) {
					System.out.println("Reservation ID: " + resList.get(i).getResID());
					System.out.println("Name: " + resList.get(i).getResName());
					System.out.println("Contact Number: " + resList.get(i).getResContact());
					System.out.println("No. of pax: " + resList.get(i).getResPax());
					System.out.println("Date: " + resList.get(i).getResDate());
					System.out.println("Reservation Timing: " + resList.get(i).getResTime());
					System.out.println("Table ID: " + resList.get(i).getResTableID());
					System.out.println("");

				}
		}
		if(check==2) {
			if(resList.size()==0) System.out.println("There are no reservations.");
			else {
				System.out.println("Enter the Reservation ID: ");
				int resId = sc.nextInt();
				if(resId>resList.size()) System.out.println("Invalid Reservation ID");
				else {
					System.out.println("Reservation ID: " + resList.get(resId-1).getResID());
					System.out.println("Name: " + resList.get(resId-1).getResName());
					System.out.println("Contact Number: " + resList.get(resId-1).getResContact());
					System.out.println("No. of pax: " + resList.get(resId-1).getResPax());
					System.out.println("Date: " + resList.get(resId-1).getResDate());
					System.out.println("Reservation Timing: " + resList.get(resId-1).getResTime());
					System.out.println("Table ID: " + resList.get(resId-1).getResTableID());
					System.out.println("");

				}
			}
		}
	}
	public void viewInvoiceReservationReservation(int resId) {
		if(resId>resList.size()) System.out.println("Invalid Reservation ID");
		else {
			System.out.println("Date: " + resList.get(resId-1).getResDate());
			System.out.println("Reservation ID: " + resList.get(resId-1).getResID());
			System.out.println("Name: " + resList.get(resId-1).getResName());
			System.out.println("Contact Number: " + resList.get(resId-1).getResContact());
			System.out.println("Table ID: " + resList.get(resId-1).getResTableID());
			System.out.println("");
		}
		
	}
	public Reservation getReservation(int resid) {
		return resList.get(resid-1);
	}
	
	public void removeReservation(int resId, TableList tables) {
		if(resList.size()==0) System.out.println("There are no reservations.");
		else {
			int tableId = resList.get(resId-1).getResTableID();
			tables.getTable(tableId).unassign();
			resList.remove(resId-1);
			System.out.println("Reservation removed.");
			if(resList.size()==0) System.out.println("There are no more reservations.");
			else {
				System.out.println("Remaining reservations");
				for(int i=0;i<resList.size();i++) {
					System.out.println("Reservation ID: " + resList.get(i).getResID());
					System.out.println("Name: " + resList.get(i).getResName());
					System.out.println("Contact Number: " + resList.get(i).getResContact());
					System.out.println("No. of pax: " + resList.get(i).getResPax());
					System.out.println("Reservation Timing: " + resList.get(i).getResTime());
					System.out.println("Table ID: " + resList.get(i).getResTableID());
					System.out.println("");
				}
			}
			
		}
	}
}
