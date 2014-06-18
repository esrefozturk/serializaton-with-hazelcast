/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

package identifieddataserializable;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

import java.io.IOException;
import java.util.Date;

public class Customer implements IdentifiedDataSerializable {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    long[] longArray;

    public int getFactoryId(){
        return 0;
    }

    public int getId(){
        return 0;
    }

    public void readData( ObjectDataInput in ) throws IOException {

    }

    public void writeData( ObjectDataOutput out ) throws IOException{

    }

}
