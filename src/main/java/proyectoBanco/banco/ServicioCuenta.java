package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioCuenta {
    private final GestorCuentas gestorCuentas;

    public ServicioCuenta(GestorCuentas gestorCuentas) {
        this.gestorCuentas = gestorCuentas;
    }

    // Métodos de usuario
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentas.obtenerCuenta(credenciales.usuario());
    }
    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        this.gestorCuentas.solicitarCrearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public void solicitarEliminarCuenta(CredencialesUsuario credenciales) {
        this.gestorCuentas.solicitarEliminarCuenta(credenciales.usuario());
    }
}
