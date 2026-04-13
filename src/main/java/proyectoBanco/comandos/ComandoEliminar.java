package proyectoBanco.comandos;

import proyectoBanco.Administrador;

public record ComandoEliminar(String usuario) implements Comando {

    @Override
    public void manejar(Administrador administrador) {
        administrador.manejarEliminar(this);
    }
}
