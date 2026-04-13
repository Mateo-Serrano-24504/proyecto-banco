package proyectoBanco;

import proyectoBanco.administrador.Administrador;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.CuentaAhorro;
import proyectoBanco.cuentas.CuentaCorriente;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.HashMap;

public class Banco {
    private final HashMap<String, Cuenta> cuentas;
    private Administrador administrador;

    public Banco() {
        this.cuentas = new HashMap<>();
    }

    public void cambiarAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cuenta obtenerCuenta(String nombrePropietario) {
        return this.cuentas.get(nombrePropietario);
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, String nombrePropietario) {
        administrador.solicitarCrearCuenta(tipoCuenta, nombrePropietario);
    }
    public void crearCuentaCorriente(String nombrePropietario) {
        if (this.cuentas.containsKey(nombrePropietario)) {
            return;
        }
        this.cuentas.put(
                nombrePropietario,
                new CuentaCorriente(nombrePropietario, this)
        );
    }
    public void crearCuentaAhorro(String nombrePropietario) {
        if (this.cuentas.containsKey(nombrePropietario)) {
            return;
        }
        this.cuentas.put(
                nombrePropietario,
                new CuentaAhorro(nombrePropietario, this)
        );
    }

    public void solicitarEliminarCuenta(String nombrePropietario) {
        administrador.solicitarEliminarCuenta(nombrePropietario);
    }
    public void eliminarCuenta(String nombrePropietario) {
        this.cuentas.remove(nombrePropietario);
    }

    public boolean transferir(String emisor, String receptor, int cantidad) {
        var cuentaEmisor = this.cuentas.get(emisor);
        var cuentaReceptor = this.cuentas.get(receptor);
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
