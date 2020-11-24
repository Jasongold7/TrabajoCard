package com.example.creditcardform;

public class Tarjeta {
    private Integer id;
    private String nombre;
    private String apellido;
    private String nTarjeta;
    private String mes;
    private String anho;
    private String codigo;
    private String calle;
    private String ciudad;
    private String estado;
    private String codiP;
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getnTarjeta() {
        return nTarjeta;
    }

    public String getMes() {
        return mes;
    }

    public String getAnho() {
        return anho;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodiP() {
        return codiP;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setnTarjeta(String nTarjeta) {
        this.nTarjeta = nTarjeta;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodiP(String codiP) {
        this.codiP = codiP;
    }
    public boolean esVacio() {
        if (this.nombre.isEmpty() && this.apellido.isEmpty() && this.nTarjeta.isEmpty() && this.mes.isEmpty() && this.anho.isEmpty() && this.codigo.isEmpty() && this.calle.isEmpty() && this.ciudad.isEmpty() && this.estado.isEmpty() && this.codiP.isEmpty())
            return true;
        return false;
    }
    public boolean tarIgual(String repetir){
        if(this.nTarjeta.equals(repetir))
            return true;
        return false;
    }
}
