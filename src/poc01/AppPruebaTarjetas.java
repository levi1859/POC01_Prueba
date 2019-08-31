/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc01;

import clases.Cliente;
import clases.Credito;
import clases.Tarjeta;
import clases.TarjetaBancaria;

/**
 *
 * @author 19024993k
 */
public class AppPruebaTarjetas {
    public static void main(String[] args){
        Tarjeta t1 = new Tarjeta();
        System.out.println("t1: " + t1.toString());
        
        TarjetaBancaria tb = new TarjetaBancaria();
        System.out.println("tb: "+ tb.toString());
        
        TarjetaBancaria tb2 = new TarjetaBancaria("BCI", "19024993-K", "Nelson Valeria");
        System.out.println("tb2: " + tb2.toString());
        
        tb2.setBanco("Edwards");
        System.out.println("tb2: " + tb2.toString());
        
        Cliente c = tb2.getCliente();
        System.out.println("Cliente tb2: " + c.toString());
        
        Credito c2= new Credito(tb2,"VISA",3000000);
        System.out.println("C2: " + c2.toString());
        
        TarjetaBancaria tb3 = new TarjetaBancaria("BBVA", "16326163-4","Esteban Contreras");
        System.out.println("tb3: " + tb3.toString());
        
        TarjetaBancaria tb4 = new TarjetaBancaria("SANTANDER", "17086158-2", "Javier Díaz");
        System.out.println("tb4: " + tb4.toString());
        
        Credito c3 = new Credito(tb3,"Master",2000000);
        System.out.println("C3: " + c3.toString());
        
        Credito c4 = new Credito(tb4,"VISA",1000500);
        System.out.println("C4: " + c4.toString());
        
        if (c2.comprarNacional(1200000))
            System.out.println("Aprobado");
        else 
            System.out.println("Rechazado por falta de cupo");
        
        if (c2.comprarNacional(2500000))
            System.out.println("Aprobado");
        else 
            System.out.println("Rechazado por falta de cupo");
        
        
    }
}
