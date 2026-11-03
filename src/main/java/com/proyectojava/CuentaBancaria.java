package com.proyectojava;

public class CuentaBancaria {
    // 1. Encapsulamiento con private (Atributos)
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // 2. Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // 3. Metodos con logica de negocio bancario

    public void depositar(double monto){
        if (monto > 0){
            this.saldo += monto;
            System.out.println("Deposito exitoso de $ " + monto + ". Nuevo Saldo " + this.saldo);
        } else {
            System.out.println("El deposito a depositar debe de ser mayor a 0.");
        }
    }
    public boolean retirar (double monto){
        if (monto > 0 && monto <= this.saldo){
            this.saldo -= monto;
            System.out.println("Retiro exitoso de $ " + monto + ". saldo restante: $" + this.saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes o monto invalido para el retiro.");
            return false;
        }
    }

        // 4. Getters para consultar la informacion

        public String getNumeroCuenta() { return numeroCuenta; }
        public String getTitular() { return titular; }
        public double getSaldo () { return saldo; }

}
