package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.cuentas.TipoCuenta;

public class UsuarioGestorCuentas extends Usuario {
    private final ServicioGestorCuentas servicioGestorCuentas;

    public UsuarioGestorCuentas(PerfilUsuario perfilUsuario, ServicioGestorCuentas servicioGestorCuentas) {
        super(perfilUsuario);
        this.servicioGestorCuentas = servicioGestorCuentas;
    }

    public boolean crearCuenta(PerfilUsuario perfilUsuario, TipoCuenta tipoCuenta) {
        return this.servicioGestorCuentas.crearCuenta(super.perfilUsuario.generarCredenciales(), tipoCuenta);
    }
    public boolean eliminarCuenta(PerfilUsuario perfilUsuario) {
        return this.servicioGestorCuentas.eliminarCuenta(super.perfilUsuario.generarCredenciales());
    }
    public void verOperacionesPendientes() {
        var operacionesPendientes = this.servicioGestorCuentas.obtenerVistaOperacionesPendientes(
                super.perfilUsuario.generarCredenciales()
        );
        if (operacionesPendientes == null) {
            return;
        }
        System.out.println("\nOperaciones pendientes:");
        for (var operacion: operacionesPendientes) {
            System.out.println(operacion);
        }
    }
    public boolean resolverOperacion(int indice) {
        this.servicioGestorCuentas.resolverOperacion(super.perfilUsuario.generarCredenciales(), indice);
        return true;
    }
}
