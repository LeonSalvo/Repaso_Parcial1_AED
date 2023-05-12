package ArbolesBinarios;
public class TArbolBB<T> implements IArbolBB<T>{
    private IElementoAB<T> raiz;
    public IElementoAB<T> getRaiz(){
        return raiz;
    }
    public TArbolBB(){
        raiz = null;
    }
    @Override
    public boolean insertar(IElementoAB unElemento) {
        if (raiz == null){
            raiz = unElemento;
            return true;
        }
        else {
            return raiz.insertar(unElemento);

        }
    }

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        return raiz.buscar(unaEtiqueta);
    }

    @Override
    public String preOrden() {
        if (raiz == null)
            return "Arbol vacio";
        else
            return raiz.preOrden();
    }

    @Override
    public String inOrden() {
        if (raiz == null)
            return "Arbol vacio";
        else
            return raiz.inOrden();
    }

    @Override
    public String postOrden() {
        if (raiz == null)
            return "Arbol vacio";
        else
            return raiz.postOrden();
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(raiz != null){
            raiz.eliminar(unaEtiqueta);
        }
    }
    
    public boolean esVacio() {
        return (raiz == null);
    }

}
