/**
 * Classe Van
 * Representa uma van da frota da locadora.
 * Estende Veiculo e acrescenta capacidade de passageiros,
 * presença de ar-condicionado e finalidade de uso (passeio ou carga).
 * Vans têm diária mais elevada por comportarem mais passageiros.
 */
public class Van extends Veiculo {

    // --- Atributos específicos ---
    private int     capacidadePassageiros; // Número máximo de passageiros
    private boolean arCondicionado;        // true se possui ar-condicionado
    private String  finalidade;            // "Passeio" ou "Carga"

    // Valor base de diária para vans
    private static final double DIARIA_BASE_VAN = 200.0;

    /**
     * Construtor completo de Van.
     * @param id                     identificador único
     * @param placa                  placa da van
     * @param marca                  marca fabricante
     * @param modelo                 modelo da van
     * @param ano                    ano de fabricação
     * @param quilometragem          quilometragem atual
     * @param capacidadePassageiros  número máximo de passageiros
     * @param arCondicionado         true se possui ar-condicionado
     * @param finalidade             "Passeio" ou "Carga"
     */
    public Van(int id, String placa, String marca, String modelo, int ano,
               double quilometragem, int capacidadePassageiros,
               boolean arCondicionado, String finalidade) {
        // Chama o construtor da superclasse Veiculo
        super(id, placa, marca, modelo, ano, quilometragem);
        this.capacidadePassageiros = capacidadePassageiros;
        this.arCondicionado        = arCondicionado;
        this.finalidade            = finalidade;
    }

    // --- Implementação do método abstrato ---

    /**
     * Retorna descrição completa da van com todos os atributos.
     * @return String formatada com os dados da van
     */
    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "VAN\n" +
            "  ID................: %d\n"  +
            "  Placa.............: %s\n"  +
            "  Marca.............: %s\n"  +
            "  Modelo............: %s\n"  +
            "  Ano...............: %d\n"  +
            "  Quilometragem.....: %.0f km\n" +
            "  Capacidade........: %d passageiros\n" +
            "  Ar-condicionado...: %s\n"  +
            "  Finalidade........: %s\n"  +
            "  Disponível........: %s\n"  +
            "  Diária............: R$ %.2f\n" +
            "  Última Manutenção.: %s\n"  +
            "  Custo Total Manut.: R$ %.2f",
            getId(), getPlaca(), getMarca(), getModelo(), getAno(),
            getQuilometragem(), capacidadePassageiros,
            arCondicionado ? "Sim" : "Não", finalidade,
            isDisponivel() ? "Sim" : "Não",
            calcularValorDiaria(), getUltimaManutencao(),
            getCustoTotalManutencao()
        );
    }

    // --- Implementação do cálculo de diária ---

    /**
     * Calcula a diária da van.
     * Vans para passeio com mais de 12 lugares têm +20%.
     * Vans com ar-condicionado têm +15% adicionais.
     * @return valor da diária em reais
     */
    @Override
    public double calcularValorDiaria() {
        double diaria = DIARIA_BASE_VAN;
        if (capacidadePassageiros > 12) {
            diaria *= 1.20; // +20% para vans grandes
        }
        if (arCondicionado) {
            diaria *= 1.15; // +15% para vans com ar-condicionado
        }
        return diaria;
    }

    // --- Getters e Setters ---

    /** @return capacidade máxima de passageiros */
    public int getCapacidadePassageiros() { return capacidadePassageiros; }

    /** @param capacidadePassageiros nova capacidade de passageiros */
    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    /** @return true se possui ar-condicionado */
    public boolean isArCondicionado() { return arCondicionado; }

    /** @param arCondicionado novo estado do ar-condicionado */
    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    /** @return finalidade da van (Passeio ou Carga) */
    public String getFinalidade() { return finalidade; }

    /** @param finalidade nova finalidade */
    public void setFinalidade(String finalidade) { this.finalidade = finalidade; }
}
