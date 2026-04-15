package proyectoBanco.gestorCuentas;

import proyectoBanco.gestorCuentas.comandos.ComandoGestorCuenta;
import proyectoBanco.gestorCuentas.comandos.ComandoSalir;

public class Menu {
    private final ServicioComandoGestorCuentas servicioComandoGestorCuentas;

    Menu(ServicioComandoGestorCuentas servicioComandoGestorCuentas) {
        this.servicioComandoGestorCuentas = servicioComandoGestorCuentas;
    }

    private void mostrarTitulo() {
        System.out.println("Menu de gestor de cuentas\n");
        System.out.println("Escribe algunos de los siguientes comandos:");
        System.out.println(" 1. manejar");
        System.out.println(" 2. manejar <codigo>");
        System.out.println(" 3. listar");
        System.out.println(" 4. ayuda");
        System.out.println(" 5. salir");
    }

    public void ejecutar() {
        this.mostrarTitulo();
        ComandoGestorCuenta comando;
        while (true) {
            System.out.print("\n> ");
            comando = this.servicioComandoGestorCuentas.siguienteComando();
            if (comando instanceof ComandoSalir) {
                break;
            }
            if (comando == null) {
                System.out.println("Comando desconocido");
                continue;
            }
            comando.ejecutar();
        }
    }
}
