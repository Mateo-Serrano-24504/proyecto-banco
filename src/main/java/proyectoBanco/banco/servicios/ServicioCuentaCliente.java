package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorCuentas;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioCuentaCliente {
    private final GestorCuentas gestorCuentas;

    public ServicioCuentaCliente(GestorCuentas gestorCuentas) {
        this.gestorCuentas = gestorCuentas;
    }

    // Métodos de usuario
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentas.obtenerCuenta(credenciales.usuario());
    }
    public void solicitarCrearCuenta(CredencialesUsuario credenciales, TipoCuenta tipoCuenta) {
        this.gestorCuentas.solicitarCrearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public void solicitarEliminarCuenta(CredencialesUsuario credenciales) {
        this.gestorCuentas.solicitarEliminarCuenta(credenciales.usuario());
    }
}
