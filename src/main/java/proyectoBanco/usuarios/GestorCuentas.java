package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.CuentaCorriente;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.HashMap;

public class GestorCuentas extends Usuario {
    private final HashMap<CredencialesUsuario, Cuenta> cuentas;
    private final CreadorCuenta creadorCuenta;

    public GestorCuentas(
            ServicioBanco servicioBanco,
            CredencialesUsuario credencialesUsuario,
            CreadorCuenta creadorCuenta
    ) {
        super(servicioBanco, credencialesUsuario);
        this.cuentas = new HashMap<>();
        this.creadorCuenta = creadorCuenta;
    }

    public boolean crearCuenta(CredencialesUsuario credencialesUsuario, TipoCuenta tipoCuenta) {
        if (this.cuentas.containsKey(credencialesUsuario)) {
            return false;
        }
        this.cuentas.put(
                credencialesUsuario,
                this.creadorCuenta.crearCuenta(
                        tipoCuenta,
                        credencialesUsuario.usuario()
                )
        );
        return true;
    }
    public boolean eliminarCuenta() {
        return false;
    }
    public Cuenta obtenerCuenta() {
        return new CuentaCorriente("");
    }
    public void iterarCuentas() {}
}
