package ListaEnlazada;

public class Conjunto<T> implements IConjunto<T>{


    private Nodo<T> primero;

    public Conjunto() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (primero == null)
            primero = nodo;
        else{
            Nodo temporal =  primero;
            while (temporal.getSiguiente() != null){
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nodo);
        }
    }

    public Nodo<T> buscar(Comparable clave) {
        Nodo temporal = primero;
        while (temporal != null){
            if (clave.compareTo(temporal.getEtiqueta()) == 0)
                return temporal;
            temporal = temporal.getSiguiente();
        }
        return null;
    }
    public boolean eliminar(Comparable clave) {
        return false;
    }

    public String imprimir() {
        return null;
    }

    @Override
    public String imprimir(String separador) {
        return null;
    }

    public void cImprimir() {
        Nodo temporal = this.primero;
        while (temporal != null){
            System.out.println(temporal.getEtiqueta().toString());
            temporal = temporal.getSiguiente();
        }
    }

    @Override
    public int cantElementos() {
        return 0;
    }

    @Override
    public boolean esVacia() {
        return false;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {

    }
    public boolean buscarB(Comparable clave) {
        Nodo temporal = primero;
        while (temporal != null){
            if (clave.compareTo(temporal.getEtiqueta()) == 0)
                return true;
            temporal = temporal.getSiguiente();
        }
        return false;
    }
    @Override
    public Conjunto<T> opUnion(Conjunto<T> conjunto1, Conjunto<T> conjunto2) {
        Conjunto<T> conjuntoResultado = new Conjunto<>();
        Nodo temporal = conjunto1.primero;
        while(temporal != null){
            System.out.println();
            Nodo nuevo = new Nodo<>(temporal.getEtiqueta(), temporal.getDato());
            conjuntoResultado.insertar(nuevo);
            temporal = temporal.getSiguiente();
        }
        Nodo temporal2 = conjunto2.primero;
        while (temporal2 != null) {
            if (!conjuntoResultado.buscarB(temporal2.getEtiqueta())){
                Nodo nuevo = new Nodo<>(temporal2.getEtiqueta(), temporal2.getDato());
                conjuntoResultado.insertar(nuevo);
            }
            temporal2 = temporal2.getSiguiente();
        }
        return conjuntoResultado;
    }
    @Override
    public Conjunto<T> opInterseccion(Conjunto<T> conjunto1, Conjunto<T> conjunto2) {
        Conjunto<T> conjuntoResultado2 = new Conjunto<>();
        Nodo temporal = conjunto1.primero;
        while (temporal != null){
            if (conjunto2.buscarB(temporal.getEtiqueta())) {
                Nodo nuevo = new Nodo<>(temporal.getEtiqueta(), temporal.getDato());
                conjuntoResultado2.insertar(nuevo);
            }
            temporal = temporal.getSiguiente();
        }
        return conjuntoResultado2;
    }
}
