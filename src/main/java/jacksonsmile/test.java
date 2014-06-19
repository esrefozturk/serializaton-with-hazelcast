package jacksonsmile;

import com.hazelcast.config.Config;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 20.06.2014.
 */
public class test {
    public static IMap<Integer, Customer> customerMap;
    public static Config config;
    public static HazelcastInstance hazelcastInstance;
    public static Customer customer;
    public static SerializerConfig serializerConfig;

    public static void main( String[] args ){
        config = new Config();

        serializerConfig = new SerializerConfig();
        serializerConfig.setTypeClass( Customer.class ).setImplementation( new CustomerSmileSerializer() );
        config.getSerializationConfig().getSerializerConfigs().add( serializerConfig );
        hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        customerMap = hazelcastInstance.getMap("customers");
        customer = new Customer("ali veli" );

        customerMap.set(0, customer);
        Customer newCustomer = customerMap.get(0);

        System.out.println("Name:" + newCustomer.name);

    }

}