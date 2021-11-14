package Project;

import java.util.*;

/**
 * Represents a list of order that is paid by customer.
 */

public class SalesRecord extends OrderList{
    //constructors

    /**
     * Creates an empty list of sales record.
     */
    public SalesRecord() { super(); }


    /**
     * Add paid order to sales record array.
     */
    public void addSalesRecord(Order order) { super.getOrderListArray().add(order); }

    /**
     * Display sales revenue by Day.
     */
    public void printByDay(String date)
    {
        System.out.println("Sales Revenue Report for " + date);
        double dRevenue = 0;
        for (int i = 0; i < super.getOrderListArray().size(); i++)
        {
            if (super.getOrderListArray().get(i).getDate().equals(date))
            {
                super.getOrderListArray().get(i).printOrder();
                dRevenue += super.getOrderListArray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + date + ": " + dRevenue);
    }

    /**
     * Display sales revenue by Month.
     */
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

    /**
     * Display sales revenue by Year.
     */
    public void printByYear(String year)
    {
        System.out.println("Sales Revenue Report for " + year);
        double yRevenue = 0;
        for (int i = 0; i < super.getOrderListArray().size(); i++)
        {
            String ordyear = super.getOrderListArray().get(i).getDate();
            String[] splitOrdYear = ordyear.trim().split("\\s+");
            if (splitOrdYear[2].equals(year))
            {
                super.getOrderListArray().get(i).printOrder();
                yRevenue += super.getOrderListArray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + year + ": " + yRevenue);
    }


}