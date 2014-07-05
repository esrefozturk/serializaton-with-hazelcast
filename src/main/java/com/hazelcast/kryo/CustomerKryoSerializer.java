package com.hazelcast.kryo;

import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.Input;
import com.hazelcast.nio.serialization.StreamSerializer;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.ObjectDataInput;
import com.esotericsoftware.kryo.Kryo;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 18.06.2014.
 */

public class CustomerKryoSerializer implements StreamSerializer<Customer> {

    private static ThreadLocal<Kryo>  kryoThreadLocal = new ThreadLocal(){
        protected Kryo initialValue(){
            Kryo kryo = new Kryo();
            kryo.register(Customer.class);
            return kryo;
        }
    };

    public void write( ObjectDataOutput objectDataOutput, Customer customer ) throws IOException{
        //System.out.println("I am writing a Customer");
        Kryo kryo = kryoThreadLocal.get();
        Output output = new Output((OutputStream) objectDataOutput);
        kryo.writeObject( output , customer );
        output.flush();
    }

    public Customer read(ObjectDataInput objectDataInput) throws IOException{
        //System.out.println("I am reading a Customer");
        Input input = new Input( (InputStream) objectDataInput  );
        return kryoThreadLocal.get().readObject( input , Customer.class );
    }

    public int getTypeId(){
        return 1;
    }

    public void destroy(){}

}
