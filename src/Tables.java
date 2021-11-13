package Project;

public class Tables {
	private int tableId;
	private int tableSize;
	private boolean[] isReserved;

	public Tables(int tableId, int tableSize)
	{
		this.tableId=tableId;
		this.isReserved=new boolean[24];
		this.tableSize=tableSize;
	}
	public int getTableId()
	{
		return this.tableId;
	}
	public int getTableSize()
	{
		return this.tableSize;
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