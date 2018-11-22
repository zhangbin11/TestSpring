package prs.corejava.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zhangbin on 2017/7/26.
 */
public interface Product extends Remote {

    public String getDescription() throws RemoteException;

}
