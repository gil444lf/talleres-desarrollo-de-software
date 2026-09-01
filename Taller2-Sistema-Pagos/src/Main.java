import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" SISTEMA DE PAGOS DE SERVICIOS");
        System.out.println("====================================");

        SistemaPagos sistema = new SistemaPagos();

        // CREAR CLIENTE

        Cliente cliente = new Cliente(
                "C001",
                "Juan Gil",
                "juan@email.com"
        );

        sistema.crearCliente(cliente);

        // CREAR CUENTAS

        Cuenta cuentaAhorros =
                new CuentaAhorros(
                        "1001",
                        500000,
                        0.01
                );

        Cuenta cuentaCorriente =
                new CuentaCorriente(
                        "2001",
                        300000,
                        100000
                );

        sistema.crearCuenta(cuentaAhorros);
        sistema.crearCuenta(cuentaCorriente);

        cliente.agregarCuenta(cuentaAhorros);
        cliente.agregarCuenta(cuentaCorriente);

        // POLIMORFISMO

        System.out.println("\n--- POLIMORFISMO ---");

        Cuenta[] cuentas = {
                cuentaAhorros,
                cuentaCorriente
        };

        for (Cuenta cuenta : cuentas) {

            System.out.println(
                    "Cuenta: " + cuenta.getNumero());

            System.out.println(
                    "Saldo: $" + cuenta.getSaldo());

            cuenta.aplicarBeneficio();
        }

        // CREAR FACTURAS

        Factura factura1 = new Factura(
                "F001",
                "Energía",
                120000,
                cliente
        );

        Factura factura2 = new Factura(
                "F002",
                "Agua",
                80000,
                cliente
        );

        sistema.crearFactura(factura1);
        sistema.crearFactura(factura2);

        cliente.agregarFactura(factura1);
        cliente.agregarFactura(factura2);

        // CONSULTAR FACTURAS

        System.out.println("\n--- FACTURAS DEL CLIENTE ---");

        List<Factura> facturas =
                sistema.obtenerFacturasPorCliente(cliente);

        for (Factura factura : facturas) {
            System.out.println(factura);
        }

        // CONSULTAR SALDO

        System.out.println("\n--- SALDO ANTES DEL PAGO ---");

        System.out.println(
                "$" + sistema.obtenerSaldoCuenta("1001"));

        // PROCESAR PAGO

        System.out.println("\n--- PROCESANDO PAGO ---");

        Pago pago = sistema.procesarPago(
                cliente,
                "F001",
                "1001"
        );

        System.out.println("Pago realizado correctamente");
        System.out.println(pago);

        // SALDO DESPUÉS

        System.out.println("\n--- SALDO DESPUÉS DEL PAGO ---");

        System.out.println(
                "$" + sistema.obtenerSaldoCuenta("1001"));

        // HISTORIAL

        System.out.println("\n--- HISTORIAL DE PAGOS ---");

        List<Pago> historial =
                sistema.obtenerPagosPorCliente(cliente);

        for (Pago p : historial) {
            System.out.println(p);
        }

        // ESTADO DE FACTURA

        System.out.println("\n--- ESTADO DE FACTURA ---");

        System.out.println(
                "Factura " +
                factura1.getNumero() +
                " pagada: " +
                factura1.isPagada());

        System.out.println("\n====================================");
        System.out.println("      PROGRAMA FINALIZADO");
        System.out.println("====================================");
    }
}