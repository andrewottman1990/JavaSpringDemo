package com.ottman.javaspringdemo.logFeature;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/logs")
public class LogController {
    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/getall")
    public List<Log> GetAllLogs() {
        return this.logService.GetAllLogs();
    }
}
