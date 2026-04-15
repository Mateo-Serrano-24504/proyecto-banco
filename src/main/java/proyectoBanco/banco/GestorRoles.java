package proyectoBanco.banco;

import proyectoBanco.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GestorRoles {
    private void agregarRolesDeUsuarioEnBdd(Map<String, Set<RolUsuario>> roles, String nombre, Set<RolUsuario> rolesUsuario) {
        if (!roles.containsKey(nombre)) {
            roles.put(nombre, rolesUsuario);
        } else {
            roles.get(nombre).addAll(rolesUsuario);
        }
    }
    private void eliminarRolDeUsuarioEnBdd(Map<String, Set<RolUsuario>> roles, String nombre, RolUsuario rolUsuario) {
        var rolesActuales = roles.get(nombre);
        if (rolesActuales == null || rolesActuales.isEmpty()) {
            return;
        }
        rolesActuales.remove(rolUsuario);
        if (rolesActuales.isEmpty()) {
            roles.remove(nombre);
        }
    }
    private boolean verificarUsuarioTieneRolesEnBdd(Map<String, Set<RolUsuario>> roles, String nombre) {
        return roles.containsKey(nombre);
    }
    public boolean verificarRolEnUsuarioEnBdd(Map<String, Set<RolUsuario>> roles, String usuario, RolUsuario rolUsuario) {
        var rolesActuales = roles.get(usuario);
        if (rolesActuales == null || rolesActuales.isEmpty()) {
            return false;
        }
        return rolesActuales.contains(rolUsuario);
    }

    public GestorRoles() {}

    public void agregarRolesDeUsuario(String nombre, Set<RolUsuario> rolesUsuario) {
        AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> {
                    this.agregarRolesDeUsuarioEnBdd(
                            bdd.roles, nombre, rolesUsuario
                    );
                    return null;
                }
        );
    }
    public void eliminarRolDeUsuario(String nombre, RolUsuario rolUsuario) {
        AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> {
                    this.eliminarRolDeUsuarioEnBdd(
                            bdd.roles, nombre, rolUsuario
                    );
                    return null;
                }
        );
    }
    public boolean usuarioTieneRoles(String usuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.verificarUsuarioTieneRolesEnBdd(bdd.roles, usuario)
        );
    }
    public boolean verificarRolesEnUsuario(String usuario, RolUsuario rolUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.verificarRolEnUsuarioEnBdd(bdd.roles, usuario, rolUsuario)
        );
    }
}
