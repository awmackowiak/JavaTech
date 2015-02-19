package module3;

/**
 * Created by artur.mackowiak on 19/02/15.
 */

public class Storage {

    private int[] numbers = new int[20];
    private int currentIdx;

    public synchronized void addNumber(int number) {
        if(currentIdx == numbers.length -1){
            System.out.println("Yo tablica is full optymisto");
            try {
                wait(); //Watek czeja
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Index w magazynie: " + currentIdx);
            numbers[currentIdx] = number;
            currentIdx++;
            notify(); //Powiadamia watki w wait ze ktorys moze zaczac dzialac
        }
    }


    public int removeNumber() {
        synchronized (this) {
            if (currentIdx > 0) {
                System.out.println("Index: " + currentIdx);
                notify();
                return numbers[currentIdx--];
            }
        }
        System.out.println("Yo magazyn jest pusty");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }


}
