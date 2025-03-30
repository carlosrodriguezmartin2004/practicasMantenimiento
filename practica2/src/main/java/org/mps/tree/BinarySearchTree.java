package org.mps.tree;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree<T> implements BinarySearchTreeStructure<T> {
    private Comparator<T> comparator;
    private T value;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    public String render(){
        String render = "";

        if (value != null) {
            render += value.toString();
        }

        if (left != null || right != null) {
            render += "(";
            if (left != null) {
                render += left.render();
            }
            render += ",";
            if (right != null) {
                render += right.render();
            }
            render += ")";
        }

        return render;
    }

    public BinarySearchTree(Comparator<T> comparator) {
            this.comparator = comparator;
            value = null;
            left = null;
            right = null;

    }

    @Override
    public void insert(T value) {
        if(value == null){
            throw new BinarySearchTreeException("Valor nulo");
        }

        if(this.value == null){
            this.value = value;
        } else if (this.comparator.compare(this.value, value) < 0) { // Si es mayor
            if(this.right == null){
                this.right = new BinarySearchTree<>(this.comparator);
            }
            this.right.insert(value);
        }else if(this.comparator.compare(this.value, value) > 0){
            if(this.left == null){
                this.left = new BinarySearchTree<>(this.comparator);
            }
            this.left.insert(value);
        }
    }

    @Override
    public boolean isLeaf() {
        if(this.value == null){
            throw new BinarySearchTreeException("Valor nulo");
        }
        return this.left == null && this.right == null;
    }

    @Override
    public boolean contains(T value) {
        boolean loEs = false;

        if(value == null){
            throw new BinarySearchTreeException("Valor a buscar nulo");
        }

        if(this.comparator.compare(this.value, value) == 0){
            loEs = true;
        }else if(this.comparator.compare(this.value, value) < 0 && this.right != null){
            loEs = this.right.contains(value);
        }else if(this.comparator.compare(this.value, value) > 0 && this.left != null){
            loEs = this.left.contains(value);
        }

        return loEs;
    }

    @Override
    public T minimum() {
        T minimo;

        if(this.value == null){
            throw new BinarySearchTreeException("Arbol vacío");
        }

        if(this.left != null){
            minimo = this.left.minimum();
        }else{
            minimo = this.value;
        }



        return minimo;
    }

    @Override
    public T maximum() {
        T maximo;

        if(this.value == null){
            throw new BinarySearchTreeException("Arbol vacío");
        }

        if(this.right != null){
            maximo = this.right.maximum();
        }else{
            maximo = this.value;
        }
        return maximo;
    }

    @Override
    public void removeBranch(T value){

        if(value == null){
            throw new BinarySearchTreeException("Valor a buscar nulo");
        }

        if(this.comparator.compare(this.value, value) == 0){
            this.left = null;
            this.right = null;
            this.value = null;

        }else if(this.comparator.compare(this.value, value) < 0){
            this.right.removeBranch(value);
        }else if(this.comparator.compare(this.value, value) > 0){
            this.left.removeBranch(value);
        }
    }

    @Override
    public int size() {


        if(this.value == null){
            return 0;
        }
        int i = 1;

        if(this.left != null){
            i += this.left.size();
        }

        if(this.right != null){
            i += this.right.size();
        }
        return i;
    }

    @Override
    public int depth() {

        if(this.value == null){
            return 0;
        }

        int i = 1;
        int j = 1;


        if(this.left != null){
            i+=this.left.depth();
        }

        if(this.right != null){
            j += this.right.depth();
        }

        return Math.max(i, j);
    }

    // Complex operations
    // (Estas operaciones se incluirán más adelante para ser realizadas en la segunda
    // sesión de laboratorio de esta práctica)

    @Override
    public void removeValue(T value) {

    }

    @Override
    public List<T> inOrder() {
        return List.of();
    }

    @Override
    public void balance() {

    }


}
