package proyectoBanco.gestorCuentas.comandos;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.usuarios.PerfilUsuario;

public class ComandoListar extends ComandoGestorCuenta {
    public ComandoListar(ServicioBanco servicioBanco, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioBanco, perfilUsuarioGestorCuentas);
    }

    @Override
    public void ejecutar() {
        var operacionesPendientes = super.servicioBanco.obtenerOperacionesPendientes(
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
