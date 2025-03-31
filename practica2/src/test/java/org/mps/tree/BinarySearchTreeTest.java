package org.mps.tree;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {


    @Test
    public void renderSoloInserts(){
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

    @Test
    public void renderArbolVacio(){
        String expected = "";

        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String actual = bst2.render();
        assertEquals(expected, actual);
    }

    @Test
    public void renderArbolSinHijos(){
        String expected = "30";

        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        bst2.insert(30);

        String actual = bst2.render();
        assertEquals(expected, actual);
    }

    @Test
    public void renderArbolConSoloHijoIzquierdo(){
        String expected = "30(10,)";

        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        bst2.insert(30);
        bst2.insert(10);

        String actual = bst2.render();
        assertEquals(expected, actual);
    }

    @Test
    public void renderArbolConSoloHijoDerecho(){
        String expected = "30(,50)";

        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        bst2.insert(30);
        bst2.insert(50);

        String actual = bst2.render();
        assertEquals(expected, actual);
    }

    @Test
    public void insertValorNulo(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "Valor nulo";

        BinarySearchTreeException error = assertThrows(BinarySearchTreeException.class, () -> bst2.insert(null));

        String actual = error.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void insertEnArbolVacio(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "30";

        bst2.insert(30);

        String actual = bst2.render();

        assertEquals(expected, actual);

    }

    @Test
    public void insertDosVecesMismoValor(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "30";

        bst2.insert(30);
        bst2.insert(30);


        String actual = bst2.render();

        assertEquals(expected, actual);

    }

    @Test
    public void insertDerecha(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "30(,50)";

        bst2.insert(30);
        bst2.insert(50);

        String actual = bst2.render();

        assertEquals(expected, actual);

    }

    @Test
    public void insertIzquierda(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "30(20,)";

        bst2.insert(30);
        bst2.insert(20);

        String actual = bst2.render();

        assertEquals(expected, actual);
    }

    @Test
    public void insertTerceraFilaIzquierda(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "30(20(10,),)";

        bst2.insert(30);
        bst2.insert(20);
        bst2.insert(10);

        String actual = bst2.render();

        assertEquals(expected, actual);
    }

    @Test
    public void insertTerceraFilaDerecha(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "30(,40(,50))";

        bst2.insert(30);
        bst2.insert(40);
        bst2.insert(50);

        String actual = bst2.render();

        assertEquals(expected, actual);
    }




}