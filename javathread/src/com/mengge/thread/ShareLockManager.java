package com.mengge.thread;

import java.util.HashMap;
/**
 * �ڴ湲������������̲߳���
 * ����Ϊ��̬�������߳̽������к��Զ��ͷ���
 * ��java web��java cs��ͨ���ͻ��˵�һ��Զ�̵���
 * ��java server�п���һ���߳�
 * @author mlr
 *
 */
public class ShareLockManager {
   /**
    * �̼߳�����
    */
   private ThreadLocal<HashMap<String, String>> local=new ThreadLocal<HashMap<String, String>>(){
	   protected HashMap<String, String>  initialValue() {
	        return new HashMap<String, String>();
	    }
   };
   /**
    * ��ŵ�ǰ�߳��У������Ķ���
    * @param lockdir
    * @throws Exception
    */
   public void putLock(String lockdir)throws Exception{
	   local.get().put(lockdir, lockdir);
   }
   /**
    * �õ���ǰ�߳��У���������
    * @param lockdir
    * @return
    * @throws Exception
    */
   public String getLock(String lockdir)throws Exception{
	   return local.get().get(lockdir);
   }
   
   /**
    * �õ���ǰ�߳��У���������
    * @param lockdir
    * @return
    * @throws Exception
    */
   public void clearLock()throws Exception{
	    local.get().clear();
   }
   /**
    * �õ���ǰ�߳����е�������
    * @return
    */
   public HashMap<String, String> getThreadLockMap(){
	   return local.get();
   }
   
}
