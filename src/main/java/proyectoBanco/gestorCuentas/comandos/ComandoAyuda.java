package proyectoBanco.gestorCuentas.comandos;

import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.usuarios.PerfilUsuario;

public class ComandoAyuda extends ComandoGestorCuenta {

    public ComandoAyuda(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
    }

    @Override
    public void ejecutar() {
        System.out.println("Comandos:");
        System.out.println(" 1. manejar");
        System.out.println(" 2. manejar <codigo>");
        System.out.println(" 3. listar");
        System.out.println(" 4. ayuda");
        System.out.println(" 5. salir");
    }
}
