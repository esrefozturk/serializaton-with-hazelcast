package com.hazelcast.serializable;

import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.mainbenchmark.AbstractBenchmark;
import com.hazelcast.mainbenchmark.AbstractCustomer;
import com.hazelcast.mainbenchmark.MainBenchmark;
import com.hazelcast.nio.serialization.SerializationService;
import com.hazelcast.nio.serialization.SerializationServiceBuilder;
import java.util.Date;
import java.util.Random;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 06.07.2014.
 */
public class SerializableBenchmark extends AbstractBenchmark {
    public SerializableBenchmark() {
        super("serializable");
    }
}
