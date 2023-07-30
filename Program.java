package ToyStore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Program {

    static Scanner scanner = new Scanner(System.in);
    static File getPrize = new File("prize.txt");
    static FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter(getPrize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        Toy toy1 = new Toy("car", 15, 20);
        Toy toy2 = new Toy("doll", 7, 35);
        Toy toy3 = new Toy("drum", 2, 18);
        Toy toy4 = new Toy("blocks", 12, 12);
        Toy toy5 = new Toy("book", 15, 80);
        Toy toy6 = new Toy("puzzle", 8, 45);
        Toy toy7 = new Toy("lego", 3, 50);
        Toy toy8 = new Toy("play-mobile", 10, 60);

        Store store = new Store();
        store.add(toy1);
        store.add(toy2);
        store.add(toy3);
        store.add(toy4);
        store.add(toy5);
        store.add(toy6);
        store.add(toy7);
        store.add(toy8);
        Prizes prizes = new Prizes();

        boolean f = true;
        while (f) {
            System.out.print("\n[1] To add the new toy to the store;\n[2] To change the toy frequency;\n[3] To print all toys in the store;\n" +
                    "[4] To define the prize toy and write it to the queue;\n[5] To print the queue of the prizes;\n" +
                    "[6] To take the prize toy from the queue and write it to the file;\n" +
                    "[9] To exit the program;\n\nPlease choose the action: ");
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1 -> store.addNewToy();
                case 2 -> store.changeFrequency();
                case 3 -> store.print();
                case 4 -> prizes.addPrize(store.definePrizeToy());
                case 5 -> prizes.print();
                case 6 -> {
                    Toy toyToFile = prizes.addPrizeToFile();
                    if (toyToFile != null) {
                        try {
                            fileWriter.write(toyToFile.toString());
                            System.out.println("The prize toy was successfully taken from the queue and was written to the file.");
                            fileWriter.flush();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                case 9 -> {
                    fileWriter.close();
                    f = false;
                }
                default -> System.out.println("\nYou entered unknown action, please enter the right action.");
            }
        }
    }
}
