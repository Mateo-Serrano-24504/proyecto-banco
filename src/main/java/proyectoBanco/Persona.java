package proyectoBanco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

public class Persona {
    private final String nombreUsuario;
    private final String direccion;
    private final ServicioBanco servicioBanco;
    private Cuenta cuenta;

    public Persona(String nombreUsuario, String direccion, ServicioBanco servicioBanco) {
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.servicioBanco = servicioBanco;
        this.cuenta = servicioBanco.obtenerCuenta(this.nombreUsuario);
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta) {
        this.servicioBanco.solicitarCrearCuenta(
                tipoCuenta,
                this.nombreUsuario
        );
    }
    public void solicitarEliminarCuenta() {
        this.servicioBanco.solicitarEliminarCuenta(this.nombreUsuario);
    }

    public void actualizarCuenta() {
        this.cuenta = this.servicioBanco.obtenerCuenta(this.nombreUsuario);
    }
    public void cargarSaldo(int cantidad) {
        if (this.cuenta == null) {
            return;
        }
        this.cuenta.depositar(cantidad);
    }
    public boolean transferir(String receptor, int cantidad) {
        if (this.cuenta == null) {
            return false;
        }
        return this.cuenta.transferir(receptor, cantidad);
    }
    public void verBalance() {
        if (this.cuenta == null) {
            return;
        }
        this.cuenta.verBalance();
    }
}
