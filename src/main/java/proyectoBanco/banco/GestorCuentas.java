package proyectoBanco.banco;

import proyectoBanco.banco.comandos.ComandoCuenta;
import proyectoBanco.banco.comandos.ComandoCuentaCrearCuenta;
import proyectoBanco.banco.comandos.ComandoCuentaEliminarCuenta;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.*;

public class GestorCuentas  {
    private final HashMap<String, Cuenta> cuentas;
    private final CreadorCuenta creadorCuenta;
    private final Map<Integer, ComandoCuenta> tareasPendientes;

    private boolean crearCuentaEnBdd(Map<String, Cuenta> cuentas, String usuario, TipoCuenta tipoCuenta) {
        if (cuentas.containsKey(usuario)) {
            return false;
        }
        cuentas.put(
                usuario,
                this.creadorCuenta.crearCuenta(
                        tipoCuenta,
                        usuario
                )
        );
        return true;
    }
    private boolean eliminarCuentaEnBdd(Map<String, Cuenta> cuentas, String usuario) {
        if (!cuentas.containsKey(usuario)) {
            return false;
        }
        cuentas.remove(usuario);
        return true;
    }

    public GestorCuentas(
            HashMap<String, Cuenta> cuentas,
            CreadorCuenta creadorCuenta
    ) {
        this.cuentas = cuentas;
        this.creadorCuenta = creadorCuenta;
        this.tareasPendientes = new HashMap<>();
    }

    public void solicitarCrearCuenta(String usuario, TipoCuenta tipoCuenta) {
        this.tareasPendientes.put(
                this.tareasPendientes.size(),
                new ComandoCuentaCrearCuenta(this, usuario, tipoCuenta)
        );
    }
    public void solicitarEliminarCuenta(String usuario) {
        this.tareasPendientes.put(
                this.tareasPendientes.size(),
                new ComandoCuentaEliminarCuenta(this,usuario)
        );
    }

    // Operaciones de cuenta
    public boolean crearCuenta(String usuario, TipoCuenta tipoCuenta) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.crearCuentaEnBdd(bdd.cuentas, usuario, tipoCuenta)
        );
    }
    public boolean eliminarCuenta(String usuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.eliminarCuentaEnBdd(bdd.cuentas, usuario)
        );
    }
    public Cuenta obtenerCuenta(String usuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> bdd.cuentas.get(usuario)
        );
    }

    // Operaciones de administrador
    public List<String> obtenerVistaOperacionesPendientes() {
        var vista = new ArrayList<String>();
        for (var comando : this.tareasPendientes.entrySet()) {
            vista.add(comando.getValue() + " / Código: " + comando.getKey());
        }
        return vista;
    }
    public void resolverOperacion(Integer codigo) {
        var comando = this.tareasPendientes.remove(codigo);
        if (comando == null) {
            return;
        }
        comando.ejecutar();
    }
}
