package Project;

public class Tables {
	private int tableid;
	private int tablesize;
	private boolean isReserved;
	
	public Tables(int tableid)
	{
		this.tableid=tableid;
		this.isReserved=false;
		//idk what to do with table size because we are 
	    //suppose to have different table sizes
	}
	public int getTableId()
	{
		return this.tableid;
	}
	public int getTableSize(int tableid)
	{	
		return this.tablesize;
	}
	public boolean getStatus(int tableid)
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
