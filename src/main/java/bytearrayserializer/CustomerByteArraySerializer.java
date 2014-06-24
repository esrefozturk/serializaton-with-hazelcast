package bytearrayserializer;

import com.hazelcast.nio.serialization.ByteArraySerializer;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Date;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 23.06.2014.
 */
public class CustomerByteArraySerializer implements ByteArraySerializer<Customer> {

    public byte[] write(Customer customer) throws IOException{
        //System.out.println("I am writing a Customer");

        byte[] result = new byte[]{};
        byte[] blank = new byte[]{' '};

        result = ArrayUtils.addAll( result , customer.name.getBytes() );
        result = ArrayUtils.addAll( result , blank );

        result = ArrayUtils.addAll( result , new Long(customer.birthday.getTime()).toString().getBytes() );
        result = ArrayUtils.addAll( result , blank );

        result = ArrayUtils.addAll( result , customer.gender.toString().getBytes() );
        result = ArrayUtils.addAll( result , blank );

        result = ArrayUtils.addAll( result , customer.emailAddress.getBytes() );
        result = ArrayUtils.addAll( result , blank );

        result = ArrayUtils.addAll( result , new Integer(customer.longArray.length).toString().getBytes() );
        result = ArrayUtils.addAll( result , blank );

        for(int i=0;i<customer.longArray.length;i++){
            result = ArrayUtils.addAll( result , new Long(customer.longArray[i]).toString().getBytes() );
            result = ArrayUtils.addAll( result , blank );
        }

        return result;
    }

    public Customer read(byte[] bytes) throws IOException{
        //System.out.println("I am reading a Customer");

        Customer customer = new Customer();
        int from,to,length;

        for(from=0,to=0;bytes[to]!=' ';to++);
        customer.name = new String(Arrays.copyOfRange(bytes,from,to));

        for(from=to+1,to=to+1;bytes[to]!=' ';to++);
        customer.birthday = new Date( Long.parseLong( new String(Arrays.copyOfRange(bytes,from,to))));

        for(from=to+1,to=to+1;bytes[to]!=' ';to++);
        customer.gender = Customer.Sex.valueOf(new String(Arrays.copyOfRange(bytes,from,to)));

        for(from=to+1,to=to+1;bytes[to]!=' ';to++);
        customer.emailAddress = new String(Arrays.copyOfRange(bytes,from,to));

        for(from=to+1,to=to+1;bytes[to]!=' ';to++);
        length = Integer.parseInt(new String(Arrays.copyOfRange(bytes,from,to)));

        customer.longArray = new long[length];

        for(int i=0;i<length;i++) {
            for(from=to+1,to=to+1;bytes[to]!=' ';to++);
            customer.longArray[i] = Long.parseLong( new String(Arrays.copyOfRange(bytes,from,to)));
        }

        return new Customer();

    }

    public int getTypeId(){
        return 1;
    }

    public void destroy(){}

}
