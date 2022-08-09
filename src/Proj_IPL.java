import javax.sound.midi.Soundbank;
import java.util.*;
import java.io.*;

public class Proj_IPL {
    public static void main(String[] args) throws Exception {

        BufferedReader br;
//===================================Read Matches.csv=======================================================================
        br = new BufferedReader(new FileReader("matches.csv"));
        String lineMatches = br.readLine();//For skip first line.
        // Listing start of Match
        List<Matches> matchesList = new ArrayList<Matches>();
        while ((lineMatches = br.readLine()) != null) {
            Matches m = new Matches(lineMatches);
            matchesList.add(m);
        }
//=====================================Read Delivery.csv====================================================================
        br = new BufferedReader(new FileReader("deliveries.csv"));
        String lineDelivery = br.readLine();//For skip first line.
        //Listing Delivery;
        List<Delivery> deliveryList = new ArrayList<Delivery>();

        while ((lineDelivery = br.readLine()) != null) {

            Delivery temp = new Delivery(lineDelivery);
            deliveryList.add(temp);
        }
//==========================================================================================================================
        Solution1 sol1 = new Solution1();
        System.out.println("Number of matches played per year of all the years in IPL.");
        System.out.println(sol1.numberOfMatchPlayedPerYear(matchesList));
//==========================================================================================================================
        Solution2 sol2 = new Solution2();
        System.out.println("Number of matches won of all teams over all the years of IPL.");
        System.out.println(sol2.numberOfMatchesWon(matchesList));
//==========================================================================================================================
        Solution3 sol3 = new Solution3();
        System.out.println("For the year 2016 get the extra runs conceded per team.");
        System.out.println(sol3.countExtraRuns(deliveryList,matchesList));
//==========================================================================================================================

        br.close();
    }
}
class Matches {
    private int id;
    private int season;
    private int dl_applied;
    private int win_by_runs;
    private int win_by_wickets;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String toss_winner;
    private String toss_decision;
    private String result;
    private String winner;
    private String player_of_match;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;

    Matches(String s) {
        String[] st = s.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        String[] str = new String[18];

        //coping values to the larger string
        for (int i = 0; i < st.length; i++) {
            str[i] = st[i];
        }

        id = Integer.parseInt(str[0]);
        season = Integer.parseInt(str[1]);
        city = str[2];
        date = str[3];
        team1 = str[4];
        team2 = str[5];
        toss_winner = str[6];
        toss_decision = str[7];
        result = str[8];
        dl_applied = Integer.parseInt(str[9]);
        winner = str[10];
        win_by_runs = Integer.parseInt(str[11]);
        win_by_wickets = Integer.parseInt(str[12]);
        player_of_match = str[13];
        venue = str[14];
        umpire1 = str[15];
        umpire2 = str[16];
        umpire3 = str[17];

    }

    public int getId() {
        return id;
    }

    public int getSeason() {
        return season;
    }

    public int getDl_applied() {
        return dl_applied;
    }

    public int getWin_by_runs() {
        return win_by_runs;
    }

    public int getWin_by_wickets() {
        return win_by_wickets;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }
    public String getToss_winner() {
        return toss_winner;
    }

    public String getToss_decision() {
        return toss_decision;
    }

    public String getResult() {
        return result;
    }

    public String getWinner() {
        return winner;
    }

    public String getPlayer_of_match() {
        return player_of_match;
    }

    public String getVenue() {
        return venue;
    }

    public String getUmpire1() {
        return umpire1;
        }

    public String getUmpire2() {
        return umpire2;
    }

    public String getUmpire3() {
        return umpire3;
    }


    @Override
    public String toString() {
        return (id + " " + season + " " + city + " " + date + " " + team1 + " " + team2 + " " + toss_winner + " " + toss_decision + " " + result + " " + dl_applied + " " + winner + " " + win_by_runs + " " + win_by_wickets + " " + player_of_match + " " + venue + " " + umpire1 + " " + umpire2 + " " + umpire3);
    }
}
class Delivery {
    private int match_id;
    private int inning;
    private String batting_team;
    private String bowling_team;
    private int over;
    private int ball;
    private String batsman;
    private String non_striker;
    private String bowler;
    private int is_super_over;
    private int wide_runs;
    private int bye_runs;
    private int legbye_runs;
    private int noball_runs;
    private int penalty_runs;
    private int batsman_runs;
    private int extra_runs;
    private int total_runs;
    private String player_dismissed;
    private String dismissal_kind;
    private String fielder;

    //Constructor
    Delivery(String s) {
        String[] st = s.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

        String[] str = new String[21];
        for (int i = 0; i < st.length; i++) {
            str[i] = st[i];
        }
//intializing data
        match_id = Integer.parseInt(str[0]);
        inning = Integer.parseInt(str[1]);
        batting_team = str[2];
        bowling_team = str[3];
        over = Integer.parseInt(str[4]);
        ball = Integer.parseInt(str[5]);
        batsman = str[6];
        non_striker = str[7];
        bowler = str[8];
        is_super_over = Integer.parseInt(str[9]);
        wide_runs = Integer.parseInt(str[10]);
        bye_runs = Integer.parseInt(str[11]);
        legbye_runs = Integer.parseInt(str[12]);
        noball_runs = Integer.parseInt(str[13]);
        penalty_runs = Integer.parseInt(str[14]);
        batsman_runs = Integer.parseInt(str[15]);
        extra_runs = Integer.parseInt(str[16]);
        total_runs = Integer.parseInt(str[17]);
        player_dismissed = str[18];
        dismissal_kind = str[19];
        fielder = str[20];
    }

    public int getMatch_id()
    {
        return match_id;
    }

    public int getInning() {
        return inning;
    }

    public String getBatting_team() {
        return batting_team;
    }

    public String getBowling_team() {
        return bowling_team;
    }

    public int getOver() {
        return over;
    }

    public int getBall() {
        return ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public String getNon_striker() {
        return non_striker;
    }

    public String getBowler() {
        return bowler;
    }

    public int getIs_super_over() {
        return is_super_over;
    }

    public int getWide_runs() {
        return wide_runs;
    }

    public int getBye_runs() {
        return bye_runs;
    }

    public int getLegbye_runs() {
        return legbye_runs;
    }

    public int getNoball_runs() {
        return noball_runs;
    }

    public int getPenalty_runs() {
        return penalty_runs;
    }

    public int getBatsman_runs() {
        return batsman_runs;
    }

    public int getExtra_runs() {
        return extra_runs;
    }

    public int getTotal_runs() {
        return total_runs;
    }

    public String getPlayer_dismissed() {
        return player_dismissed;
    }

    public String getDismissal_kind() {
        return dismissal_kind;
    }

    public String getFielder() {
        return fielder;
    }
}
class Solution1 {
    public Map<Integer, Integer> numberOfMatchPlayedPerYear(List<Matches> m)
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
class Solution2 {
    public Map<String , Integer> numberOfMatchesWon(List<Matches> m)
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
class Solution3{
    Map<String, Integer> map = new HashMap<String, Integer>();


    public Map<String, Integer> countExtraRuns(List<Delivery> d, List<Matches> m)
    {
        List<Integer> ids = matchIdsOf16(m);
        Map<String, Integer> map = new HashMap<String,Integer>();
        for(Delivery dl : d)
        {
            if(ids.contains(dl.getMatch_id()))
            {
                if(map.containsKey("2016 "+dl.getBatting_team() +" Extra Runs "))
                {
                    int extraRun = map.get("2016 "+dl.getBatting_team() +" Extra Runs ");
                    map.replace("2016 "+dl.getBatting_team() +" Extra Runs ",(extraRun + dl.getExtra_runs()));
                }else {
                    map.put("2016 "+dl.getBatting_team() +" Extra Runs ", dl.getExtra_runs());
                }
            }
        }
        return map;

    }
    private List<Integer> matchIdsOf16(List<Matches> m)
    {
        List<Integer> ids = new ArrayList<Integer>();
        for(Matches ms : m)
        {
            if(ms.getSeason() == 2016)
            {
                ids.add(ms.getId());
            }
        }
        return ids;
    }
}
/*
1.Very interesting project.
2.Enjoying!!!!!!!!
3.Learned new Searching Techniques.[157-165]**
*/