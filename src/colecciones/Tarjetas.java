
package colecciones;

import clases.Credito;
import clases.Debito;
import clases.TarjetaBancaria;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
import ordenamiento.OrdenarPorBancoNumeroNombre;


/**
 * 
 */
public class Tarjetas  {    //Hereda de la clase objec
    private ArrayList<TarjetaBancaria> tarjetero;
    
    public Tarjetas(){
        tarjetero = new ArrayList<>();        
    }    
    
    public Tarjetas(Tarjetas t){
        TarjetaBancaria tbb;
        tarjetero = new ArrayList<>();
        for (TarjetaBancaria tb: tarjetero){ //primero el tipo de dato mas una variable donde se guarda cada elemento mientras lo recorre y lo agrega al arraylist
             tbb= new TarjetaBancaria(tb);
             tarjetero.add(tbb);
        }
    }
    
    public Tarjetas(String archivo){
        tarjetero = new ArrayList<>(); 
        try{
                FileReader f = new FileReader(archivo);
                Scanner sf = new Scanner(f);
                String linea;
                String datos;
                while (sf.hasNextLine()){
                    linea = sf.nextLine();
                    char tipo = linea.charAt(0);
                    datos = linea.substring(2);  //me genera un String
                    if (tipo == 'C'){
                       Credito c = new Credito(datos); 
                       tarjetero.add(c);        //lo ingreso al tarjetero del arraylist
                    }
                    else{
                        Debito d = new Debito(datos);
                        tarjetero.add(d);
                    }
                }
                sf.close();
                f.close();
        }
         catch (IOException ex){
             JOptionPane.showMessageDialog(null,"Error al abrir archivo");
         }
    } 

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for( TarjetaBancaria t: tarjetero){
            s.append(t.toString()+ "\n");
        }
        return s.toString();
    }
    
    public boolean add(TarjetaBancaria t){
        return tarjetero.add(t);        //pregunta si esta vacio y retorna atrue agregandolo al tarjetero(es lo mismo que hacerlo con if
    }
    
    public boolean isEmpty(){
        return tarjetero.isEmpty();
    }
    
    public int size(){
        return tarjetero.size();
    }
    
    public TarjetaBancaria get (int i){
        if( i>= 0 && i < tarjetero.size()){
            return tarjetero.get(i);
        }        
        return null;
               
    }
    
    public boolean toSave(String archivo){
        String linea;
       try{
           FileWriter f = new FileWriter(archivo);  // no es , true ya que sobreescribo el archivo no escribo a continuacion
           PrintWriter pf= new PrintWriter(f);
           for ( TarjetaBancaria t : tarjetero){
               if( t  instanceof Credito){       //instanceof permite saber si un objeto pertenece a una determinada clase
                    linea = "C," + t.toString();
                }
               else {
                       linea = "D,"+ t.toString();
                }
               pf.println(linea);
           }
           
           pf.close();
           f.close();
           return true;
       }
       catch(IOException ex) {
           JOptionPane.showMessageDialog(null,"Error al abrir archivo");
           return false;
       }
    }
    
    public boolean remove(TarjetaBancaria t){
        if (tarjetero.contains(t)){
            return tarjetero.remove(t);
        }
        return false;
    }
    
    public boolean contains(TarjetaBancaria t ){        //patra no tener que buscar uno por uno
        return tarjetero.contains(t);
    }
    
    public int totalTC(){   //TC = tarjeta de credito
        int c = 0;
        for( TarjetaBancaria t : tarjetero){
            if ( t instanceof Credito){
                c++;
            }
        }
        return c;
    }
    
    public int totalTD(){   //TC = tarjeta de debito
        int c = 0;
        for( TarjetaBancaria t : tarjetero){
            if ( t instanceof Debito){
                c++;
            }
        }
        return c;
    }
    
    public int totalTC(String banco){   
        int c = 0;
        for( TarjetaBancaria t : tarjetero){
            if ( t instanceof Credito && t.getBanco().equals(banco)){       // equals para comparar objetos siempre ya que == es para referencias
                c++;
            }
        }
        return c;
    }
    
    public int totalTD(String banco){  
        int c = 0;
        for( TarjetaBancaria t : tarjetero){
            if ( t instanceof Debito && t.getBanco().equals(banco)){
                c++;
            }
        }
        return c;
    }
    
    public double nomtoTotalgastoNacional(){
        double tot=0.0;
        for (TarjetaBancaria t : tarjetero){
            if (t instanceof Credito){
               // tot = tot + t.getGastoNacional(); //no se puede asi ya que java compila el metodo que este definido en la clase de referencia y en este caso es tb no credito
                Credito tc = (Credito)t;    //devo convertirlo en el objeto especifico para poder utilizar sus metodos
                tot = tot + tc.getGastoNacional();
            }
        }
        return tot;
    }
    
    public boolean saldoTotalTD(){
        double tota = 0.0;
        for(TarjetaBancaria t: tarjetero){
            if(t instanceof Debito){
                Debito td = (Debito)t;
                tota = tota + td.getSaldo();
            }
        }
        return false;
    }
    
    // La clase de la referencia debe saer comparable
    public void ordenarPorNumeroRut(){
        Collections.sort(tarjetero);
    }
    
    public void ordenarPorBancoNumeroNombre(){
//        Collections.sort(tarjetero);
        Collections.sort(tarjetero,new OrdenarPorBancoNumeroNombre());
    }
    
}
