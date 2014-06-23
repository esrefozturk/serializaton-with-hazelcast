package bytearrayserializer;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 19.06.2014.
 */

public class test {

    public static void main( String[] args ){
        Benchmark b = new Benchmark();
        System.out.println("1000 set: "+ b.getWritePerformance()+" ms");
        System.out.println("1000 get: "+ b.getReadPerformance()+" ms");
        System.out.println("Average size: "+ b.getAverageSize()+" bytes");


    }

}