package prs.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by zhangbin on 2017/6/27.
 */
public class Audience {

    public void takeSeats(){
        System.out.println("The audience is taking their seats");
    }

    public void turnOffCellPhones(){
        System.out.println("The audience is turing off their cellphones");
    }

    public void aplaud(){
        System.out.println(" CLAP CLAP CLAP CLAP CLAP CLAP");
    }

    public void demandRefund(){
        System.out.println("Boo we want our money back!");
    }
    
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
    	
    	try {
    		System.out.println("开始执行环绕切面");
    		long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println("执行完场环绕切面,共"+(end-start)/1000+"秒");
		} catch (Throwable e) {
			e.printStackTrace();
		}
    	
    	
    }
}
