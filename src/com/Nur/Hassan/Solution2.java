package com.Nur.Hassan;

import java.util.*;

public class Solution2 {
    public Map<String, Integer> numberOfMatchesWonOfAllTeamsOverAllTheYears(List<Matches> m)
    {
        Map<String , Integer> map = new HashMap<String , Integer>();
        for (Matches mat : m)
        {
            if(map.containsKey(mat.getWinner()))
            {
                int count = map.get(mat.getWinner());
                map.replace(mat.getWinner(), ++count);
            }
            else
            {
                map.put(mat.getWinner(),1);
            }
        }
        return map;
    }

}
