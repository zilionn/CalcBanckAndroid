package model;

public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial(String cliente, int num_conta, float saldo, float limite) {
        super(cliente, num_conta, saldo);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    @Override
    public void sacar(float valor) {
        if (valor <= getSaldo() + limite) {
            depositar(-valor); // Atualiza o saldo
        } else {
            System.out.println("Saldo insuficiente e limite excedido.");
        }
    }
}