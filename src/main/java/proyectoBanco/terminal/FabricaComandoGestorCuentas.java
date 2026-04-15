package proyectoBanco.terminal;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.terminal.comandos.ComandoGestorCuenta;
import proyectoBanco.terminal.comandos.ComandoListar;
import proyectoBanco.terminal.comandos.ComandoManejarTodos;
import proyectoBanco.usuarios.PerfilUsuario;

public class FabricaComandoGestorCuentas {
    private final ServicioBanco servicioBanco;
    private final PerfilUsuario perfilUsuarioGestorCuentas;

    public FabricaComandoGestorCuentas(ServicioBanco servicioBanco, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioBanco = servicioBanco;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    public ComandoGestorCuenta crear(String entrada) {
        switch (entrada) {
            case "manejar" -> {
                return new ComandoManejarTodos(this.servicioBanco, this.perfilUsuarioGestorCuentas);
            }
            case "listar" -> {
                return new ComandoListar(this.servicioBanco, this.perfilUsuarioGestorCuentas);
            }
            default -> {
                return null;
            }
        }
    }
}
