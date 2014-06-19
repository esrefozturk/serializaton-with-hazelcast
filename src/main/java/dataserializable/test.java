package dataserializable;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.nio.serialization.SerializationService;
import com.hazelcast.nio.serialization.SerializationServiceBuilder;
import java.util.Date;
import java.util.Arrays;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 19.06.2014.
 */

public class test {
    public static IMap<Integer, Customer> customerMap;
    public static Config config;
    public static HazelcastInstance hazelcastInstance;
    public static Customer customer;
    public static void main( String[] args ){
        config = new Config();
        hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        customerMap = hazelcastInstance.getMap("customers");
        customer = new Customer("ali veli" , new Date(93,8,4), Customer.Sex.MALE ,
                                "ali@veli.com",new long[]{7,8,9,1,2,3});

        customerMap.set(0, customer);
        Customer newCustomer = customerMap.get(0);

        System.out.println("Name:" + newCustomer.name);
        System.out.println("Birthday:" + newCustomer.birthday);
        System.out.println("Gender:" + newCustomer.gender);
        System.out.println("EmailAddress:" + newCustomer.emailAddress);
        System.out.println("LongArray:" + Arrays.toString( newCustomer.longArray ) );
    }

}
