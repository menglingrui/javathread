package com.mengge.thread;

import java.util.HashMap;

public class SharePubData {
  
  private static HashMap<String, String> lockData=new HashMap<String, String>();
  /**
   * �жϵ�ǰ�����ܷ����
   * @param lock
   * @return
   */
  public static synchronized boolean canLock(String lock){
	  if(lockData.get(lock)!=null&&lockData.get(lock).length()>0){
		  return false;
	  }else{
		  return true;
	  }
  }
  /**
   * �Ե�ǰ������м���
   * @param lock
   * @return
   */
  public static synchronized boolean lock(String lock){
	  if(canLock(lock)){
		  lockData.put(lock, lock);
		  return true;
	  }else{
		  return false;
	  }
  }
  /**
   * �Ե�ǰ�����ͷż���
   * @param lock
   * @return
   */
  public static void unlock(String lock){
	  lockData.remove(lock) ;
  }
}
