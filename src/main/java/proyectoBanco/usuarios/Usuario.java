package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

public class Usuario {
    private PerfilUsuario perfilUsuario;
    private final ServicioBanco servicioBanco;
    private Cuenta vistaCuenta;

    public Usuario(PerfilUsuario perfilUsuario, ServicioBanco servicioBanco) {
        this.perfilUsuario = perfilUsuario;
        this.servicioBanco = servicioBanco;
        this.vistaCuenta = null;
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta) {
        this.servicioBanco.solicitarCrearCuenta(
                tipoCuenta,
                this.perfilUsuario.generarCredenciales()
        );
    }
    public void solicitarEliminarCuenta() {
        this.servicioBanco.solicitarEliminarCuenta(this.perfilUsuario.generarCredenciales());
    }

    public void actualizarCuenta() {
        this.vistaCuenta = this.servicioBanco.obtenerEstadoCuenta(
                this.perfilUsuario.generarCredenciales()
        );
    }
    public boolean depositar(int cantidad) {
        return this.servicioBanco.depositar(cantidad, this.perfilUsuario.generarCredenciales());
    }
    public boolean retirar(int cantidad) {
        return this.servicioBanco.retirar(cantidad, this.perfilUsuario.generarCredenciales());
    }
    public boolean transferir(String receptor, int cantidad) {
        return this.servicioBanco.transferir(receptor, cantidad, this.perfilUsuario.generarCredenciales());
    }
    public void verEstadoCuenta() {
        if (this.vistaCuenta == null) {
            return;
        }
        this.vistaCuenta.verBalance();
    }
}
