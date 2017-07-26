package prs.corejava.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by zhangbin on 2017/7/26.
 */
public class ProductImpl extends UnicastRemoteObject implements Product {

    private String desc;

    public ProductImpl(String desc) throws RemoteException{
        this.desc = desc;
    }


    @Override
    public String getDescription() throws RemoteException {
        System.out.println("desc:" + desc);
        return "desc:" + desc;
    }
}
