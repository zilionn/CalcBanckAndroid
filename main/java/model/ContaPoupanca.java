package model;
public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    public ContaPoupanca(String cliente, int num_conta, float saldo, int diaRendimento) {
        super(cliente, num_conta, saldo);
        this.diaRendimento = diaRendimento;
    }

    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        float novoSaldo = getSaldo() + (getSaldo() * taxaRendimento / 100);
        depositar(novoSaldo - getSaldo());
    }
}
