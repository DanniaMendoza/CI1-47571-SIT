/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author usuario
 */
public class Tarjeta {
    
    private int Id_Tarjeta;
    private String CodigoTarjeta;
    private double Monto;
    private String Estado;
    private usuarios usuario;

    public Tarjeta(){
    }
    
    public Tarjeta(int Id_Tarjeta, String CodigoTarjeta, double Monto, String Estado, int ID_Usuario, usuarios usuario) {
        this.Id_Tarjeta = Id_Tarjeta;
        this.CodigoTarjeta = CodigoTarjeta;
        this.Monto = Monto;
        this.Estado = Estado;
        this.usuario = usuario;
    }

    public int getId_Tarjeta() {
        return Id_Tarjeta;
    }

    public void setId_Tarjeta(int Id_Tarjeta) {
        this.Id_Tarjeta = Id_Tarjeta;
    }

    public String getCodigoTarjeta() {
        return CodigoTarjeta;
    }

    public void setCodigoTarjeta(String CodigoTarjeta) {
        this.CodigoTarjeta = CodigoTarjeta;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(usuarios usuario) {
        this.usuario = usuario;
    }
    
    
   
   

    
}