package proyectoBanco.comandos;

import proyectoBanco.administrador.Manejador;

public record ComandoEliminar(String usuario, String contr) implements Comando {

    @Override
    public void manejar(Manejador manejador) {
        manejador.manejarEliminar(this);
    }

    @Override
    public String toString() {
        return "ComandoEliminar(" +
                this.usuario +
                ", " + this.contr +
                ")";
    }
}
