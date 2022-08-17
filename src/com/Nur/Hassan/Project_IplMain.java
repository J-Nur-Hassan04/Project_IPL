package com.Nur.Hassan;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Project_IplMain {

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

    public static BufferedReader br;

    public static void main(String[] args) throws Exception {

        List<Matches> matchesList = getMatchesList();
        List<Deliveries> deliveriesList = getDeliveriesList();

        int choice;

        do {

            System.out.println("1. Number of matches played per year of all the years in IPL.");
            System.out.println("2. Number of matches won of all teams over all the years of IPL.");
            System.out.println("3. For the year 2016 get the extra runs conceded per team.");
            System.out.println("4. For the year 2015 get the top economical bowlers.");
            System.out.println("5. For strike rate of all player");
            System.out.println("6.For the name of the player who take most number of wicket ");
            System.out.print("Enter your choice : ");

            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 0:
                    System.out.println("\n\nExited!!!\n\n");
                    break;
                case 1:
                    printOutPutIntegerKey(new Solution1().numberOfMatchesPlayedPerYear(matchesList));
                    break;
                case 2:
                    printOutPutStringKey(new Solution2().numberOfMatchesWonOfAllTeamsOverAllTheYears(matchesList));
                    break;
                case 3:
                    printOutPutStringKey(new Solution3().extraRunsConcededPerTeam2016(deliveriesList, matchesList));
                    break;
                case 4:
                    printOutPutList(new Solution4().topEconomicalBowlersOf2015(matchesList, deliveriesList));
                    break;
                case 5:
                    printOutPutList(new MyScenrio().strikeRate(deliveriesList));
                    break;
                case 6:
                    System.out.println(new MyScenrio2().mostWicketTakenBowler(deliveriesList, matchesList));
                    break;
                default:
                    System.out.println("\n\nEnter a valid choice!!!!!!!!!!!!");
                    break;
            }

        } while (choice != 0);


    }

    private static void printOutPutList(List<Map.Entry<String, Double>> list) {
        for (Map.Entry<String, Double> map : list)
        {
            System.out.println(map);
        }
    }

    private static void printOutPutIntegerKey(Map<Integer, Integer> map) {
        for (Integer key : map.keySet())
        {
            System.out.println(key + " = "+ map.get(key));
        }
    }
    private static void printOutPutStringKey(Map<String, Integer> map)
    {
        for (String key : map.keySet())
        {
            System.out.println(key + " = "+ map.get(key));
        }
    }


    public static List<Matches> getMatchesList() throws Exception {
        br = new BufferedReader(new FileReader("matches.csv"));
        List<Matches> matchesList = new ArrayList<>();
        String matchesLine = br.readLine();//Skip the first line

        while ((matchesLine = br.readLine()) != null) {
            Matches m = new Matches();
                String[] stringArr = matchesLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                String[] arr = new String[18];
                for(int i=0; i<stringArr.length; i++)
                    arr[i] = stringArr[i];

                m.setId(Integer.parseInt(arr[ID]));
                m.setSeason(Integer.parseInt(arr[SEASON]));
                m.setCity(arr[CITY]);
                m.setDate(arr[DATE]);
                m.setTeam1(arr[TEAM1]);
                m.setTeam2(arr[TEAM2]);
                m.setToss_winner(arr[TOSS_WINNER]);
                m.setToss_decision(arr[TOSS_DECISION]);
                m.setResult(arr[RESULT]);
                m.setDl_applied(Integer.parseInt(arr[DL_APPLIED]));
                m.setWinner(arr[WINNER]);
                m.setWin_by_runs(Integer.parseInt(arr[WIN_BY_RUNS]));
                m.setWin_by_wickets(Integer.parseInt(arr[WIN_BY_WICKETS]));
                m.setPlayer_of_match(arr[PLAYER_OF_MATCH]);
                m.setVenue(arr[VENUE]);
                m.setUmpire1(arr[UMPIRE1]);
                m.setUmpire2(arr[UMPIRE2]);
                m.setUmpire3(arr[UMPIRE3]);


            matchesList.add(m);
        }
        br.close();
        return matchesList;
    }

    public static List<Deliveries> getDeliveriesList() throws Exception {
        br = new BufferedReader(new FileReader("deliveries.csv"));
        List<Deliveries> deliveryList = new ArrayList<>();
        String deliverisLine = br.readLine();//skip first line

        while ((deliverisLine = br.readLine()) != null) {
            Deliveries d = new Deliveries();

                String[] stringArr = deliverisLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                String[] arr = new String[21];
                for (int i=0; i< stringArr.length; i++)
                    arr[i] = stringArr[i];

                d.setMatch_id(Integer.parseInt(arr[MATCH_ID]));
                d.setInning(Integer.parseInt(arr[INNING]));
                d.setBatting_team(arr[BATTING_TEAM]);
                d.setBowling_team(arr[BOWLING_TEAM]);
                d.setOver(Integer.parseInt(arr[OVER]));
                d.setBall(Integer.parseInt(arr[BALL]));
                d.setBatsman(arr[BATSMAN]);
                d.setNon_striker(arr[NON_STRIKER]);
                d.setBowler(arr[BOWLER]);
                d.setIs_super_over(Integer.parseInt(arr[IS_SUPER_OVER]));
                d.setWide_runs(Integer.parseInt(arr[WIDE_RUNS]));
                d.setBye_runs(Integer.parseInt(arr[BYE_RUNS]));
                d.setLegbye_runs(Integer.parseInt(arr[LEGBYE_RUNS]));
                d.setNoball_runs(Integer.parseInt(arr[NOBALL_RUNS]));
                d.setPenalty_runs(Integer.parseInt(arr[PENALTY_RUNS]));
                d.setBatsman_runs(Integer.parseInt(arr[BATSMAN_RUNS]));
                d.setExtra_runs(Integer.parseInt(arr[EXTRA_RUNS]));
                d.setTotal_runs(Integer.parseInt(arr[TOTAL_RUNS]));
                d.setPlayer_dismissed(arr[PLAYER_DISMISSED]);
                d.setDismissal_kind(arr[DISMISSAL_KIND]);
                d.setFielder(arr[FIELDER]);

                deliveryList.add(d);


        }
        br.close();
        return deliveryList;
    }
}
