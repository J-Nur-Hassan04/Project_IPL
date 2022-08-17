package com.Nur.Hassan;

import java.util.*;

public class MyScenrio {
    Map<String, Integer> ballFaced = new HashMap<>();
    Map<String, Double> totalRun = new HashMap<>();
    Map<String,Double> rate = new HashMap<>();

    public List<Map.Entry<String, Double>> strikeRate(List<Deliveries> deliveryList)
    {
        for(Deliveries batsMan : deliveryList)
        {
            if(ballFaced.containsKey(batsMan.getBatsman()))
            {
                Double total = totalRun.get(batsMan.getBatsman()) + batsMan.getTotal_runs();
                totalRun.replace(batsMan.getBatsman(),total);

                int ballCount = ballFaced.get(batsMan.getBatsman());
                ballFaced.replace(batsMan.getBatsman(), ++ballCount);
            }
            else {
                ballFaced.put(batsMan.getBatsman(),1);
                totalRun.put(batsMan.getBatsman(),(double)batsMan.getTotal_runs());
            }
        }
        for(String key : ballFaced.keySet())
        {
            rate.put(key, (totalRun.get(key) / ballFaced.get(key))*100);
        }

        List<Map.Entry<String,Double>> sortedStrikRate = new ArrayList<>(rate.entrySet());

        Comparator<Map.Entry<String , Double>> mycomp = new Comparator<>(){
            public int compare(Map.Entry<String,Double> t1, Map.Entry<String , Double> t2)
            {
                if(t1.getValue() > t2.getValue())
                {
                    return -1;
                }
                else if(t2.getValue() > t1.getValue())
                {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        };

        Collections.sort(sortedStrikRate, mycomp);

//        for(Map.Entry<String,Double> key : sortedStrikRate)
//        {
//            System.out.println(key);
//        }
        return sortedStrikRate;


    }

}
