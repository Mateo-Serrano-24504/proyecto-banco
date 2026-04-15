package proyectoBanco.gestorCuentas;

import proyectoBanco.banco.servicios.ServicioGestorCuentas;
import proyectoBanco.gestorCuentas.comandos.*;
import proyectoBanco.usuarios.PerfilUsuario;

public class FabricaComandoGestorCuentas {
    private final ServicioGestorCuentas servicioGestorCuentas;
    private final PerfilUsuario perfilUsuarioGestorCuentas;

    private ComandoGestorCuenta crearComandoManejar(String entrada) {
        var lineaDividida = entrada.split(" ");

        if (!lineaDividida[0].equals("manejar")) {
            return null;
        }

        if (lineaDividida.length > 1) {
            int codigo;
            try {
                codigo = Integer.parseInt(lineaDividida[1]);
            } catch (NumberFormatException e) {
                return null;
            }
            return new ComandoManejar(
                    this.servicioGestorCuentas,
                    this.perfilUsuarioGestorCuentas,
                    codigo
            );
        }
        return null;
    }

    public FabricaComandoGestorCuentas(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    public ComandoGestorCuenta crear(String entrada) {
        switch (entrada.charAt(0)) {
            case 'm' -> {
                return this.crearComandoManejar(entrada);
            }
            case 'l' -> {
                if (entrada.equals("listar")) {
                    return new ComandoListar(this.servicioGestorCuentas, this.perfilUsuarioGestorCuentas);
                }
                return null;
            }
            case 'a' -> {
                return new ComandoAyuda(this.servicioGestorCuentas, this.perfilUsuarioGestorCuentas);
            }
            case 's' -> {
                return new ComandoSalir(this.servicioGestorCuentas, this.perfilUsuarioGestorCuentas);
            }
            default -> {
                return null;
            }
        }
    }
}
