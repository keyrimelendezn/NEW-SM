package com.proyectojava;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    // Atributos de la cuenta
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // 1. Declaración del historial de transacciones (Lista dinámica)
    private List<String> historialMovimientos;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;

        // 2. Inicialización de la lista
        this.historialMovimientos = new ArrayList<>();

        // Registro inicial
        this.historialMovimientos.add("Apertura de cuenta con saldo inicial: $" + saldoInicial);
    }

    // Método para depositar
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            // Registrar el movimiento
            this.historialMovimientos.add("Depósito exitoso: +$" + monto + " | Saldo actual: $" + this.saldo);
            System.out.println("Depósito exitoso de $" + monto + ". Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0.");
        }
    }

    // Método para retirar
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            // Registrar el movimiento
            this.historialMovimientos.add("Retiro exitoso: -$" + monto + " | Saldo actual: $" + this.saldo);
            System.out.println("Retiro exitoso de $" + monto + ". Saldo restante: $" + this.saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes o monto inválido para el retiro.");
            return false;
        }
    }

    // Método para transferir a otra cuenta
    public boolean transferir(CuentaBancaria cuentaDestino, double monto) {
        if (monto <= 0) {
            System.out.println("El monto a transferir debe ser mayor a 0.");
            return false;
        }

        if (this.saldo >= monto) {
            this.saldo -= monto;
            cuentaDestino.saldo += monto; // Abono directo a la cuenta destino

            // Registrar en el historial de la cuenta origen (esta cuenta)
            this.historialMovimientos.add("Transferencia enviada: -$" + monto + " hacia cuenta " + cuentaDestino.getNumeroCuenta() + " | Saldo actual: $" + this.saldo);

            // Registrar en el historial de la cuenta destino
            cuentaDestino.historialMovimientos.add("Transferencia recibida: +$" + monto + " desde cuenta " + this.numeroCuenta + " | Saldo actual: $" + cuentaDestino.getSaldo());

            System.out.println("Transferencia exitosa de $" + monto + " hacia la cuenta " + cuentaDestino.getNumeroCuenta());
            return true;
        } else {
            System.out.println("Transferencia fallida: Fondos insuficientes en la cuenta origen.");
            return false;
        }
    }

    // 3. Método para imprimir el historial completo acumulado
    public void mostrarHistorial() {
        System.out.println("\n================================================");
        System.out.println("HISTORIAL DE MOVIMIENTOS - CUENTA: " + this.numeroCuenta);
        System.out.println("TITULAR: " + this.titular);
        System.out.println("================================================");
        for (String registro : this.historialMovimientos) {
            System.out.println("-> " + registro);
        }
        System.out.println("================================================\n");
    }

    // Getters
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
}