package proyectoBanco.cuentas;

public class CuentaCorriente extends Cuenta {
    private final double interesPorGiro;

    public CuentaCorriente(String propietario) {
        super.propietario = propietario;
        super.saldo = 0;
        this.interesPorGiro = 1.5;
    }

    @Override
    public void verBalance() {
        System.out.println("Balance de cuenta.");
        System.out.println("    - Tipo de cuenta: Corriente");
        System.out.println("    - Propietario: " + this.propietario);
        System.out.println("    - Saldo: " + this.saldo);
    }

    @Override
    public boolean depositar(int cantidad) {
        this.saldo += cantidad;
        return true;
    }

    @Override
    public boolean retirar(int cantidad) {
        if (this.saldo < 0) {
            return false;
        }
        this.saldo -= cantidad;
        this.saldo = (int) Math.floor(this.saldo * this.interesPorGiro);
        return true;
    }
}
