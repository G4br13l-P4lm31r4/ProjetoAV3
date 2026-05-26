/**
 * Classe abstrata Veiculo
 * Representa um veículo genérico da frota da locadora.
 * Serve de base para todas as categorias de veículos (Carro, Moto, Van).
 * Implementa as interfaces Locavel e Manutivel para garantir
 * que todo veículo possa ser locado e submetido a manutenção.
 */
public abstract class Veiculo implements Locavel, Manutivel {

    // --- Atributos ---
    private int    id;           // Identificador único do veículo
    private String placa;        // Placa do veículo (ex.: ABC-1234)
    private String marca;        // Marca fabricante (ex.: Toyota)
    private String modelo;       // Modelo do veículo (ex.: Corolla)
    private int    ano;          // Ano de fabricação
    private double quilometragem; // KM rodados acumulados
    private boolean disponivel;  // true = disponível para locação
    private double custoTotalManutencao; // Soma dos custos de manutenção
    private String ultimaManutencao;     // Descrição da última manutenção

    // Quilometragem limite para acionar alerta de manutenção (10.000 km)
    private static final double KM_MANUTENCAO = 10000.0;

    /**
     * Construtor completo de Veiculo.
     * @param id           identificador único
     * @param placa        placa do veículo
     * @param marca        marca fabricante
     * @param modelo       modelo do veículo
     * @param ano          ano de fabricação
     * @param quilometragem quilometragem atual
     */
    public Veiculo(int id, String placa, String marca, String modelo, int ano, double quilometragem) {
        this.id                   = id;
        this.placa                = placa;
        this.marca                = marca;
        this.modelo               = modelo;
        this.ano                  = ano;
        this.quilometragem        = quilometragem;
        this.disponivel           = true;  // Todo veículo começa disponível
        this.custoTotalManutencao = 0.0;
        this.ultimaManutencao     = "Nenhuma registrada";
    }

    // --- Implementações de Locavel ---

    /**
     * Marca o veículo como indisponível (em locação).
     */
    @Override
    public void iniciarLocacao() {
        this.disponivel = false;
    }

    /**
     * Marca o veículo como disponível (locação encerrada).
     */
    @Override
    public void finalizarLocacao() {
        this.disponivel = true;
    }

    // --- Implementações de Manutivel ---

    /**
     * Registra manutenção: acumula custo e salva descrição.
     * @param descricao texto descritivo do serviço
     * @param custo     valor pago pelo serviço
     */
    @Override
    public void registrarManutencao(String descricao, double custo) {
        this.custoTotalManutencao += custo;
        this.ultimaManutencao      = descricao;
    }

    /**
     * Retorna true se a quilometragem ultrapassar o limite definido.
     * @return true se necessitar manutenção
     */
    @Override
    public boolean necessitaManutencao() {
        return this.quilometragem >= KM_MANUTENCAO;
    }

    /**
     * Retorna o custo total acumulado de todas as manutenções.
     * @return custo total em reais
     */
    @Override
    public double getCustoTotalManutencao() {
        return this.custoTotalManutencao;
    }

    // --- Método abstrato ---

    /**
     * Método abstrato que cada subclasse deve implementar
     * para retornar uma descrição detalhada do veículo.
     * @return String com os dados completos do veículo
     */
    public abstract String getDescricaoCompleta();

    // --- Getters e Setters ---

    /** @return id do veículo */
    public int getId() { return id; }

    /** @param id novo id */
    public void setId(int id) { this.id = id; }

    /** @return placa do veículo */
    public String getPlaca() { return placa; }

    /** @param placa nova placa */
    public void setPlaca(String placa) { this.placa = placa; }

    /** @return marca do veículo */
    public String getMarca() { return marca; }

    /** @param marca nova marca */
    public void setMarca(String marca) { this.marca = marca; }

    /** @return modelo do veículo */
    public String getModelo() { return modelo; }

    /** @param modelo novo modelo */
    public void setModelo(String modelo) { this.modelo = modelo; }

    /** @return ano de fabricação */
    public int getAno() { return ano; }

    /** @param ano novo ano */
    public void setAno(int ano) { this.ano = ano; }

    /** @return quilometragem atual */
    public double getQuilometragem() { return quilometragem; }

    /** @param quilometragem nova quilometragem */
    public void setQuilometragem(double quilometragem) { this.quilometragem = quilometragem; }

    /** @return true se disponível para locação */
    public boolean isDisponivel() { return disponivel; }

    /** @param disponivel novo estado de disponibilidade */
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    /** @return descrição da última manutenção */
    public String getUltimaManutencao() { return ultimaManutencao; }

    /**
     * Retorna uma linha resumida com dados básicos do veículo.
     * Útil para listagens rápidas.
     * @return String formatada com id, placa, marca, modelo, ano e disponibilidade
     */
    @Override
    public String toString() {
        return String.format("[%d] %s %s (%d) - Placa: %s - %s - KM: %.0f",
                id, marca, modelo, ano, placa,
                disponivel ? "DISPONÍVEL" : "LOCADO",
                quilometragem);
    }
}
