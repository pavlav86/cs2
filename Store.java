import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class Store {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    private HashSet<Toy> toys = new HashSet<>();

    public Store() {

    }

    public void add(Toy toy) {
        toys.add(toy);
    }

    public void addNewToy() {
        System.out.print("Please enter the name of the new toy: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        Toy newToy = new Toy(name, quantity, 0);
        boolean flag = true;
        for (Toy t : toys) {
            if (t.getName().equals(name)) {
                t.setQuantity(t.getQuantity() + quantity);
                System.out.println("\nThe quantity of the existing toy was increased.");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.print("Please enter the frequency (from 0 to 100): ");
            int frequency = Integer.parseInt(scanner.nextLine());
            newToy.setFrequency(frequency);
            toys.add(newToy);
            System.out.println("\nThe new toy was successfully added to the store.");
        }


    }

    public void print() {
        for (Toy t : toys) {
            System.out.print(t);
        }
    }

    public void changeFrequency() {
        System.out.print("Please enter the name of the toy you would like to edit: ");
        String name = scanner.nextLine();
        Toy toyToChange = null;
        for (Toy t : toys) {
            if (name.equals(t.getName())) {
                toyToChange = t;
                break;
            }
        }
        if (toyToChange != null) {
            System.out.printf("The current frequency of this toy is %d.\n", toyToChange.getFrequency());
            System.out.print("Please set the new frequency (from 0 to 100): ");
            int frequency = Integer.parseInt(scanner.nextLine());
            toyToChange.setFrequency(frequency);
            System.out.printf("\nThe frequency of the toy '%s' was successfully changed.\n", toyToChange.getName());
        } else {
            System.out.println("\nThere is no toy with such name in the store.");
        }
    }

    public Toy definePrizeToy() {
        int frequencySum = 0;
        for (Toy t : toys) {
            frequencySum += t.getFrequency();
        }
        int number = random.nextInt(frequencySum + 1);

        Toy prizeToy = null;
        int f = 0;
        for (Toy t : toys) {
            f += t.getFrequency();
            if (f >= number) {
                prizeToy = new Toy(t);
                prizeToy.setQuantity(1);
                if (t.getQuantity() > 1) {
                    t.setQuantity(t.getQuantity() - 1);
                } else {
                    toys.remove(t);
                }
                break;
            }
        }
        System.out.printf("\nThe toy '%s' was successfully added to the queue.\n", prizeToy.getName().toString());
        return prizeToy;
    }
}
