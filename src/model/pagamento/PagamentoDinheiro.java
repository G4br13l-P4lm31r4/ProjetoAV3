package model.pagamento;

import interfaces.Pagavel;

public class PagamentoDinheiro implements Pagavel {

    private double valorEntregue;
    private double troco;

    public PagamentoDinheiro(double valorEntregue) {
        this.valorEntregue = valorEntregue;
    }

    @Override
    public void processarPagamento(double valor) {
        this.troco = valorEntregue - valor;
        if (troco < 0) {
            System.out.printf("Valor insuficiente! Faltam R$ %.2f.%n", Math.abs(troco));
            this.troco = 0;
        } else {
            System.out.printf("Pagamento em Dinheiro: R$ %.2f recebido. Troco: R$ %.2f%n",
                    valorEntregue, troco);
        }
    }

    public double getValorEntregue()           { return valorEntregue; }
    public double getTroco()                   { return troco; }

    @Override
    public String toString() {
        return String.format("Dinheiro (entregue: R$ %.2f | troco: R$ %.2f)", valorEntregue, troco);
    }
}
