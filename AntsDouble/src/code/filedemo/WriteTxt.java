package code.filedemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @Auther: ants_double
 * @Date: 2018-12-23 09:46
 * @Description:
 */
public class WriteTxt {

    public static void main(String[] args) {
        WriteToTxt("D:\\demo.txt","dsds2fsd");
    }

    public static  void WriteToTxt(String filepath,String content){
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(new File(filepath),true));
            writer.write("\n"+content);
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
