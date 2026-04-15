package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseDeDatos {
    public final Map<String, Cuenta> cuentas;
    public final Map<String, PerfilUsuario> periles;
    public final Map<String, Set<RolUsuario>> roles;

    BaseDeDatos() {
        this.cuentas = new HashMap<>();
        this.periles = new HashMap<>();
        this.roles = new HashMap<>();
    }
}
