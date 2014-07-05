package com.hazelcast.mainbenchmark;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.serializable.Benchmark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 23.06.2014.
 */

public class MainBenchmark {

    public static int TEST_CASE_COUNT=1000;
    public static int MAX_RANDOM = 100;
    public static List<Result> results;


    public static void main(String[] args){

        results = new ArrayList<Result>();

        Benchmark serializableBenchmark = new Benchmark();
        results.add( new Result( new String("Serializable"),
                        serializableBenchmark.getWritePerformance(),
                        serializableBenchmark.getReadPerformance(),
                        serializableBenchmark.getAverageSize()
                )
        );

        com.hazelcast.dataserializable.Benchmark dataserializableBenchmark = new com.hazelcast.dataserializable.Benchmark();
        results.add( new Result( new String("DataSerializable"),
                        dataserializableBenchmark.getWritePerformance(),
                        dataserializableBenchmark.getReadPerformance(),
                        dataserializableBenchmark.getAverageSize()
                )
        );

        com.hazelcast.identifieddataserializable.Benchmark identifiedDataSerializableBenchmark = new com.hazelcast.identifieddataserializable.Benchmark();
        results.add( new Result( new String("IdentifiedDataSerializable"),
                        identifiedDataSerializableBenchmark.getWritePerformance(),
                        identifiedDataSerializableBenchmark.getReadPerformance(),
                        identifiedDataSerializableBenchmark.getAverageSize()
                )
        );

        com.hazelcast.externalizable.Benchmark externalizableBenchmark = new com.hazelcast.externalizable.Benchmark();
        results.add( new Result( new String("Externalizable"),
                        externalizableBenchmark.getWritePerformance(),
                        externalizableBenchmark.getReadPerformance(),
                        externalizableBenchmark.getAverageSize()
                )
        );

        com.hazelcast.portable.Benchmark portableBenchmark = new com.hazelcast.portable.Benchmark();
        results.add( new Result( new String("Portable"),
                        portableBenchmark.getWritePerformance(),
                        portableBenchmark.getReadPerformance(),
                        portableBenchmark.getAverageSize()
                )
        );

        com.hazelcast.kryo.Benchmark kryoBenchmark = new com.hazelcast.kryo.Benchmark();
        results.add( new Result( new String("Kryo"),
                        kryoBenchmark.getWritePerformance(),
                        kryoBenchmark.getReadPerformance(),
                        kryoBenchmark.getAverageSize()
                )
        );

        com.hazelcast.bytearrayserializer.Benchmark byteArraySerializerBenchmark = new com.hazelcast.bytearrayserializer.Benchmark();
        results.add( new Result( new String("ByteArraySerializer"),
                        byteArraySerializerBenchmark.getWritePerformance(),
                        byteArraySerializerBenchmark.getReadPerformance(),
                        byteArraySerializerBenchmark.getAverageSize()
                )
        );

        Hazelcast.shutdownAll();

        System.out.println("\n----------------------  RESULTS  -----------------------\n");
        for(int i=0;i<results.size();i++){
            System.out.println( results.get(i).name + ":" );
            System.out.println( "\t\t\t\t\t\t\t\tWrite Performance : " + results.get(i).writePerformance + " ms" );
            System.out.println( "\t\t\t\t\t\t\t\tRead Performance  : " + results.get(i).readPerformance + " ms" );
            System.out.println( "\t\t\t\t\t\t\t\tAverage Size      : " + results.get(i).averageSize + " bytes\n" );

        }


    }
}
