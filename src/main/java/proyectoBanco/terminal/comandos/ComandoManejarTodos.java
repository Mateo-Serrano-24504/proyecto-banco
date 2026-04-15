package proyectoBanco.terminal.comandos;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.usuarios.PerfilUsuario;

public class ComandoManejarTodos extends ComandoGestorCuenta {
    public ComandoManejarTodos(ServicioBanco servicioBanco, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioBanco, perfilUsuarioGestorCuentas);
    }

    @Override
    public void ejecutar() {
        var operacionesPendientes = super.servicioBanco.obtenerOperacionesPendientes(
                this.perfilUsuarioGestorCuentas.generarCredenciales()
        );
        for (int i = 0; i < operacionesPendientes.size(); i++) {
            this.servicioBanco.resolverOperacion(
                    this.perfilUsuarioGestorCuentas.generarCredenciales(),
                    0
            );
        }
    }
}
