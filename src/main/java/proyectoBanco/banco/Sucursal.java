package proyectoBanco.banco;

import proyectoBanco.administrador.Administrador;
import proyectoBanco.cuentas.*;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.HashMap;

public class Sucursal {
    private final CreadorCuenta creadorCuenta;
    private final HashMap<String, Cuenta> cuentasActivas;
    private Administrador administrador;

    public Sucursal(Administrador administrador, CreadorCuenta creadorCuenta) {
        this.creadorCuenta = creadorCuenta;
        this.cuentasActivas = new HashMap<>();
        this.administrador = administrador;
    }

    public void cambiarAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        return this.cuentasActivas.get(credenciales.usuario());
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        administrador.solicitarCrearCuenta(tipoCuenta, credenciales.usuario());
    }
    public void solicitarEliminarCuenta(CredencialesUsuario credenciales) {
        administrador.solicitarEliminarCuenta(credenciales.usuario());
    }

//    public void crearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
//        var cuenta = this.creadorCuenta.crearCuenta(tipoCuenta, credenciales.usuario(), this);
//        this.cuentasActivas.put(credenciales.usuario(), cuenta);
//    }
    public void eliminarCuenta(CredencialesUsuario credenciales) {
        this.cuentasActivas.remove(credenciales.usuario());
    }

    public boolean transferir(CredencialesUsuario credenciales, String receptor, int cantidad) {
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
