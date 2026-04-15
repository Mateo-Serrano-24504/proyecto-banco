package proyectoBanco.gestorCuentas.comandos;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.usuarios.PerfilUsuario;

public class ComandoListar extends ComandoGestorCuenta {
    public ComandoListar(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
    }

    @Override
    public void ejecutar() {
        var operacionesPendientes = super.servicioGestorCuentas.obtenerVistaOperacionesPendientes(
                this.perfilUsuarioGestorCuentas.generarCredenciales()
        );
        if (operacionesPendientes.isEmpty()) {
            System.out.println("Sin operaciones pendientes\n");
        } else {
            System.out.println("Operaciones pendientes:");
        }
        for (var operacion : operacionesPendientes) {
            System.out.println(operacion);
        }
    }
}
