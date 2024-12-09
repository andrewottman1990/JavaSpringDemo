package com.ottman.javaspringdemo.logFeature;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

/**
 * A fictitious repository of logs.
 */
@Repository
public class LogRepository {
    /**
     * Get a number of {@link Log}s of a given type.
     * @implNote This doesn't get any actual logs, we're just pretending. Instead, it generates log objects with timestamps randomized within this year.
     * @param logType
     * @param numberOfLogs
     * @return An {@link ArrayList} of logs of the given type and of the given amount.
     */
    public ArrayList<Log> GetLogsByType(String logType, int numberOfLogs) {
        var watch = new StopWatch();
        watch.start();

        System.out.println("GetLogsByType start " + logType);

        ArrayList<Log> logList = new ArrayList<Log>(numberOfLogs);

        Log log;
        for (int i = 0; i < numberOfLogs; i++) {
            log = new Log(logType);
            logList.add(log);
        }

        watch.stop();
        System.out.println("GetLogsByType " + logType + ": " + watch.getTotalTimeSeconds());

        return logList;
    }
}