/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

package dataserializable;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import java.util.Date;
import java.io.IOException;

public class Customer implements DataSerializable {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    long[] longArray;

    public void readData( ObjectDataInput objectDataInput ) throws IOException{
        name = objectDataInput.readUTF();
        birthday = new Date( objectDataInput.readLong() );
        gender = Sex.valueOf( objectDataInput.readUTF() );
        emailAddress = objectDataInput.readUTF();
        longArray = objectDataInput.readLongArray();
    }

    public void writeData( ObjectDataOutput objectDataOutput ) throws IOException{
        objectDataOutput.writeUTF( name );
        objectDataOutput.writeLong( birthday.getTime() );
        objectDataOutput.writeUTF( gender.toString() );
        objectDataOutput.writeUTF( emailAddress );
        objectDataOutput.writeLongArray( longArray );
    }

}
