package ch.trinat.edu.threads01.u03.teil2;

public class MeinRunnable implements Runnable {

    public void run() {
        los();
    }
    private void los() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tuNochMehr();
    }
    private void tuNochMehr() {
        System.out.println("Oben auf den Stack");
    }
}