import java.lang.Thread;
public class Threads extends Thread {
    
    public Threads (String name) {
        setName(name);
    }
    public void run (){
        for (int i=0;i<100;i++){
        System.out.println(currentThread().getName()+":"+i);
    }
    }
}