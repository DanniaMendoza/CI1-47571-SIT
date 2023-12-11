package Entidades;

import java.util.Date;

public class ServiciosViaje {

    private int id_viaje;
    private int id_pasajero;
    private int id_conductor;
    private int id_ruta;
    private Date fecha;
    private String estadoviaje;
    private Float tarifa;

    public ServiciosViaje() {
    }

    public ServiciosViaje(int id_viaje, int id_pasajero, int id_conductor, int id_ruta, Date fecha, String estadoviaje, Float tarifa) {
        this.id_viaje = id_viaje;
        this.id_pasajero = id_pasajero;
        this.id_conductor = id_conductor;
        this.id_ruta = id_ruta;
        this.fecha = fecha;
        this.estadoviaje = estadoviaje;
        this.tarifa = tarifa;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadoviaje() {
        return estadoviaje;
    }

    public void setEstadoviaje(String estadoviaje) {
        this.estadoviaje = estadoviaje;
    }

    public Float getTarifa() {
        return tarifa;
    }

    public void setTarifa(Float tarifa) {
        this.tarifa = tarifa;
    }

}
