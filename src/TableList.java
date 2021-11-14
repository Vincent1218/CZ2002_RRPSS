package Project;

import java.util.*;

/**
 * Represents a list of table in the restaurant.
 */
public class TableList {

	/**
	 * The number of tables in the restaurant.
	 */
	private static final int numOfTables = 16;

	/**
	 * The list of record of tables.
	 */
	private Tables[] tableArray;

	/**
	 * The list of time that restaurant operating, incremented by 30 minutes.
	 */
	private String[] timeArray = {"10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30",
			"16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00"};

	/**
	 * Creates a list of table with 4 different size (2,4,6,8).
	 */
	public TableList()
	{
		this.tableArray= new Tables[numOfTables];
		// create table with size 2,4,6,8
		for (int i=0;i<numOfTables;i++)
		{
			if(i<4){
				this.tableArray[i]= new Tables(i+1, 2);
			}
			else if(i<8){
				this.tableArray[i]= new Tables(i+1, 4);
			}
			else if(i<12){
				this.tableArray[i]= new Tables(i+1, 6);
			}
			else{
				this.tableArray[i]= new Tables(i+1, 8);
			}
		}
	}

	/**
	 * Display status of every table( Occupied/Unoccupied )
	 */
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

	/**
	 * Check availability for specific size.
	 * @param size Specific size requested by customer.
	 * @param timeChoice Time customer gave.
	 * @return Table ID if one suitable table is found, else 0.
	 */
	public int checkAvailability(int size, int timeChoice) {
		for (int i=0;i<numOfTables;i++) {
			if(this.tableArray[i].getTableSize()==size || this.tableArray[i].getTableSize()-1==size)
			{
				if(tableArray[i].getStatus(timeChoice)==true || tableArray[i].getStatus(timeChoice+1)==true)
					continue;
				else
				{
					tableArray[i].assign(timeChoice);
					return tableArray[i].getTableId();
				}
			}

		}
		return 0;
	}

	/**
	 * Get specific table in the restaurant by table ID.
	 * @param tableId Table ID needed to get.
	 * @return Table which has the requested table ID.
	 */
	public Tables getTable(int tableId) {
		return tableArray[tableId-1];
	}
}