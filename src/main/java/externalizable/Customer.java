/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

package externalizable;

import com.hazelcast.nio.ObjectDataOutput;

import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.IOException;
import java.util.Date;
import java.lang.ClassNotFoundException;

public class Customer implements Externalizable {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    long[] longArray;

    public void writeExternal(ObjectOutput out) throws IOException{

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{

    }



}
