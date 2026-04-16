package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;

import java.util.Map;

public class GestorTransacciones {
    public GestorTransacciones() {}

    public boolean manejarDeposito(Map<String, Cuenta> cuentas, String usuario, int saldo) {
        var cuenta = cuentas.get(usuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.depositar(saldo);
        return true;
    }
    public boolean manejarRetiro(Map<String, Cuenta> cuentas, String usuario, int saldo) {
        var cuenta = cuentas.get(usuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.retirar(saldo);
        return true;
    }
    public boolean manejarTransferencia(Map<String, Cuenta> cuentas, String usuario, String receptor, int saldo) {
        var cuentaEmisor = cuentas.get(usuario);
        var cuentaReceptor = cuentas.get(receptor);
        if (cuentaEmisor == null || cuentaReceptor == null) {
            return false;
        }
        return cuentaEmisor.transferir(cuentaReceptor, saldo);
    }
}
