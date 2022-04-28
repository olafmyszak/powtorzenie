package com.company;

public class Main {
    public static void main(String[] args) {
        DeathCauseStatistic statistic =  DeathCauseStatistic.fromCsvLine("Y86            ,223,1,1,-,5,8,10,20,33,34,30,22,28,8,4,2,5,3,5,3,1");
        System.out.println(statistic.getICD10_code());

        DeathCauseStatistic.AgeBracketDeaths ageBracketDeaths = statistic.ageBracketDeaths(18);

        System.out.println(ageBracketDeaths.getYoung());
        System.out.println(ageBracketDeaths.getOld());
        System.out.println(ageBracketDeaths.getDeathCount());
    }
}