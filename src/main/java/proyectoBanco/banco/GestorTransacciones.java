package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;

import java.util.HashMap;
import java.util.Map;

public class GestorTransacciones {
    private boolean manejarDepositoEnBdd(Map<String, Cuenta> cuentas, String usuario, int saldo) {
        var cuenta = cuentas.get(usuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.depositar(saldo);
        return true;
    }
    private boolean manejarRetiroEnBdd(Map<String, Cuenta> cuentas, String usuario, int saldo) {
        var cuenta = cuentas.get(usuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.retirar(saldo);
        return true;
    }
    private boolean manejarTransferenciaEnBdd(Map<String, Cuenta> cuentas, String usuario, String receptor, int saldo) {
        var cuentaEmisor = cuentas.get(usuario);
        var cuentaReceptor = cuentas.get(receptor);
        if (cuentaEmisor == null || cuentaReceptor == null) {
            return false;
        }
        return cuentaEmisor.transferir(cuentaReceptor, saldo);
    }

    public GestorTransacciones() {}

    public boolean manejarDeposito(String usuario, int saldo) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.manejarDepositoEnBdd(
                        bdd.cuentas, usuario, saldo
                )
        );
    }
    public boolean manejarRetiro(String usuario, int saldo) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.manejarRetiroEnBdd(
                        bdd.cuentas, usuario, saldo
                )
        );
    }
    public boolean manejarTransferencia(String usuario, String receptor, int saldo) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.manejarTransferenciaEnBdd(
                        bdd.cuentas, usuario, receptor, saldo
                )
        );
    }
}
