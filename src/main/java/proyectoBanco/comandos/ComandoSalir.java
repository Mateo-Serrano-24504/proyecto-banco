package proyectoBanco.comandos;

import proyectoBanco.administrador.Manejador;

public class ComandoSalir implements Comando {
    @Override
    public void manejar(Manejador manejador) {
        manejador.manejarSalir(this);
    }

    @Override
    public String toString() {
        return "ComandoSalir";
    }
}
