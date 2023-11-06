package Entidades;


public class transporte {
   private int id_Vehiculo;
    private usuarios id_Conductor;
    private String marca;
    private String modelo;
    private int anio;
    private String numeroPlaca;
    private String estadoMantenimiento;
    private boolean estado;

    public transporte() {
    }

    public transporte(int id_Vehiculo, usuarios id_Conductor, String marca, String modelo, int anio, String numeroPlaca, String estadoMantenimiento, boolean estado) {
        this.id_Vehiculo = id_Vehiculo;
        this.id_Conductor = id_Conductor;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.numeroPlaca = numeroPlaca;
        this.estadoMantenimiento = estadoMantenimiento;
        this.estado = estado;
    }

    public int getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public usuarios getId_Conductor() {
        return id_Conductor;
    }

    public void setId_Conductor(usuarios id_Conductor) {
        this.id_Conductor = id_Conductor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getEstadoMantenimiento() {
        return estadoMantenimiento;
    }

    public void setEstadoMantenimiento(String estadoMantenimiento) {
        this.estadoMantenimiento = estadoMantenimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
