/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc01;

import clases.TarjetaBancaria;
import colecciones.Tarjetas;

/**
 *
 * @author 19024993k
 */
public class POC01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tarjetas tarjetas = new Tarjetas("tarjetas.txt");
        System.out.println("\nLISTADO DE TARJETAS\n");
        System.out.println(tarjetas.toString());
        
        if (tarjetas.toSave("paso.txt")== true)        
        System.out.println("\nGuardado correctamente\n");
        else
        System.out.println("\nError al guardar\n");
        
        TarjetaBancaria t = tarjetas.get(3);    
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
