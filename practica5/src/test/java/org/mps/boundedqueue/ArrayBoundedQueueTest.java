package org.mps.boundedqueue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class ArrayBoundedQueueTest {

    @Nested
    public class constructor {
        @Test
        @DisplayName("e")
        public void ArrayBoundedQueue_capacity0oMenor_IllegalArgumentException(){
            int cap = 0;

            assertThatThrownBy(() -> new ArrayBoundedQueue<Integer>(cap)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("a")
        public void ArrayBoundedQueue_capacityMayorA0_ArrayNotNull(){
            int cap = 10;

            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<Integer>(cap);

            assertThat(arrayBoundedQueue).isNotNull();

        }
    }

    @Nested
    public class put{
        @Test
        @DisplayName("b")
        public void put_AnyadirValorCuandoEstaLleno_FullBoundedQueueException(){
            int cap = 1;
            int val1 = 10;
            int val2 = 20;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);
            arrayBoundedQueue.put(val1);

            assertThatThrownBy(() -> arrayBoundedQueue.put(val2)).isInstanceOf(FullBoundedQueueException.class).hasMessage("put: full bounded queue");
        }

        @Test
        @DisplayName("b")
        public void put_AnyadirValorNull_IllegalArgumentException(){
            int cap = 15;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);

            assertThatThrownBy(() -> arrayBoundedQueue.put(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("put: element cannot be null");
        }

        @Test
        @DisplayName("b")
        public void put_AnyadirValorCorrecto_Valid(){
            int cap = 15;
            int val1 = 5;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);
            arrayBoundedQueue.put(val1);

            assertThat(arrayBoundedQueue).isNotNull().containsExactly(val1).isNotEmpty();
        }

    }

    @Nested
    public class get{
        @Test
        @DisplayName("b")
        public void get_ArrayVacio_EmptyBoundedQueueException(){
            int cap = 15;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);

            assertThatThrownBy(() -> arrayBoundedQueue.get()).isInstanceOf(EmptyBoundedQueueException.class).hasMessage("get: empty bounded queue");
        }

        @Test
        @DisplayName("b")
        public void get_ArrayCorrecto_Valid(){
            int cap = 15;
            int val1 = 5;
            int val2 = 10;
            int val3 = 20;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);
            arrayBoundedQueue.put(val1);
            arrayBoundedQueue.put(val2);
            arrayBoundedQueue.put(val3);

            int res = arrayBoundedQueue.get();

            assertThat(res).isEqualTo(val1);
            assertThat(arrayBoundedQueue).doesNotContain(val1);
        }
    }



    @Nested
    public class isFull{
        @Test
        @DisplayName("b")
        public void isFull_Test_Valid(){
            int cap = 15;
            int val1 = 5;
            int val2 = 10;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);
            arrayBoundedQueue.put(val1);
            arrayBoundedQueue.put(val2);

            boolean res = arrayBoundedQueue.isFull();

            assertThat(res).isFalse();
        }
    }


    @Nested
    public class isEmpty{
        @Test
        @DisplayName("b")
        public void isEmpty_Test_Valid(){
            int cap = 15;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);

            boolean res = arrayBoundedQueue.isEmpty();

            assertThat(res).isTrue();
        }
    }



    @Nested
    public class size {
        @Test
        @DisplayName("b")
        public void size_Test_Valid(){
            int cap = 15;
            int val1 = 5;
            int val2 = 10;
            int realSize = 2;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);
            arrayBoundedQueue.put(val1);
            arrayBoundedQueue.put(val2);

            int size = arrayBoundedQueue.size();

            assertThat(size).isEqualTo(realSize);
        }
    }


    @Nested
    public class getFirst{
        @Test
        @DisplayName("b")
        public void getFirst_Test_Valid(){
            int cap = 3;
            int val1 = 5;
            int val2 = 10;
            int val3 = 20;
            int expected = 0;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);
            arrayBoundedQueue.put(val1);
            arrayBoundedQueue.put(val2);

            int first = arrayBoundedQueue.getFirst();

            assertThat(first).isEqualTo(expected);
        }
    }

    @Nested
    public class getLast{
        @Test
        @DisplayName("b")
        public void getLast_Test_Valid(){
            int cap = 3;
            int val1 = 5;
            int val2 = 10;
            int val3 = 20;
            int expected = 0;
            ArrayBoundedQueue<Integer> arrayBoundedQueue = new ArrayBoundedQueue<>(cap);
            arrayBoundedQueue.put(val1);
            arrayBoundedQueue.put(val2);
            arrayBoundedQueue.put(val3);

            int last = arrayBoundedQueue.getLast();

            assertThat(last).isEqualTo(expected);
        }
    }


}
