package com.Nur.Hassan;

import java.util.*;

public class Solution1 {
    public Map<Integer, Integer> numberOfMatchesPlayedPerYear(List<Matches> m)
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
        return playedPerSeason;
    }

}
