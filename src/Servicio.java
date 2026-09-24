public class Servicio {

 //Atributos
    private int codigoServicio;
    private String nombreServicio;
    private String descripcionServicio;
    private double precioServicio;
    private boolean disponibilidad;


    Servicio(int codigoServicio, String nombreServicio, String descripcionServicio, double precioServicio) {
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.precioServicio = precioServicio;
        this.disponibilidad = true;
    }
    /* Primero dice "No esta disponible"?
    Inicialmente ESTÁ DISPONIBLE, entonces por eso arroja false porque es una afirmacion false
    luego de tener el valor FALSE, vuelve a afirmar lo mismo, siento esto verdadero que no esta disponible
    retorna true
     */
public boolean cambiarDisponibilidad(){
    if(!this.disponibilidad)  this.disponibilidad = true;
        else{
            this.disponibilidad = false;
        }
        return disponibilidad;
    }
}


    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
