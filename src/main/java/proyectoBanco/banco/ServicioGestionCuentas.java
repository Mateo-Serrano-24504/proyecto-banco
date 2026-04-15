package proyectoBanco.banco;

import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.List;

public class ServicioGestionCuentas {
    private final GestorCuentas gestorCuentas;

    public ServicioGestionCuentas(GestorCuentas gestorCuentas) {
        this.gestorCuentas = gestorCuentas;
    }

    // Métodos de gestor de cuentas
    public boolean crearCuenta(CredencialesUsuario credenciales, TipoCuenta tipoCuenta) {
        return this.gestorCuentas.crearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public boolean eliminarCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentas.eliminarCuenta(credenciales.usuario());
    }
    public List<String> obtenerVistaOperacionesPendientes() {
        return this.gestorCuentas.obtenerVistaOperacionesPendientes();
    }
    public void resolverOperacion(int indice) {
        this.gestorCuentas.resolverOperacion(indice);
    }
}
