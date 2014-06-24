package identifieddataserializable;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 20.06.2014.
 */

public class test
{
    public static IMap<Integer, identifieddataserializable.Customer> customerMap;
    public static Config config;
    public static HazelcastInstance hazelcastInstance;
    public static identifieddataserializable.Customer customer;

    public static void main(String[] args)
    {
        config = new Config();
        config.getSerializationConfig().addDataSerializableFactory(1, new CustomerFactory());
        hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        customerMap = hazelcastInstance.getMap("customers");

        customer = new identifieddataserializable.Customer("ad soyad", new Date(01,8,7), Customer.Sex.MALE, "ad@soyad.com", new ArrayList<Long>() {{ add(150L); add(75L); add(3L); add(1L); }});
        customerMap.set(1, customer);
        identifieddataserializable.Customer newCustomer = customerMap.get(1);

        System.out.println("Name:" + newCustomer.name);
        System.out.println("Birthday:" + newCustomer.birthday);
        System.out.println("Gender:" + newCustomer.gender);
        System.out.println("EmailAddress:" + newCustomer.emailAddress);
        System.out.println("LongArray:");
        for(Long tmp : newCustomer.longArray) System.out.println(tmp.toString());
    }
}