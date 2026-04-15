package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.Set;

public class ServicioUsuario {
    private final GestorUsuarios gestorUsuarios;

    public ServicioUsuario(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    public boolean crearUsuarioSiNoExiste(PerfilUsuario perfilUsuario, Set<RolUsuario> roles) {
        return this.gestorUsuarios.agregarUsuarioSiNoExiste(perfilUsuario, roles);
    }
    public boolean eliminarRolDeUsuarioSiExiste(PerfilUsuario perfilUsuario, RolUsuario rolUsuario) {
        return this.gestorUsuarios.eliminarRolDeUsuarioSiExiste(
                perfilUsuario.generarCredenciales(),
                rolUsuario
        );
    }
}
