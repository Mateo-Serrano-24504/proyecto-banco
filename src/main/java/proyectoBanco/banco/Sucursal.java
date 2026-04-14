package proyectoBanco.banco;

import proyectoBanco.cuentas.*;
import proyectoBanco.usuarios.CredencialesUsuario;

public class Sucursal {
    private final GestorCuentas gestorCuentas;
    private final GestorTransacciones gestorTransacciones;

    public Sucursal(
            GestorCuentas gestorCuentas,
            GestorTransacciones gestorTransacciones
        ) {
        this.gestorCuentas = gestorCuentas;
        this.gestorTransacciones = gestorTransacciones;
    }

    // Métodos de Cliente
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentas.obtenerCuenta(credenciales.usuario());
    }
    public boolean crearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        return this.gestorCuentas.crearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public boolean eliminarCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentas.eliminarCuenta(credenciales.usuario());
    }
    public boolean depositar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransacciones.manejarDeposito(credenciales.usuario(), cantidad);
    }
    public boolean retirar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransacciones.manejarRetiro(credenciales.usuario(), cantidad);
    }
    public boolean transferencia(CredencialesUsuario credenciales, String receptor, int cantidad) {
        return this.gestorTransacciones.manejarTransferencia(credenciales.usuario(), receptor, cantidad);
    }
}
