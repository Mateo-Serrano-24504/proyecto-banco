package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.HashMap;

public class GestorCuentas extends Usuario {
    private final HashMap<String, Cuenta> cuentas;
    private final CreadorCuenta creadorCuenta;

    public GestorCuentas(
            ServicioBanco servicioBanco,
            CredencialesUsuario credencialesUsuario,
            HashMap<String, Cuenta> cuentas,
            CreadorCuenta creadorCuenta
    ) {
        super(servicioBanco, credencialesUsuario);
        this.cuentas = cuentas;
        this.creadorCuenta = creadorCuenta;
    }

    public boolean crearCuenta(CredencialesUsuario credencialesUsuario, TipoCuenta tipoCuenta) {
        if (this.cuentas.containsKey(credencialesUsuario.usuario())) {
            return false;
        }
        this.cuentas.put(
                credencialesUsuario.usuario(),
                this.creadorCuenta.crearCuenta(
                        tipoCuenta,
                        credencialesUsuario.usuario()
                )
        );
        return true;
    }
    public boolean eliminarCuenta(CredencialesUsuario credencialesUsuario) {
        if (!this.cuentas.containsKey(credencialesUsuario.usuario())) {
            return false;
        }
        this.cuentas.remove(credencialesUsuario.usuario());
        return true;
    }
    public Cuenta obtenerCuenta(CredencialesUsuario credencialesUsuario) {
        return this.cuentas.get(credencialesUsuario.usuario());
    }
    public void iterarCuentas() {}
}
