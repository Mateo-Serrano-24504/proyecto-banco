package proyectoBanco.terminal.comandos;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.usuarios.PerfilUsuario;

public abstract class ComandoGestorCuenta {
    protected ServicioBanco servicioBanco;
    protected PerfilUsuario perfilUsuarioGestorCuentas;
    public ComandoGestorCuenta(ServicioBanco servicioBanco, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioBanco = servicioBanco;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    public abstract void ejecutar();
}
