package com.ottman.javaspringdemo.logFeature;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.UUID;

/**
 * A model of a fictitious type of log.
 */
public class Log {

    public LocalDateTime timestamp;
    public String logType;
    public UUID id = UUID.randomUUID();

    public Log(String logType) {
        this.logType = logType;
        this.timestamp = generateRandomDateThisYear();
    }

    /**
     * Generates a random {@link LocalDateTime} this year.
     * @return Random {@link LocalDateTime}
     */
    private LocalDateTime generateRandomDateThisYear() {
        int currentYear = LocalDate.now().getYear();

        long minEpoch = LocalDateTime.of(currentYear, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);
        // The upper bound for random is exclusive, so use 1/1 of the next year rather than 12/31 of current year
        long maxEpoch = LocalDateTime.of(currentYear + 1, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);

        var random = new Random();
        long randomEpoch = random.nextLong(minEpoch, maxEpoch);

        return LocalDateTime.ofEpochSecond(randomEpoch, 0, ZoneOffset.UTC);
    }
}