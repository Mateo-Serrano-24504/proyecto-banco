package proyectoBanco.comandos;

import proyectoBanco.Administrador;

public class ComandoSalir implements Comando {
    @Override
    public void manejar(Administrador administrador) {
        administrador.manejarSalir(this);
    }
}
