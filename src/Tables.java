package Project;

public class Tables {
	private int tableid;
	private int tablesize;
	private boolean[] isReserved;

	public Tables(int tableid, int tablesize)
	{
		this.tableid=tableid;
		this.isReserved=new boolean[24];
		this.tablesize=tablesize;
	}
	public int getTableId()
	{
		return this.tableid;
	}
	public int getTableSize()
	{
		return this.tablesize;
	}
	public boolean getStatus(int timeChoice)
	{
		return isReserved[timeChoice];
	}
	public String showStatus(int timeChoice)
	{
		if (this.isReserved[timeChoice] == true)
		{
			return "Occupied";
		}
		else
		{
			return "Unoccupied";
		}
	}
	public void assign(int timeChoice) {
		this.isReserved[timeChoice]=true;
		this.isReserved[timeChoice+1]=true;
		return;
	}
	public void unassign(int timeChoice) {
		this.isReserved[timeChoice]=false;
		this.isReserved[timeChoice+1]=false;
		return;
	}

}