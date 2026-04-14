package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.Cuenta;

public class Cliente extends Usuario {
    private Cuenta vistaCuenta;

    public Cliente(ServicioBanco servicioBanco, CredencialesUsuario credencialesUsuario) {
        super(servicioBanco, credencialesUsuario);
        this.vistaCuenta = null;
    }

    public void actualizarVistaCuenta() {
        this.vistaCuenta = this.servicioBanco.obtenerEstadoCuenta(super.credencialesUsuario);
    }
    public boolean depositar(int cantidad) {
        return this.servicioBanco.depositar(cantidad, super.credencialesUsuario);
    }
    public boolean retirar(int cantidad) {
        return this.servicioBanco.retirar(cantidad, super.credencialesUsuario);
    }
    public boolean transferir(String receptor, int cantidad) {
        return this.servicioBanco.transferir(receptor, cantidad, super.credencialesUsuario);
    }
    public void verEstadoCuenta() {
        if (this.vistaCuenta == null) {
            return;
        }
        this.vistaCuenta.verBalance();
    }
}
