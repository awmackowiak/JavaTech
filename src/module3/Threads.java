package module3;

/**
 * Created by artur.mackowiak on 19/02/15.
 */

public class Threads {


    private static class Task implements Runnable {

        private int tick;

        @Override
        public void run() {
//            thread.isInterrupted();
            while (!Thread.currentThread().isInterrupted() && tick++ < 2000) {
                System.out.println("Thread nr1: " + Thread.currentThread().getName());
            }
        }

    }

    private static class Task2 extends Thread {

        private Thread thread;

        public Task2(Thread thred) {
            this.thread = thred;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.isInterrupted(); //Usawiamy flage watek zakonczony
//            super.run();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Task task3 = new Task();

        Thread worker1 = new Thread(task3);
        Thread worker2 = new Thread(task3);

        Task2 task2 = new Task2(worker1);
        Thread manager = new Thread(task2); //watek sprzatajacy (Zabijajacy watki) ;)

//        Task task1 = new Task(thread1);


        worker1.start(); //Start uruchamia watek !! Nie run ;) Bo to odpalimy w glownym watku programu
        worker2.start();
        Thread.sleep(5000); //Uspienie glownego watku(Main)
        manager.start(); //Po wstaniu glownego watku odpala watek sprzatajacy
        manager.join(); //blokuje glowny watek i czeka az sie skonczy watek manager
        System.out.println("########");


    }

}
