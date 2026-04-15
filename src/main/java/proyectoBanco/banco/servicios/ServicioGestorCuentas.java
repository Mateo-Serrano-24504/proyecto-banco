package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.List;

public class ServicioGestorCuentas extends ServicioProtegido {
    private final ServicioGestionCuentas servicioGestionCuentas;

    public ServicioGestorCuentas(GestorUsuarios gestorUsuarios, ServicioGestionCuentas servicioGestionCuentas) {
        super(gestorUsuarios);
        this.servicioGestionCuentas = servicioGestionCuentas;
    }

    public boolean crearCuenta(CredencialesUsuario credenciales, TipoCuenta tipoCuenta) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioGestionCuentas.crearCuenta(credenciales, tipoCuenta);
    }
    public boolean eliminarCuenta(CredencialesUsuario credenciales) {
        return this.servicioGestionCuentas.eliminarCuenta(credenciales);
    }
    public List<String> obtenerVistaOperacionesPendientes() {
        return this.servicioGestionCuentas.obtenerVistaOperacionesPendientes();
    }
    public void resolverOperacion(int indice) {
        this.servicioGestionCuentas.resolverOperacion(indice);
    }
}
