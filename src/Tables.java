package Project;

public class Tables {
	private int tableID;
	private int tablesize;
	private boolean isReserved;
	
	public Tables(int tableID, int tablesize)
	{
		this.tableID=tableID;
		this.isReserved=false;
		this.tablesize=tablesize;
		//idk what to do with table size because we are 
	    //suppose to have different table sizes
	}
	public int getTableID()
	{
		return this.tableID;
	}
	public int getTableSize()
	{	
		return this.tablesize;
	}
	public boolean getStatus()
	{
		return this.isReserved;
	}
	public String showStatus()
	{
		if (this.isReserved == true)
		{
			return "Occupied";
		}
		else
		{
			return "Unoccupied";
		}
	}
	public void assign() {
		this.isReserved=true;
		return;
	}
	public void unassign() {
		this.isReserved=false;
		return;
	}

}