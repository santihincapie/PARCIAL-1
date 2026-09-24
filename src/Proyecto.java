import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Proyecto {


    private int codigoProyecto;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;


    // Con otras clases
    private list<Desarrollador> desarrolladores;
    private list<Servicio> servicios;

    Proyecto(LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega) {
        this.codigoProyecto = codigoProyecto;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.desarrolladores= new ArrayList<>();
        this.servicios= new ArrayList<>();


    }




    public void cambiarEstadoProyecto(EstadoProyecto nuevoEstado) {
        this.estado=nuevoEstado;


        switch (nuevoEstado) {
            case Confirmado:
                for(Desarrollador d: this.desarrollador){
                    d.actualizarDisponibilidadDesarrollador(EstadoDesarrollador.Ocupado)
                }
                break;

            case En_Curso:
                for (Desarrollador d: this.desarrollador){
                    d.actualizarDisponibilidadDesarrollador(EstadoDesarrollador.Asignado)
                }
                break;

            case Finalizado:
                for (Desarrollador d: this.desarrollador){
                    d.actualizarDisponibilidadDesarrollador(EstadoProyecto.Disponible)
                }
                break;
            case Cancelado:
                for(Desarrollador d: this.desarrollador){
                    d.actualizarDisponibilidadDesarrollador(EstadoDesarrollador.Disponible)
                }
                break;
            case Pendiente:
                break;
        }
        }

        public double calcularValorTotal(){
        double total=0;
        for(Desarrollador d: this.desarrollador) {
            total = total + (d.getTarifaDia() * this.calcularDiasDuracion());
        }
            for(Servicio s: this.servicios){
                total= total + s.getPrecio();
            }

            this.valorTotal = total;
            return total;

        }


//esto es para saber la diferencia de dias entre dos fechas
    private long calcularDiasDeDuracion() {
        return ChronoUnit.DAYS.between(this.fechaInicio, this.fechaEntrega);
    }








    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}



