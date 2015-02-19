package module3;

/**
 * Created by artur.mackowiak on 19/02/15.
 * Wywolanie watka po przez dziedziczenie a nie po przed interface Runable
 */
public class Thread_Nr_Two extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread nr1: " + Thread.currentThread().getName());
        }
//        super.run();
    }

    public static void main(String[] args) {
        Thread_Nr_Two thread_nr_two = new Thread_Nr_Two();
        Thread_Nr_Two thread_nr_two1 = new Thread_Nr_Two();

        thread_nr_two.start();
        thread_nr_two1.start();
    }

}
