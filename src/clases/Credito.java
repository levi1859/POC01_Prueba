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
public class Credito extends TarjetaBancaria {
    private String nombreTarjeta;
    private double cupoNacional;
    private double gastoNacional;
    
    public Credito(){
        super();
        nombreTarjeta = "";
        cupoNacional= 0.0;
        gastoNacional = 0.0;
    }
    
    public Credito(String bco, Cliente c){
        super(bco, c);
        nombreTarjeta = "";
        cupoNacional= 0.0;
        gastoNacional = 0.0;
    }
    
    public Credito(TarjetaBancaria t){
    super(t);
        nombreTarjeta = "";
        cupoNacional= 0.0;
        gastoNacional = 0.0;
    }
    
    public Credito(TarjetaBancaria t, String nom, double cupoNac){
    super(t);
        nombreTarjeta = nom;
        cupoNacional= cupoNac;
        gastoNacional = 0.0;
    }
    
     public Credito(String bco, Rut r , String nom){
        super(bco,r,nom);
        nombreTarjeta = "";
        cupoNacional= 0.0;
        gastoNacional = 0.0;
    }
     
     public Credito(String bco,String r , String nom){
        super(bco,r,nom);
        nombreTarjeta = "";
        cupoNacional= 0.0;
        gastoNacional = 0.0;
    }
     
    public Credito(String bco, Cliente c, String nomTarjeta){
        super(bco, c);
        nombreTarjeta =nomTarjeta;
        cupoNacional= 0.0;
        gastoNacional = 0.0;
    } 
    
    public Credito(String bco, Cliente c, String nomTarjeta, double cupoNac){
        super(bco, c);
        nombreTarjeta =nomTarjeta;
        cupoNacional= cupoNac;
        gastoNacional = 0.0;
    }
    
    public Credito(Credito t){
        super(t.getNumero() , t.getBanco(), t.getCliente());
        nombreTarjeta =t.nombreTarjeta;
        cupoNacional= t.cupoNacional;
        gastoNacional = t.gastoNacional;
    }
    
     public Credito(String c){
    super();
        String[] datos = c.split(",");
        this.setNumero(Integer.parseInt(datos[0]));    
        this.setBanco(datos[1]);
        this.setCliente(new Cliente(new Rut(datos[2]),datos[3]));
        nombreTarjeta =datos[4];
        cupoNacional= Double.parseDouble(datos[5]);
        gastoNacional = Double.parseDouble(datos[6]);
    }
    
    @Override
    public String toString(){
      return super.toString()+ ","+ nombreTarjeta + ","+ cupoNacional + ","+ gastoNacional;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public double getCupoNacional() {
        return cupoNacional;
    }

    public void setCupoNacional(double cupoNacional) {
        this.cupoNacional = cupoNacional;
    }

    public double getGastoNacional() {
        return gastoNacional;
    }

    public void setGastoNacional(double gastoNacional) {
        this.gastoNacional = gastoNacional;
    }
    
    //Métodos especificos
    public boolean pagarGastoNacional(double monto){
        if (monto > gastoNacional)
            return false;
        else
            gastoNacional = gastoNacional - monto;
        return true;
    }
    
    public boolean comprarNacional(double monto){
        double tot = cupoNacional + gastoNacional;
        if(tot > cupoNacional)
            return false;
        else
            gastoNacional = gastoNacional + monto;
        return true;
    }
    
   
}
