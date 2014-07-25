package com.hazelcast.portable;

import com.hazelcast.mainbenchmark.AbstractBenchmark;
import com.hazelcast.config.*;
import java.util.Date;
import com.hazelcast.mainbenchmark.MainBenchmark;
import com.hazelcast.nio.serialization.ClassDefinitionBuilder;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 23.06.2014.
 */

public class PortableBenchmark extends AbstractBenchmark
{

    public PortableBenchmark()
    {
        super(new Config("portable").setSerializationConfig(new SerializationConfig().addPortableFactory(1, new PortableCustomerFactory()).addClassDefinition(new ClassDefinitionBuilder(1, 1).addUTFField("name").addLongField("birthday").addUTFField("gender").addUTFField("emailAddress").addIntField("size").addLongArrayField("longArray").build())));
    }

    public double getWritePerformance()
    {
        start = System.currentTimeMillis();

        for(int i = 0; i < MainBenchmark.TEST_CASE_COUNT; i++)
        {
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new PortableCustomer("MyNameIs" + newRandom, new Date(newRandom), ((newRandom % 2) == 0) ? PortableCustomer.Sex.MALE : PortableCustomer.Sex.FEMALE, "MyEmailIs" + newRandom, new long[newRandom]);
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
            customer = new PortableCustomer("MyNameIs" + newRandom, new Date(newRandom), ((newRandom % 2) == 0) ? PortableCustomer.Sex.MALE : PortableCustomer.Sex.FEMALE, "MyEmailIs" + newRandom, new long[newRandom]);
            totalSize += (serializationService.toData(customer).bufferSize());
        }

        return (totalSize / MainBenchmark.TEST_CASE_COUNT);
    }
}