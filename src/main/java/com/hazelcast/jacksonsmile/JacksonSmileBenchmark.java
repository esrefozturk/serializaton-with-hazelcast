package com.hazelcast.jacksonsmile;

import com.hazelcast.bytearrayserializer.ByteArraySerializerCustomer;
import com.hazelcast.config.Config;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.kryo.CustomerKryoSerializer;
import com.hazelcast.mainbenchmark.AbstractBenchmark;
import com.hazelcast.mainbenchmark.MainBenchmark;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 07.07.2014.
 */
public class JacksonSmileBenchmark extends AbstractBenchmark {
    public JacksonSmileBenchmark(){
        super( new Config("jacksonsmile").setSerializationConfig(new SerializationConfig().setSerializerConfigs(
                new ArrayList<SerializerConfig>() {{
                    add(new SerializerConfig().setTypeClass(ByteArraySerializerCustomer.class).setImplementation(new CustomerJacksonSmileSerializer()));
                }}
        )) );
    }
    public double getWritePerformance(){
        start = System.currentTimeMillis();
        for(int i=0;i< MainBenchmark.TEST_CASE_COUNT;i++){
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new JacksonSmileCustomer( "name_" + newRandom , new Date( newRandom ) ,
                    (newRandom%2==0)?JacksonSmileCustomer.Sex.MALE:JacksonSmileCustomer.Sex.FEMALE ,
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
            customer = new JacksonSmileCustomer( "name_" + newRandom , new Date( newRandom ) ,
                    (newRandom%2==0)?JacksonSmileCustomer.Sex.MALE:JacksonSmileCustomer.Sex.FEMALE ,
                    "email_" + newRandom , new long[newRandom] );
            totalSize += serializationService.toData(customer).bufferSize();
        }
        return totalSize/MainBenchmark.TEST_CASE_COUNT;
    }
}