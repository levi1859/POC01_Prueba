/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Utiles.Rut;

/**
 *
 * @author 85605410
 */
public class Debito extends TarjetaBancaria{
    private double saldo;
    
    public Debito(){
        super();
        saldo = 0.0;
    }
    
    public Debito(TarjetaBancaria t){
        super(t);
        saldo = 0.0;
    }
    
    public Debito(TarjetaBancaria t, double s){
        super(t);
        saldo =s;
    }
    
    public Debito(Debito d){
        super(d.getNumero(), d.getBanco(), d.getCliente());
        saldo = d.saldo;
    }
    
    public Debito(String d){
        super();
        String[] datos = d.split(",");
        this.setNumero(Integer.parseInt(datos[0]));    
        this.setBanco(datos[1]);
        this.setCliente(new Cliente(new Rut(datos[2]),datos[3]));
        saldo = Double.parseDouble(datos[4]);
    }
    
    public String tostring(){
        return super.toString() + ","+ saldo;
    }
    
    //Métodos especificos
    public void depositar(double monto){
        saldo+= monto;
    }
    
    public boolean girar(double monto){
        if(monto <= saldo){
            saldo -=monto;
            return true;
        }
        else{
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
