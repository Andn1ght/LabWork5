package service;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Node<K, V>>{

    /**
     * Inner class representing a node in the BST.
     *
     * @param <K> The type of the key.
     * @param <V> The type of the value.
     */
    public static class Node<K, V> {
        private K key; // The key of the node
        private V val;  // The value associated with the key
        private Node<K, V> left, right; // The left and right child of the node

        /**
         * Constructs a new node with the specified key and value.
         *
         * @param key The key of the node.
         * @param val The value associated with the key.
         */
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        /**
         * Returns the key of the node.
         *
         * @return The key of the node.
         */
        public K getKey() {
            return key;
        }

        /**
         * Returns the value associated with the key of the node.
         *
         * @return The value associated with the key of the node.
         */
        public V getValue() {
            return val;
        }
    }
    private Node<K, V> root; // The root node of the binary search tree
    private int size; // The number of nodes in the binary search tree

    /**
     * Inserts a key-value pair into the BST.
     *
     * @param key The key to insert.
     * @param val The value associated with the key.
     */
    public void put(K key, V val) {
        // Check if the key is null and throw an exception if it is
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");
        // Call the private helper method put to recursively insert the key-value pair
        root = put(root, key, val);
    }

    /**
     * Inserts a key-value pair into the binary search tree, recursive helper method for put.
     *
     * @param node The current node being processed during the recursive insertion.
     * @param key  The key of the node to be inserted.
     * @param val  The value associated with the key to be inserted.
     * @return The updated node after insertion.
     */
    private Node<K, V> put(Node<K, V> node, K key, V val) {
        // If the current node is null, create a new node with the given key-value pair and return it
        if (node == null) {
            size++;
            return new Node<>(key, val);
        }

        // Compare the given key with the key of the current node
        int comparison = key.compareTo(node.key);

        // If the given key is less than the current node's key, recursively insert it in the left subtree
        if (comparison < 0)
            node.left = put(node.left, key, val);
        // If the given key is greater than the current node's key, recursively insert it in the right subtree
        else if (comparison > 0)
            node.right = put(node.right, key, val);
        // If the given key is equal to the current node's key, update the value of the current node
        else
            node.val = val;

        // Return the updated node
        return node;
    }

    /**
     * Retrieves the value associated with the specified key in the BST.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or null if the key is not found.
     */
    public V get(K key) {
        // Check if the key is null and throw an exception if it is
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");

        // Call the private helper method get to retrieve the node associated with the key
        Node<K, V> node = get(root, key);

        // Return the value of the retrieved node if it exists, otherwise return null
        return (node == null) ? null : node.val;
    }

    /**
     * Retrieves the value associated with the given key from the binary search tree, recursive helper method for get.
     *
     * @param node The current node being processed during the recursive search.
     * @param key  The key to search for.
     * @return The value associated with the given key if found, or null if the key does not exist in the tree.
     */
    private Node<K, V> get(Node<K, V> node, K key) {
        // If the current node is null, the key does not exist in the tree, so return null
        if (node == null)
            return null;

        // Compare the given key with the key of the current node
        int comparison = key.compareTo(node.key);

        // If the given key is less than the current node's key, recursively search in the left subtree
        if (comparison < 0)
            return get(node.left, key);
        // If the given key is greater than the current node's key, recursively search in the right subtree
        else if (comparison > 0)
            return get(node.right, key);
        // If the given key is equal to the current node's key, return the current node
        else
            return node;
    }

    /**
     * Deletes the node with the specified key from the BST.
     *
     * @param key The key to delete.
     */
    public void delete(K key) {
        // Check if the key is null and throw an exception if it is
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");

        // Call the private helper method delete to remove the node associated with the key
        root = delete(root, key);
    }

    /**
     * Deletes the node associated with the given key from the binary search tree, recursive helper method for delete.
     *
     * @param node The current node being processed during the recursive deletion.
     * @param key  The key of the node to delete.
     * @return The updated node structure after deletion.
     */
    private Node<K, V> delete(Node<K, V> node, K key) {
        // If the current node is null, the key does not exist in the tree, so return null
        if (node == null)
            return null;

        // Compare the given key with the key of the current node
        int comparison = key.compareTo(node.key);

        // If the given key is less than the current node's key, recursively delete in the left subtree
        if (comparison < 0)
            node.left = delete(node.left, key);
            // If the given key is greater than the current node's key, recursively delete in the right subtree
        else if (comparison > 0)
            node.right = delete(node.right, key);
            // If the given key is equal to the current node's key, perform the deletion
        else {
            // Case 1: No children
            if (node.left == null && node.right == null) {
                return null;
            }
            // Case 2: One child
            else if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            // Case 3: Two children
            else {
                Node<K, V> replaceTemp = findMin(node.right);  // Find the minimum node in the right subtree
                node.key = replaceTemp.key;  // Replace the key of the current node with the minimum key
                node.val = replaceTemp.val;  // Replace the value of the current node with the minimum value
                node.right = deleteMin(node.right);  // Delete the minimum node in the right subtree
            }
        }

        return node;
    }

    /**
     * Finds and returns the minimum node in the subtree rooted at the given node.
     *
     * @param node The root of the subtree to search for the minimum node.
     * @return The minimum node in the subtree.
     */
    private Node<K, V> findMin(Node<K, V> node) {
        // Recursively find the minimum node by traversing to the leftmost node in the subtree
        return node.left == null ? node : findMin(node.left);
    }

    /**
     * Deletes and returns the minimum node in the subtree rooted at the given node.
     *
     * @param node The root of the subtree to delete the minimum node from.
     * @return The updated root of the subtree after deleting the minimum node.
     */
    private Node<K, V> deleteMin(Node<K, V> node) {
        // If the left child of the current node is null, then it is the minimum node
        if (node.left == null)
            return node.right; // Return the right child (null if it is also null)

        // Recursively delete the minimum node in the left subtree
        node.left = deleteMin(node.left);

        // Return the updated node
        return node;
    }

    /**
     * Returns an iterator for the BST that iterates over the nodes in in-order traversal.
     *
     * @return An iterator for the BST.
     */
    public Iterator<Node<K, V>> iterator() {
        return new InOrderIterator();
    }

    // Inner class implementing the in-order iterator
    private class InOrderIterator implements Iterator<Node<K, V>> {
        private Node<K, V> current;
        private Stack<Node<K, V>> nodeStack;

        public InOrderIterator() {
            current = root;
            nodeStack = new Stack<>();
        }

        @Override
        public boolean hasNext() {
            // The iterator has next element if either the stack is not empty or there is a current node
            return !nodeStack.isEmpty() || current != null;
        }

        @Override
        public Node<K, V> next() {
            // Perform an in-order traversal to get the next node

            // Traverse to the leftmost node and push each encountered node to the stack
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }

            // If there are no more elements, throw a NoSuchElementException
            if (!hasNext())
                throw new NoSuchElementException("No more elements in the BST.");

            // Pop the top node from the stack (which is the next node in in-order traversal)
            Node<K, V> node = nodeStack.pop();

            // Set the current node to the right child of the popped node
            current = node.right;

            // Return the popped node
            return node;
        }
    }

    public int size() {
        return size;
    }
}
