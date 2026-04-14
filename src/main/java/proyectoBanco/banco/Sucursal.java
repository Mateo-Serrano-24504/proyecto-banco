package proyectoBanco.banco;

import proyectoBanco.administrador.Administrador;
import proyectoBanco.cuentas.*;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.HashMap;

public class Sucursal {
    private final CreadorCuenta creadorCuenta;
    private final HashMap<String, Cuenta> cuentasActivas;
    private Administrador administrador;

    public Sucursal(CreadorCuenta creadorCuenta) {
        this.creadorCuenta = creadorCuenta;
        this.cuentasActivas = new HashMap<>();
        this.administrador = null;
    }

    public void cambiarAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        return this.cuentasActivas.get(credenciales.usuario());
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        administrador.solicitarCrearCuenta(tipoCuenta, credenciales);
    }
    public void solicitarEliminarCuenta(CredencialesUsuario credenciales) {
        administrador.solicitarEliminarCuenta(credenciales);
    }

    public void crearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        var cuenta = this.creadorCuenta.crearCuenta(tipoCuenta, credenciales.usuario());
        this.cuentasActivas.put(credenciales.usuario(), cuenta);
    }
    public void eliminarCuenta(CredencialesUsuario credenciales) {
        this.cuentasActivas.remove(credenciales.usuario());
    }

    public boolean intentarHacerDeposito(int cantidad, CredencialesUsuario credencialesUsuario) {
        return this.cuentasActivas.get(credencialesUsuario.usuario()).depositar(cantidad);
    }
    public boolean intentarHacerRetiro(int cantidad, CredencialesUsuario credencialesUsuario) {
        return this.cuentasActivas.get(credencialesUsuario.usuario()).retirar(cantidad);
    }
    public boolean intentarHacerTransferencia(String receptor, int cantidad, CredencialesUsuario credenciales) {
        var cuentaEmisor = this.cuentasActivas.get(credenciales.usuario());
        var cuentaReceptor = this.cuentasActivas.get(receptor);
        if (cuentaEmisor == null || cuentaReceptor == null) {
            return false;
        }
        var pudoRetirar = cuentaEmisor.retirar(cantidad);
        if (pudoRetirar) {
            cuentaReceptor.depositar(cantidad);
        }
        return pudoRetirar;
    }
}
