<h1>ABOUT</h1>
This project is prepared to serve as a sample application for Hazelcast, the leading open source in-memory data grid . Here, Hazelcast's use case is Custom Serialization.

<h2>Prerequisites</h2>
You should have installed Apache Maven(http://maven.apache.org/download.cgi) on your system.

<h2>How to Run Sample Application</h2>

1) clone the repository to your local using the following command:
```
git clone https://github.com/hazelcastInternsSummer14/customSerialization.git
```
2) go to customSerialization folder

3) run the code: 
```
mvn compile
```

4) run the code:
```
mvn exec:java -Dexec.mainClass="mainbenchmark.MainBenchmark"
```
