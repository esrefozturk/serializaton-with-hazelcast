/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014. Cool.
 */

package externalizable;

import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.ClassNotFoundException;
import java.util.ArrayList;

public class Customer implements Externalizable
{
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Long> longArray;

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException
    {
        name = objectInput.readLine();
        birthday = new Date(Long.valueOf(objectInput.readLine()).longValue());
        gender = Sex.valueOf(objectInput.readLine());
        emailAddress = objectInput.readLine();
        int len = objectInput.readInt();
        longArray = new ArrayList<Long>(len);
        Long tmp;
        for(int i = 0; i < len; i++)  {  tmp = objectInput.readLong(); longArray.add(tmp); }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException
    {
        objectOutput.writeChars(name);
        Format formatter = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
        String s = formatter.format(birthday);
        objectOutput.writeChars(s);
        objectOutput.writeChars(gender.toString());
        objectOutput.writeChars(emailAddress);
        objectOutput.writeInt(longArray.size());
        for(int i = 0; i < longArray.size(); i++) objectOutput.writeLong(longArray.get(i));
    }
}