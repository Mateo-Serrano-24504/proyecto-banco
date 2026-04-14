package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;

public class GestorTransacciones extends Usuario {
    public GestorTransacciones(ServicioBanco servicioBanco, CredencialesUsuario credencialesUsuario) {
        super(servicioBanco, credencialesUsuario);
    }

    public boolean manejarDeposito(CredencialesUsuario credencialesUsuario, int saldo) {
        return false;
    }
    public boolean manejarRetiro(CredencialesUsuario credencialesUsuario, int saldo) {
        return false;
    }
    public boolean manejarTransferencia(CredencialesUsuario credencialesUsuario, String receptor, int saldo) {
        return false;
    }
}
