package ArbolesBinarios;


public class ElementoAritmeticoAB<T>  extends TElementoAB{

    private Comparable[] operaciones = {"+", "-", "/", "*"};

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    public ElementoAritmeticoAB(Comparable unaEtiqueta, Object unosDatos) {
        super(unaEtiqueta, unosDatos);
    }

    public boolean insertar(TElementoAB elemento){
        if (elemento.getEtiqueta().equals("+")){
            if(getHijoIzq().getEtiqueta().compareTo(elemento) < 0){
                return getHijoIzq().insertar(elemento);
            }
            else{
                return getHijoDer().insertar(elemento);
            }
        } else if (elemento.getEtiqueta().equals("-")){

        } else if (elemento.getEtiqueta().equals("*")){

        } else if (elemento.getEtiqueta().equals("/")){

        } else {

        }
        return false;
    }
}
