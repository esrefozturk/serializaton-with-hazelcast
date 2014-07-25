package com.hazelcast.identifieddataserializable;

import com.hazelcast.config.*;
import java.util.Date;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.mainbenchmark.AbstractBenchmark;
import com.hazelcast.mainbenchmark.MainBenchmark;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 23.06.2014.
 */

public class IdentifiedDataSerializableBenchmark extends AbstractBenchmark
{
    public IdentifiedDataSerializableBenchmark(){
        super(new Config("identifieddataserializable").setSerializationConfig(new SerializationConfig().addDataSerializableFactory(1, new IdentifiedDataSerializableCustomerFactory())));
    }

    public double getWritePerformance()
    {
        start = System.currentTimeMillis();

        for(int i = 0; i < MainBenchmark.TEST_CASE_COUNT; i++)
        {
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new IdentifiedDataSerializableCustomer("MyNameIs" + newRandom, new Date(newRandom), ((newRandom % 2) == 0) ? IdentifiedDataSerializableCustomer.Sex.MALE : IdentifiedDataSerializableCustomer.Sex.FEMALE, "MyEmailIs" + newRandom, new long[newRandom]);
            customerMap.set(newRandom, customer);
        }

        end = System.currentTimeMillis();
        return (end - start);
    }

    public double getAverageSize()
    {
        totalSize = 0;

        for(int i = 0; i < MainBenchmark.TEST_CASE_COUNT; i++)
        {
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new IdentifiedDataSerializableCustomer("MyNameIs" + newRandom, new Date(newRandom), ((newRandom % 2) == 0) ? IdentifiedDataSerializableCustomer.Sex.MALE : IdentifiedDataSerializableCustomer.Sex.FEMALE, "MyEmailIs" + newRandom, new long[newRandom]);
            totalSize += (serializationService.toData(customer).bufferSize());
        }

        return (totalSize / MainBenchmark.TEST_CASE_COUNT);
    }
}