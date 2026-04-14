package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;

import java.util.HashMap;

public class GestorTransacciones {
    private final HashMap<String, Cuenta> cuentas;

    public GestorTransacciones(
            HashMap<String, Cuenta> cuentas
    ) {
        this.cuentas = cuentas;
    }

    public boolean manejarDeposito(String usuario, int saldo) {
        var cuenta = this.cuentas.get(usuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.depositar(saldo);
        return true;
    }
    public boolean manejarRetiro(String usuario, int saldo) {
        var cuenta = this.cuentas.get(usuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.retirar(saldo);
        return true;
    }
    public boolean manejarTransferencia(String usuario, String receptor, int saldo) {
        var cuentaEmisor = this.cuentas.get(usuario);
        var cuentaReceptor = this.cuentas.get(receptor);
        if (cuentaEmisor == null || cuentaReceptor == null) {
            return false;
        }
        return cuentaEmisor.transferir(cuentaReceptor, saldo);
    }
}
