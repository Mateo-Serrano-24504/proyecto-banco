package proyectoBanco.banco;

import proyectoBanco.usuarios.CredencialesUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.List;

public class GestorRoles {
    private final HashMap<String, List<RolUsuario>> rolesUsuario;

    public GestorRoles() {
        this.rolesUsuario = new HashMap<>();
    }

    public boolean verificarUsuarioConCredenciales(CredencialesUsuario credencialesUsuario, RolUsuario rolUsuario) {
        var roles = this.rolesUsuario.get(credencialesUsuario.usuario());
        if (roles == null || roles.isEmpty()) {
            return false;
        }
        return roles.contains(rolUsuario);
    }
}
