package proyectoBanco.banco.concurrencia;

import proyectoBanco.banco.AccesoBaseDeDatos;
import proyectoBanco.banco.GestorCuentas;
import proyectoBanco.banco.comandos.ComandoCuenta;
import proyectoBanco.banco.comandos.ComandoCuentaCrearCuenta;
import proyectoBanco.banco.comandos.ComandoCuentaEliminarCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorCuentasConcurrente {
    private final GestorCuentas gestorCuentas;
    private final Map<Integer, ComandoCuenta> tareasPendientes;

    public GestorCuentasConcurrente(GestorCuentas gestorCuentas) {
        this.gestorCuentas = gestorCuentas;
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
                new ComandoCuentaEliminarCuenta(this ,usuario)
        );
    }

    // Operaciones de cuenta
    public boolean crearCuenta(String usuario, TipoCuenta tipoCuenta) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorCuentas.crearCuenta(bdd.cuentas, usuario, tipoCuenta)
        );
    }
    public boolean eliminarCuenta(String usuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorCuentas.eliminarCuenta(bdd.cuentas, usuario)
        );
    }
    public Cuenta obtenerCuenta(String usuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorCuentas.obtenerCuenta(bdd.cuentas, usuario)
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
