package proyectoBanco.gestorCuentas.comandos;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.usuarios.PerfilUsuario;

public class ComandoManejarTodos extends ComandoGestorCuenta {
    public ComandoManejarTodos(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
    }

    @Override
    public void ejecutar() {
        var operacionesPendientes = super.servicioGestorCuentas.obtenerVistaOperacionesPendientes(
                this.perfilUsuarioGestorCuentas.generarCredenciales()
        );
        for (int i = 0; i < operacionesPendientes.size(); i++) {
            this.servicioGestorCuentas.resolverOperacion(
                    this.perfilUsuarioGestorCuentas.generarCredenciales(),
                    0
            );
        }
    }
}
