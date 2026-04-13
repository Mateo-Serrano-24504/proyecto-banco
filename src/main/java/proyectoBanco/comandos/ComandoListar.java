package proyectoBanco.comandos;

import proyectoBanco.administrador.Manejador;

public class ComandoListar implements Comando {
    @Override
    public void manejar(Manejador manejador) {
        manejador.manejarListar(this);
    }

    @Override
    public String toString() {
        return "ComandoListar";
    }
}
