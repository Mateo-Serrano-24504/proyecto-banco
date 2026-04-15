package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioProtegido {
    protected GestorUsuarios gestorUsuarios;

    protected ServicioProtegido(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    protected boolean credencialesInvalidas(CredencialesUsuario credencialesUsuario) {
        return !this.gestorUsuarios.verificarCredencialesUsuario(credencialesUsuario);
    }
}
