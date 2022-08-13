package com.Nur.Hassan;

import java.util.*;

public class Solution1 {
    public void numberOfMatchesPlayedPerYear(List<Matches> m)
    {
        Map<Integer, Integer> playedPerSeason = new HashMap<Integer, Integer>();

        for(Matches mat : m)
        {
            if(playedPerSeason.containsKey(mat.getSeason()))
            {
                int count = playedPerSeason.get(mat.getSeason());
                playedPerSeason.replace(mat.getSeason(),++count);
            }
            else
            {
                playedPerSeason.put(mat.getSeason(),1);
            }
        }

        Iterator<Integer> it = playedPerSeason.keySet().iterator();
        while (it.hasNext())
        {
            int key = it.next();
            System.out.println(key + " = " + playedPerSeason.get(key));
        }
    }

}
