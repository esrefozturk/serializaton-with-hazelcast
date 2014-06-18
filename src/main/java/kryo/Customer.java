package kryo; /**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

import java.util.Date;

public class Customer {
    public enum Sex { MALE, FEMALE }
    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    long[] longArray;
}
