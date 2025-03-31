package org.mps.tree;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Nested
    @DisplayName("render")
    class Render {
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
    }

    @Nested
    @DisplayName("insert")
        class Insert{
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


    @Nested
    @DisplayName("isLeaf")
    class isLeaf{
        @Test
        public void isLeafArbolVacio(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            String expected = "Valor nulo";

            BinarySearchTreeException error = assertThrows(BinarySearchTreeException.class, () -> bst2.isLeaf());

            String actual = error.getMessage();
            assertEquals(expected, actual);

        }

        @Test
        public void isLeafArbolConHijoIzquierdo(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);
            boolean expected = false;

            bst2.insert(30);
            bst2.insert(20);

            boolean actual = bst2.isLeaf();

            assertEquals(expected, actual);

        }

        @Test
        public void isLeafArbolConHijoDerecho(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);
            boolean expected = false;

            bst2.insert(30);
            bst2.insert(40);

            boolean actual = bst2.isLeaf();

            assertEquals(expected, actual);

        }

        @Test
        public void isLeafArbolConDosHijos(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);
            boolean expected = false;

            bst2.insert(30);
            bst2.insert(40);
            bst2.insert(20);

            boolean actual = bst2.isLeaf();

            assertEquals(expected, actual);

        }

        @Test
        public void isLeafArbolSinHijos(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);
            boolean expected = true;

            bst2.insert(30);

            boolean actual = bst2.isLeaf();

            assertEquals(expected, actual);

        }

    }

    @Nested
    @DisplayName("contains")
    class contains{
        @Test
        public void containsValorNulo(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            String expected = "Valor a buscar nulo";

            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(5);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);

            BinarySearchTreeException error = assertThrows(BinarySearchTreeException.class, () -> bst2.contains(null));

            String actual =  error.getMessage();

            assertEquals(expected, actual);

        }

        @Test
        public void containsArbolNulo(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            String expected = "Arbol nulo";



            BinarySearchTreeException error = assertThrows(BinarySearchTreeException.class, () -> bst2.contains(5));

            String actual =  error.getMessage();

            assertEquals(expected, actual);

        }

        @Test
        public void containsValoQueExiste(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            boolean expected = true;

            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(5);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);

            boolean actual = bst2.contains(20);

            assertEquals(expected, actual);

        }

        @Test
        public void containsValorQueNOExisteALaIzquierda(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            boolean expected = false;

            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(5);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);

            boolean actual = bst2.contains(1);

            assertEquals(expected, actual);

        }

        @Test
        public void containsValorQueNOExisteALaDerecha(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            boolean expected = false;

            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(5);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);

            boolean actual = bst2.contains(100);

            assertEquals(expected, actual);

        }
    }

    @Nested
    @DisplayName("minimum")
    class minimum{
        @Test
        public void minimoDeArbolVacio(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            String expected = "Arbol vacio";



            BinarySearchTreeException error = assertThrows(BinarySearchTreeException.class, () -> bst2.minimum());

            String actual =  error.getMessage();

            assertEquals(expected, actual);

        }

        @Test
        public void minimoDeArbolBienHecho(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            Integer expected = 5;

            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(5);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);



            Integer actual =  bst2.minimum();

            assertEquals(expected, actual);

        }

    }


@Nested
@DisplayName("maximum")
class maximum{
    @Test
    public void maximoDeArbolVacio(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        String expected = "Arbol vacio";



        BinarySearchTreeException error = assertThrows(BinarySearchTreeException.class, () -> bst2.maximum());

        String actual =  error.getMessage();

        assertEquals(expected, actual);

    }

    @Test
    public void maximoDeArbolBienHecho(){
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

        Integer expected = 50;

        bst2.insert(30);
        bst2.insert(10);
        bst2.insert(20);
        bst2.insert(5);
        bst2.insert(40);
        bst2.insert(50);
        bst2.insert(35);



        Integer actual =  bst2.maximum();

        assertEquals(expected, actual);

    }


}

    @Nested
    @DisplayName("removeBranch")
    class removeBranch{
        @Test
        public void removeBranchValorNulo(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            String expected = "Valor a buscar nulo";

            BinarySearchTreeException error = assertThrows(BinarySearchTreeException.class, () -> bst2.removeBranch(null));

            String actual =  error.getMessage();

            assertEquals(expected, actual);
        }

        @Test
        public void removeBranchValorLaIzquierdaLuegoDerecha(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            String expected = "30(10(5,),40(35,50))";


            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(5);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);

            bst2.removeBranch(20);


            String actual = bst2.render();

            assertEquals(expected, actual);
        }

    }


    @Nested
    @DisplayName("size")
    class size{
        @Test
        public void sizeArbolVacio(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            int expected = 0;

            int actual = bst2.size();

            assertEquals(expected, actual);



        }


        @Test
        public void sizeArbolBienHecho(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            int expected = 7;


            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(5);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);



            int actual = bst2.size();

            assertEquals(expected, actual);
        }


    }



    @Nested
    @DisplayName("depth")
    class depth{
        @Test
        public void depthArbolVacio(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            int expected = 0;

            int actual = bst2.depth();

            assertEquals(expected, actual);



        }


        @Test
        public void depthArbolBienHecho(){
            Comparator<Integer> comparator = Integer::compareTo;
            BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(comparator);

            int expected = 3;


            bst2.insert(30);
            bst2.insert(10);
            bst2.insert(40);
            bst2.insert(50);
            bst2.insert(35);



            int actual = bst2.depth();

            assertEquals(expected, actual);
        }


    }





    // Complex operations
    // (Estas operaciones se incluirán más adelante para ser realizadas en la segunda
    // sesión de laboratorio de esta práctica)



}