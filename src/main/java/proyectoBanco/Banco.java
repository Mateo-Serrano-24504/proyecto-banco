package proyectoBanco;

import java.util.HashMap;

public class Banco {
    private HashMap<String, Cuenta> cuentas;

    public Banco() {
        this.cuentas = new HashMap<>();
    }

    public Cuenta obtenerCuenta(String nombrePropietario) {
        return this.cuentas.get(nombrePropietario);
    }

    public void crearCuenta(TipoCuenta tipoCuenta, String nombrePropietario, String direccion) {
        if (this.cuentas.containsKey(nombrePropietario)) {
            return;
        }
        this.cuentas.put(
                nombrePropietario,
                new Cuenta(tipoCuenta, nombrePropietario, direccion, this)
        );
    }
    public void eliminarCuenta(String nombrePropietario) {
        this.cuentas.remove(nombrePropietario);
    }

    public boolean transferir(String emisor, String receptor, int cantidad) {
        var cuentaEmisor = this.cuentas.get(emisor);
        var cuentaReceptor = this.cuentas.get(receptor);
        if (cuentaEmisor == null || cuentaReceptor == null) {
            return false;
        }
        var saldoEmisor = cuentaEmisor.obtenerSaldo();
        if (saldoEmisor < cantidad) {
            return false;
        }
        cuentaEmisor.retirar(cantidad);
        cuentaReceptor.guardar(cantidad);
        return true;
    }
}
