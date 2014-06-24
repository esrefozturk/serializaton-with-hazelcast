package portable;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.nio.serialization.*;
import java.util.Date;

/**
 * Created by Mustafa Orkun Acar <mustafaorkunacar@gmail.com> on 20.06.2014.
 */

public class test
{
    public static IMap<Integer, portable.Customer> customerMap;
    public static Config config;
    public static HazelcastInstance hazelcastInstance;
    public static portable.Customer customer;

    public static void main(String[] args)
    {
        config = new Config();
        config.getSerializationConfig().addPortableFactory(1, new CustomerFactory());
        ClassDefinitionBuilder builder = new ClassDefinitionBuilder(1, 1);
        builder.addUTFField("name").addLongField("birthday").addUTFField("gender").addUTFField("emailAddress").addIntField("size").addLongArrayField("longArray");
        ClassDefinition customerClassDef = builder.build();
        config.getSerializationConfig().addClassDefinition(customerClassDef);
        hazelcastInstance = Hazelcast.newHazelcastInstance(config);

        customerMap = hazelcastInstance.getMap("customers");
        customer = new portable.Customer("ali veli", new Date(11,5,6), Customer.Sex.FEMALE, "ali@veli.com", new long[]{123, 456, 789, 741});
        customerMap.set(2, customer);
        portable.Customer newCustomer = customerMap.get(2);

        System.out.println("Name:" + newCustomer.name);
        System.out.println("Birthday:" + newCustomer.birthday);
        System.out.println("Gender:" + newCustomer.gender);
        System.out.println("EmailAddress:" + newCustomer.emailAddress);
        System.out.println("LongArray:");
        for(Long tmp : newCustomer.longArray) System.out.println(tmp.toString());
    }
}