public abstract class Cuenta {

    private String numero;
    private double saldo;

    public Cuenta(String numero, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException(
                    "El saldo inicial no puede ser negativo");
        }

        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero");
        }

        saldo += monto;
    }

    public void retirar(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero");
        }

        if (monto > saldo) {
            throw new IllegalArgumentException(
                    "Saldo insuficiente");
        }

        saldo -= monto;
    }

    protected void disminuirSaldo(double monto) {
        saldo -= monto;
    }

    public abstract void aplicarBeneficio();
}