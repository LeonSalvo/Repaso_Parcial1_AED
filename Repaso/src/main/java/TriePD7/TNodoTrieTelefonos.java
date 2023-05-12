import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {
    
    private static final int CANT_CHR_NUMEROS = 10;
    private TNodoTrieTelefonos[] hijos;
    private boolean esPersona;
    private TAbonado abonado;

    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[CANT_CHR_NUMEROS];
        esPersona = false;
        abonado = null;
    }
    
    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < primerosDigitos.length(); c++) {
            int indice = primerosDigitos.charAt(c) - '0';
            if(nodo != null){
                nodo = nodo.hijos[indice];
            }
        }
        if(nodo != null){
            if(nodo.esPersona){
                abonados.add(nodo.abonado);
            }else {
                for (int c = 0; c < CANT_CHR_NUMEROS; c++) {
                    if(nodo.hijos[c] != null){
                        buscarTelefonos(primerosDigitos + (char)(c + '0'), abonados);
                    } 
                }
            }
        }        
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            int indice = unAbonado.getTelefono().charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPersona = true;
        nodo.abonado = unAbonado;
    }
}
