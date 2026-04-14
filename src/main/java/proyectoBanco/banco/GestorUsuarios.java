package proyectoBanco.banco;

import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.Set;

public class GestorUsuarios {
    private final GestorRoles gestorRoles;
    private final HashMap<String, PerfilUsuario> perfilesUsuarios;

    public GestorUsuarios(GestorRoles gestorRoles) {
        this.gestorRoles = gestorRoles;
        this.perfilesUsuarios = new HashMap<>();
    }

    public boolean agregarUsuario(PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        if (this.perfilesUsuarios.containsKey(perfilUsuario.obtenerNombre())) {
            return false;
        }
        this.perfilesUsuarios.put(perfilUsuario.obtenerNombre(), perfilUsuario);
        this.gestorRoles.agregarRolesDeUsuario(perfilUsuario.obtenerNombre(), rolesUsuario);
        return true;
    }
}
