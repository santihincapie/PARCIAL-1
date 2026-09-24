import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Devplus {


    private int idEmpresa;
    private String nombreEmpresa;
    private int nit;
    private String direccion;
    private String telefono;
    private String paginaWeb;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Desarrollador> desarrolladores = new ArrayList<>();
    private List<Proyecto> proyectos = new ArrayList<>();


    Devplus(int idEmpresa, String nombreEmpresa, int nit, String direccion, String telefono, String paginaWeb) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;

    }

    public void registrarCliente(Cliente nuevoCliente) {
        clientes.add(nuevoCliente);
    }

    public void registrarDesarollador(Desarrollador nuevoDesarrollador) {
        desarrolladores.add(nuevoDesarrollador);
    }

    public void registrarProyecto(Proyecto nuevoProyecto) {
        proyectos.add(nuevoProyecto);
    }

    public Cliente consultarClienteTelefono(String telefono) {
        for (Cliente c : clientes) {
            // ojo: telefono en Cliente es int, aquí llega como String -> conviertes para comparar
            if (String.valueOf(c.getTelefono()).equals(telefono)) {
                return c;
            }
        }
        return null; // no encontrado
    }

    public boolean esNumeroPerfecto(int numero) {
        if (numero <= 0) return false;
        int sumaDivisores = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores == numero;
    }

    public double calcularIngresosFecha(LocalDate fecha) {
        double totalIngresos = 0;
        for (Proyecto p : proyectos) {
            // aqui depende de como tengas fechaEntrega/fechaInicio en Proyecto (String o LocalDate)
            // ejemplo si fechaEntrega es String "yyyy-MM-dd":
            if (p.getFechaEntrega().equals(fecha)) {
                totalIngresos += p.getValorTotal();
            }
        }
        return totalIngresos;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}



