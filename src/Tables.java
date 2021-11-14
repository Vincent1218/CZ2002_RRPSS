package Project;

/**
 * Represents a table in the restaurant.
 */
public class Tables {
	/**
	 * The ID of the table in the restaurant.
	 */
	private int tableId;

	/**
	 * The size of person that the table can hold.
	 */
	private int tableSize;

	/**
	 * The status of the table at different time. From 10 am to 10 pm.
	 */
	private boolean[] isReserved;

	/**
	 * Creates a table with the given parameters.
	 * @param tableId Table ID.
	 * @param tableSize The size that the table can hold.
	 */
	public Tables(int tableId, int tableSize)
	{
		this.tableId=tableId;
		this.isReserved=new boolean[24];
		this.tableSize=tableSize;
	}

	/**
	 * Gets the table ID.
	 * @return Table ID.
	 */
	public int getTableId()
	{
		return this.tableId;
	}

	/**
	 * Gets the size that the table can hold.
	 * @return Table size
	 */
	public int getTableSize()
	{
		return this.tableSize;
	}

	/**
	 * Gets the status of table at particular time.
	 * @param timeChoice Time index that customer wish to book.
	 * @return Boolean status of reservation of the table.
	 */
	public boolean getStatus(int timeChoice)
	{
		return isReserved[timeChoice];
	}

	/**
	 * Gets the status of table at particular time.
	 * @param timeChoice Time index that customer wish to book.
	 * @return Status of reservation of the table. (Occupied/Unoccupied)
	 */
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

	/**
	 * Assign a booked time for the table.
	 * Consecutive two index will be booked. (1 hour)
	 * @param timeChoice Time index that customer wish to book.
	 */
	public void assign(int timeChoice) {
		this.isReserved[timeChoice]=true;
		this.isReserved[timeChoice+1]=true;
		return;
	}

	/**
	 * Unassign a booked time of the table.
	 * @param timeChoice Time index that customer wish to remove.
	 */
	public void unassign(int timeChoice) {
		this.isReserved[timeChoice]=false;
		this.isReserved[timeChoice+1]=false;
		return;
	}

}