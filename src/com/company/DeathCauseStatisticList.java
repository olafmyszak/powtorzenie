package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> deathCauseStatisticList = new ArrayList<>();

    public DeathCauseStatistic get(int index) {
        return deathCauseStatisticList.get(index);
    }

    public void repopulate(String path) {
        deathCauseStatisticList.clear();

        try (Stream<String> stream = Files.lines(Path.of(path))) {
            stream
                    .skip(2)
                    .map(DeathCauseStatistic::fromCsvLine)
                    .forEach(statistic -> deathCauseStatisticList.add(statistic));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(long age, int n){
        if(n > (long) deathCauseStatisticList.size())
        {
            System.out.println("gowno he he");
            throw new IndexOutOfBoundsException();
        }

        List<DeathCauseStatistic> result = new ArrayList<>(n);

        return result;
    }
}

