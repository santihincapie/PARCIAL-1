import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

    public class Proyecto {


        private int codigoProyecto;
        private LocalDate fechaSolicitud;
        private LocalDate fechaInicio;
        private LocalDate fechaEntrega;
        private String nombreProyecto;

        // Con otras clases
        private List<Desarrollador> desarrolladores;
        private List<Servicio> servicios;
        private EstadoProyecto estado;
        private double valorTotal;
        private MetodoPago metodoPago;


        public Proyecto(int codigoProyecto, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega) {
            this.codigoProyecto = codigoProyecto;
            this.fechaSolicitud = fechaSolicitud;
            this.fechaInicio = fechaInicio;
            this.fechaEntrega = fechaEntrega;
            this.estado = EstadoProyecto.Pendiente;
            this.desarrolladores = new ArrayList<>();
            this.servicios = new ArrayList<>();
        }




        public void cambiarEstadoProyecto(EstadoProyecto nuevoEstado) {
            this.estado=nuevoEstado;


            switch (nuevoEstado) {
                case Confirmado:
                    for(Desarrollador d: this.desarrolladores){
                        d.actualizarDisponibilidadDesarrollador(EstadoDesarrollador.Ocupado);
                    }
                    break;

                case En_Curso:
                    for (Desarrollador d: this.desarrolladores){
                        d.actualizarDisponibilidadDesarrollador(EstadoDesarrollador.Asignado);
                    }
                    break;

                case Finalizado:
                    for (Desarrollador d: this.desarrolladores){
                        d.actualizarDisponibilidadDesarrollador(EstadoDesarrollador.Disponible);
                    }
                    break;
                case Cancelado:
                    for(Desarrollador d: this.desarrolladores){
                        d.actualizarDisponibilidadDesarrollador(EstadoDesarrollador.Disponible);
                    }
                    break;
                case Pendiente:
                    break;
            }
            }

            public double calcularValorTotal(){
            double total=0;
            for(Desarrollador d: this.desarrolladores) {
                total = total + (d.getTarifaDia() * this.calcularDiasDeDuracion());
            }
                for(Servicio s: this.servicios){
                    total= total + s.getPrecioServicio();
                }

                this.valorTotal = total;
                return total;

            }

        public MetodoPago getMetodoPago() {
            return metodoPago;
        }

        public void setMetodoPago(MetodoPago metodoPago) {
            this.metodoPago = metodoPago;
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

        public String getNombreProyecto() {
            return nombreProyecto;
        }

        public void setNombreProyecto(String nombreProyecto) {
            this.nombreProyecto = nombreProyecto;
        }
        public EstadoProyecto getEstado() {
            return estado;
        }

        public void setEstado(EstadoProyecto estado) {
            this.estado = estado;
        }

        public List<Desarrollador> getDesarrolladores() {
            return desarrolladores;
        }

        public List<Servicio> getServicios() {
            return servicios;
        }
    }



