package proyectoBanco.comandos;

import proyectoBanco.Administrador;

public record ComandoManejarPeticicon(int indicePeticion) implements Comando {

    @Override
    public void manejar(Administrador administrador) {
        administrador.manejarManejarPeticion(this);
    }
}
