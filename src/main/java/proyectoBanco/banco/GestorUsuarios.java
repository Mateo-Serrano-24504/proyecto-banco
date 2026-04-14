package proyectoBanco.banco;

import proyectoBanco.usuarios.CredencialesUsuario;
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

    public boolean verificarCredencialesUsuario(CredencialesUsuario credencialesUsuario) {
        var perfilUsuario = this.perfilesUsuarios.get(credencialesUsuario.usuario());
        if (perfilUsuario == null) {
            return false;
        }
        return perfilUsuario.obtenerContr().equals(credencialesUsuario.contr());
    }
    public boolean agregarUsuarioSiNoExiste(PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        var perfil = this.perfilesUsuarios.get(perfilUsuario.obtenerNombre());
        if (perfil != null) {
            return perfil.generarCredenciales().equals(perfilUsuario.generarCredenciales());
        }
        this.perfilesUsuarios.put(perfilUsuario.obtenerNombre(), perfilUsuario);
        this.gestorRoles.agregarRolesDeUsuario(perfilUsuario.obtenerNombre(), rolesUsuario);
        return true;
    }
    public boolean eliminarRolDeUsuarioSiExiste(PerfilUsuario perfilUsuario, RolUsuario rolUsuario) {
        var perfil = this.perfilesUsuarios.get(perfilUsuario.obtenerNombre());
        if (perfil == null) {
            return false;
        }
        var nombre = perfil.obtenerNombre();
        this.gestorRoles.eliminarRolDeUsuario(nombre, rolUsuario);
        if (!this.gestorRoles.usuarioTieneRoles(nombre)) {
            this.perfilesUsuarios.remove(nombre);
        }
        return true;
    }
}
