package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.banco.concurrencia.GestorUsuariosConcurrente;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.Set;

public class ServicioUsuario {
    private final GestorUsuariosConcurrente gestorUsuariosConcurrente;

    public ServicioUsuario(GestorUsuariosConcurrente gestorUsuariosConcurrente) {
        this.gestorUsuariosConcurrente = gestorUsuariosConcurrente;
    }

    public boolean crearUsuarioSiNoExiste(PerfilUsuario perfilUsuario, Set<RolUsuario> roles) {
        return this.gestorUsuariosConcurrente.agregarUsuarioSiNoExiste(perfilUsuario, roles);
    }
    public boolean eliminarRolDeUsuarioSiExiste(PerfilUsuario perfilUsuario, RolUsuario rolUsuario) {
        return this.gestorUsuariosConcurrente.eliminarRolDeUsuarioSiExiste(
                perfilUsuario.generarCredenciales(),
                rolUsuario
        );
    }
}
