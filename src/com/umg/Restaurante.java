package com.umg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 12/07/2017.
 */
public class Restaurante {

    private String Nombre;
    private String Direccion;
    private int cantEmpleados;
    private int cantMaxComenzales;
    private boolean aceptaNinos;
    private int categoria;

    private List<Comenzal> comenzales;

    public Restaurante() {
        comenzales = new ArrayList<>();
    }

    public void setComenzales(List<Comenzal> tmpSet) {
        comenzales = tmpSet;
    }

    public void anadirComenzal(Comenzal tempC) {
        comenzales.add(tempC);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public int getCantMaxComenzales() {
        return cantMaxComenzales;
    }

    public void setCantMaxComenzales(int cantMaxComenzales) {
        this.cantMaxComenzales = cantMaxComenzales;
    }

    public boolean isAceptaNinos() {
        return aceptaNinos;
    }

    public void setAceptaNinos(boolean aceptaNinos) {
        this.aceptaNinos = aceptaNinos;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
