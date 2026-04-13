package proyectoBanco.comandos;

import proyectoBanco.administrador.Manejador;

public record ComandoManejarPeticicon(int indicePeticion) implements Comando {

    @Override
    public void manejar(Manejador manejador) {
        manejador.manejarManejarPeticion(this);
    }
}
