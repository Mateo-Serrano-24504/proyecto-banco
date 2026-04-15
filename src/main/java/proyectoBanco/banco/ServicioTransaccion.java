package proyectoBanco.banco;

import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioTransaccion {
    private final GestorTransacciones gestorTransacciones;

    public ServicioTransaccion(GestorTransacciones gestorTransacciones) {
        this.gestorTransacciones = gestorTransacciones;
    }

    public boolean depositar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransacciones.manejarDeposito(credenciales.usuario(), cantidad);
    }
    public boolean retirar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransacciones.manejarRetiro(credenciales.usuario(), cantidad);
    }
    public boolean transferir(CredencialesUsuario credenciales, String receptor, int cantidad) {
        return this.gestorTransacciones.manejarTransferencia(credenciales.usuario(), receptor, cantidad);
    }
}
