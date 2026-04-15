package proyectoBanco.gestorCuentas.comandos;

import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.usuarios.PerfilUsuario;

public class ComandoSalir extends ComandoGestorCuenta {
    public ComandoSalir(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
    }

    @Override
    public void ejecutar() {}
}
