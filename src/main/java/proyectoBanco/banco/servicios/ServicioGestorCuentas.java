package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;
import proyectoBanco.usuarios.PerfilUsuario;

import java.util.List;

public class ServicioGestorCuentas extends ServicioProtegido {
    private final ServicioGestionCuentas servicioGestionCuentas;

    public ServicioGestorCuentas(GestorUsuarios gestorUsuarios, ServicioGestionCuentas servicioGestionCuentas) {
        super(gestorUsuarios);
        this.servicioGestionCuentas = servicioGestionCuentas;
    }

    public boolean crearCuenta(
            CredencialesUsuario credenciales,
            PerfilUsuario perfilUsuario,
            TipoCuenta tipoCuenta
    ) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioGestionCuentas.crearCuenta(perfilUsuario.generarCredenciales(), tipoCuenta);
    }
    public boolean eliminarCuenta(CredencialesUsuario credenciales, PerfilUsuario perfilUsuario) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioGestionCuentas.eliminarCuenta(perfilUsuario.generarCredenciales());
    }
    public List<String> obtenerVistaOperacionesPendientes(CredencialesUsuario credenciales) {
        if (super.credencialesInvalidas(credenciales)) {
            return null;
        }
        return this.servicioGestionCuentas.obtenerVistaOperacionesPendientes();
    }
    public boolean resolverOperacion(CredencialesUsuario credenciales, Integer codigo) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        this.servicioGestionCuentas.resolverOperacion(codigo);
        return true;
    }
}
