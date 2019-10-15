package com.antsdouble;

import com.antsdouble.pojo.User;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/15
 */
public class ProtoTest {

    @Test
    public void  test(){

        User user=new User();
        user.setFirstName("ants");
        user.setLastName("double");
        Schema<User> schema= RuntimeSchema.getSchema(User.class);
        LinkedBuffer buffer=LinkedBuffer.allocate(1024);
        byte[] bytes = ProtostuffIOUtil.toByteArray(user, schema, buffer);
        System.out.println(Arrays.toString(bytes));
        User userParsed=schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes,userParsed,schema);
        System.out.println(userParsed);

        byte[] serializer = ProtostuffUtil.serializer(user);
        System.out.println(Arrays.toString(serializer));
        User deserialize = ProtostuffUtil.deserialize(serializer, User.class);
        System.out.println(deserialize);

    }
}
