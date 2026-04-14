package proyectoBanco.banco;

import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.HashMap;

public class GestorCuentas  {
    private final HashMap<String, Cuenta> cuentas;
    private final CreadorCuenta creadorCuenta;

    public GestorCuentas(
            HashMap<String, Cuenta> cuentas,
            CreadorCuenta creadorCuenta
    ) {
        this.cuentas = cuentas;
        this.creadorCuenta = creadorCuenta;
    }

    public boolean crearCuenta(String usuario, TipoCuenta tipoCuenta) {
        if (this.cuentas.containsKey(usuario)) {
            return false;
        }
        this.cuentas.put(
                usuario,
                this.creadorCuenta.crearCuenta(
                        tipoCuenta,
                        usuario
                )
        );
        return true;
    }
    public boolean eliminarCuenta(String usuario) {
        if (!this.cuentas.containsKey(usuario)) {
            return false;
        }
        this.cuentas.remove(usuario);
        return true;
    }
    public Cuenta obtenerCuenta(String usuario) {
        return this.cuentas.get(usuario);
    }
    public void iterarCuentas() {}
}
