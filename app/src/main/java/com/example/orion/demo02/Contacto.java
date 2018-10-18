package com.example.orion.demo02;

public class Contacto {
    private int codigo;
    private String nombre;
    private String alias;
    private String telefono;

    @Override
    public String toString()
    {
        return alias+" - "+telefono;
    }

    public Contacto(int codigo, String nombre, String alias, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.alias = alias;
        this.telefono = telefono;
    }
    public Contacto(String nombre, String alias, String telefono) {
        this.nombre = nombre;
        this.alias = alias;
        this.telefono = telefono;
    }
    public Contacto() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
