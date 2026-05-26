/**
 * Classe Moto
 * Representa uma motocicleta da frota da locadora.
 * Estende Veiculo e acrescenta cilindrada, tipo de moto
 * e a exigência de habilitação categoria A.
 */
public class Moto extends Veiculo {

    // --- Atributos específicos ---
    private int    cilindrada;        // Cilindrada em cc (ex.: 150, 300, 600)
    private String tipoMoto;          // Sport, Trail, Touring, Naked, Scooter...
    private boolean exigeHabilitacaoA; // true = necessita CNH categoria A

    // Valor base de diária para motos
    private static final double DIARIA_BASE_MOTO = 90.0;

    /**
     * Construtor completo de Moto.
     * @param id                  identificador único
     * @param placa               placa da moto
     * @param marca               marca fabricante
     * @param modelo              modelo da moto
     * @param ano                 ano de fabricação
     * @param quilometragem       quilometragem atual
     * @param cilindrada          cilindrada em cc
     * @param tipoMoto            categoria/tipo da moto
     * @param exigeHabilitacaoA   true se exige CNH-A
     */
    public Moto(int id, String placa, String marca, String modelo, int ano,
                double quilometragem, int cilindrada,
                String tipoMoto, boolean exigeHabilitacaoA) {
        // Chama o construtor da superclasse Veiculo
        super(id, placa, marca, modelo, ano, quilometragem);
        this.cilindrada         = cilindrada;
        this.tipoMoto           = tipoMoto;
        this.exigeHabilitacaoA  = exigeHabilitacaoA;
    }

    // --- Implementação do método abstrato ---

    /**
     * Retorna descrição completa da moto com todos os atributos.
     * @return String formatada com os dados da moto
     */
    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "MOTO\n" +
            "  ID................: %d\n"  +
            "  Placa.............: %s\n"  +
            "  Marca.............: %s\n"  +
            "  Modelo............: %s\n"  +
            "  Ano...............: %d\n"  +
            "  Quilometragem.....: %.0f km\n" +
            "  Cilindrada........: %d cc\n"   +
            "  Tipo..............: %s\n"  +
            "  Exige CNH-A.......: %s\n"  +
            "  Disponível........: %s\n"  +
            "  Diária............: R$ %.2f\n" +
            "  Última Manutenção.: %s\n"  +
            "  Custo Total Manut.: R$ %.2f",
            getId(), getPlaca(), getMarca(), getModelo(), getAno(),
            getQuilometragem(), cilindrada, tipoMoto,
            exigeHabilitacaoA ? "Sim" : "Não",
            isDisponivel() ? "Sim" : "Não",
            calcularValorDiaria(), getUltimaManutencao(),
            getCustoTotalManutencao()
        );
    }

    // --- Implementação do cálculo de diária ---

    /**
     * Calcula a diária da moto.
     * Motos acima de 500 cc têm acréscimo de 30% por serem mais potentes.
     * @return valor da diária em reais
     */
    @Override
    public double calcularValorDiaria() {
        if (cilindrada > 500) {
            return DIARIA_BASE_MOTO * 1.30; // +30% para motos de alta cilindrada
        }
        return DIARIA_BASE_MOTO;
    }

    // --- Getters e Setters ---

    /** @return cilindrada em cc */
    public int getCilindrada() { return cilindrada; }

    /** @param cilindrada nova cilindrada */
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }

    /** @return tipo/categoria da moto */
    public String getTipoMoto() { return tipoMoto; }

    /** @param tipoMoto novo tipo de moto */
    public void setTipoMoto(String tipoMoto) { this.tipoMoto = tipoMoto; }

    /** @return true se exige habilitação categoria A */
    public boolean isExigeHabilitacaoA() { return exigeHabilitacaoA; }

    /** @param exigeHabilitacaoA novo valor do requisito de CNH-A */
    public void setExigeHabilitacaoA(boolean exigeHabilitacaoA) {
        this.exigeHabilitacaoA = exigeHabilitacaoA;
    }
}
