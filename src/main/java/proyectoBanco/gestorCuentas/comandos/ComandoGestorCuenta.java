package proyectoBanco.gestorCuentas.comandos;

import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.usuarios.PerfilUsuario;

public abstract class ComandoGestorCuenta {
    protected ServicioGestorCuentas servicioGestorCuentas;
    protected PerfilUsuario perfilUsuarioGestorCuentas;

    public ComandoGestorCuenta(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    public abstract void ejecutar();
}
