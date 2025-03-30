package org.mps.tree;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compareTo;

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(comparator);
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);
        bst2.insert(100);
        BinarySearchTree<Integer> bst3 = new BinarySearchTree<>(comparator);


        bst.insert(10);

        bst.insert(20);

        bst.insert(30);

        bst.insert(40);

        bst.insert(5);

        bst.insert(6);

        bst.insert(7);

        bst.insert(2);

        bst.insert(15);

        System.out.println(bst.render());

        System.out.println(bst.minimum());

        System.out.println(bst.maximum());

        System.out.println(bst.contains(7));

        System.out.println(bst.contains(11));

        System.out.println(bst.isLeaf());

        System.out.println(bst2.isLeaf());

        // Lanza un error System.out.println(bst3.isLeaf());

        bst.removeBranch(30);
        System.out.println(bst.render());

        System.out.println(bst.size());
        System.out.println(bst2.size());
        System.out.println(bst3.size());


        System.out.println(bst.depth());
        System.out.println(bst2.depth());
        System.out.println(bst3.depth());




    }
}
