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

    public void printByDay(String date)
    {
        System.out.println("Sales Revenue Report for " + date);
        double drevenue = 0;
        for (int i = 0; i < this.orderArray.size(); i++)
        {
            if (this.orderArray.get(i).getDate().equals(date))
            {
                this.orderArray.get(i).printOrder();
                drevenue += this.orderArray.get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + date + ": " + drevenue);
    }

    public void printByMonth(String period)
    {
        System.out.println("Sales Revenue Report for " + period);
        String[] splitPeriod = period.trim().split("\\s+");
        double prevenue = 0;
        for (int j = 0; j < this.orderArray.size(); j++)
        {
            String ordperiod = this.orderArray.get(j).getDate();
            String[] splitOrdPeriod = ordperiod.trim().split("\\s+");
            if ((splitOrdPeriod[1].equals(splitPeriod[0])) && (splitOrdPeriod[2].equals(splitPeriod[1])))
            {
                this.orderArray.get(j).printOrder();
                prevenue += this.orderArray.get(j).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + period + ": " + prevenue);
    }

    public void printByYear(String year)
    {
        System.out.println("Sales Revenue Report for " + year);
        double yrevenue = 0;
        for (int i = 0; i < this.orderArray.size(); i++)
        {
            String ordyear = this.orderArray.get(i).getDate();
            String[] splitOrdYear = ordyear.trim().split("\\s+");
            if (splitOrdYear[2].equals(year))
            {
                this.orderArray.get(i).printOrder();
                yrevenue += this.orderArray.get(i).getFinalPrice();
            }
        }
        System.out.println("Total revenue for " + year + ": " + yrevenue);
    }


}
