import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Proyecto {


    private int codigoProyecto;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
private double valorTotal;

    // Con otras clases
    private List<Desarrollador> desarrolladores;
    private List<Servicio> servicios;
    private EstadoProyecto estado;

  public  Proyecto(int codigoProyecto, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega) {
        this.codigoProyecto = codigoProyecto;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.desarrolladores= new ArrayList<>();
        this.servicios= new ArrayList<>();
    }

    public void cambiarEstadoProyecto(EstadoProyecto nuevoEstado) {
        this.estado = nuevoEstado;


        switch (nuevoEstado) {
            case Confirmado:
                for(Desarrollador d: this.desarrolladores){
                    d.actualizarDisponibilidad(EstadoDesarrollador.Ocupado);
                }
                break;

            case En_Curso:
                for (Desarrollador d: this.desarrolladores){
                    d.actualizarDisponibilidad(EstadoDesarrollador.Asignado);
                }
                break;

            case Finalizado:
                for (Desarrollador d: this.desarrolladores){
                    d.actualizarDisponibilidad(EstadoDesarrollador.Disponible);
                }
                break;
            case Cancelado:
                for(Desarrollador d: this.desarrolladores){
                    d.actualizarDisponibilidad(EstadoDesarrollador.Disponible);
                }
                break;
            case Pendiente:
                break;
        }
        }

        public double calcularValorTotal(){
        double total = 0;
        for(Desarrollador d: this.desarrolladores) {
            total = total + (d.getTarifaDia() * this.calcularDiasDuracion());
        }
            for(Servicio s: this.servicios){
                total = total + s.getPrecio();
            }

            this.valorTotal = total;
            return total;

        }
//esto es para saber la diferencia de dias entre dos fechas
    private long calcularDiasDuracion() {
        return ChronoUnit.DAYS.between(this.fechaInicio, this.fechaEntrega);
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}



