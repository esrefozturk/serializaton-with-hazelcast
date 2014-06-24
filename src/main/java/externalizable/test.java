package externalizable;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import java.util.Date;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 20.06.2014.
 */

public class test
{
    public static IMap<Integer, externalizable.Customer> customerMap;
    public static Config config;
    public static HazelcastInstance hazelcastInstance;
    public static externalizable.Customer customer;

    public static void main(String[] args)
    {
        config = new Config();
        hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        customerMap = hazelcastInstance.getMap("customers");
        customer = new externalizable.Customer("ad soyad", new Date(93,8,7), Customer.Sex.FEMALE, "ad@soyad.com", new long[]{2,4,3,567});
        customerMap.set(1, customer);
        externalizable.Customer newCustomer = customerMap.get(1);

        System.out.println("Name:" + newCustomer.name);
        System.out.println("Birthday:" + newCustomer.birthday);
        System.out.println("Gender:" + newCustomer.gender);
        System.out.println("EmailAddress:" + newCustomer.emailAddress);
        System.out.println("LongArray:");
        for(Long tmp : newCustomer.longArray) System.out.println(tmp.toString());
    }
}