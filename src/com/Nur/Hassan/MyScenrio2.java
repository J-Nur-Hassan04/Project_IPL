package com.Nur.Hassan;

import java.util.*;

import java.util.HashMap;

public class MyScenrio2 {
    private Map<String, Integer> map = new HashMap<>();
    private Map<Integer, List<Integer>> ids = new HashMap<>();

    //    public List<Map.Entry<String, Integer>> mostWicketTakenBowler(List<Deliveries> deliveriesList, List<Matches> matchesList)
//    {
//
//        Map<Integer, List<Integer>> listOfIdOfEachYears = getIdsOfEachYear(matchesList);
//        List<Map.Entry<String, Integer>> listOfEachBowlerMostWicketTakenInEachSeason = new ArrayList<>();
//
//        for (Integer key: listOfIdOfEachYears.keySet())
//        {
//            List<Integer> list = listOfIdOfEachYears.get(key);
//            listOfEachBowlerMostWicketTakenInEachSeason.add(getWicketTakenListOfEachPlayer(list, deliveriesList));
//        }
//
//        return listOfEachBowlerMostWicketTakenInEachSeason;
//    }
    public List<String> mostWicketTakenBowler(List<Deliveries> deliveriesList, List<Matches> matchesList) {

        Map<Integer, List<Integer>> listOfIdOfEachYears = getIdsOfEachYear(matchesList);
        List<String> listOfEachBowlerMostWicketTakenInEachSeason = new ArrayList<>();

        for (Integer key : listOfIdOfEachYears.keySet()) {
            List<Integer> list = listOfIdOfEachYears.get(key);
//        listOfEachBowlerMostWicketTakenInEachSeason.add(getWicketTakenListOfEachPlayer(list, deliveriesList));
            String str = "";
            Map.Entry<String, Integer> dataOfMap = getWicketTakenListOfEachPlayer(list, deliveriesList);
            str += key + " = " + dataOfMap.getKey() + " " + dataOfMap.getValue() + "\n";
            listOfEachBowlerMostWicketTakenInEachSeason.add(str);

        }

        return listOfEachBowlerMostWicketTakenInEachSeason;
    }

    private Map.Entry<String, Integer> getWicketTakenListOfEachPlayer(List<Integer> listOfIds, List<Deliveries> d) {
        Map<String, Integer> map = new HashMap<>();
        for (Deliveries dl : d) {
            if (listOfIds.contains(dl.getMatch_id())) {
                if (dl.getDismissal_kind() != null) {
                    if (map.containsKey(dl.getBowler())) {
                        int wicketTaken = map.get(dl.getBowler());
                        map.replace(dl.getBowler(), ++wicketTaken);
                    } else {
                        map.put(dl.getBowler(), 1);
                    }
                }
            }
        }
        return sortMap(map).get(0);

    }

    private Map<Integer, List<Integer>> getIdsOfEachYear(List<Matches> matchesList) {
        for (Matches matches : matchesList) {
            if (ids.containsKey(matches.getSeason())) {
                ids.get(matches.getSeason()).add(matches.getId());
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(matches.getId());
                ids.put(matches.getSeason(), l);
            }
        }
        return ids;
    }


    private List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> map1, Map.Entry<String, Integer> map2) {
                if (map1.getValue() > map2.getValue()) {
                    return -1;
                } else if (map1.getValue() < map2.getValue()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        Collections.sort(list, myComparator);

        return list;
    }
}
