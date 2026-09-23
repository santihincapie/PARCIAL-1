public class Desarrollador {


    private int codigoDesarrollador;
    private int cantidadProyectosSimultaneos;
    private double tarifaDia;
    private String equipoTrabajo;

    Desarrollador(int codigoDesarrollador, int cantidadProyectosSimultaneos, double tarifaDia, String equipoTrabajo) {
        this.codigoDesarrollador = codigoDesarrollador;
        this.cantidadProyectosSimultaneos= cantidadProyectosSimultaneos;
        this.tarifaDia = tarifaDia;
        this.equipoTrabajo = equipoTrabajo;


    }















    public int getCodigoDesarrollador() {
        return codigoDesarrollador;
    }

    public void setCodigoDesarrollador(int codigoDesarrollador) {
        this.codigoDesarrollador = codigoDesarrollador;
    }

    public int getCantidadProyectosSimultaneos() {
        return cantidadProyectosSimultaneos;
    }

    public void setCantidadProyectosSimultaneos(int cantidadProyectosSimultaneos) {
        this.cantidadProyectosSimultaneos = cantidadProyectosSimultaneos;
    }

    public double getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }
}
