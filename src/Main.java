import service.BST;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try {
            BST<Integer, String> tree = new BST<>();
            tree.put(5, "Value 5");
            tree.put(2, "Value 2");
            tree.put(8, "Value 8");
            tree.put(1, "Value 1");

            for (BST.Node<Integer, String> node : tree) {
                System.out.println("Key is " + node.getKey() + " and Value is " + node.getValue());
            }

            // Access an invalid key
            String value = tree.get(10);
            System.out.println("Value for key 10: " + value);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}