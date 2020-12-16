package ch.trinat.edu.threads02.u03;

public class ProducerConsumer {

    public static void main (String[] args){

        BufferN buffer = new BufferN(100);

        new Producer(buffer,1).start();
        new Consumer(buffer).start();
        new Producer(buffer,1000).start();
        new Consumer(buffer).start();
    }
}

class Producer extends Thread{
    BufferN buffer;
    int startValue;

    Producer (BufferN buffer, int startValue){
        this.buffer = buffer;
        this.startValue = startValue;
        this.start();
    }

    public void run(){
        for (int x = startValue; x<100+startValue;x++){
            buffer.put(x);
            System.out.println("put"+Thread.currentThread().getName()+" "+x);
            try{
                sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    BufferN buffer;
    Consumer(BufferN buffer){
        this.buffer=buffer;
    }

    public void run(){
        while (true){
            System.out.println("get"+Thread.currentThread().getName()+" - "+buffer.get());
            try{
                sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
