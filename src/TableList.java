package Project;

public class TableList {
	private static final int numOfTables = 15;
	private Tables[] tableArray;
	public boolean checkTableAvailability;
	
	public TableList()
	{
		this.tableArray= new Tables[numOfTables];
		for (int i=0;i<numOfTables;i++)
		{//
			//int size = (i%2==0) ? 2 : 4;
			int size = ((i+1)*2)%8;
			if(size==0) size=8;
			this.tableArray[i]= new Tables(i+1, size);
		}
	}
	
	public void viewAllTableStatus()
	{
		System.out.println("Table ID--------Size------------Status");

		for (int i=0;i<numOfTables;i++)
		{
			 System.out.println(i+1 + "\t\t" + this.tableArray[i].getTableSize() + "\t\t" + tableArray[i].showStatus());
		}
		System.out.println("");
	}
	
	public int checkAvailability(int size) {
		for (int i=0;i<numOfTables;i++) {
			if(this.tableArray[i].getTableSize()==size || this.tableArray[i].getTableSize()-1==size)
			{
				if(tableArray[i].getStatus()==false)
				{
					tableArray[i].assign();
					return tableArray[i].getTableId();
				}
				//if status is true then check time of res
				//if curTime - resTime !> 10mins return 0
				//else unassign and return tableID
			}
				
		}
		return 0;
	}
	
	public Tables getTable(int tableId) {
		return tableArray[tableId-1];
	}
}