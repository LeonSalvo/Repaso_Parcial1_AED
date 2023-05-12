package TDATrie;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    public static void main(String[] args) {
        TArbolTrie arb = new TArbolTrie();
        arb.insertar("hola");
        arb.insertar("hoy");

        System.out.println(arb.buscar("b"));

    }

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if(this.raiz != null){
            return this.raiz.buscar(palabra);
        }
        return 0;
    }

    public TNodoTrie buscarNodoTrie(String s){
        if(this.raiz != null){
            return this.buscarNodoTrie(s);
        }
        return null;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {

        if(this.raiz != null){
            LinkedList<String> a = new LinkedList<>();
            this.raiz.predecir(prefijo, a);
            return a;
        }
        return null;
    }


}