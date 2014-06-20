package dataserializable;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.nio.serialization.SerializationService;
import com.hazelcast.nio.serialization.SerializationServiceBuilder;
import java.util.Date;
import java.util.Arrays;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 19.06.2014.
 */

public class test {

    public static void main( String[] args ){
        Benchmark b = new Benchmark();
        System.out.println("1000 set:"+ b.getWritePerformance()+"ms");
        System.out.println("1000 get:"+ b.getReadPerformance()+"ms");
        System.out.println("Average size:"+ b.getAverageSize()+"bytes");


    }

}