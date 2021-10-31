package Project;

public class TableList {
	private Tables[] tableArray;
	public boolean checkTableAvailability;
	
	public TableList()
	{
		this.tableArray= new Tables[12];
		for (int i=0;i<12;i++)
		{
			this.tableArray[i]= new Tables(i+1);
		}
	}
	public void viewAllTableStatus()
	{
		System.out.println("Table ID------------------------------Status");

		for (int i=0;i<12;i++)
		{
			 System.out.println(i + "\t\t" + this.tableArray[i].showStatus());
		}
		System.out.println("");
	}
	//#boolean checkTableAvailability(orderID) #check time 
	//and reservation here, 
	//if over XX minutes, cancel the reservation and return true
}
