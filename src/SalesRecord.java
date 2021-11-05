package Project;

import java.util.*;

public class SalesRecord extends OrderList{
    //private ArrayList<Order> orderArray;

    //constructors
    public SalesRecord() { super(); }

    public void addSalesRecord(Order order) { super.getOrderlistarray().add(order); }

    public void printByDay(String date)
    {
        System.out.println("Sales Revenue Report for " + date);
        double drevenue = 0;
        for (int i = 0; i < super.getOrderlistarray().size(); i++)
        {
            if (super.getOrderlistarray().get(i).getDate().equals(date))
            {
                super.getOrderlistarray().get(i).printOrder();
                drevenue += super.getOrderlistarray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + date + ": " + drevenue);
    }

    public void printByMonth(String period)
    {
        System.out.println("Sales Revenue Report for " + period);
        String[] splitPeriod = period.trim().split("\\s+");
        double prevenue = 0;
        for (int j = 0; j < super.getOrderlistarray().size(); j++)
        {
            String ordperiod = super.getOrderlistarray().get(j).getDate();
            String[] splitOrdPeriod = ordperiod.trim().split("\\s+");
            if ((splitOrdPeriod[1].equals(splitPeriod[0])) && (splitOrdPeriod[2].equals(splitPeriod[1])))
            {
                super.getOrderlistarray().get(j).printOrder();
                prevenue += super.getOrderlistarray().get(j).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + period + ": " + prevenue);
    }

    public void printByYear(String year)
    {
        System.out.println("Sales Revenue Report for " + year);
        double yrevenue = 0;
        for (int i = 0; i < super.getOrderlistarray().size(); i++)
        {
            String ordyear = super.getOrderlistarray().get(i).getDate();
            String[] splitOrdYear = ordyear.trim().split("\\s+");
            if (splitOrdYear[2].equals(year))
            {
                super.getOrderlistarray().get(i).printOrder();
                yrevenue += super.getOrderlistarray().get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + year + ": " + yrevenue);
    }


}