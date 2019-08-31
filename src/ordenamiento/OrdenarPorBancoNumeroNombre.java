/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import clases.TarjetaBancaria;
import java.util.Comparator;

/**
 *para ordenamiento alternativo de la coleccion d4e tarjetas bancarias
 * @author 19024993k
 */
public class OrdenarPorBancoNumeroNombre implements Comparator<TarjetaBancaria>{
    
    @Override
    public int compare(TarjetaBancaria t1, TarjetaBancaria t2){
        if(t1.getBanco().compareTo(t2.getBanco())== 0){
            if(t1.getNumero() == t2.getNumero()){
                if(t1.getCliente().getNombre().compareTo(t2.getCliente().getNombre())== 0){
                return 0;
            }
            else{
                    return t1.getCliente().getNombre().compareTo(t2.getCliente().getNombre());
            }
            }
            else{
                    if(t1.getNumero() > t2.getNumero())
                        return 1;
                    else
                        return -1;
            }
        }
            else { 
                return t1.getBanco().compareTo(t2.getBanco());
            }
    }
   
}
