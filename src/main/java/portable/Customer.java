package portable;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableWriter;
import com.hazelcast.nio.serialization.PortableReader;
import java.util.Date;
import java.io.IOException;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

public class Customer implements Portable {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    long[] longArray;

    public int getFactoryId(){
        return 0;
    }

    public int getClassId(){
        return 0;
    }

    public void writePortable( PortableWriter writer ) throws IOException{

    }

    public void readPortable( PortableReader reader) throws IOException{

    }

}
