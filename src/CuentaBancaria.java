public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numeroCuenta;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, double saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public void depositarDinero(double monto){
        this.saldo += monto;
    }

    public void retirarDinero(double monto){
        this.saldo-=monto;
    }

    public void transferirDinero(CuentaBancaria destino, double monto) {
        if (this.saldo >= monto && monto > 0) {
            this.saldo -= monto;
            destino.depositarDinero(monto);
            System.out.println("Transferencia realizada con éxito.");
        } else {
            System.out.println("Error: Saldo insuficiente o monto inválido.");
        }
    }
    public void pedirPrestamo(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto del préstamo debe ser mayor a 0.");
            return;
        }


        double interes = (monto / 1000) * 0.1;
        if (interes > 1.8) {
            interes = 1.8;
        }

        double totalPagar = monto + (monto * interes / 100);
        this.saldo += monto;
        System.out.println("Préstamo aprobado.");
        System.out.println("Monto prestado: " + monto);
        System.out.println(" interés aplicado: " + interes + "%");
        System.out.println("Total a pagar: " + totalPagar);
        System.out.println("Nuevo saldo: " + this.saldo);
    }



    public void mostrarInformacion(){
        System.out.println("El nombre del titular es: " + this.titular);
        System.out.println("El saldo de la cuenta es: " + this.saldo);
        System.out.println("El numero de cuenta es: " + this.numeroCuenta);
    }


}
