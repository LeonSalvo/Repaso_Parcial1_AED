package org.example;
import ListaEnlazada.*;
public class Main {
    public static void main(String[] args) {

        Nodo<Integer> nodo1 = new Nodo<>(1,1);
        Nodo<Integer> nodo2 = new Nodo<>(2,1);
        Nodo<Integer> nodo3 = new Nodo<>(3,1);
        Nodo<Integer> nodo4 = new Nodo<>(4,1);

        Lista<Integer> lista = new Lista<>();
        lista.insertarOrdenado(nodo1);
        lista.insertarOrdenado(nodo4);
        lista.insertarOrdenado(nodo3);
        lista.insertarOrdenado(nodo2);
        System.out.println(lista.imprimir());
    }
}