# Project_IPL by MySQL;
IPL project with given data set

**Command for select Database**
> use IPLDataSet;

**1. Number of matches played per year of all the years in IPL.**
```
-- Problem 1 solution --
SELECT 
    season, COUNT(*) AS 'Number of Matches Per Season'
FROM
    matches
GROUP BY season
ORDER BY season;
```
**2. Number of matches won of all teams over all the years of IPL.**
```
-- Problem 2 solution --
SELECT 
    winner, COUNT(*) AS 'Number of time win'
FROM
    matches
GROUP BY winner
ORDER BY COUNT(*);
```
**3. For the year 2016 get the extra runs conceded per team.**
```
-- Problem 3 solution --
SELECT 
    bowling_team,
    SUM(extra_runs) AS 'Extra Runs Conseed Per Team'
FROM
    deliveries
WHERE
    match_id IN (SELECT 
            id
        FROM
            matches
        WHERE
            season = 2016)
GROUP BY bowling_team
ORDER BY SUM(extra_runs);
```
**4. For the year 2015 get the top economical bowlers.**
```
-- Problem 4 solution --
SELECT 
    bowler,
    (SUM(total_runs) * 6 / COUNT(CASE WHEN (noball_runs = 0 AND wide_runs = 0) 
                                      THEN 1 
                                      ELSE NULL
                                      END)) 
AS EconomyRate
FROM
    deliveries
WHERE
    match_id IN (SELECT 
                      id
                  FROM
                      matches
                  WHERE
                      season = '2015')
GROUP BY bowler
ORDER BY EconomyRate;
```
**5. Create your own scenario.**
```
-- Problem 5  My scenario 
SELECT 
    batsman,
    (SUM(total_runs) / COUNT(batsman) * 100) AS strikeRate
FROM
    deliveries
WHERE
    match_id IN (SELECT 
                      id
                FROM
                      matches
                WHERE
                      season = 2016)
GROUP BY batsman
ORDER BY strikeRate DESC;
```

**6. Create your own scenario**
```
-- Number of times looses every team in all seasons --
SELECT 
    team1, c1+c2 as 'Number of times loos'
FROM
    (SELECT 
        team1,
            COUNT(CASE
                WHEN team1 != winner THEN 1
                ELSE NULL
            END) as c1
    FROM
        matches
    GROUP BY team1) as s1 inner join ( SELECT 
        team2,
            COUNT(CASE
                WHEN team2 != winner THEN 1
                ELSE NULL
            END) as c2
    FROM
        matches
    GROUP BY team2 ) as s2 on s1.team1 = s2.team2;
```
