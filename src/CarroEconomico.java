/**
 * Classe CarroEconomico
 * Representa um carro da categoria econômica da frota.
 * Estende Carro e adiciona o consumo médio de combustível
 * como critério de diferenciação.
 * A diária é menor que a de um Carro padrão, refletindo
 * o posicionamento de mercado desta categoria.
 */
public class CarroEconomico extends Carro {

    // --- Atributos específicos ---
    private double consumoMedio; // Consumo médio em km/litro

    // Valor de diária reduzido para a categoria econômica
    private static final double DIARIA_ECONOMICO = 80.0;

    /**
     * Construtor completo de CarroEconomico.
     * @param id                    identificador único
     * @param placa                 placa do veículo
     * @param marca                 marca fabricante
     * @param modelo                modelo do veículo
     * @param ano                   ano de fabricação
     * @param quilometragem         quilometragem atual
     * @param numeroPortas          número de portas
     * @param tipoCombustivel       tipo de combustível
     * @param capacidadePortaMalas  volume do porta-malas em litros
     * @param consumoMedio          consumo médio em km/litro
     */
    public CarroEconomico(int id, String placa, String marca, String modelo, int ano,
                          double quilometragem, int numeroPortas, String tipoCombustivel,
                          double capacidadePortaMalas, double consumoMedio) {
        // Chama o construtor da superclasse Carro
        super(id, placa, marca, modelo, ano, quilometragem,
              numeroPortas, tipoCombustivel, capacidadePortaMalas);
        this.consumoMedio = consumoMedio;
    }

    // --- Sobrescrita do método abstrato ---

    /**
     * Retorna descrição completa do carro econômico, incluindo consumo médio.
     * @return String formatada com todos os dados
     */
    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "CARRO ECONÔMICO\n" +
            "  ID................: %d\n"  +
            "  Placa.............: %s\n"  +
            "  Marca.............: %s\n"  +
            "  Modelo............: %s\n"  +
            "  Ano...............: %d\n"  +
            "  Quilometragem.....: %.0f km\n" +
            "  Nº de Portas......: %d\n"  +
            "  Combustível.......: %s\n"  +
            "  Porta-malas.......: %.0f L\n" +
            "  Consumo Médio.....: %.1f km/L\n" +
            "  Disponível........: %s\n"  +
            "  Diária............: R$ %.2f\n" +
            "  Última Manutenção.: %s\n"  +
            "  Custo Total Manut.: R$ %.2f",
            getId(), getPlaca(), getMarca(), getModelo(), getAno(),
            getQuilometragem(), getNumeroPortas(), getTipoCombustivel(),
            getCapacidadePortaMalas(), consumoMedio,
            isDisponivel() ? "Sim" : "Não",
            calcularValorDiaria(), getUltimaManutencao(),
            getCustoTotalManutencao()
        );
    }

    // --- Sobrescrita do cálculo de diária ---

    /**
     * Retorna o valor fixo de diária para a categoria econômica.
     * @return valor da diária em reais
     */
    @Override
    public double calcularValorDiaria() {
        return DIARIA_ECONOMICO;
    }

    // --- Getters e Setters ---

    /** @return consumo médio em km/litro */
    public double getConsumoMedio() { return consumoMedio; }

    /** @param consumoMedio novo consumo médio */
    public void setConsumoMedio(double consumoMedio) { this.consumoMedio = consumoMedio; }
}
