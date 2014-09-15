package com.mengge.thread;
public class Test { 
        public static void main(String[] args) { 
                User u = new User("����", 100); 
                User u2 = new User("����", 100); 
                MyThread t1 = new MyThread("�߳�A", u, 20); 
                MyThread t2 = new MyThread("�߳�B", u, -60); 
                MyThread t3 = new MyThread("�߳�C", u, -80); 
                MyThread t4 = new MyThread("�߳�D", u, -30); 
                MyThread t5 = new MyThread("�߳�E", u, 32); 
                MyThread t6 = new MyThread("�߳�F", u, 21); 
                
                MyThread t11 = new MyThread("�߳�A", u2, 20); 
                MyThread t21 = new MyThread("�߳�B", u2, -60); 
                MyThread t31 = new MyThread("�߳�C", u2, -80); 
                MyThread t41 = new MyThread("�߳�D", u2, -30); 
                MyThread t51 = new MyThread("�߳�E", u2, 32); 
                MyThread t61 = new MyThread("�߳�F", u2, 21); 

                t1.start(); 
                t2.start(); 
                t3.start(); 
                t4.start(); 
                t5.start(); 
                t6.start(); 

                t11.start(); 
                t21.start(); 
                t31.start(); 
                t41.start(); 
                t51.start(); 
                t61.start(); 
        } 
} 

class MyThread extends Thread { 
        private User u; 
        private int y = 0; 

        MyThread(String name, User u, int y) { 
                super(name); 
                this.u = u; 
                this.y = y; 
        } 

        public void run() { 
        	    
                u.oper(y); 
        } 
} 

class User { 
        private String code; 
        private int cash; 

        User(String code, int cash) { 
                this.code = code; 
                this.cash = cash; 
        } 

        public String getCode() { 
                return code; 
        } 

        public void setCode(String code) { 
                this.code = code; 
        } 

        /** 
         * ҵ�񷽷� 
         * @param x ���x��Ԫ 
         * @throws Exception 
         */ 
        public void oper(int x)   { 
                try { 
                	boolean islock= SharePKLock.dynamicLock(code);
                	if(islock){
                        Thread.sleep(10L); 
                        this.cash += x; 
                        System.out.println(Thread.currentThread().getName() + "���н��������ӡ�" + x + "������ǰ�û��˻�  ["+code+"] ���Ϊ��" + cash); 
                        Thread.sleep(10L); 
                	}else{
                		Thread.sleep(100L);  
                		oper(x);
                	}
                } catch (Exception e) { 
                    e.printStackTrace(); 
                }finally{
                	try {
						SharePKLock.releaseDynamicLock();
					} catch (Exception e) {
						e.printStackTrace();
					}
                }
        } 

        @Override 
        public String toString() { 
                return "User{" + 
                                "code='" + code + '\'' + 
                                ", cash=" + cash + 
                                '}'; 
        } 
}