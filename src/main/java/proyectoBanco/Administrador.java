package proyectoBanco;

import proyectoBanco.comandos.ComandoCrear;
import proyectoBanco.comandos.ComandoEliminar;
import proyectoBanco.comandos.ComandoSalir;
import proyectoBanco.comandos.ServicioComando;

public class Administrador {
    private Banco banco;
    private ServicioComando servicioComando;

    private TipoCuenta obtenerTipoCuenta(String argumento) {
        if (argumento.equals("corriente")) {
            return TipoCuenta.CuentaCorriente;
        }
        return null;
    }

    public void manejarCrear(ComandoCrear comandoCrear) {}
    public void manejarEliminar(ComandoEliminar comandoEliminar) {}
    public void manejarSalir(ComandoSalir comandoSalir) {}

    private void crearCuenta(TipoCuenta tipoCuenta, String usuario, String direccion) {
        this.banco.crearCuenta(tipoCuenta, usuario, direccion);
    }

    private void eliminarCuenta(String usuario) {
        this.banco.eliminarCuenta(usuario);
    }

    public Administrador(Banco banco, ServicioComando servicioComando) {
        this.banco = banco;
        this.servicioComando = servicioComando;
    }

    public void procesarComando() {
        var comando = this.servicioComando.obtenerComando();
        var argumentos = comando.split(" ");
        if (argumentos[0].equals("crear")) {
            this.crearCuenta(
                    this.obtenerTipoCuenta(argumentos[1]),
                    argumentos[2],
                    argumentos[3]
            );
        } else if (argumentos[0].equals("eliminar")) {
            this.eliminarCuenta(argumentos[1]);
        }
    }
}
