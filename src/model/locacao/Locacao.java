package model.locacao;

import interfaces.Pagavel;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.veiculo.Veiculo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Locacao {

    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private Funcionario funcionario;
    private String dataRetirada;
    private String dataDevolucao;
    private String dataDevolucaoReal;
    private int quantidadeDias;
    private double valorTotal;
    private String status;
    private Pagavel formaPagamento;

    public Locacao(int id, Cliente cliente, Veiculo veiculo, Funcionario funcionario,
            String dataRetirada, String dataDevolucao) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolucaoReal = null;
        this.quantidadeDias = calcularDias(dataRetirada, dataDevolucao);
        this.status = "ABERTA";
        this.formaPagamento = null;
        this.valorTotal = veiculo.calcularValorDiaria() * this.quantidadeDias;
        veiculo.iniciarLocacao();
        cliente.incrementarLocacoes();
    }

    private static int calcularDias(String dataInicio, String dataFim) {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inicio = LocalDate.parse(dataInicio, fmt);
            LocalDate fim = LocalDate.parse(dataFim, fmt);
            long dias = ChronoUnit.DAYS.between(inicio, fim);
            return dias > 0 ? (int) dias : 1;
        } catch (Exception e) {
            return 1;
        }
    }

    public void encerrarLocacao(String dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.quantidadeDias = calcularDias(this.dataRetirada, dataDevolucaoReal);
        this.valorTotal = veiculo.calcularValorDiaria() * this.quantidadeDias;
        this.status = "ENCERRADA";
        veiculo.finalizarLocacao();
    }

    public void cancelarLocacao() {
        this.status = "CANCELADA";
        veiculo.finalizarLocacao();
    }

    public String getDescricaoCompleta() {
        String pagamentoInfo = formaPagamento != null ? formaPagamento.toString() : "Não definida";
        return String.format(
                "LOCAÇÃO\n" +
                        "  ID................: %d\n" +
                        "  Status............: %s\n" +
                        "  Cliente...........: [%d] %s\n" +
                        "  Veículo...........: [%d] %s %s (%s)\n" +
                        "  Funcionário.......: [%d] %s\n" +
                        "  Data Retirada.....: %s\n" +
                        "  Previsão Devolução: %s\n" +
                        "  Devolução Real....: %s\n" +
                        "  Qtd. de Dias......: %d dias\n" +
                        "  Diária do Veículo.: R$ %.2f\n" +
                        "  Valor Total.......: R$ %.2f\n" +
                        "  Forma de Pagamento: %s",
                id, status,
                cliente.getId(), cliente.getNome(),
                veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(),
                funcionario.getId(), funcionario.getNome(),
                dataRetirada, dataDevolucao,
                dataDevolucaoReal != null ? dataDevolucaoReal : "Em aberto",
                quantidadeDias, veiculo.calcularValorDiaria(),
                valorTotal, pagamentoInfo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo v) {
        this.veiculo = v;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario f) {
        this.funcionario = f;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String d) {
        this.dataRetirada = d;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String d) {
        this.dataDevolucao = d;
        this.quantidadeDias = calcularDias(this.dataRetirada, d);
        this.valorTotal = veiculo.calcularValorDiaria() * this.quantidadeDias;
    }

    public String getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int q) {
        this.quantidadeDias = q;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double v) {
        this.valorTotal = v;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public Pagavel getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Pagavel p) {
        this.formaPagamento = p;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | Cliente: %s | Veículo: %s %s | %s - %s (%d dia(s)) | R$ %.2f",
                id, status, cliente.getNome(),
                veiculo.getMarca(), veiculo.getModelo(),
                dataRetirada, dataDevolucao, quantidadeDias, valorTotal);
    }
}
