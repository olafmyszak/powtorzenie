package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DeathCauseStatistic {
    private String ICD10_code;
    private int[] nr_of_deaths;

    public DeathCauseStatistic(String ICD10_code, int[] nr_of_deaths) {
        this.ICD10_code = ICD10_code;
        this.nr_of_deaths = nr_of_deaths;
    }

    public static DeathCauseStatistic fromCsvLine(String line) {
        String code;
        int[] nr_of_deaths = new int[20];

        StringTokenizer tokenizer = new StringTokenizer(line, ",");

        code = tokenizer.nextToken().trim();

        tokenizer.nextToken();

        int counter = 0;
        while (tokenizer.hasMoreTokens()){
            String nr = tokenizer.nextToken();

            if(!nr.equals("-")){
                nr_of_deaths[counter] = Integer.parseInt(nr);
            }

            ++counter;
        }

        return new DeathCauseStatistic(code, nr_of_deaths);
    }

    public String getICD10_code() {
        return ICD10_code;
    }

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }

        public int getYoung() {
            return young;
        }

        public int getOld() {
            return old;
        }

        public int getDeathCount() {
            return deathCount;
        }
    }

    public AgeBracketDeaths ageBracketDeaths(int age){
       return new AgeBracketDeaths(age/5*5, age/5*5+4, nr_of_deaths[age/5]);
    }
}
