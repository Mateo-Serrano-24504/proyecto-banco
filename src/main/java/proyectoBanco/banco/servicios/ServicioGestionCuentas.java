package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorCuentas;
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
    public void resolverOperacion(Integer codigo) {
        this.gestorCuentas.resolverOperacion(codigo);
    }
}
