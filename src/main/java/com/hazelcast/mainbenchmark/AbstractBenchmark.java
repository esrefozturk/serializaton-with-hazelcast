package com.hazelcast.mainbenchmark;

import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.nio.serialization.SerializationService;
import com.hazelcast.nio.serialization.SerializationServiceBuilder;
import java.util.Random;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 06.07.2014.
 */

public abstract class AbstractBenchmark {
    public IMap<Integer, AbstractCustomer> customerMap;
    public Config config;
    public HazelcastInstance hazelcastInstance;
    public AbstractCustomer customer;
    public SerializationService serializationService;
    public SerializerConfig serializerConfig;
    public long totalSize;
    public Random random;
    public long start,end;
    public int newRandom;

    public AbstractBenchmark( String name , SerializerConfig serializerConfig  ){
        config = new Config();
        config.setGroupConfig(new GroupConfig(name));
        if( serializerConfig != null )
            config.getSerializationConfig().getSerializerConfigs().add( serializerConfig );
        hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        customerMap = hazelcastInstance.getMap("customers");
        serializationService = new SerializationServiceBuilder().setConfig(config.getSerializationConfig()).build();
        random = new Random();

    }

    public double getReadPerformance(){
        start = System.currentTimeMillis();
        for(int i=0;i< MainBenchmark.TEST_CASE_COUNT;i++){
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customerMap.get( newRandom );
        }
        end = System.currentTimeMillis();
        return end-start;
    }

    public abstract double getWritePerformance();

    public abstract double getAverageSize();

}
