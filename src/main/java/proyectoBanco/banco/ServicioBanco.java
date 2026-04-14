package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioBanco {
    private final Sucursal sucursal;

    public ServicioBanco(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credencialesUsuario) {
        this.sucursal.solicitarCrearCuenta(tipoCuenta, credencialesUsuario);
    }
    public void solicitarEliminarCuenta(CredencialesUsuario credencialesUsuario) {
        this.sucursal.solicitarEliminarCuenta(credencialesUsuario);
    }

    public void refrescarPerfilUsuario() {
        // Por ahora no cambia...
    }
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credencialesUsuario) {
        return this.sucursal.obtenerEstadoCuenta(credencialesUsuario);
    }

    public boolean depositar(int cantidad, CredencialesUsuario credencialesUsuario) {
        return this.sucursal.intentarHacerDeposito(cantidad, credencialesUsuario);
    }
    public boolean retirar(int cantidad, CredencialesUsuario credencialesUsuario) {
        return this.sucursal.intentarHacerRetiro(cantidad, credencialesUsuario);
    }
    public boolean transferir(String receptor, int cantidad, CredencialesUsuario credencialesUsuario) {
        return this.sucursal.intentarHacerTransferencia(
                receptor,
                cantidad,
                credencialesUsuario
        );
    }
}
