package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioCliente extends ServicioProtegido {
    private final ServicioCuentaCliente servicioCuentaCliente;
    private final ServicioTransaccion servicioTransaccion;

    public ServicioCliente(
            GestorUsuarios gestorUsuarios,
            ServicioCuentaCliente servicioCuentaCliente,
            ServicioTransaccion servicioTransaccion
    ) {
        super(gestorUsuarios);
        this.servicioCuentaCliente = servicioCuentaCliente;
        this.servicioTransaccion = servicioTransaccion;
    }

    // Operaciones de cuentas
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        if (super.credencialesInvalidas(credenciales)) {
            return null;
        }
        return this.servicioCuentaCliente.obtenerEstadoCuenta(credenciales);
    }
    public boolean solicitarCrearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        this.servicioCuentaCliente.solicitarCrearCuenta(tipoCuenta, credenciales);
        return true;
    }
    public boolean solicitarEliminarCuenta(CredencialesUsuario credenciales) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        this.servicioCuentaCliente.solicitarEliminarCuenta(credenciales);
        return true;
    }

    // Operaciones de transacción
    public boolean depositar(CredencialesUsuario credenciales, int cantidad) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioTransaccion.depositar(credenciales, cantidad);
    }
    public boolean retirar(CredencialesUsuario credenciales, int cantidad) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioTransaccion.retirar(credenciales, cantidad);
    }
    public boolean transferir(CredencialesUsuario credenciales, String receptor, int cantidad) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioTransaccion.transferir(credenciales, receptor, cantidad);
    }
}
