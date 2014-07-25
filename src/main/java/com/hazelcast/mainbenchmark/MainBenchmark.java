package com.hazelcast.mainbenchmark;

import com.hazelcast.bytearrayserializer.ByteArraySerializerBenchmark;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.dataserializable.DataSerializableBenchmark;
import com.hazelcast.externalizable.ExternalizableBenchmark;
import com.hazelcast.identifieddataserializable.IdentifiedDataSerializableBenchmark;
import com.hazelcast.jacksonsmile.JacksonSmileBenchmark;
import com.hazelcast.kryo.KryoBenchmark;
import com.hazelcast.portable.PortableBenchmark;
import com.hazelcast.serializable.SerializableBenchmark;

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

        SerializableBenchmark serializableBenchmark = new SerializableBenchmark();
        results.add( new Result( new String("Serializable"),
                        serializableBenchmark.getWritePerformance(),
                        serializableBenchmark.getReadPerformance(),
                        serializableBenchmark.getAverageSize()
                )
        );
        Hazelcast.shutdownAll();

        DataSerializableBenchmark dataserializableBenchmark = new DataSerializableBenchmark();
        results.add( new Result( new String("DataSerializable"),
                        dataserializableBenchmark.getWritePerformance(),
                        dataserializableBenchmark.getReadPerformance(),
                        dataserializableBenchmark.getAverageSize()
                )
        );
        Hazelcast.shutdownAll();

        IdentifiedDataSerializableBenchmark identifiedDataSerializableBenchmark = new IdentifiedDataSerializableBenchmark();
        results.add( new Result( new String("IdentifiedDataSerializable"),
                        identifiedDataSerializableBenchmark.getWritePerformance(),
                        identifiedDataSerializableBenchmark.getReadPerformance(),
                        identifiedDataSerializableBenchmark.getAverageSize()
                )
        );
        Hazelcast.shutdownAll();

        ExternalizableBenchmark externalizableBenchmark = new ExternalizableBenchmark();
        results.add( new Result( new String("Externalizable"),
                        externalizableBenchmark.getWritePerformance(),
                        externalizableBenchmark.getReadPerformance(),
                        externalizableBenchmark.getAverageSize()
                )
        );
        Hazelcast.shutdownAll();

        PortableBenchmark portableBenchmark = new PortableBenchmark();
        results.add( new Result( new String("Portable"),
                        portableBenchmark.getWritePerformance(),
                        portableBenchmark.getReadPerformance(),
                        portableBenchmark.getAverageSize()
                )
        );
        Hazelcast.shutdownAll();

        KryoBenchmark kryoBenchmark = new KryoBenchmark();
        results.add( new Result( new String("Kryo"),
                        kryoBenchmark.getWritePerformance(),
                        kryoBenchmark.getReadPerformance(),
                        kryoBenchmark.getAverageSize()
                )
        );
        Hazelcast.shutdownAll();

        ByteArraySerializerBenchmark byteArraySerializerBenchmark = new ByteArraySerializerBenchmark();
        results.add( new Result( new String("ByteArraySerializer"),
                        byteArraySerializerBenchmark.getWritePerformance(),
                        byteArraySerializerBenchmark.getReadPerformance(),
                        byteArraySerializerBenchmark.getAverageSize()
                )
        );
        Hazelcast.shutdownAll();

        JacksonSmileBenchmark jacksonSmileBenchmark = new JacksonSmileBenchmark();
        results.add( new Result( new String("JacksonSmile"),
                        jacksonSmileBenchmark.getWritePerformance(),
                        jacksonSmileBenchmark.getReadPerformance(),
                        jacksonSmileBenchmark.getAverageSize()
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
