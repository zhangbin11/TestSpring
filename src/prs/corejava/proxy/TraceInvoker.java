package prs.corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhangbin on 2017/7/3.
 */
public class TraceInvoker implements InvocationHandler {

    private Object target;

    public TraceInvoker(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("target = [" + target + "], method = [" + method + "], args = [" + args + "]");

        return method.invoke(target,args);
    }


    public static void main(String[] args) {
        Object[] elements = new Object[100];

        for(int i=0;i<elements.length;i++){

            Integer target = i;
            InvocationHandler trace = new TraceInvoker(target);
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},trace);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length)+1;

//        Object i = elements[0];
//        i.toString();


        int result = Arrays.binarySearch(elements,key);

        System.out.println(result);

    }
}
