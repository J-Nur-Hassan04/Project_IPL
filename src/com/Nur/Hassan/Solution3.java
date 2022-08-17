package com.Nur.Hassan;

import java.util.*;

public class Solution3 {
    Map<String, Integer> map = new HashMap<String, Integer>();


    public Map<String , Integer> extraRunsConcededPerTeam2016(List<Deliveries> d, List<Matches> m) {
        List<Integer> ids = matchIdsOf16(m);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Deliveries dl : d) {
            if (ids.contains(dl.getMatch_id())) {
                if (map.containsKey("2016 " + dl.getBatting_team() + " Extra Runs ")) {
                    int extraRun = map.get("2016 " + dl.getBatting_team() + " Extra Runs ");
                    map.replace("2016 " + dl.getBatting_team() + " Extra Runs ", (extraRun + dl.getExtra_runs()));
                } else {
                    map.put("2016 " + dl.getBatting_team() + " Extra Runs ", dl.getExtra_runs());
                }
            }
        }
        return map;
    }

    private List<Integer> matchIdsOf16(List<Matches> m) {
        List<Integer> ids = new ArrayList<Integer>();
        for (Matches ms : m) {
            if (ms.getSeason() == 2016) {
                ids.add(ms.getId());
            }
        }
        return ids;
    }

}
