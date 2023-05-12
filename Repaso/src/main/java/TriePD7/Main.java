import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();
        //Creo Raiz
        trieAbonados.insertar(null);
        
        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        for(String user : ManejadorArchivosGenerico.leerArchivo("src/abonados.txt")){
            String[] split = user.split(",");
            trieAbonados.insertar(new TAbonado(split[1], split[0]));
        }
        
        String codigoPais = ManejadorArchivosGenerico.leerArchivo("src/codigos1.txt")[0].split(": ")[1] ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = ManejadorArchivosGenerico.leerArchivo("src/codigos1.txt")[1].split(": ")[1] ;// utilizar el indicado en el archivo "codigos.txt"
        
        System.out.println("Buscando -> (" + codigoPais + ", " + codigoArea + ")");
        
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        
        Collections.sort(ab);
        
        StringBuilder nombres = new StringBuilder();
        for(TAbonado i : ab){
            nombres.append(i.toString()).append(",");
            System.out.println(i.toString());
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", nombres.toString().split(","));
        
        
        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
      
        
    }
}