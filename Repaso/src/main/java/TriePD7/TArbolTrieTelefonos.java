import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    public TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        if(raiz != null){
            LinkedList<TAbonado> abonados = new LinkedList<TAbonado>();
            raiz.buscarTelefonos(pais+area, abonados);
            return abonados;
        }
        return null;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if(raiz != null){
            raiz.insertar(unAbonado);
        }else{
            raiz = new TNodoTrieTelefonos();
        }
    }

 
    
}
