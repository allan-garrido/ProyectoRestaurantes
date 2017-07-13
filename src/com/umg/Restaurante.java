package com.umg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALLAN GARRIDO on 12/07/2017.
 */
public class Restaurante {

    private String Nombre;
    private String Direccion;
    private int cantEmpleados;
    private int cantMaxComenzales;
    private boolean aceptaNinos;
    private int categoria;

    private List<Comensal> comenzales;

    public List<Comensal> getComenzales() {
        return comenzales;
    }

    public Restaurante() {
        comenzales = new ArrayList<>();
    }

    public void setComenzales(List<Comensal> tmpSet) {
        comenzales = tmpSet;
    }

    public void anadirComenzal(Comensal tempC) {
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

    public Restaurante(String nombre, String direccion, int cantEmpleados, int cantMaxComenzales, boolean aceptaNinos, int categoria, List<Comensal> comenzales) {
        Nombre = nombre;
        Direccion = direccion;
        this.cantEmpleados = cantEmpleados;
        this.cantMaxComenzales = cantMaxComenzales;
        this.aceptaNinos = aceptaNinos;
        this.categoria = categoria;
        this.comenzales = comenzales;

        comenzales = new ArrayList<>();
    }

    public float calcularImpuesto(){
        float resultado = categoria*cantMaxComenzales;
        if(aceptaNinos) return  resultado/3;
        return  resultado;
    }

    public Comensal clienteVIP(){
        int cantVisitas=0;
        Comensal vip= new Comensal();

        for (Comensal c:comenzales
             ) {
            if(c.getCantVisistas()>cantVisitas) {
                cantVisitas=c.getCantVisistas();
                vip=c;
            }
            }
        return vip;
        }
}
