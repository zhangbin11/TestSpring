package prs.corejava.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Created by zhangbin on 2017/7/26.
 */
public class ProductServer {


    public static void main(String[] args) {
        try{

            LocateRegistry.createRegistry(1099);

            ProductImpl p = new ProductImpl("toast");

            Context namingContext = new InitialContext();

            namingContext.rebind("rmi://localhost:1099/toast",p);

            System.out.println("注册成功");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
