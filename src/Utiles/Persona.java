/*
 * 
 */
package utiles;

import java.util.*;
import java.util.Calendar;

/**
 *
 */
public class Persona {
    private Nombre nom;
    private Rut rut;
    private char estadoCivil; //S, C, D, V
    private Fecha fecNac;
    private char genero;

    public Persona(){
        this.nom = new Nombre();
        this.rut = new Rut();
        this.fecNac = new Fecha();
        this.estadoCivil = ' ';
        this.genero = ' ';
    }
    
    public Persona(Nombre nom, Rut rut, Fecha fecNac, char genero, char estciv) {
        this.nom = nom;
        this.rut = rut;
        this.fecNac = fecNac;
        this.genero = genero;
        this.estadoCivil = estciv;
    }
    
    public Persona(Persona p){
        this.nom = new Nombre(p.nom);
        this.rut = new Rut(p.rut);
        this.fecNac = new Fecha(p.fecNac);
        this.genero = p.genero;
        this.estadoCivil = p.estadoCivil;
    }

    public Nombre getNom() {
        return nom;
    }

    public void setNom(Nombre nom) {
        this.nom = nom;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public Fecha getFecNac() {
        return fecNac;
    }

    public void setFecNac(Fecha fecNac) {
        this.fecNac = fecNac;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    public void setEstadoCivil(char estciv){
        this.estadoCivil = estciv;
    }
    
    public char getEstadoCivil(){
        return estadoCivil;
    }
    
    @Override
    public String toString(){
        String s = nom.toString() + '\n';
        s += "Rut: " + rut.toString() + '\n';
        s += "Fecha de nacimiento: " + fecNac.toString() + '\n' + "Genero: ";
        if(this.genero == 'F' || this.genero == 'f')
            s += "Femenino" + '\n';
        else
            s += "Masculino" + '\n' + "Estado civil: ";
        switch (this.estadoCivil){//S, C, D, V
            case 'S':
                s += "Soltero" + '\n';
                break;
            case 'C':
                s += "Casado" + '\n';
                break;
            case 'D':
                s += "Disponible" + '\n';
                break;
            case 'V':
                s += "Viudo" + '\n';
                break;
        }        
        return s;
    }    
    
}
