package com.hazelcast.serializable;

import com.hazelcast.bytearrayserializer.ByteArraySerializerCustomer;
import com.hazelcast.bytearrayserializer.CustomerByteArraySerializer;
import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.mainbenchmark.AbstractBenchmark;
import com.hazelcast.mainbenchmark.AbstractCustomer;
import com.hazelcast.mainbenchmark.MainBenchmark;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 06.07.2014.
 */

public class SerializableBenchmark extends AbstractBenchmark {
    public SerializableBenchmark() {
        super( new Config("serializable") );
    }

    public double getWritePerformance(){
        start = System.currentTimeMillis();
        for(int i=0;i<MainBenchmark.TEST_CASE_COUNT;i++){
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new SerializableCustomer( "name_" + newRandom , new Date( newRandom ) ,
                    (newRandom%2==0)? AbstractCustomer.Sex.MALE:AbstractCustomer.Sex.FEMALE ,
                    "email_" + newRandom , new long[newRandom] );
            customerMap.set( newRandom , customer );
        }
        end = System.currentTimeMillis();
        return end-start;
    }

    public double getAverageSize(){
        totalSize = 0;
        for(int i=0;i<MainBenchmark.TEST_CASE_COUNT;i++){
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new SerializableCustomer( "name_" + newRandom , new Date( newRandom ) ,
                    (newRandom%2==0)?AbstractCustomer.Sex.MALE:AbstractCustomer.Sex.FEMALE ,
                    "email_" + newRandom , new long[newRandom] );
            totalSize += serializationService.toData(customer).bufferSize();
        }
        return totalSize/MainBenchmark.TEST_CASE_COUNT;
    }
}
