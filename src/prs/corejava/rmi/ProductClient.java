package prs.corejava.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import java.rmi.RMISecurityManager;

/**
 * Created by zhangbin on 2017/7/26.
 */
public class ProductClient {

    public static void main(String[] args) {

        try{

            Context namingContext = new InitialContext();

            Product tost = (Product) namingContext.lookup("rmi://localhost:1099/toast");

            System.out.println(tost.getDescription());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
