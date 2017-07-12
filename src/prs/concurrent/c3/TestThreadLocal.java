package prs.concurrent.c3;

import java.sql.*;

/**
 * Created by zhangbin on 2017/7/10.
 */
public class TestThreadLocal {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            try {
                return java.sql.DriverManager.getConnection("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Connection getConnection(){
        return connectionHolder.get();
    }

}
