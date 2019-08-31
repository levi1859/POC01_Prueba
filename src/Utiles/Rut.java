package Utiles;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Representa el RUT o RUN.
 * clase Rut sea comparable
 * @author NVA
 */
public class Rut implements Comparable<Rut> {
    private int rut;
    private char dv;
    
    /**
     * Costructor por defecto
     */
    public Rut() {
        rut=0;
        dv='0';
    }
    /**
     * Constructor que recibe un String con formato "dddddddd-c"
     * @param rt 
     */
    public Rut(String rt){ //"79733720-K"
        
        int largo= rt.length();     
        int num= Integer.parseInt(rt.substring(0, largo-2));
        
        rut= num;
        dv= Character.toUpperCase(rt.charAt(largo-1));
        char dvc= calculaDv();
        
        if (dv!=dvc)
        {
               //System.out.println("RUT invalido");
               this.rut=0;
               this.dv='0';
        }
    }
    /**
     * Constructor recibe como parámetro el rut SIN dígito verificador.
     * @param num 
     */
    public Rut(int num) { //797333720
        rut= num;       
        dv= calculaDv();
    }
    /**
     * Constructor que recibe el rut separado en la parte numérica y el dígito verificador
     * @param num:  Parte entera
     * @param d : Dígito verificador
     */
    public Rut(int num, char d) {
        rut= num;
        dv= Character.toUpperCase(d);
        char dvc= calculaDv();
        
        if (dvc!=dv){
               //System.out.println("RUT invalido");
               this.rut=0;
               this.dv='0';
        }
    }
    /**
     * Constructor de copia
     * @param r : Objeto de la clase Rut.
     */
    public Rut(Rut r){
        rut=r.rut;
        dv= r.dv;
    }  
    public boolean esValido(){
        return rut!=0;
    }
    public void setRut(String rt){
        int num= rut;
        char dvr= dv;
        
        int largo= rt.length();     
        int rut= Integer.parseInt(rt.substring(0, largo-2));
        
        int dv= Character.toUpperCase(rt.charAt(largo-1));
        char dvc= calculaDv();
        
        if (dv!=dvc)
        {
               //System.out.println("RUT invalido");
               this.rut=num;
               this.dv=dvr;
        } 
    } 
    public String getRut(){
        return rut+"-"+dv;
    }   
    public String toString(){
        return rut+"-"+dv;
    }  
    public int getNumRut() {
        return rut;
    } 
    public char getDv(){
        
        return dv;
    }    
    public void listar(){
        System.out.println(rut+"-"+dv);
    }
    /**
     * Sobreescritura método equals. Heredado de la clase Object.
     * @param r
     * @return 
     */
    public boolean equals(Rut r){
        if (rut==r.rut && dv==r.dv)
           return true;
        else
           return false;
    }
    private char calculaDv() {
        int factor=2;
        int suma=0;
        int dig;
        char dvr;
        int num= rut;
        
        while (num!=0)
        {
            dig= num%10;
            suma= suma + dig*factor;
            factor++;
            if (factor >7)
               factor=2;
            num= num/10;
        }
        
        int digito = 11 - suma%11;
        if (digito==10)
          dvr= 'K';
        else
           if (digito==11)
              dvr='0';
           else
              dvr= (char)(digito + 48);
      
        return dvr;
    }
    
    // Implementar el método de la interface comparable
    @Override
    public int compareTo(Rut r){
        if( rut ==r.rut)
            return 0;
        else
            if(rut<r.rut)
                return -1;
            else
                return 1;  
    }
}

