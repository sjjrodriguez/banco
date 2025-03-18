import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        double monto;
        boolean estado = true;

        List<CuentaBancaria> listBanco = new ArrayList<>();

        CuentaBancaria cl1 = new CuentaBancaria();
        do {
            System.out.println("""
                    1. Crear cliente
                    2. Mostrar todos los clientes
                    3. Mostrar informacion de una cuenta especifica
                    4. Depositar dinero
                    5. Retirar dinero
                    6. transferir dineros entre cuentas
                    7. pedir prestamo 
                    8.salir
                    
                    
                    """);
            System.out.println("ingrese una opcion");
            op = teclado.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("Ingrese nombre del titular");
                    cl1.setTitular(teclado.next());
                    System.out.println("Ingrse saldo de la cuenta");
                    cl1.setSaldo(teclado.nextDouble());
                    System.out.println("Ingrese numero de cuenta");
                    cl1.setNumeroCuenta(teclado.next());

                    listBanco.add(new CuentaBancaria(cl1.getTitular(), cl1.getSaldo(), cl1.getNumeroCuenta()));
                }
                case 2 -> {
                    for (CuentaBancaria cu : listBanco) {
                        System.out.println(cu);
                    }
                }
                case 3 -> {
                    String nCuenta;
                    System.out.println("Ingrese su nuemero de cuenta");
                    nCuenta = teclado.next();
                    for (int i = 0; i < listBanco.size(); i++) {
                        if (listBanco.get(i).getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            System.out.println(listBanco.get(i));
                        }

                    }
                }
                case 4 -> {
                    String depositar;
                    System.out.println("DEPOSITAR");
                    System.out.println("INGRESE NUMERO DE CUENTA");
                    depositar = teclado.next();
                    for (int i = 0; i < listBanco.size(); i++) {

                        listBanco.get(i).getNumeroCuenta().equalsIgnoreCase(depositar);

                        do {
                            System.out.println("Cuanto dinero desea depositar su dinero es ");
                            monto = teclado.nextDouble();
                            listBanco.get(i).depositarDinero(monto);
                        } while (monto <= 0);

                    }
                }
                case 5 -> {
                    String retirardinero;
                    System.out.println("RETIRAR");
                    System.out.println("INGRESE NUMERO DE CUENTA");
                    retirardinero = teclado.next();
                    for (int i = 0; i < listBanco.size(); i++) {

                        listBanco.get(i).getNumeroCuenta().equalsIgnoreCase(retirardinero);

                        do {
                            System.out.println("Cuanto dinero desea retirar");
                            monto = teclado.nextDouble();
                            listBanco.get(i).retirarDinero(monto);
                        } while (monto <= 0);

                    }
                }
                case 6 -> {
                    CuentaBancaria origen = null, destino = null;
                    System.out.println("TRANSFERENCIA ENTRE CUENTAS");
                    System.out.println("Ingrese número de cuenta de origen:");
                    String cuentaOrigen = teclado.next();

                    System.out.println("Ingrese número de cuenta de destino:");
                    String cuentaDestino = teclado.next();

                    System.out.println("Ingrese monto a transferir:");
                    monto = teclado.nextDouble();

                        for (CuentaBancaria cuenta : listBanco) {
                            if (cuenta.getNumeroCuenta().equalsIgnoreCase(cuentaOrigen)) {
                                origen = cuenta;


                            }
                            if (cuenta.getNumeroCuenta().equalsIgnoreCase(cuentaDestino)) {
                                destino = cuenta;

                            }

                    }
                    if (origen != null && destino != null) {
                        origen.transferirDinero(destino, monto);
                        System.out.println("transferencia exitosa.");
                        System.out.println("saldo cuenta origen: " + origen.getSaldo());
                        System.out.println("saldo cuenta destino: " + destino.getSaldo());
                    } else {
                        System.out.println("Error: Una o ambas cuentas no existen.");
                    }
                }

                case 7 -> {
                    System.out.println("PEDIR PRÉSTAMO");
                    System.out.println("Ingrese número de cuenta:");
                    String cuentaPrestamo = teclado.next();

                    CuentaBancaria cuenta = null;


                    for (CuentaBancaria c : listBanco) {
                        if (c.getNumeroCuenta().equalsIgnoreCase(cuentaPrestamo)) {
                            cuenta = c;
                            break;
                        }
                    }

                    if (cuenta != null) {
                        System.out.println("Ingrese el monto del préstamo:");
                        double montoPrestamo = teclado.nextDouble();
                        cuenta.pedirPrestamo(montoPrestamo);
                    } else {
                        System.out.println("Error: La cuenta no existe.");
                    }
                }
                case 8 -> {
                    System.out.println("Saliendo hasta luego ");
                    estado = false;
                }
            }
        }
        while (estado);

        }
    }


