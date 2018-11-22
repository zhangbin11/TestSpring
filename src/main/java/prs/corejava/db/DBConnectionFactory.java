package prs.corejava.db;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by zhangbin on 2017/7/26.
 */
public class DBConnectionFactory {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("src/source/jdbc.properties"));
            prop.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String dirver,String url,String username,String password){
        try {
            Class.forName(dirver);
            Connection con = DriverManager.getConnection(url,username,password);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Connection getMacLocal(){
        System.out.println(prop.getProperty("macLocalDriver"));
        System.out.println(prop.getProperty("macLocalUrl"));

        return getConnection(prop.getProperty("macLocalDriver"),prop.getProperty("macLocalUrl"),prop.getProperty("macLocalUserName"),"");
    }
}
