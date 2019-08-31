
package poc01;

import clases.TarjetaBancaria;
import colecciones.Tarjetas;

/**
 *
 * @author 19024993k
 */
public class AppColecciones {
    public static void main(String[]args){
        Tarjetas tarjetas = new Tarjetas("tarjetas.txt");
        System.out.println("\nLISTADO DE TARJETAS\n");
        System.out.println(tarjetas.toString());
        
        if (tarjetas.toSave("paso.txt")== true)        // me debiese crar el archivo y guardarlo(tb de el arraylist tarjetero)
        System.out.println("\nGuardado correctamente\n");
        else
        System.out.println("\nError al guardar\n");
        
        TarjetaBancaria t = tarjetas.get(3);    //remuevo la tarjeta de la posicion 3
        System.out.println(t.toString());
        if(tarjetas.remove(t)){
          System.out.println("tarjeta "+ t.getNumero()+ " fue eliminada\n");
        }
        else{
            System.out.println("tarjeta " + t.getNumero() + "No existe\n");
        }
        
        System.out.println("\nLISTADO DE TARJETAS\n");
        System.out.println(tarjetas.toString());
        
        if(tarjetas.remove(t)){
          System.out.println("tarjeta "+ t.getNumero()+ " fue eliminada\n");
        }
        else{
            System.out.println("tarjeta " + t.getNumero() + "No existe\n");
        }
        
        tarjetas.ordenarPorNumeroRut();
        System.out.println("\nLISTADO DE TARJETAS ORDENADAS POR NUM Y RUT\n");
        System.out.println(tarjetas.toString());
        
        tarjetas.ordenarPorBancoNumeroNombre();
        System.out.println("\nLISTADO DE TARJETAS ORDENADAS POR BANCO, NUMERO Y NOMBRE DE CLIENTE\n");
        System.out.println(tarjetas.toString());
    }
}
