package jacksonsmile;

import com.hazelcast.nio.serialization.ByteArraySerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.smile.SmileFactory;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 20.06.2014.
 */

public class CustomerSmileSerializer implements ByteArraySerializer<Customer> {

    public byte[] write(Customer customer) throws java.io.IOException{
        System.out.println("I am writing a Customer");
        return customer.name.getBytes();
    }

    public Customer read(byte[] bytes) throws java.io.IOException{
        System.out.println("I am reading a Customer");
        return new Customer( new String(bytes) );
    }

    public int getTypeId(){
        return 1;
    }

    public void destroy(){}

}

