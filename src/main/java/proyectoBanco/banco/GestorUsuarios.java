package proyectoBanco.banco;

import proyectoBanco.usuarios.CredencialesUsuario;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.Set;

public class GestorUsuarios {
    private final GestorRoles gestorRoles;

    public GestorUsuarios(GestorRoles gestorRoles) {
        this.gestorRoles = gestorRoles;
    }

    public boolean verificarCredencialesUsuario(BaseDeDatos bdd, CredencialesUsuario credencialesUsuario) {
        var perfilUsuario = bdd.perfiles.get(credencialesUsuario.usuario());
        if (perfilUsuario == null) {
            return false;
        }
        return perfilUsuario.obtenerContr().equals(credencialesUsuario.contr());
    }
    public boolean agregarUsuarioSiNoExiste(BaseDeDatos bdd, PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        var perfil = bdd.perfiles.get(perfilUsuario.obtenerNombre());
        if (perfil != null) {
            return perfil.generarCredenciales().equals(perfilUsuario.generarCredenciales());
        }
        bdd.perfiles.put(perfilUsuario.obtenerNombre(), perfilUsuario);
        this.gestorRoles.agregarRolesDeUsuario(bdd.roles, perfilUsuario.obtenerNombre(), rolesUsuario);
        return true;
    }
    public boolean eliminarRolDeUsuarioSiExiste(BaseDeDatos bdd, CredencialesUsuario credencialesUsuario, RolUsuario rolUsuario) {
        var nombre = credencialesUsuario.usuario();
        if (bdd.perfiles.containsKey(nombre)) {
            return false;
        }
        this.gestorRoles.eliminarRolDeUsuario(bdd.roles, nombre, rolUsuario);
        if (!this.gestorRoles.verificarUsuarioTieneRoles(bdd.roles, nombre)) {
            bdd.perfiles.remove(nombre);
        }
        return true;
    }
}
