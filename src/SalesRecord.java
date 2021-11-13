package Project;

import java.util.*;

public class SalesRecord extends OrderList{
    //private ArrayList<Order> orderArray;

    //constructors
    public SalesRecord() { super(); }

    public void addSalesRecord(Order order) { super.getOrderListArray().add(order); }

    public void printByDay(String date)
    {
        System.out.println("Sales Revenue Report for " + date);
        double drevenue = 0;
        for (int i = 0; i < super.getOrderListArray().size(); i++)
        {
            if (super.getOrderListArray().get(i).getDate().equals(date))
            {
                super.getOrderListArray().get(i).printOrder();
                drevenue += super.getOrderListArray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + date + ": " + drevenue);
    }

    public void printByMonth(String period)
    {
        System.out.println("Sales Revenue Report for " + period);
        String[] splitPeriod = period.trim().split("\\s+");
        double prevenue = 0;
        for (int j = 0; j < super.getOrderListArray().size(); j++)
        {
            String ordperiod = super.getOrderListArray().get(j).getDate();
            String[] splitOrdPeriod = ordperiod.trim().split("\\s+");
            if ((splitOrdPeriod[1].equals(splitPeriod[0])) && (splitOrdPeriod[2].equals(splitPeriod[1])))
            {
                super.getOrderListArray().get(j).printOrder();
                prevenue += super.getOrderListArray().get(j).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + period + ": " + prevenue);
    }

    public void printByYear(String year)
    {
        System.out.println("Sales Revenue Report for " + year);
        double yrevenue = 0;
        for (int i = 0; i < super.getOrderListArray().size(); i++)
        {
            String ordyear = super.getOrderListArray().get(i).getDate();
            String[] splitOrdYear = ordyear.trim().split("\\s+");
            if (splitOrdYear[2].equals(year))
            {
                super.getOrderListArray().get(i).printOrder();
                yrevenue += super.getOrderListArray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + year + ": " + yrevenue);
    }


}