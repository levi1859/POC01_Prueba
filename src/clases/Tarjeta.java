/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author 85605410
 */
public class Tarjeta {
    private static int generador=1000;
    private int numero;
    
    public Tarjeta(){
        generador++;
        numero=generador;
    }
    public Tarjeta(int num){
        numero=num;
    }
    public Tarjeta(Tarjeta t){
        numero= t.numero;
    }
    public void setNumero(int n){
        numero=n;
    }
    public int getNumero(){
        return numero;
    }
    
    @Override
    public String toString(){
        return ""+numero;
    }
    
    
}
