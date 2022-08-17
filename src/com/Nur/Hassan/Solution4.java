package com.Nur.Hassan;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Solution4 {
    Map<String , Double> numberOfOver = new HashMap<>();
    Map<String, Double> totalRun = new HashMap<>();
    List<Integer> ids = new ArrayList<>();

    public List<Map.Entry<String, Double>> topEconomicalBowlersOf2015(List<Matches> matchesList, List<Deliveries> deliveryList)
    {
        for(Matches m : matchesList)
        {
            if(m.getSeason() == 2015)
            {
                ids.add(m.getId());
            }
        }

        for (Deliveries d :deliveryList)
        {
            if(ids.contains(d.getMatch_id()))
            {
                if(numberOfOver.containsKey(d.getBowler()))
                {
                    double runCount = d.getTotal_runs() + totalRun.get(d.getBowler());
                    totalRun.replace(d.getBowler(), runCount);

                    double countBall = numberOfOver.get(d.getBowler());
                    numberOfOver.replace(d.getBowler(), ++countBall);
                }
                else {
                    numberOfOver.put(d.getBowler(),1.0);
                    totalRun.put(d.getBowler(), (double)d.getTotal_runs());

                }
            }
        }

        for(String key : numberOfOver.keySet())
        {
            numberOfOver.replace(key, numberOfOver.get(key)/6);
        }

        Map<String,Double> economyRate = totalRun;

        for(String key : economyRate.keySet())
        {
            economyRate.replace(key, totalRun.get(key)/numberOfOver.get(key));
        }

        List<Map.Entry<String, Double>> topEconoyBowler = new ArrayList<>(economyRate.entrySet());
        Comparator<Map.Entry<String , Double>> myComp = new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> t1, Map.Entry<String, Double> t2) {
                if(t1.getValue() > t2.getValue())
                {
                    return 1;
                } else if (t1.getValue() == t2.getValue()) {
                    return 0;
                }
                else {
                    return -1;
                }
            }
        };
        Collections.sort(topEconoyBowler,myComp);

//        for(Map.Entry<String, Double> key : topEconoyBowler)
//        {
//            System.out.println(key);
//        }
        return topEconoyBowler;
    }

}
