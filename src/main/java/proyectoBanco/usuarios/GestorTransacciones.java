package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.Cuenta;

import java.util.HashMap;

public class GestorTransacciones extends Usuario {
    private HashMap<CredencialesUsuario, Cuenta> cuentas;

    public GestorTransacciones(ServicioBanco servicioBanco, CredencialesUsuario credencialesUsuario) {
        super(servicioBanco, credencialesUsuario);
        this.cuentas = new HashMap<>();
    }

    public boolean manejarDeposito(CredencialesUsuario credencialesUsuario, int saldo) {
        var cuenta = this.cuentas.get(credencialesUsuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.depositar(saldo);
        return true;
    }
    public boolean manejarRetiro(CredencialesUsuario credencialesUsuario, int saldo) {
        var cuenta = this.cuentas.get(credencialesUsuario);
        if (cuenta == null) {
            return false;
        }
        cuenta.retirar(saldo);
        return true;
    }
    public boolean manejarTransferencia(CredencialesUsuario credencialesUsuario, String receptor, int saldo) {
        return false;
    }
}
