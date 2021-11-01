package Project;

import java.util.*;

public class SalesRecord {
    private ArrayList<Order> orderArray;

    //constructors
    public SalesRecord()
    {
        this.orderArray = new ArrayList<>();
    }

    public void addSalesRecord(Order order)
    {
        this.orderArray.add(order);
    }


}
