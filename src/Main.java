import service.BST;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try {
            BST<Integer, String> tree = new BST<>();
            tree.put(7, "Arman");
            tree.put(5, "Zhandos");
            tree.put(14, "Amir");
            tree.put(6, "Ali");
            tree.put(4, "Anuar");
            tree.put(11, "Aldiyar");
            tree.put(17, "Zhanibek");
            tree.put(0, "Alikhan");
            tree.put(12, "Almas");
            tree.put(14, "Andrey");
            tree.put(25, "Max");
            tree.put(3, "Nurali");
            tree.put(9, "Kerey");

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

            System.out.println("Tree height is: " + tree.countHeight());

        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}