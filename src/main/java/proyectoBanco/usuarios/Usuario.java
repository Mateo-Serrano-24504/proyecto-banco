package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.banco.servicios.ServicioProtegido;

public class Usuario {
    protected final PerfilUsuario perfilUsuario;

    public Usuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
}
