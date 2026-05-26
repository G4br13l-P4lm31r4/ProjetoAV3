/**
 * Classe Locacao
 * Representa um contrato de locação de veículo entre um cliente
 * e a locadora, registrado por um funcionário.
 * Armazena os dados do período, veículo, cliente, funcionário
 * responsável e o valor total calculado.
 */
public class Locacao {

    // --- Atributos ---
    private int       id;                 // Identificador único da locação
    private Cliente   cliente;            // Cliente que realizou a locação
    private Veiculo   veiculo;            // Veículo locado
    private Funcionario funcionario;      // Funcionário que registrou a locação
    private String    dataRetirada;       // Data de retirada (dd/MM/aaaa)
    private String    dataDevolucao;      // Data de devolução prevista (dd/MM/aaaa)
    private String    dataDevolucaoReal;  // Data real de devolução (null se em aberto)
    private int       quantidadeDias;     // Número de dias da locação
    private double    valorTotal;         // Valor total calculado
    private String    status;             // ABERTA, ENCERRADA ou CANCELADA
    private String    observacoes;        // Observações adicionais

    /**
     * Construtor completo de Locacao.
     * Ao criar a locação, o veículo é marcado como indisponível
     * e o contador de locações do cliente é incrementado.
     *
     * @param id             identificador único
     * @param cliente        cliente locatário
     * @param veiculo        veículo a ser locado
     * @param funcionario    funcionário que registra a locação
     * @param dataRetirada   data de retirada do veículo
     * @param dataDevolucao  data prevista de devolução
     * @param quantidadeDias número de dias da locação
     * @param observacoes    observações adicionais
     */
    public Locacao(int id, Cliente cliente, Veiculo veiculo, Funcionario funcionario,
                   String dataRetirada, String dataDevolucao,
                   int quantidadeDias, String observacoes) {
        this.id             = id;
        this.cliente        = cliente;
        this.veiculo        = veiculo;
        this.funcionario    = funcionario;
        this.dataRetirada   = dataRetirada;
        this.dataDevolucao  = dataDevolucao;
        this.dataDevolucaoReal = null;       // Ainda não devolvido
        this.quantidadeDias = quantidadeDias;
        this.observacoes    = observacoes;
        this.status         = "ABERTA";

        // Calcula o valor total com base na diária do veículo
        this.valorTotal = veiculo.calcularValorDiaria() * quantidadeDias;

        // Marca o veículo como indisponível para novas locações
        veiculo.iniciarLocacao();

        // Incrementa o histórico de locações do cliente
        cliente.incrementarLocacoes();
    }

    /**
     * Encerra a locação: define a data real de devolução,
     * recalcula o valor se o prazo foi diferente do previsto
     * e libera o veículo para novas locações.
     *
     * @param dataDevolucaoReal data real de devolução
     * @param diasReais         número real de dias utilizados
     */
    public void encerrarLocacao(String dataDevolucaoReal, int diasReais) {
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.quantidadeDias    = diasReais;
        // Recalcula o valor com o número real de dias
        this.valorTotal = veiculo.calcularValorDiaria() * diasReais;
        this.status     = "ENCERRADA";
        // Libera o veículo
        veiculo.finalizarLocacao();
    }

    /**
     * Cancela a locação e libera o veículo para novas locações.
     */
    public void cancelarLocacao() {
        this.status = "CANCELADA";
        veiculo.finalizarLocacao();
    }

    /**
     * Retorna a descrição completa da locação com todos os dados.
     * @return String formatada com todas as informações
     */
    public String getDescricaoCompleta() {
        return String.format(
            "LOCAÇÃO\n" +
            "  ID................: %d\n"  +
            "  Status............: %s\n"  +
            "  Cliente...........: [%d] %s\n" +
            "  Veículo...........: [%d] %s %s (%s)\n" +
            "  Funcionário.......: [%d] %s\n" +
            "  Data Retirada.....: %s\n"  +
            "  Previsão Devolução: %s\n"  +
            "  Devolução Real....: %s\n"  +
            "  Qtd. de Dias......: %d dias\n" +
            "  Diária do Veículo.: R$ %.2f\n" +
            "  Valor Total.......: R$ %.2f\n" +
            "  Observações.......: %s",
            id, status,
            cliente.getId(), cliente.getNome(),
            veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(),
            funcionario.getId(), funcionario.getNome(),
            dataRetirada, dataDevolucao,
            dataDevolucaoReal != null ? dataDevolucaoReal : "Em aberto",
            quantidadeDias, veiculo.calcularValorDiaria(),
            valorTotal, observacoes
        );
    }

    // --- Getters e Setters ---

    /** @return id da locação */
    public int getId() { return id; }

    /** @param id novo id */
    public void setId(int id) { this.id = id; }

    /** @return cliente locatário */
    public Cliente getCliente() { return cliente; }

    /** @param cliente novo cliente */
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    /** @return veículo locado */
    public Veiculo getVeiculo() { return veiculo; }

    /** @param veiculo novo veículo */
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    /** @return funcionário responsável */
    public Funcionario getFuncionario() { return funcionario; }

    /** @param funcionario novo funcionário */
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    /** @return data de retirada */
    public String getDataRetirada() { return dataRetirada; }

    /** @param dataRetirada nova data de retirada */
    public void setDataRetirada(String dataRetirada) { this.dataRetirada = dataRetirada; }

    /** @return data prevista de devolução */
    public String getDataDevolucao() { return dataDevolucao; }

    /** @param dataDevolucao nova data prevista de devolução */
    public void setDataDevolucao(String dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    /** @return data real de devolução */
    public String getDataDevolucaoReal() { return dataDevolucaoReal; }

    /** @return quantidade de dias */
    public int getQuantidadeDias() { return quantidadeDias; }

    /** @param quantidadeDias nova quantidade de dias */
    public void setQuantidadeDias(int quantidadeDias) { this.quantidadeDias = quantidadeDias; }

    /** @return valor total da locação */
    public double getValorTotal() { return valorTotal; }

    /** @param valorTotal novo valor total */
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    /** @return status da locação */
    public String getStatus() { return status; }

    /** @param status novo status */
    public void setStatus(String status) { this.status = status; }

    /** @return observações */
    public String getObservacoes() { return observacoes; }

    /** @param observacoes novas observações */
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    /**
     * Retorna resumo da locação em uma linha.
     * @return String com id, status, cliente, veículo e valor
     */
    @Override
    public String toString() {
        return String.format("[%d] %s | Cliente: %s | Veículo: %s %s | Valor: R$ %.2f",
                id, status, cliente.getNome(),
                veiculo.getMarca(), veiculo.getModelo(), valorTotal);
    }
}
