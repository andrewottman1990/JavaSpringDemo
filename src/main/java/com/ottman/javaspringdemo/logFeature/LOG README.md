# Log Feature

This is a feature which gets a ficticious set of logs from a ficticious system.

This is based off a real ASP.NET C# project I created a backend service designed for customer support activities to retrieve 9 different types of user logs from a database and present them in a consistent format, ordered by date and fully human-readable. Using concurrency, efficient Couchbase SQL++ queries, and effective use of indexes, it collected and processed hundreds of thousands of logs in seconds.

To demonstrate transferring my skills to Java, I am recreating some aspects of this in Java (but with log generation instead of a real database) to show use of asynchronous/concurrent processing using CompletableFuture. This code concurrently generates 5 sets of logs, each set of a different log type, joins them into a single data set, and sorts it.

The primary code demonstration is in LogService.java. The endpont can be reached with a GET request to http://localhost:8080/logs/getall. There is an optional API parameter "logsSize" which determines the size of each set of logs (so the total data set size is logsSize * 5).
