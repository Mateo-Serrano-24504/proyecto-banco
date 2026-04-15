package proyectoBanco.gestorCuentas;

import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.gestorCuentas.comandos.ComandoGestorCuenta;
import proyectoBanco.gestorCuentas.comandos.ComandoListar;
import proyectoBanco.gestorCuentas.comandos.ComandoManejarTodos;
import proyectoBanco.usuarios.PerfilUsuario;

public class FabricaComandoGestorCuentas {
    private final ServicioGestorCuentas servicioGestorCuentas;
    private final PerfilUsuario perfilUsuarioGestorCuentas;

    public FabricaComandoGestorCuentas(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    public ComandoGestorCuenta crear(String entrada) {
        switch (entrada) {
            case "manejar" -> {
                return new ComandoManejarTodos(this.servicioGestorCuentas, this.perfilUsuarioGestorCuentas);
            }
            case "listar" -> {
                return new ComandoListar(this.servicioGestorCuentas, this.perfilUsuarioGestorCuentas);
            }
            default -> {
                return null;
            }
        }
    }
}
