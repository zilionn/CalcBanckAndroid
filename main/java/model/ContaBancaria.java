package model;
public class ContaBancaria {
    private String cliente;
    private int num_conta;
    private float saldo;

    public ContaBancaria(String cliente, int num_conta, float saldo) {
        this.cliente = cliente;
        this.num_conta = num_conta;
        this.saldo = saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void sacar(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(float valor) {
        saldo += valor;
    }
}