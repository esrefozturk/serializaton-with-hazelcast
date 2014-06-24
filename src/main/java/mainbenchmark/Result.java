package mainbenchmark;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 23.06.2014.
 */

public class Result {
    public String name;
    public double writePerformance,readPerformance,averageSize;

    public Result( String name , double writePerformance , double readPerformance , double averageSize ){
        this.name = name;
        this.writePerformance = writePerformance;
        this.readPerformance = readPerformance;
        this.averageSize = averageSize;
    }


}
