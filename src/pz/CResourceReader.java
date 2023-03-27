package pz;

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
            Enumeration<?> enu = properties.propertyNames();
            while(enu.hasMoreElements()){
                String key = (String) enu.nextElement();
                System.out.println(key + ": " + properties.getProperty(key));
            }
        }catch(Exception ex){ System.err.println(ex.getLocalizedMessage()); }
    }
    public static void main(String[] args) throws Exception {
        String sProjectPath1 = System.getProperty("user.dir");
        String sProjectPath2 = new File("").getAbsolutePath();
        //file:/projectname/out/production/classname/packagename/
        String sClassPath1 = CResourceReader.class.getResource("").toString();
        System.out.println(sClassPath1);
        readPropertyFileInClassPath("application1.properties");
    }

}
