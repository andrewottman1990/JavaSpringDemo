# Log Feature

This is a feature which gets a ficticious set of logs from a ficticious system.

This is based off a real ASP.NET C# project I created a backend service designed for customer support activities to retrieve 9 different types of user logs from a database and present them in a consistent format, ordered by date and fully human-readable. Using concurrency, efficient Couchbase SQL++ queries, and effective use of indexes, it collected and processed hundreds of thousands of logs in seconds.

To demonstrate transferring my skills to Java, I am recreating this in Java (but with log generation instead of a real database) to show use of asynchronous/concurrent processing using CompletableFuture.