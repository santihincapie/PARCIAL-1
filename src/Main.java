import javax.swing.*;
import java.time.LocalDate;

public class Main {

    private static Devplus nuevaEmpresa;

    public static void main(String[] args) {
        nuevaEmpresa = new Devplus(1, "DevPlus", 890000234, "CRA 19#21-27 ESQUINA", "3214567890", "DevPlusAXM.co");
        int option = 0;

        do {

        /*ShowInput es quien abre la ventana emergen y parseInt vuelve el numero
        ingresado por el usuario a un INT

         */
            option = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al menú de DevPlus:" +
                    "\n 1. Registrar CLiente" +
                    "\n 2. Registrar Desarrollador" +
                    "\n 3. Registrar Proyecto" +
                    "\n 4. Consultar cliente por el número de telefono" +
                    "\n 5. Verificar si el número de telefono ingresado es perfecto" +
                    "\n 6. Calcular ingresos por una fecha especifica" +
                    "\n 0. Salir"));


            switch (option) {
                case 1:
                    solicitarInformacionCliente();
                    break;
                case 2:
                    solicitarInformacionDesarrollador();
                    break;
                case 3:
                    solicitarInformacionProyecto();
                    break;
                case 4:
                    solicitarTelefonoCliente();
                    break;
                case 5:
                    solicitarNumeroPerfecto();
                    break;
                case 6:
                    solicitarFechaIngresos();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "El  programa finalizó");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
//Significa: Mientras sea diferente a 0, repita el ciclo
        } while (option != 0);
    }

    private static void solicitarInformacionCliente() {
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID correspondiente al cliente"));
        String razonSocial = JOptionPane.showInputDialog("Introduce el nombre del cliente");
        int identificacion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la identificacion del cliente"));
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del cliente"));
        String email = JOptionPane.showInputDialog("Introduce el email del cliente");
        String pais = JOptionPane.showInputDialog("Introduce el pais  de procedencia del cliente");

        Cliente nuevoCliente = new Cliente(idCliente, razonSocial, identificacion, telefono, email, pais);
nuevaEmpresa.registrarCliente(nuevoCliente);
        JOptionPane.showMessageDialog(null,"Cliente registrado con exito");
    }

    private static void solicitarInformacionDesarrollador() {
        int codigoDesarrollador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del desarrollador"));
        String equipoTrabajo = JOptionPane.showInputDialog("Ingrese el equipo de trabajo al cual pertenece el desarrollador");
        double tarifaDia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por día del desarrollador"));
        int cantidadMax = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad máxima de proyectos que el desarrollador puede realizar simultaneamente "));

        Desarrollador nuevoDesarrollador = new Desarrollador(codigoDesarrollador, cantidadMax, tarifaDia, equipoTrabajo);
        nuevaEmpresa.registrarDesarollador(nuevoDesarrollador);
        JOptionPane.showMessageDialog(null, "Desarrollador registrado con exito");
    }

    private static void solicitarInformacionProyecto() {
        int codigoProyecto= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del proyecto"));
        String fechaSolicitudTexto = JOptionPane.showInputDialog("Ingrese la fecha de solicitacion del proyecto");
        String fechaInicioTexto = JOptionPane.showInputDialog("Ingrese la fecha de inicio del proyecto");
        String fechaEntregaTexto = JOptionPane.showInputDialog("Ingrese la fecha de entrega del proyecto");


    /*
     Este comando LocalDate.parse sirve para convertir el texto en una fecha real dentro de java, esto con
       el proposito de calcular los días
     */

        LocalDate fechaSolicitud = LocalDate.parse(fechaSolicitudTexto);
        LocalDate fechaInicio = LocalDate.parse(fechaInicioTexto);
        LocalDate fechaEntrega = LocalDate.parse(fechaEntregaTexto);

        Proyecto nuevoProyecto = new Proyecto(codigoProyecto, fechaSolicitud, fechaInicio, fechaEntrega);
nuevaEmpresa.registrarProyecto(nuevoProyecto);
        JOptionPane.showMessageDialog(null, "Proyecto registrado con exito");
    }


    private static void solicitarTelefonoCliente() {
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono a consultar");

        Cliente encontrado = nuevaEmpresa.consultarClienteTelefono(telefono);
        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "El telefono no existe");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente encontrado" + encontrado.getRazonSocial());
        }
    }

    private static void solicitarNumeroPerfecto() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero a verificar"));
        boolean esPerfecto = nuevaEmpresa.esNumeroPerfecto(numero);


        if (esPerfecto) {
            JOptionPane.showMessageDialog(null, "Es un numero perfecto");
        } else {
            JOptionPane.showMessageDialog(null, "No es un numero perfecto");
        }
    }

    private static void solicitarFechaIngresos() {
        String fechaTexto = JOptionPane.showInputDialog("Ingrese la fecha a consultar(AAAA-MM-DD):");
        LocalDate fecha = LocalDate.parse(fechaTexto);
        double ingresos = nuevaEmpresa.calcularIngresosFecha(fecha);

        JOptionPane.showMessageDialog(null,"Los ingresos correspondientes a la fecha ingresada son:" + ingresos);
    }
}