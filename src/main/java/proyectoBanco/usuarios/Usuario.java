package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;

public class Usuario {
    protected final ServicioBanco servicioBanco;
    protected final CredencialesUsuario credencialesUsuario;

    public Usuario(ServicioBanco servicioBanco, CredencialesUsuario credencialesUsuario) {
        this.servicioBanco = servicioBanco;
        this.credencialesUsuario = credencialesUsuario;
    }
}
