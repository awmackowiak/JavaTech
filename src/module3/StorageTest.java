package module3;

import java.util.Random;

/**
 * Created by artur.mackowiak on 19/02/15.
 */

public class StorageTest {


    private class Consumer implements Runnable {

        private Storage storage;

        public Consumer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                storage.removeNumber();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private class Producer implements Runnable {

        private Storage storage;
        private Random random = new Random();

        public Producer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                storage.addNumber(random.nextInt());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        StorageTest storageTest = new StorageTest();
        Producer producer = storageTest.new Producer(storage);
        Consumer consumer = storageTest.new Consumer(storage);

        for (int i = 0; i < 2000; i++) {
            new Thread(i % 2 != 0 ? producer : consumer).start();
        }

    }

}
