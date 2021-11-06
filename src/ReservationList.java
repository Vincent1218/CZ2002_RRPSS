package Project;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationList {
	private ArrayList<Reservation> resList;
	
	public ReservationList() {this.resList =new ArrayList<>();}
	public int getSize()
	{
		return resList.size();
	}
	public void makeRes(TableList tables, int counter) {
		Scanner sc = new Scanner(System.in);
		int pax=0;
		System.out.println("Whose name will the reservation be under?");
		String name = sc.next();
		while(counter<3)
		{
			System.out.println("Number of Pax?");
			try {pax = sc.nextInt();
			sc.nextLine();}
			catch(InputMismatchException ex)
			{
				if(counter<2)
				{
					System.out.println("Incorrect Entry.Please Try Again..");
					System.out.println("");
				}
				sc.next();
				++counter;
				continue;
			}
			counter = 0;
			if(counter == 0) {break;}
		}
		if(counter==3) 
		{
			System.out.println("Incorrect Entry. Return to main program..");
			return;
		}
		int tableId = tables.checkAvailability(pax);
		if(tableId==0) System.out.println("Sorry, we have no available tables at the moment. Please try again later.");
		else {
			int contact = 0;
			System.out.println("Enter the Date in DD/MM/YYYY:");
			String date = sc.next();
			System.out.println("Enter the Time in HH:MM (24H Format):");
			String time = sc.next();
			sc.nextLine();
			while(counter<3)
			{
				System.out.println("Please enter your Contact Number: ");
				try {contact = sc.nextInt();
				sc.nextLine();}
				catch(InputMismatchException ex)
				{
					if(counter<2)
					{
						System.out.println("Incorrect Entry.Please Try Again..");
						System.out.println("");
					}
					sc.next();
					++counter;
					continue;
				}
				counter = 0;
				if(counter == 0) {break;}
			}
			if(counter==3) 
			{
				System.out.println("Incorrect Entry. Return to main program..");
				return;
			}
			int resId = resList.size() + 1;
			Reservation newRes = new Reservation(name, contact, pax, date, time, tableId, resId);
			resList.add(newRes);
			System.out.println("");
			System.out.println("Reservation successful. Your Reservation ID is " + resId + " and your Table ID is " + tableId);
			System.out.println("");
		}
	}
	
	public void viewReservation(int counter) {
		Scanner sc = new Scanner(System.in);
		int check=0;
		while (counter<3)
		{
			System.out.println("Would you like to view all reservations or a specific reservation?");
			System.out.println("(1)View all (2)View specific");
			try {check = sc.nextInt();
				sc.nextLine();}
				catch(InputMismatchException ex)
				{
					if(counter<2)
					{
						System.out.println("Incorrect Entry.Please Try Again..");
						System.out.println("");
					}
					sc.next();
					++counter;
					continue;
				}
				counter = 0;
				if(counter == 0) {break;}
		}
		if(counter==3) 
		{
			System.out.println("Incorrect Entry. Return to main program..");
			return;
		}
		if(check>2)
		{
			System.out.println("Incorrect Entry. Return to main program..");
			return;
		}
		switch(check)
		{
			case 1:
			{
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
				break;
			case 2:
			{
				if(resList.size()==0) System.out.println("There are no reservations.");
				else {
					System.out.println("Enter the Reservation ID: ");
					int resId = sc.nextInt();
					if(resId>resList.size()||resId<0) System.out.println("Invalid Reservation ID");
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
			break;
			default:
			{
				System.out.println("");
				System.out.println("Incorrect Entry. Please try again...");
				System.out.println("");
			}
		}
	}
	public void viewInvoiceReservationReservation(int resId) {
		if(resId>resList.size()||resId<0)System.out.println("Invalid Reservation ID");
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
		else if(resId>resList.size()||resId<0)System.out.println("Invalid Reservation ID");
		else {
			int tableId = resList.get(resId-1).getResTableID();
			if (tableId != 0) tables.getTable(tableId).unassign();
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
					System.out.println("Date: " + resList.get(i).getResDate());
					System.out.println("Reservation Timing: " + resList.get(i).getResTime());
					System.out.println("Table ID: " + resList.get(i).getResTableID());
					System.out.println("");
				}
			}
			
		}
	}

	public void clearReservation(TableList tables) {
		if(resList.size()==0) return;
		else 
			for(int i=0;i<resList.size();i++)
			{
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date resTime = null;
				String resDateTime = resList.get(i).getResDate() + " " + resList.get(i).getResTime();
				try {
					resTime = formatter.parse(resDateTime);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				//System.out.println(resTime); 
    			Date curTime = new Date();  
				//System.out.println(curTime);
				long diff = (curTime.getTime() - resTime.getTime())/(60*1000);
				//System.out.println(diff);
				if(diff>10)
				{
					tables.getTable(resList.get(i).getResTableID()).unassign();
					resList.get(i).updateTableID(0);
				}
			}
	}
}
