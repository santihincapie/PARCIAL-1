import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Desarrollador {


    private int codigoDesarrollador;
    private int cantidadProyectosSimultaneos;
    private double tarifaDia;
    private String equipoTrabajo;

    private EstadoDesarrollador estado;
    private NivelDesarrollador nivel;

    private List<Proyecto> proyectosAsignados;

    Desarrollador(int codigoDesarrollador, int cantidadProyectosSimultaneos, double tarifaDia, String equipoTrabajo) {
        this.codigoDesarrollador = codigoDesarrollador;
        this.cantidadProyectosSimultaneos= cantidadProyectosSimultaneos;
        this.tarifaDia = tarifaDia;
        this.equipoTrabajo = equipoTrabajo;
        this.estado = EstadoDesarrollador.Disponible; // estado inicial por defecto
        this.proyectosAsignados = new ArrayList<>();


    }




    public boolean disponibilidadDesarrollador(String fechaInicio, String fechaFin) {
        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);

        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin.");
        }

        if (estado == EstadoDesarrollador.Ocupado|| estado == EstadoDesarrollador.En_Capacitacion) {
            return false;
        }

        return proyectosAsignados.size() < cantidadProyectosSimultaneos;
    }

    /**
     * Actualiza el estado de disponibilidad del desarrollador.
     */
    public void actualizarDisponibilidadDesarrollador(EstadoDesarrollador nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Desarrollador #" + codigoDesarrollador
                + " actualizo su estado a: " + nuevoEstado);
    }

    @Override
    public String toString() {
        return "Desarrollador{" +
                "codigoDesarrollador=" + codigoDesarrollador +
                ", cantidadProyectosSimultaneos=" + cantidadProyectosSimultaneos +
                ", tarifaDia=" + tarifaDia +
                ", equipoTrabajo='" + equipoTrabajo + '\'' +
                ", estado=" + estado +
                ", nivel=" + nivel +
                '}';
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
