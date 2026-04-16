package proyectoBanco.banco.concurrencia;

import proyectoBanco.banco.AccesoBaseDeDatos;
import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.usuarios.CredencialesUsuario;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.Set;

public class GestorUsuariosConcurrente {
    private final GestorUsuarios gestorUsuarios;

    public GestorUsuariosConcurrente(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    public boolean verificarCredencialesUsuario(CredencialesUsuario credencialesUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.verificarCredencialesUsuario(bdd, credencialesUsuario)
        );
    }
    public boolean agregarUsuarioSiNoExiste(PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.agregarUsuarioSiNoExiste(bdd, perfilUsuario, rolesUsuario)
        );
    }
    public boolean eliminarRolDeUsuarioSiExiste(CredencialesUsuario credencialesUsuario, RolUsuario rolUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.eliminarRolDeUsuarioSiExiste(bdd, credencialesUsuario, rolUsuario)
        );
    }
}
