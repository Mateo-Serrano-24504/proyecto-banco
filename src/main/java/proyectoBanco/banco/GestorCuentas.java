package proyectoBanco.banco;

import proyectoBanco.banco.comandos.Comando;
import proyectoBanco.banco.comandos.ComandoCrearCuenta;
import proyectoBanco.banco.comandos.ComandoEliminarCuenta;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.HashMap;
import java.util.HashSet;

public class GestorCuentas  {
    private final HashMap<String, Cuenta> cuentas;
    private final CreadorCuenta creadorCuenta;
    private final HashSet<Comando> tareasPendientes;

    public GestorCuentas(
            HashMap<String, Cuenta> cuentas,
            CreadorCuenta creadorCuenta
    ) {
        this.cuentas = cuentas;
        this.creadorCuenta = creadorCuenta;
        this.tareasPendientes = new HashSet<>();
    }

    public void solicitarCrearCuenta(String usuario, TipoCuenta tipoCuenta) {
        this.tareasPendientes.add(new ComandoCrearCuenta(this, usuario, tipoCuenta));
    }
    public void solicitarEliminarCuenta(String usuario) {
        this.tareasPendientes.add(new ComandoEliminarCuenta(this,usuario));
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
}
