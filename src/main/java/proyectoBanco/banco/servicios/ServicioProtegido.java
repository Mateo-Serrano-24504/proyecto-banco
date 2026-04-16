package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorUsuarios;
import proyectoBanco.banco.concurrencia.GestorUsuariosConcurrente;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioProtegido {
    protected GestorUsuariosConcurrente gestorUsuariosConcurrente;

    protected ServicioProtegido(GestorUsuariosConcurrente gestorUsuarios) {
        this.gestorUsuariosConcurrente = gestorUsuarios;
    }

    protected boolean credencialesInvalidas(CredencialesUsuario credencialesUsuario) {
        return !this.gestorUsuariosConcurrente.verificarCredencialesUsuario(credencialesUsuario);
    }
}
