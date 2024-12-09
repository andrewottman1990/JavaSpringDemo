package com.ottman.javaspringdemo.logFeature;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

/**
 * Service for interacting with logs from a ficticious system
 */
@Service
public class LogService {

    private List<String> logTypes = Arrays.asList("bleLog", "deviceLog", "networkLog", "authLog", "eventLog");
    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    /**
     * Get all logs from the ficticious system.
     * @return List of all {@link Log}s
     */
    public List<Log> GetAllLogs(int logsSize) {
        var startTime = System.currentTimeMillis();

        ArrayList<CompletableFuture<ArrayList<Log>>> futures = new ArrayList<CompletableFuture<ArrayList<Log>>>(logTypes.size());
        List<Log> allLogs = new ArrayList<Log>(logTypes.size() * logsSize);
        
        // For each type of ficticious log, we will create a CompletableFuture and asyncronously get logs.
        for (String logTypeString : logTypes) {
            var logArrayFuture = CompletableFuture.supplyAsync(() -> logRepository.GetLogsByType(logTypeString, logsSize));
            logArrayFuture.thenAccept(logs -> allLogs.addAll(logs));

            // Add this to our list of futures
            futures.add(logArrayFuture);
        }

        // Wait for all futures to complete
        var allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        var getLogsCompleteTime = System.currentTimeMillis();
        System.out.println("All GetLogs complete: " + (getLogsCompleteTime - startTime));

        // Sort logs by time descending
        // Potential enhancement: any way to speed this up?
        allLogs.sort(new LogSortTimeDescendingComparator());

        System.out.println("Sort logs: " + (System.currentTimeMillis() - getLogsCompleteTime));

        return allLogs;
    }
}
