package Project;

import java.util.*;

public class SalesRecord extends OrderList{
    //private ArrayList<Order> orderArray;

    //constructors
    public SalesRecord() { super(); }

    public void addSalesRecord(Order order) { super.getOrderlistArray().add(order); }

    public void printByDay(String date)
    {
        System.out.println("Sales Revenue Report for " + date);
        double drevenue = 0;
        for (int i = 0; i < super.getOrderlistArray().size(); i++)
        {
            if (super.getOrderlistArray().get(i).getDate().equals(date))
            {
                super.getOrderlistArray().get(i).printOrder();
                drevenue += super.getOrderlistArray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + date + ": " + drevenue);
    }

    public void printByMonth(String period)
    {
        System.out.println("Sales Revenue Report for " + period);
        String[] splitPeriod = period.trim().split("\\s+");
        double prevenue = 0;
        for (int j = 0; j < super.getOrderlistArray().size(); j++)
        {
            String ordperiod = super.getOrderlistArray().get(j).getDate();
            String[] splitOrdPeriod = ordperiod.trim().split("\\s+");
            if ((splitOrdPeriod[1].equals(splitPeriod[0])) && (splitOrdPeriod[2].equals(splitPeriod[1])))
            {
                super.getOrderlistArray().get(j).printOrder();
                prevenue += super.getOrderlistArray().get(j).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + period + ": " + prevenue);
    }

    public void printByYear(String year)
    {
        System.out.println("Sales Revenue Report for " + year);
        double yrevenue = 0;
        for (int i = 0; i < super.getOrderlistArray().size(); i++)
        {
            String ordyear = super.getOrderlistArray().get(i).getDate();
            String[] splitOrdYear = ordyear.trim().split("\\s+");
            if (splitOrdYear[2].equals(year))
            {
                super.getOrderlistArray().get(i).printOrder();
                yrevenue += super.getOrderlistArray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + year + ": " + yrevenue);
    }


}