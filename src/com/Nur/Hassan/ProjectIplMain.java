package com.Nur.Hassan;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class ProjectIplMain {

    public static final int ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int DATE = 3;
    public static final int TEAM1 = 4;
    public static final int TEAM2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKETS = 12;
    public static final int PLAYER_OF_MATCH = 13;
    public static final int VENUE = 14;
    public static final int UMPIRE1 = 15;
    public static final int UMPIRE2 = 16;
    public static final int UMPIRE3 = 17;

    public static final int MATCH_ID = 0;
    public static final int INNING = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALL = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final int IS_SUPER_OVER = 9;
    public static final int WIDE_RUNS = 10;
    public static final int BYE_RUNS = 11;
    public static final int LEGBYE_RUNS = 12;
    public static final int NOBALL_RUNS = 13;
    public static final int PENALTY_RUNS = 14;
    public static final int BATSMAN_RUNS = 15;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    public static final int PLAYER_DISMISSED = 18;
    public static final int DISMISSAL_KIND = 19;
    public static final int FIELDER = 20;

    public static BufferedReader bufferedReader;

    public static void main(String[] args) throws Exception {

        List<Matches> matchesList = getMatchesList();
        List<Deliveries> deliveriesList = getDeliveriesList();

        System.out.println("Number of matches played per year of all the years in IPL.");
        System.out.println(findNumberOfMatchesPlayedPerYear(matchesList));

        System.out.println("Number of matches won of all teams over all the years of IPL.");
        System.out.println(findNumberOfMatchesWonOfAllTeamsOverAllTheYears(matchesList));

        System.out.println("For the year 2016 get the extra runs conceded per team.");
        System.out.println(findExtraRunsConcededPerTeamInSpecificYear(deliveriesList,matchesList));

        System.out.println("For the year 2015 get the top economical bowlers.");
        System.out.println(findTopEconomicalBowlersOfSpecificYear(matchesList, deliveriesList));

        System.out.println("Strike rate of all player in IPL");
        System.out.println(findStrikeRate(deliveriesList));

        System.out.println("Wicket taken by every player in every season");
        System.out.println(getListMostWicketTakenPlayerOfEachSeason(deliveriesList, matchesList));

    }

    public static List<Matches> getMatchesList() throws Exception {
        bufferedReader = new BufferedReader(new FileReader("matches.csv"));
        List<Matches> matchesList = new ArrayList<>();
        String matchesLine = bufferedReader.readLine();//Skip the first line

        while ((matchesLine = bufferedReader.readLine()) != null) {
            Matches matches = new Matches();
            String[] stringArr = matchesLine.split(",");
            String[] arr = new String[18];
            for (int index = 0; index < stringArr.length; index++) {
                arr[index] = stringArr[index];
            }

            matches.setId(Integer.parseInt(arr[ID]));
            matches.setSeason(Integer.parseInt(arr[SEASON]));
            matches.setCity(arr[CITY]);
            matches.setDate(arr[DATE]);
            matches.setTeam1(arr[TEAM1]);
            matches.setTeam2(arr[TEAM2]);
            matches.setToss_winner(arr[TOSS_WINNER]);
            matches.setToss_decision(arr[TOSS_DECISION]);
            matches.setResult(arr[RESULT]);
            matches.setDl_applied(Integer.parseInt(arr[DL_APPLIED]));
            matches.setWinner(arr[WINNER]);
            matches.setWin_by_runs(Integer.parseInt(arr[WIN_BY_RUNS]));
            matches.setWin_by_wickets(Integer.parseInt(arr[WIN_BY_WICKETS]));
            matches.setPlayer_of_match(arr[PLAYER_OF_MATCH]);
            matches.setVenue(arr[VENUE]);
            matches.setUmpire1(arr[UMPIRE1]);
            matches.setUmpire2(arr[UMPIRE2]);
            matches.setUmpire3(arr[UMPIRE3]);

            matchesList.add(matches);
        }
        bufferedReader.close();
        return matchesList;
    }

    public static List<Deliveries> getDeliveriesList() throws Exception {
        bufferedReader = new BufferedReader(new FileReader("deliveries.csv"));
        List<Deliveries> deliveryList = new ArrayList<>();
        String deliverisLine = bufferedReader.readLine();//skip first line

        while ((deliverisLine = bufferedReader.readLine()) != null) {
            Deliveries deliveries = new Deliveries();

            String[] stringArr = deliverisLine.split(",");
            String[] arr = new String[21];
            for (int index = 0; index < stringArr.length; index++) {
                arr[index] = stringArr[index];
            }

            deliveries.setMatchId(Integer.parseInt(arr[MATCH_ID]));
            deliveries.setInning(Integer.parseInt(arr[INNING]));
            deliveries.setBattingTeam(arr[BATTING_TEAM]);
            deliveries.setBowlingTeam(arr[BOWLING_TEAM]);
            deliveries.setOver(Integer.parseInt(arr[OVER]));
            deliveries.setBall(Integer.parseInt(arr[BALL]));
            deliveries.setBatsman(arr[BATSMAN]);
            deliveries.setNonStriker(arr[NON_STRIKER]);
            deliveries.setBowler(arr[BOWLER]);
            deliveries.setIsSuperOver(Integer.parseInt(arr[IS_SUPER_OVER]));
            deliveries.setWideRuns(Integer.parseInt(arr[WIDE_RUNS]));
            deliveries.setByeRuns(Integer.parseInt(arr[BYE_RUNS]));
            deliveries.setLegByRuns(Integer.parseInt(arr[LEGBYE_RUNS]));
            deliveries.setNoBallRuns(Integer.parseInt(arr[NOBALL_RUNS]));
            deliveries.setPenaltyRuns(Integer.parseInt(arr[PENALTY_RUNS]));
            deliveries.setBatsmanRuns(Integer.parseInt(arr[BATSMAN_RUNS]));
            deliveries.setExtraRuns(Integer.parseInt(arr[EXTRA_RUNS]));
            deliveries.setTotalRuns(Integer.parseInt(arr[TOTAL_RUNS]));
            deliveries.setPlayerDismissed(arr[PLAYER_DISMISSED]);
            deliveries.setDismissalKind(arr[DISMISSAL_KIND]);
            deliveries.setFielder(arr[FIELDER]);

            deliveryList.add(deliveries);
        }
        bufferedReader.close();
        return deliveryList;
    }

    public static Map<Integer, Integer> findNumberOfMatchesPlayedPerYear(List<Matches> matchesList) {
        Map<Integer, Integer> playedPerSeason = new HashMap<Integer, Integer>();

        for (Matches matches : matchesList) {
            if (playedPerSeason.containsKey(matches.getSeason())) {
                int count = playedPerSeason.get(matches.getSeason());
                playedPerSeason.replace(matches.getSeason(), ++count);
            } else {
                playedPerSeason.put(matches.getSeason(), 1);
            }
        }
        return playedPerSeason;
    }

    public static Map<String, Integer> findNumberOfMatchesWonOfAllTeamsOverAllTheYears(List<Matches> matchesList) {
        Map<String, Integer> matchesWon = new HashMap<String, Integer>();
        for (Matches matches : matchesList) {
            if (matchesWon.containsKey(matches.getWinner())) {
                int count = matchesWon.get(matches.getWinner());
                matchesWon.replace(matches.getWinner(), ++count);
            } else {
                matchesWon.put(matches.getWinner(), 1);
            }
        }
        return matchesWon;
    }

    public static Map<String, Integer> findExtraRunsConcededPerTeamInSpecificYear(List<Deliveries> deliveriesList,
                                                                                  List<Matches> matchesList) {
        System.out.print("Enter year :");
        int year = new Scanner(System.in).nextInt();

        List<Integer> ids = new ArrayList<>();
        for (Matches matches : matchesList) {
            if (matches.getSeason() == year) {
                ids.add(matches.getId());
            }
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Deliveries deliveries : deliveriesList) {
            if (ids.contains(deliveries.getMatchId())) {
                if (map.containsKey(year + " " + deliveries.getBattingTeam() + " Extra Runs ")) {
                    int extraRun = map.get(year + " " + deliveries.getBattingTeam() + " Extra Runs ");
                    map.replace(year + " " + deliveries.getBattingTeam() + " Extra Runs ",
                                                                            (extraRun + deliveries.getExtraRuns()));
                } else {
                    map.put(year + " " + deliveries.getBattingTeam() + " Extra Runs ", deliveries.getExtraRuns());
                }
            }
        }
        return map;
    }

    public static List<Map.Entry<String, Double>> findTopEconomicalBowlersOfSpecificYear(List<Matches> matchesList,
                                                                                         List<Deliveries> deliveryList) {
        System.out.print("Enter Year :");
        int year = new Scanner(System.in).nextInt();
        Map<String, Double> numberOfOver = new HashMap<>();
        Map<String, Double> totalRun = new HashMap<>();
        List<Integer> ids = new ArrayList<>();

        for (Matches matches : matchesList) {
            if (matches.getSeason() == year) {
                ids.add(matches.getId());
            }
        }

        for (Deliveries deliveries : deliveryList) {
            if (ids.contains(deliveries.getMatchId())) {
                if (numberOfOver.containsKey(deliveries.getBowler())) {
                    double runCount = deliveries.getTotalRuns() + totalRun.get(deliveries.getBowler());
                    totalRun.replace(deliveries.getBowler(), runCount);

                    double countBall = numberOfOver.get(deliveries.getBowler());
                    numberOfOver.replace(deliveries.getBowler(), ++countBall);
                } else {
                    numberOfOver.put(deliveries.getBowler(), 1.0);
                    totalRun.put(deliveries.getBowler(), (double) deliveries.getTotalRuns());

                }
            }
        }

        for (String key : numberOfOver.keySet()) {
            numberOfOver.replace(key, numberOfOver.get(key) / 6);
        }

        Map<String, Double> economyRate = totalRun;

        for (String key : economyRate.keySet()) {
            economyRate.replace(key, totalRun.get(key) / numberOfOver.get(key));
        }

        List<Map.Entry<String, Double>> topEconoyBowler = new ArrayList<>(economyRate.entrySet());

        Comparator<Map.Entry<String, Double>> myComp = new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> t1, Map.Entry<String, Double> t2) {
                if (t1.getValue() > t2.getValue()) {
                    return 1;
                } else if (t1.getValue() == t2.getValue()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };

        Collections.sort(topEconoyBowler, myComp);

        return topEconoyBowler;
    }

    public static List<Map.Entry<String, Double>> findStrikeRate(List<Deliveries> deliveryList) {
        Map<String, Integer> ballFaced = new HashMap<>();
        Map<String, Double> totalRun = new HashMap<>();
        Map<String, Double> strikeRate = new HashMap<>();

        for (Deliveries batsMan : deliveryList) {
            if (ballFaced.containsKey(batsMan.getBatsman())) {
                Double total = totalRun.get(batsMan.getBatsman()) + batsMan.getTotalRuns();
                totalRun.replace(batsMan.getBatsman(), total);

                int ballCount = ballFaced.get(batsMan.getBatsman());
                ballFaced.replace(batsMan.getBatsman(), ++ballCount);
            } else {
                ballFaced.put(batsMan.getBatsman(), 1);
                totalRun.put(batsMan.getBatsman(), (double) batsMan.getTotalRuns());
            }
        }
        for (String key : ballFaced.keySet()) {
            strikeRate.put(key, (totalRun.get(key) / ballFaced.get(key)) * 100);
        }

        List<Map.Entry<String, Double>> sortedStrikRate = new ArrayList<>(strikeRate.entrySet());
        Comparator<Map.Entry<String, Double>> mycomp = new Comparator<>() {
            public int compare(Map.Entry<String, Double> t1, Map.Entry<String, Double> t2) {
                if (t1.getValue() > t2.getValue()) {
                    return -1;
                } else if (t2.getValue() > t1.getValue()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        Collections.sort(sortedStrikRate, mycomp);


        return sortedStrikRate;
    }

//  public static List<Map.Entry<String, Integer>> mostWicketTakenBowler(List<Deliveries> deliveriesList, List<Matches> matchesList)
//        {
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
    public static List<String> getListMostWicketTakenPlayerOfEachSeason(List<Deliveries> deliveriesList,
                                                                        List<Matches> matchesList) {

        Map<Integer, List<Integer>> listOfIdOfEachYears = getIdsOfEachYear(matchesList);
        List<String> listOfEachBowlerMostWicketTakenInEachSeason = new ArrayList<>();

        for (Integer key : listOfIdOfEachYears.keySet()) {
            List<Integer> list = listOfIdOfEachYears.get(key);
//        listOfEachBowlerMostWicketTakenInEachSeason.add(getWicketTakenListOfEachPlayer(list, deliveriesList));
//            String yearNameWicketTaken = "";
            Map.Entry<String, Integer> dataOfMap = findMostWicketTakenPlayerOfSeason(list, deliveriesList);
            String yearNameWicketTaken = key + " = " + dataOfMap.getKey() + " " + dataOfMap.getValue() + "\n";
            listOfEachBowlerMostWicketTakenInEachSeason.add(yearNameWicketTaken);

        }

        return listOfEachBowlerMostWicketTakenInEachSeason;
    }

    public static Map.Entry<String, Integer> findMostWicketTakenPlayerOfSeason(List<Integer> listOfIds,
                                                                               List<Deliveries> deliveriesList) {
        Map<String, Integer> wicketTakenMap = new HashMap<>();
        for (Deliveries deliveries : deliveriesList) {
            if (listOfIds.contains(deliveries.getMatchId())) {
                if (deliveries.getDismissalKind() != null) {
                    if (wicketTakenMap.containsKey(deliveries.getBowler())) {
                        int wicketTaken = wicketTakenMap.get(deliveries.getBowler());
                        wicketTakenMap.replace(deliveries.getBowler(), ++wicketTaken);
                    } else {
                        wicketTakenMap.put(deliveries.getBowler(), 1);
                    }
                }
            }
        }
        return sortMap(wicketTakenMap).get(0);

    }

    public static Map<Integer, List<Integer>> getIdsOfEachYear(List<Matches> matchesList) {
        Map<Integer, List<Integer>> ids = new HashMap<>();
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

    public static List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> listToBeSort = new ArrayList<>(map.entrySet());
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

        Collections.sort(listToBeSort, myComparator);

        return listToBeSort;
    }
}