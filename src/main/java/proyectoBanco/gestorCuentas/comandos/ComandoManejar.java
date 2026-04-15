package proyectoBanco.gestorCuentas.comandos;

import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.usuarios.PerfilUsuario;

public class ComandoManejar extends ComandoGestorCuenta {
    private final Integer codigo;

    public ComandoManejar(
            ServicioGestorCuentas servicioGestorCuentas,
            PerfilUsuario perfilUsuarioGestorCuentas,
            Integer codigo
    ) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        super.servicioGestorCuentas.resolverOperacion(
                super.perfilUsuarioGestorCuentas.generarCredenciales(),
                this.codigo
        );
    }
}
