package TDATrie;


import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        // implementar

    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodoActual = this;
        for(char c : prefijo.toCharArray()){
            if(nodoActual == null){
                return;
            }
            nodoActual = nodoActual.hijos[c - 'a'];
        }
        nodoActual.buscarPalabras(prefijo, palabras, prefijo);
    }

    @Override
    public int buscar(String s) {
        int comparaciones = 0;
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return comparaciones;
            }
            nodo = nodo.hijos[indice];
            comparaciones ++;
        }
        return comparaciones;
    }

    private LinkedList<String> buscarPalabras(String prefijo, LinkedList<String> lista, String aAgregar){
        String original = aAgregar;
        for(int i = 0; i < CANT_CHR_ABECEDARIO; i++){
            if(this.hijos[i] != null){
                aAgregar = original + (char) (i + 'a');
                if(this.hijos[i].esPalabra){
                    lista.add(aAgregar);
                    aAgregar = original;
                }
                this.hijos[i].buscarPalabras(prefijo, lista, aAgregar);
            }
        }
        return lista;
    }
}