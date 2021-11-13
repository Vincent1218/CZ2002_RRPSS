package Project;

import java.util.*;
public class TableList {
	private static final int numOfTables = 15;
	private Tables[] tableArray;
	public boolean checkTableAvailability;
	private String[] timeArray = {"10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30",
	"16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00"};
	
	public TableList()
	{
		this.tableArray= new Tables[numOfTables];
		for (int i=0;i<numOfTables;i++)
		{
			int size = ((i+1)*2)%8;
			if(size==0) size=8;
			this.tableArray[i]= new Tables(i+1, size);
		}
	}
	
	public void viewAllTableStatus()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose time slot");
		for(int i=0;i<23;i++)
			System.out.printf("(%d) " + timeArray[i] + "\n", i+1);
		
		int timeChoice = sc.nextInt();
		
		System.out.println("Table ID--------Size------------Status");

		for (int i=0;i<numOfTables;i++)
		{
			 System.out.println(i+1 + "\t\t" + this.tableArray[i].getTableSize() + "\t\t" + tableArray[i].showStatus(timeChoice-1));
		}
		System.out.println("");
	}
	
	public int checkAvailability(int size, int timeChoice) {
		for (int i=0;i<numOfTables;i++) {
			if(this.tableArray[i].getTableSize()==size || this.tableArray[i].getTableSize()-1==size)
			{
				if(tableArray[i].getStatus(timeChoice-1)==true)
					continue;
				else
				{
					tableArray[i].assign(timeChoice-1);
					return tableArray[i].getTableId();
				}
			}
				
		}
		return 0;
	}
	
	public Tables getTable(int tableId) {
		return tableArray[tableId-1];
	}
}