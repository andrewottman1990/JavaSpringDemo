package com.ottman.javaspringdemo.logFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * Service for interacting with logs from a ficticious system
 */
@Service
public class LogService {
    private int NUMBER_LOGS_EACH = 10000;

    private List<String> logTypes = Arrays.asList("bleLog", "deviceLog", "networkLog", "authLog", "eventLog");
    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    /**
     * Get all logs from the ficticious system
     * @return List of all {@link Log}s
     */
    public List<Log> GetAllLogs() {
        var functionLogs = new StopWatch();
        functionLogs.start();
        
        ArrayList<CompletableFuture<ArrayList<Log>>> futures = new ArrayList<CompletableFuture<ArrayList<Log>>>(logTypes.size());
        List<Log> allLogs = new ArrayList<Log>();
        
        for (String logTypeString : logTypes) {
            var logArrayFuture = CompletableFuture.supplyAsync(() -> logRepository.GetLogsByType(logTypeString, NUMBER_LOGS_EACH));
            logArrayFuture.thenApply(logs -> allLogs.addAll(logs));

            futures.add(logArrayFuture);
        }

        var allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        functionLogs.stop();
        System.out.println("GetAllLogs: " + functionLogs.getTotalTimeSeconds());

        return allLogs;
    }
}
