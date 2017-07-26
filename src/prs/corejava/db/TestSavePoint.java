package prs.corejava.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Created by zhangbin on 2017/7/26.
 */
public class TestSavePoint {

    public void test(){
        Connection con = DBConnectionFactory.getMacLocal();

        String sql= "insert into student(name,password) values(?,?)";
        String badSql= "insert asds student(name,password) values(?,?)";

        PreparedStatement ps = null;
        PreparedStatement badPs = null;
        Savepoint point = null;

        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setString(1, "zhangsan");
            ps.setString(2,"123");
            badPs = con.prepareStatement(badSql);
            badPs.setString(1, "lisi");
            badPs.setString(2, "123");

            ps.execute();
            point = con.setSavepoint();
            badPs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            if(con!=null){
                try {
                    con.rollback(point);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }finally {
            try {
                if(con!=null){
                    con.commit();
                    con.releaseSavepoint(point);
                }
                if(ps!=null){
                    ps.close();
                }
                if(badPs!=null){
                    badPs.close();
                }
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new TestSavePoint().test();
    }
}
