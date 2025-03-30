package org.mps.tree;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    public void setUp(){
        Comparator<Integer> comparator = Integer::compareTo;
        bst = new BinarySearchTree<>(comparator);
        bst.insert(30);
        bst.insert(10);
        bst.insert(20);
        bst.insert(5);
        bst.insert(40);
        bst.insert(50);
        bst.insert(35);
    }



    @Test
    public void renderTest(){
        String expected = "30(10(5,20),40(35,50))";

        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);
        bst2.insert(30);
        bst2.insert(10);
        bst2.insert(20);
        bst2.insert(5);
        bst2.insert(40);
        bst2.insert(50);
        bst2.insert(35);

        String actual = bst2.render();
        assertEquals(expected, actual);
    }



}