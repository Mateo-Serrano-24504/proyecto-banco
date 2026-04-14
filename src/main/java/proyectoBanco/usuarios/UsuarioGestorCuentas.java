package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;

public class UsuarioGestorCuentas extends Usuario {
    public UsuarioGestorCuentas(ServicioBanco servicioBanco, CredencialesUsuario credencialesUsuario) {
        super(servicioBanco, credencialesUsuario);
    }

    public void verOperacionesPendientes() {
        var operacionesPendientes = this.servicioBanco.obtenerOperacionesPendientes(this.credencialesUsuario);
        if (operacionesPendientes == null) {
            return;
        }
        System.out.println("\nOperaciones pendientes:");
        for (var operacion: operacionesPendientes) {
            System.out.println(operacion);
        }
    }
    public boolean resolverOperacion(int indice) {
        return this.servicioBanco.resolverOperacion(this.credencialesUsuario, indice);
    }
}
