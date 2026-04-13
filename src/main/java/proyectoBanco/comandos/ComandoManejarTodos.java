package proyectoBanco.comandos;

import proyectoBanco.administrador.Manejador;

public class ComandoManejarTodos implements Comando {
    @Override
    public void manejar(Manejador manejador) {
        manejador.manejarManejarTodos(this);
    }
}
