package ArbolesBinarios;
public class TElementoAB<T> implements IElementoAB<T>{
    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(IElementoAB<T> elemento){this.hijoIzq = (TElementoAB) elemento;}

    @Override
    public void setHijoDer(IElementoAB<T> elemento) {this.hijoDer = (TElementoAB) elemento;}

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0 ){
            return this;
        } else {
            if (unaEtiqueta.compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    return hijoIzq.buscar(unaEtiqueta);
                } else {
                    return null;
                }
            } else {
                if (unaEtiqueta.compareTo(etiqueta) > 0) {
                    if (hijoDer != null) {
                        return hijoDer.buscar(unaEtiqueta);
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public boolean insertar(IElementoAB<T> elemento) {
        if (etiqueta.compareTo(elemento.getEtiqueta()) == 0){
            return false;
        }
        if (etiqueta.compareTo(elemento.getEtiqueta()) > 0) {
            if (hijoIzq == null) {
                this.setHijoIzq(elemento);
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        }
        else{
            if (hijoDer == null){
                setHijoDer(elemento);
                return true;
            }
            else{
                return hijoDer.insertar(elemento);
            }
        }
    }

    @Override
    public String preOrden() {
        String preOrden = String.valueOf(etiqueta) + " ";
        if (hijoIzq != null){
            preOrden = preOrden + hijoIzq.preOrden();
        }
        if (hijoDer != null){
            preOrden = preOrden + hijoDer.preOrden();
        }
        return preOrden;
    }

    @Override
    public String inOrden() {
        String inOrden = "";
        if (hijoIzq != null){
            inOrden = inOrden + hijoIzq.inOrden();
        }
        inOrden = inOrden + String.valueOf(etiqueta) + " ";
        if (hijoDer != null){
            inOrden = inOrden + hijoDer.inOrden();
        }
        return inOrden;
    }

    @Override
    public String postOrden() {
        String postOrden = "";
        if (hijoIzq != null){
            postOrden = postOrden + hijoIzq.postOrden();
        }
        if (hijoDer != null){
            postOrden = postOrden + hijoDer.postOrden();
        }
        postOrden = postOrden + String.valueOf(etiqueta) + " ";
        return postOrden;
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
        return null;
    }
}
