package ToyStore;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prizes {


    private Deque<Toy> prizes;

    public Prizes() {
        prizes = new ArrayDeque();
    }

    public void addPrize(Toy toy) {
        prizes.add(toy);
    }

    public void print() {
        if (prizes.size() == 0) {
            System.out.println("\nThe queue is still empty. Please add toys to the queue.");
        } else {
            for (Toy t : prizes) {
                System.out.print(t);
            }
        }
    }


    public Toy addPrizeToFile() {
        if (prizes.size() != 0) {
            Toy toyPrize = prizes.pollFirst();
            System.out.println("The prize toy is:");
            System.out.print(toyPrize);
            return toyPrize;
        } else {
            System.out.println("The queue is empty. Please add toys to the queue.");
            return null;
        }

    }
}