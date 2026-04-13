package proyectoBanco.comandos;

import proyectoBanco.Administrador;

public class ComandoManejarTodos implements Comando {
    @Override
    public void manejar(Administrador administrador) {
        administrador.manejarManejarTodos(this);
    }
}
