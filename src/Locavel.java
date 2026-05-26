/**
 * Interface Locavel
 * Define o contrato para objetos que podem ser locados no sistema.
 * Toda classe que implemente esta interface deve fornecer os métodos
 * de iniciar e finalizar uma locação, além de calcular o valor diário.
 */
public interface Locavel {

    /**
     * Inicia o processo de locação do veículo.
     * Deve alterar o estado do veículo para "indisponível".
     */
    void iniciarLocacao();

    /**
     * Finaliza o processo de locação do veículo.
     * Deve alterar o estado do veículo para "disponível".
     */
    void finalizarLocacao();

    /**
     * Calcula o valor da diária de locação do veículo.
     * @return valor em reais (double) da diária
     */
    double calcularValorDiaria();
}
