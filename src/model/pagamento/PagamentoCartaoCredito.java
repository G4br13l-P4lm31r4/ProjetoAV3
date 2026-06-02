package model.pagamento;

import interfaces.Pagavel;

public class PagamentoCartaoCredito implements Pagavel {

    private int    numeroParcelas;
    private double valorPago;

    public PagamentoCartaoCredito(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    @Override
    public void processarPagamento(double valor) {
        this.valorPago = valor;
        double parcela = valor / numeroParcelas;
        System.out.printf("Pagamento via Cartão de Crédito: %dx de R$ %.2f (total: R$ %.2f) processado!%n",
                numeroParcelas, parcela, valor);
    }

    public int getNumeroParcelas()             { return numeroParcelas; }
    public void setNumeroParcelas(int n)       { this.numeroParcelas = n; }

    @Override
    public String toString() {
        return String.format("Cartão de Crédito %dx de R$ %.2f",
                numeroParcelas, numeroParcelas > 0 ? valorPago / numeroParcelas : valorPago);
    }
}
