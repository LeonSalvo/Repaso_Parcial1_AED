package ListaEnlazada;

public interface IConjunto<T> extends ILista<T>{
    public Conjunto<T> opUnion(Conjunto<T> conjunto1, Conjunto<T> conjunto2);
    public Conjunto<T> opInterseccion(Conjunto<T> conjunto1, Conjunto<T> conjunto2);
}
