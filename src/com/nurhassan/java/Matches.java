package com.nurhassan.java;

public class Matches {

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

    public void setId(int id) {
        this.id = id;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setDl_applied(int dl_applied) {
        this.dl_applied = dl_applied;
    }

    public void setWin_by_runs(int win_by_runs) {
        this.win_by_runs = win_by_runs;
    }

    public void setWin_by_wickets(int win_by_wickets) {
        this.win_by_wickets = win_by_wickets;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setToss_winner(String toss_winner) {
        this.toss_winner = toss_winner;
    }

    public void setToss_decision(String toss_decision) {
        this.toss_decision = toss_decision;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setPlayer_of_match(String player_of_match) {
        this.player_of_match = player_of_match;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }

    public void setUmpire3(String umpire3) {
        this.umpire3 = umpire3;
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
        return id + " " +venue + umpire1 +" " + umpire2 +"\n";
    }
}
