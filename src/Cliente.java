public class Cliente {

    private int idCliente;
    private String razonSocial;
    private int identificacion;
    private int telefono;
    private String email;
    private String paisProvidencia;



    Cliente(int idCliente, String razonSocial, int identificacion, int telefono, String email, String paisProvidencia) {
     this.idCliente = idCliente;
    this.razonSocial = razonSocial;
     this.identificacion = identificacion;
     this.telefono = telefono;
     this.email = email;
     this.paisProvidencia = paisProvidencia;
    }





















    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaisProvidencia() {
        return paisProvidencia;
    }

    public void setPaisProvidencia(String paisProvidencia) {
        this.paisProvidencia = paisProvidencia;
    }
}
