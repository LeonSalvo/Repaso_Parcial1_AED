/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4_pd0_alonso;

/**
 *
 * @author gatom
 */
public class ElementoAritmeticoAB<T>  extends TElementoAB{
    private Comparable[] operaciones = {"+", "-", "/", "*"};
    
    @Override
    public boolean insertar(TElementoAB elemento){
        if (elemento.getEtiqueta().equals("+")){
            if(hijoIzq.getEtiqueta().compareTo(elemento) < 0){
                return hijoIzq.insertar(elemento);
            }
            else{
                return hijoDer.insertar(elemento);
            }
        } else if (elemento.getEtiqueta().equals("-")){
            
        } else if (elemento.getEtiqueta().equals("*")){
            
        } else if (elemento.getEtiqueta().equals("/")){
            
        } else {
            
        }
        return false;
    }
}
