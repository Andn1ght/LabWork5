import service.BST;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try {
            BST<Integer, String> tree = new BST<>();
            tree.put(5, "Arman");
            tree.put(2, "Zhandos");
            tree.put(8, "Amir");
            tree.put(4, "Ali");
            tree.put(3, "Anuar");
            tree.put(12, "Aldiyar");
            tree.put(-4, "Zhanibek");
            tree.put(0, "Alikhan");

            System.out.println("----------------------------------------------------------");

            for (BST.Node<Integer, String> node : tree) {
                System.out.println("Key is " + node.getKey() + " and Value is " + node.getValue());
            }

            System.out.println("----------------------------------------------------------");

            // Access an invalid key
            String value = tree.get(10);
            System.out.println("Value for key 10: " + value);

            System.out.println("----------------------------------------------------------");

            System.out.println("Size of BST: " + tree.size());

            System.out.println("----------------------------------------------------------");

            System.out.println("Deleting 8th key...");
            tree.delete(8);

            System.out.println("Value for key 8: " + tree.get(8));

            System.out.println("----------------------------------------------------------");

            for (BST.Node<Integer, String> node : tree) {
                System.out.println("Key is " + node.getKey() + " and Value is " + node.getValue());
            }

        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}