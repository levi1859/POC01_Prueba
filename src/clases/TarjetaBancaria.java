/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Utiles.Rut;

/**
 *TarjetaBancaria sera un objeto comparable
 * @author 85605410
 */
public class TarjetaBancaria extends Tarjeta implements Comparable<TarjetaBancaria> {
    private String banco;
    private Cliente cliente;
    
    public TarjetaBancaria(){
        super(); //Tarjeta();
        banco = "Chile";
        cliente = new Cliente();  //crear cliente vacio
    }
    
     public TarjetaBancaria(String bco, Cliente c){
        super();    //Tarjeta ;
        
        banco = bco;
        cliente = new Cliente(c);
    }
    
    public TarjetaBancaria(int num,String bco, Cliente c){
        super(num);    //Tarjeta num;
        
        banco = bco;
        cliente = new Cliente(c);
    }
    
    public TarjetaBancaria(String bco, Rut r, String nom){
        super();
        banco=bco;
        cliente = new Cliente(r,nom);
    }
    
    public TarjetaBancaria(String bco, String r, String nom){
        super();
        banco=bco;
        cliente = new Cliente(new Rut(r),nom);
    }
    
    /*
    tb: String separados por coma
    */        
    public TarjetaBancaria(String tb){
        super();
        String[] datos = tb.split(","); //crea un arreglo con todos los datos spliteados
        this.setNumero(Integer.parseInt(datos[0]));     //cree la tarjeta y se le asigna el numero
        this.banco = datos[1];
        this.cliente = new Cliente(new Rut(datos[2]),datos[3]);
    }
    
    public TarjetaBancaria(TarjetaBancaria t){
        super(t.getNumero());
        banco = t.banco;
        cliente = new Cliente(t.cliente);
    }
    
    public TarjetaBancaria(Tarjeta t, String bco, Cliente c){
        super(t);
        banco = bco;
        cliente = new Cliente(c);
    }
    
    @Override
     public String toString(){      //la profe ocupo el de abajo yo lo hize con este porque se me dio la gana xD
       return  super.toString()+"," + banco +"," + cliente.toString();
     }
     
//     public String toString(){
//         StringBuilder s = new StringBuilder();
//         s.append(super.toString());
//         s.append(",");
//         s.append(banco);
//         s.append(",");
//         s.append(cliente);
//         return s.toString();
//     }

    @Override
     public boolean equals(Object obj){
         if(obj instanceof TarjetaBancaria){
             //convertir obj en TarjetaBancaria pos casting
             TarjetaBancaria t = (TarjetaBancaria)obj;  //casting poner entreparentesis el tipo de datos a convertir ya que si lo trabajo como objeto no tiene atributos(cliente, rut ,etc)
             return (this.getNumero() == t.getNumero()) &&
                     cliente.getRut().equals(t.getCliente().getRut());
         }
         return false;
     }
     
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //Implementar el método de la interface comparable<>
    @Override
    public int compareTo(TarjetaBancaria t){
        if (this.getNumero() == t.getNumero()){
               if (this.cliente.getRut().compareTo(t.cliente.getRut())== 0){ //lo comparo con == ya que es un numero un String seria con equals
            return 0;
            }
            else{
                return this.cliente.getRut().compareTo(t.cliente.getRut());   
            }
        }
        else{
            if(this.getNumero() > t.getNumero()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
     
    
}
