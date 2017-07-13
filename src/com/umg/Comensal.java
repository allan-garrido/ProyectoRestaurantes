package com.umg;

/**
 * Created by ALLAN GARRIDO on 12/07/2017.
 */
public class Comensal {

    private String nombre;
    private String apellidos;
    private  int cantVisistas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCantVisistas() {
        return cantVisistas;
    }

    public void setCantVisistas(int cantVisistas) {
        this.cantVisistas = cantVisistas;
    }

    public Comensal() {

    }

    public Comensal(String nombre, String apellidos, int cantVisistas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cantVisistas = cantVisistas;
    }


}
