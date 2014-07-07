package com.hazelcast.dataserializable;

import com.hazelcast.mainbenchmark.AbstractBenchmark;
import com.hazelcast.mainbenchmark.MainBenchmark;

import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 07.07.2014.
 */

public class DataSerializableBenchmark extends AbstractBenchmark {
    public DataSerializableBenchmark(){
        super("dataserializable",null);
    }
    public double getWritePerformance(){
        start = System.currentTimeMillis();
        for(int i=0;i< MainBenchmark.TEST_CASE_COUNT;i++){
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new DataSerializableCustomer( "name_" + newRandom , new Date( newRandom ) ,
                    (newRandom%2==0)?DataSerializableCustomer.Sex.MALE:DataSerializableCustomer.Sex.FEMALE ,
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
            customer = new DataSerializableCustomer( "name_" + newRandom , new Date( newRandom ) ,
                    (newRandom%2==0)?DataSerializableCustomer.Sex.MALE:DataSerializableCustomer.Sex.FEMALE ,
                    "email_" + newRandom , new long[newRandom] );
            totalSize += serializationService.toData(customer).bufferSize();
        }
        return totalSize/MainBenchmark.TEST_CASE_COUNT;
    }
}
