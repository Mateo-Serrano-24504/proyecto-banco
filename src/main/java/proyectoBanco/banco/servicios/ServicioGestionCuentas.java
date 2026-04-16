package proyectoBanco.banco.servicios;

import proyectoBanco.banco.concurrencia.GestorCuentasConcurrente;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.List;

public class ServicioGestionCuentas {
    private final GestorCuentasConcurrente gestorCuentasConcurrente;

    public ServicioGestionCuentas(GestorCuentasConcurrente gestorCuentasConcurrente) {
        this.gestorCuentasConcurrente = gestorCuentasConcurrente;
    }

    // Métodos de gestor de cuentas
    public boolean crearCuenta(CredencialesUsuario credenciales, TipoCuenta tipoCuenta) {
        return this.gestorCuentasConcurrente.crearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public boolean eliminarCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentasConcurrente.eliminarCuenta(credenciales.usuario());
    }
    public List<String> obtenerVistaOperacionesPendientes() {
        return this.gestorCuentasConcurrente.obtenerVistaOperacionesPendientes();
    }
    public void resolverOperacion(Integer codigo) {
        this.gestorCuentasConcurrente.resolverOperacion(codigo);
    }
}
