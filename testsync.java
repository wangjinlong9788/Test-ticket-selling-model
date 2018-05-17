
public class testsync {  
    private int num=10; 
    public synchronized void sell(){  
        if(num==0){  
            return;  
        }  
        num--;  
        System.out.println(Thread.currentThread().getName()+"One ticket sold,remain"+num+"ticket");  
    }  
    class window implements Runnable{  
  
        @Override  
        public void run() {  
            // TODO Auto-generated method stub  
            while(true){  
                sell();  
                try {  
                    Thread.sleep(1000*2);  
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
        }  
          
    }  
    public static void main(String[] args) {  
    	testsync d = new testsync();  
        window w = d.new window();  
        new Thread(w,"win1").start();  
        new Thread(w,"win2").start();  
        new Thread(w,"win3").start();  
        new Thread(w,"win4").start(); 
        //Demo d = new Demo();  
        //new Thread(d.new window(),"window1").start();  
        //new Thread(d.new window(),"window2").start();  
        //new Thread(d.new window(),"window3").start();  
        //new Thread(d.new window(),"window4").start();  
    }  
}