package pz;

import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class CResourceReader {

    public static void readPropertyFileInClassPath(String filename){

        try{
            InputStream inst = CResourceReader.class.getResourceAsStream(filename);
            Properties properties = new Properties();
            properties.load(inst);
            inst.close();
            String sLang = properties.getProperty("lang");
            StringBuilder sb = new StringBuilder();
            Enumeration<?> enu = properties.propertyNames();
            while(enu.hasMoreElements()){
                String key = (String) enu.nextElement();
                String s = String.format("%s: %s", key, properties.getProperty(key));
                sb.append(s); sb.append("\n");
            }
            JOptionPane.showMessageDialog(null,sb.toString(),"PROPERTIES",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){ System.err.println(ex.getLocalizedMessage()); }
    }
    public static void main(String[] args) {
        String sProjectPath1 = System.getProperty("user.dir");
        String sProjectPath2 = new File("").getAbsolutePath();
        //file:/projectname/out/production/classname/packagename/
        String sClassPath1 = CResourceReader.class.getResource("").toString();
        System.out.println(sClassPath1);
        readPropertyFileInClassPath("application1.properties");
    }

}
