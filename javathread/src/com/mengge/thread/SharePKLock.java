package com.mengge.thread;

import java.util.HashMap;

public class SharePKLock {
  
  private static ShareLockManager lokmanager=new ShareLockManager();
  
  public static boolean dynamicLock(String lockdir) throws Exception{
	 boolean isSucess=SharePubData.lock(lockdir);
	 if(isSucess){
		 lokmanager.putLock(lockdir);
	 }else{
		 return false;
	 }
	return isSucess;
	
  }
	   
  public static void releaseDynamicLock() throws Exception{	
	  HashMap<String, String>lockmap=lokmanager.getThreadLockMap();
	  if(lockmap!=null&& lockmap.size()>0){
		  for(String key:lockmap.keySet()){
			  SharePubData.unlock(key);
		  }
	  }
	  lokmanager.clearLock();
  }
}
