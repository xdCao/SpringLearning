package chapter4;

import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by xdcao on 2017/4/2.
 */
public class FileSourceExample {

    public static void main(String[] args){
        try {
            String filePath="H:/springLearning/src/main/resources/12.txt";
            WritableResource res1=new PathResource(filePath);

            Resource res2=new ClassPathResource("12.txt");

            OutputStream stream1=res1.getOutputStream();
            stream1.write("asdasdasd".getBytes());
            stream1.close();

            InputStream ins1=res1.getInputStream();
            InputStream ins2=res2.getInputStream();

            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            int i;
            while ((i=ins1.read())!=-1){
                byteArrayOutputStream.write(i);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
