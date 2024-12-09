package com.ottman.javaspringdemo.logFeature;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for endpoints related to ficticious logs.
 */
@RestController
@RequestMapping(path = "/logs")
public class LogController {
    private int DEFAULT_LOGS_SIZE = 10000;

    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    /**
     * Gets all ficticious logs.
     * @param logSize Size of each collection of logs to get. Total number of logs is this * number of different log types.
     * @implNote Since there is not real system to get logs for, the logs are randomly generated for each request.
     * @return
     */
    @GetMapping("/getall")
    public List<Log> GetAllLogs(@RequestParam(name = "logsSize", required = false) Integer logsSize) {
        return this.logService.GetAllLogs(logsSize != null ? logsSize.intValue() : DEFAULT_LOGS_SIZE);
    }
}
