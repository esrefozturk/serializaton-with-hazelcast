package com.hazelcast.externalizable;

import com.hazelcast.config.Config;
import java.util.Date;
import com.hazelcast.mainbenchmark.AbstractBenchmark;
import com.hazelcast.mainbenchmark.MainBenchmark;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 23.06.2014.
 */

public class ExternalizableBenchmark extends AbstractBenchmark
{
    public ExternalizableBenchmark(){
        super( new Config("externalizable"));
    }

    public double getWritePerformance()
    {
        start = System.currentTimeMillis();

        for(int i = 0; i < MainBenchmark.TEST_CASE_COUNT; i++)
        {
            newRandom = random.nextInt(MainBenchmark.MAX_RANDOM);
            customer = new ExternalizableCustomer("MyNameIs" + newRandom, new Date(newRandom), ((newRandom % 2) == 0) ? ExternalizableCustomer.Sex.MALE : ExternalizableCustomer.Sex.FEMALE, "MyEmailIs" + newRandom, new long[newRandom]);
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
            customer = new ExternalizableCustomer("MyNameIs" + newRandom, new Date(newRandom), ((newRandom % 2) == 0) ? ExternalizableCustomer.Sex.MALE : ExternalizableCustomer.Sex.FEMALE, "MyEmailIs" + newRandom, new long[newRandom]);
            totalSize += (serializationService.toData(customer).bufferSize());
        }

        return (totalSize / MainBenchmark.TEST_CASE_COUNT);
    }
}