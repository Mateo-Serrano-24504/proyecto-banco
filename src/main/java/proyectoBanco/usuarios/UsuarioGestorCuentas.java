package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.gestorCuentas.comandos.ComandoListar;

public class UsuarioGestorCuentas extends Usuario {
    private final ServicioGestorCuentas servicioGestorCuentas;

    public UsuarioGestorCuentas(PerfilUsuario perfilUsuario, ServicioGestorCuentas servicioGestorCuentas) {
        super(perfilUsuario);
        this.servicioGestorCuentas = servicioGestorCuentas;
    }

    public boolean crearCuenta(PerfilUsuario perfilUsuario, TipoCuenta tipoCuenta) {
        return this.servicioGestorCuentas.crearCuenta(super.perfilUsuario.generarCredenciales(), tipoCuenta);
    }
    public boolean eliminarCuenta(PerfilUsuario perfilUsuario) {
        return this.servicioGestorCuentas.eliminarCuenta(super.perfilUsuario.generarCredenciales());
    }
    public void verOperacionesPendientes() {
        var comando = new ComandoListar(
                this.servicioGestorCuentas,
                this.perfilUsuario
        );
        comando.ejecutar();
    }
    public boolean resolverOperacion(int indice) {
        this.servicioGestorCuentas.resolverOperacion(super.perfilUsuario.generarCredenciales(), indice);
        return true;
    }
}
