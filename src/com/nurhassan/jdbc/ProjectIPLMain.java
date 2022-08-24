package com.nurhassan.jdbc;

import com.nurhassan.java.Deliveries;
import com.nurhassan.java.Matches;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class ProjectIPLMain {

    public static final int ID = 1;
    public static final int SEASON = 2;
    public static final int CITY = 3;
    public static final int DATE = 4;
    public static final int TEAM1 = 5;
    public static final int TEAM2 = 6;
    public static final int TOSS_WINNER = 7;
    public static final int TOSS_DECISION = 8;
    public static final int RESULT = 9;
    public static final int DL_APPLIED = 10;
    public static final int WINNER = 11;
    public static final int WIN_BY_RUNS = 12;
    public static final int WIN_BY_WICKETS = 13;
    public static final int PLAYER_OF_MATCH = 14;
    public static final int VENUE = 15;
    public static final int UMPIRE1 = 16;
    public static final int UMPIRE2 = 17;
    public static final int UMPIRE3 = 18;

    public static final int MATCH_ID = 1;
    public static final int INNING = 2;
    public static final int BATTING_TEAM = 3;
    public static final int BOWLING_TEAM = 4;
    public static final int OVER = 5;
    public static final int BALL = 6;
    public static final int BATSMAN = 7;
    public static final int NON_STRIKER = 8;
    public static final int BOWLER = 9;
    public static final int IS_SUPER_OVER = 10;
    public static final int WIDE_RUNS = 11;
    public static final int BYE_RUNS = 12;
    public static final int LEGBYE_RUNS = 13;
    public static final int NOBALL_RUNS = 14;
    public static final int PENALTY_RUNS = 15;
    public static final int BATSMAN_RUNS = 16;
    public static final int EXTRA_RUNS = 17;
    public static final int TOTAL_RUNS = 18;
    public static final int PLAYER_DISMISSED = 19;
    public static final int DISMISSAL_KIND = 20;
    public static final int FIELDER = 21;

    private static final String dataBaseURL = "JDBC:mysql://localhost:3306/IPLDataSet";
    private static final String userName = "root";
    private static final String password = "NurHassan@2000";

    public static void main(String[] args) throws Exception {

        List<Matches> matches = getMatches();
        List<Deliveries> deliveries = getDeliveries();

        findNumberOfMatchesPlayedPerYear(matches);
        findNumberOfMatchesWonByAllTeamsOverAllTheYears(matches);
        findExtraRunsConcededPerTeamInSpecificYear(matches, deliveries);
        findTopEconomicalBowlersOfSpecificYear(matches, deliveries);
        findStrikeRateOfEveryPlayer(deliveries);
        getMostWicketTakenPlayerOfEachSeason(matches, deliveries);

    }

    public static List<Matches> getMatches() throws Exception {
        List<Matches> matches = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection databaseConnection = DriverManager.getConnection(dataBaseURL, userName, password);
            Statement data = databaseConnection.createStatement();
            ResultSet resultSet = data.executeQuery("Select * from matches");

            while (resultSet.next()) {
                Matches match = new Matches();

                match.setId(resultSet.getInt(ID));
                match.setSeason(resultSet.getInt(SEASON));
                match.setCity(resultSet.getString(CITY));
                match.setDate(resultSet.getString(DATE));
                match.setTeam1(resultSet.getString(TEAM1));
                match.setTeam2(resultSet.getString(TEAM2));
                match.setToss_winner(resultSet.getString(TOSS_WINNER));
                match.setToss_decision(resultSet.getString(TOSS_DECISION));
                match.setResult(resultSet.getString(RESULT));
                match.setDl_applied(resultSet.getInt(DL_APPLIED));
                match.setWinner(resultSet.getString(WINNER));
                match.setWin_by_runs(resultSet.getInt(WIN_BY_RUNS));
                match.setWin_by_wickets(resultSet.getInt(WIN_BY_WICKETS));
                match.setPlayer_of_match(resultSet.getString(PLAYER_OF_MATCH));
                match.setVenue(resultSet.getString(VENUE));
                match.setUmpire1(resultSet.getString(UMPIRE1));
                match.setUmpire2(resultSet.getString(UMPIRE2));
                match.setUmpire3(resultSet.getString(UMPIRE3));

                matches.add(match);
            }
            databaseConnection.close();
        } catch (SQLException e) {
            System.out.println("SQLException occurred when getting Matches data");
        }

        return matches;
    }

    public static List<Deliveries> getDeliveries() throws Exception {
        List<Deliveries> deliveries = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dataBaseURL, userName, password);
            Statement data = connection.createStatement();
            ResultSet resultSet = data.executeQuery(" select * from deliveries");


            while (resultSet.next()) {
                Deliveries delivery = new Deliveries();

                delivery.setMatchId(resultSet.getInt(MATCH_ID));
                delivery.setInning(resultSet.getInt(INNING));
                delivery.setBattingTeam(resultSet.getString(BATTING_TEAM));
                delivery.setBowlingTeam(resultSet.getString(BOWLING_TEAM));
                delivery.setOver(resultSet.getInt(OVER));
                delivery.setBall(resultSet.getInt(BALL));
                delivery.setBatsman(resultSet.getString(BATSMAN));
                delivery.setNonStriker(resultSet.getString(NON_STRIKER));
                delivery.setBowler(resultSet.getString(BOWLER));
                delivery.setIsSuperOver(resultSet.getInt(IS_SUPER_OVER));
                delivery.setWideRuns(resultSet.getInt(WIDE_RUNS));
                delivery.setByeRuns(resultSet.getInt(BYE_RUNS));
                delivery.setLegByRuns(resultSet.getInt(LEGBYE_RUNS));
                delivery.setNoBallRuns(resultSet.getInt(NOBALL_RUNS));
                delivery.setPenaltyRuns(resultSet.getInt(PENALTY_RUNS));
                delivery.setBatsmanRuns(resultSet.getInt(BATSMAN_RUNS));
                delivery.setExtraRuns(resultSet.getInt(EXTRA_RUNS));
                delivery.setTotalRuns(resultSet.getInt(TOTAL_RUNS));
                delivery.setPlayerDismissed(resultSet.getString(PLAYER_DISMISSED));
                delivery.setDismissalKind(resultSet.getString(DISMISSAL_KIND));
                delivery.setFielder(resultSet.getString(FIELDER));

                deliveries.add(delivery);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException occurred when getting Deliveries data");
        }

        return deliveries;
    }

    public static void findNumberOfMatchesPlayedPerYear(List<Matches> matches) throws Exception {
        Map<Integer, Integer> playedPerSeason = new HashMap<Integer, Integer>();

        for (Matches match : matches) {
            if (playedPerSeason.containsKey(match.getSeason())) {
                int count = playedPerSeason.get(match.getSeason());
                playedPerSeason.replace(match.getSeason(), ++count);
            } else {
                playedPerSeason.put(match.getSeason(), 1);
            }
        }
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println(playedPerSeason);
    }

    public static void findNumberOfMatchesWonByAllTeamsOverAllTheYears(List<Matches> matches) throws Exception {
        Map<String, Integer> matchesWon = new HashMap<String, Integer>();
        for (Matches match : matches) {
            if (matchesWon.containsKey(match.getWinner())) {
                int count = matchesWon.get(match.getWinner());
                matchesWon.replace(match.getWinner(), ++count);
            } else {
                matchesWon.put(match.getWinner(), 1);
            }
        }

        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println(matchesWon);
    }

    public static void findExtraRunsConcededPerTeamInSpecificYear(List<Matches> matches,
                                                                  List<Deliveries> deliveries) throws Exception {
        //System.out.print("Enter year for which you want to calculate extra runs :");
        int year = 2016;//new Scanner(System.in).nextInt();

        List<Integer> ids = new ArrayList<>();
        for (Matches match : matches) {
            if (match.getSeason() == year) {
                ids.add(match.getId());
            }
        }
        Map<String, Integer> mapExtraRun = new HashMap<String, Integer>();
        for (Deliveries delivery : deliveries) {
            if (ids.contains(delivery.getMatchId())) {
                if (mapExtraRun.containsKey(delivery.getBowlingTeam() + " Extra Runs ")) {
                    int extraRun = mapExtraRun.get(delivery.getBowlingTeam() + " Extra Runs ")
                            + delivery.getExtraRuns();
                    mapExtraRun.replace(delivery.getBowlingTeam() + " Extra Runs ", extraRun);
                } else {
                    mapExtraRun.put(delivery.getBowlingTeam() + " Extra Runs ", delivery.getExtraRuns());
                }
            }
        }
        System.out.println("3. For the year " + year + " get the extra runs conceded per team.");
        System.out.println(mapExtraRun);
    }

    public static void findTopEconomicalBowlersOfSpecificYear(List<Matches> matches,
                                                              List<Deliveries> deliveries) throws Exception {
        //System.out.print("Enter Year for which you want to find top economical bowler :");
        int year = 2015;//new Scanner(System.in).nextInt();

        Map<String, Double> numberOfOver = new HashMap<>();
        Map<String, Double> totalRun = new HashMap<>();
        List<Integer> ids = new ArrayList<>();

        for (Matches match : matches) {
            if (match.getSeason() == year) {
                ids.add(match.getId());
            }
        }
        for (Deliveries delivery : deliveries) {
            if (ids.contains(delivery.getMatchId())) {
                if (totalRun.containsKey(delivery.getBowler())) {
                    double runCount = totalRun.get(delivery.getBowler()) + delivery.getTotalRuns()
                            - (delivery.getByeRuns() + delivery.getLegByRuns());
                    totalRun.replace(delivery.getBowler(), runCount);

                    if (numberOfOver.containsKey(delivery.getBowler()) && delivery.getWideRuns() == 0
                            && delivery.getNoBallRuns() == 0) {
                        double countBall = numberOfOver.get(delivery.getBowler());
                        numberOfOver.replace(delivery.getBowler(), ++countBall);
                    }
                } else {
                    numberOfOver.put(delivery.getBowler(), 1.0);
                    totalRun.put(delivery.getBowler(), (double) delivery.getTotalRuns());

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
            public int compare(Map.Entry<String, Double> stringDoubleEntry1,
                               Map.Entry<String, Double> stringDoubleEntry2) {
                if (stringDoubleEntry1.getValue() > stringDoubleEntry2.getValue()) {
                    return 1;
                } else if (stringDoubleEntry1.getValue() == stringDoubleEntry2.getValue()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };

        Collections.sort(topEconoyBowler, myComp);

        System.out.println("4. For the year " + year + " get the top economical bowlers.");
        System.out.println(topEconoyBowler);
    }

    public static void findStrikeRateOfEveryPlayer(List<Deliveries> deliveries) throws Exception {
        Map<String, Integer> ballFaced = new HashMap<>();
        Map<String, Double> totalRun = new HashMap<>();
        Map<String, Double> strikeRate = new HashMap<>();

        for (Deliveries delivery : deliveries) {
            if (ballFaced.containsKey(delivery.getBatsman())) {
                Double total = totalRun.get(delivery.getBatsman()) + delivery.getTotalRuns();
                totalRun.replace(delivery.getBatsman(), total);

                int ballCount = ballFaced.get(delivery.getBatsman());
                ballFaced.replace(delivery.getBatsman(), ++ballCount);

            } else {
                ballFaced.put(delivery.getBatsman(), 1);
                totalRun.put(delivery.getBatsman(), (double) delivery.getTotalRuns());
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

        System.out.println("5. Strike rate of all player in IPL");
        System.out.println(sortedStrikRate);
    }

    /*
    this function is same as the followed function

     public static List<Map.Entry<String, Integer>> mostWicketTakenBowler(List<Deliveries> deliveries, List<Matches> matches)
           {

           Map<Integer, List<Integer>> listOfIdOfEachYears = getIdsOfEachYear(matches);
           List<Map.Entry<String, Integer>> listOfEachBowlerMostWicketTakenInEachSeason = new ArrayList<>();

           for (Integer key: listOfIdOfEachYears.keySet())
           {
               List<Integer> list = listOfIdOfEachYears.get(key);
               listOfEachBowlerMostWicketTakenInEachSeason.add(getWicketTakenListOfEachPlayer(list, deliveries));
           }

           return listOfEachBowlerMostWicketTakenInEachSeason;
       }

     */
    public static void getMostWicketTakenPlayerOfEachSeason(List<Matches> matches,
                                                            List<Deliveries> deliveries) throws Exception {

        Map<Integer, List<Integer>> idsOfEachYears = getIdsOfEachYear(matches);
        List<String> mostWicketTakenBowlerInEachSeason = new ArrayList<>();

        for (Integer key : idsOfEachYears.keySet()) {
            List<Integer> list = idsOfEachYears.get(key);
            Map.Entry<String, Integer> dataOfMap = findMostWicketTakenPlayerOfSeason(list, deliveries);
            String yearNameWicketTaken = key + " = " + dataOfMap.getKey() + " " + dataOfMap.getValue();
            mostWicketTakenBowlerInEachSeason.add(yearNameWicketTaken);

        }

        System.out.println("6. Most wicket taken player of each season ");
        System.out.println(mostWicketTakenBowlerInEachSeason);
    }

    public static Map.Entry<String, Integer> findMostWicketTakenPlayerOfSeason(
            List<Integer> listOfIds, List<Deliveries> deliveries) throws Exception {
        Map<String, Integer> wicketTaken = new HashMap<>();
        for (Deliveries delivery : deliveries) {
            if (listOfIds.contains(delivery.getMatchId())) {
                if (!delivery.getDismissalKind().equals("")) {
                    if (wicketTaken.containsKey(delivery.getBowler())) {
                        int wicketTakenCounter = wicketTaken.get(delivery.getBowler());
                        wicketTaken.replace(delivery.getBowler(), ++wicketTakenCounter);
                    } else {
                        wicketTaken.put(delivery.getBowler(), 1);
                    }
                }
            }
        }

        return sortMap(wicketTaken).get(0);
    }

    public static Map<Integer, List<Integer>> getIdsOfEachYear(List<Matches> matches) throws Exception {
        Map<Integer, List<Integer>> ids = new HashMap<>();
        for (Matches match : matches) {
            if (ids.containsKey(match.getSeason())) {
                ids.get(match.getSeason()).add(match.getId());
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(match.getId());
                ids.put(match.getSeason(), l);
            }
        }
        return ids;
    }

    public static List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> map) throws Exception {
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
