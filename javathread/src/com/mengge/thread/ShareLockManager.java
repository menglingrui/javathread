package com.mengge.thread;

import java.util.HashMap;
/**
 * 内存共享锁，处理多线程并发
 * 此锁为动态锁，在线程结束运行后，自动释放锁
 * 在java web或java cs中通常客户端的一次远程调用
 * 在java server中看做一个线程
 * @author mlr
 *
 */
public class ShareLockManager {
   /**
    * 线程级变量
    */
   private ThreadLocal<HashMap<String, String>> local=new ThreadLocal<HashMap<String, String>>(){
	   protected HashMap<String, String>  initialValue() {
	        return new HashMap<String, String>();
	    }
   };
   /**
    * 存放当前线程中，加锁的对象
    * @param lockdir
    * @throws Exception
    */
   public void putLock(String lockdir)throws Exception{
	   local.get().put(lockdir, lockdir);
   }
   /**
    * 得到当前线程中，加锁对象
    * @param lockdir
    * @return
    * @throws Exception
    */
   public String getLock(String lockdir)throws Exception{
	   return local.get().get(lockdir);
   }
   
   /**
    * 得到当前线程中，加锁对象
    * @param lockdir
    * @return
    * @throws Exception
    */
   public void clearLock()throws Exception{
	    local.get().clear();
   }
   /**
    * 得到当前线程所有的锁对象
    * @return
    */
   public HashMap<String, String> getThreadLockMap(){
	   return local.get();
   }
   
}
