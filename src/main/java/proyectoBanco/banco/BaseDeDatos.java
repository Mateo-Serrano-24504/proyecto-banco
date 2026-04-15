package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.usuarios.PerfilUsuario;

import java.util.HashMap;
import java.util.Map;

public class BaseDeDatos {
    public final Map<String, Cuenta> cuentas;
    public final Map<String, PerfilUsuario> periles;

    BaseDeDatos() {
        this.cuentas = new HashMap<>();
        this.periles = new HashMap<>();
    }
}
