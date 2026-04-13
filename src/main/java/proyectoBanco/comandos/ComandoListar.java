package proyectoBanco.comandos;

import proyectoBanco.Administrador;

public class ComandoListar implements Comando {
    @Override
    public void manejar(Administrador administrador) {
        administrador.manejarListar(this);
    }

    @Override
    public String toString() {
        return "ComandoListar";
    }
}
