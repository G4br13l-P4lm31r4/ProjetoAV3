package model.pagamento;

import interfaces.Pagavel;

public class PagamentoPix implements Pagavel {

    private double valorPago;

    @Override
    public void processarPagamento(double valor) {
        this.valorPago = valor;
        System.out.printf("Pagamento via PIX de R$ %.2f processado com sucesso!%n", valor);
    }

    @Override
    public String toString() {
        return String.format("PIX (R$ %.2f)", valorPago);
    }
}
