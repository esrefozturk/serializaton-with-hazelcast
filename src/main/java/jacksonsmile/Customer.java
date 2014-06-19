package jacksonsmile;

import com.hazelcast.nio.serialization.ByteArraySerializer;
import java.util.Date;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.smile.SmileFactory;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 20.06.2014.
 */

public class Customer {
    String name;

    public Customer(){}

    public Customer( String name ){
        this.name = name;
    }

}
