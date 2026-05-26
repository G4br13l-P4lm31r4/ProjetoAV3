/**
 * Interface Manutivel
 * Define o contrato para objetos que podem passar por manutenção.
 * Toda classe que implemente esta interface deve fornecer os métodos
 * de registrar manutenção e verificar necessidade de manutenção.
 */
public interface Manutivel {

    /**
     * Registra uma manutenção realizada no veículo.
     * @param descricao descrição do serviço realizado
     * @param custo     custo em reais do serviço
     */
    void registrarManutencao(String descricao, double custo);

    /**
     * Verifica se o veículo necessita de manutenção com base
     * na quilometragem ou tempo desde a última revisão.
     * @return true se precisar de manutenção, false caso contrário
     */
    boolean necessitaManutencao();

    /**
     * Retorna o custo total acumulado de manutenções do veículo.
     * @return custo total em reais (double)
     */
    double getCustoTotalManutencao();
}
