package proyectoBanco.banco.servicios;

import proyectoBanco.banco.concurrencia.GestorCuentasConcurrente;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioCuentaCliente {
    private final GestorCuentasConcurrente gestorCuentasConcurrente;

    public ServicioCuentaCliente(GestorCuentasConcurrente gestorCuentasConcurrente) {
        this.gestorCuentasConcurrente = gestorCuentasConcurrente;
    }

    // Métodos de usuario
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentasConcurrente.obtenerCuenta(credenciales.usuario());
    }
    public void solicitarCrearCuenta(CredencialesUsuario credenciales, TipoCuenta tipoCuenta) {
        this.gestorCuentasConcurrente.solicitarCrearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public void solicitarEliminarCuenta(CredencialesUsuario credenciales) {
        this.gestorCuentasConcurrente.solicitarEliminarCuenta(credenciales.usuario());
    }
}
