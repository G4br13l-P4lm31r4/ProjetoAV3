/**
 * Classe CarroLuxo
 * Representa um carro da categoria luxo da frota.
 * Estende Carro e adiciona itens de conforto e seguro incluso
 * como diferenciais desta categoria premium.
 * A diária é mais elevada, podendo incluir acréscimo percentual
 * sobre a base em função dos itens extras disponíveis.
 */
public class CarroLuxo extends Carro {

    // --- Atributos específicos ---
    private String itensConforto;    // Lista de itens (ex.: "Couro, Teto Solar, GPS")
    private boolean seguroIncluso;   // true se o seguro já está embutido na diária

    // Valor de diária elevado para a categoria luxo
    private static final double DIARIA_LUXO = 350.0;

    /**
     * Construtor completo de CarroLuxo.
     * @param id                    identificador único
     * @param placa                 placa do veículo
     * @param marca                 marca fabricante
     * @param modelo                modelo do veículo
     * @param ano                   ano de fabricação
     * @param quilometragem         quilometragem atual
     * @param numeroPortas          número de portas
     * @param tipoCombustivel       tipo de combustível
     * @param capacidadePortaMalas  volume do porta-malas em litros
     * @param itensConforto         itens extras de conforto
     * @param seguroIncluso         true se seguro está incluso na diária
     */
    public CarroLuxo(int id, String placa, String marca, String modelo, int ano,
                     double quilometragem, int numeroPortas, String tipoCombustivel,
                     double capacidadePortaMalas, String itensConforto, boolean seguroIncluso) {
        // Chama o construtor da superclasse Carro
        super(id, placa, marca, modelo, ano, quilometragem,
              numeroPortas, tipoCombustivel, capacidadePortaMalas);
        this.itensConforto  = itensConforto;
        this.seguroIncluso  = seguroIncluso;
    }

    // --- Sobrescrita do método abstrato ---

    /**
     * Retorna descrição completa do carro de luxo, incluindo itens e seguro.
     * @return String formatada com todos os dados
     */
    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "CARRO LUXO\n" +
            "  ID................: %d\n"  +
            "  Placa.............: %s\n"  +
            "  Marca.............: %s\n"  +
            "  Modelo............: %s\n"  +
            "  Ano...............: %d\n"  +
            "  Quilometragem.....: %.0f km\n" +
            "  Nº de Portas......: %d\n"  +
            "  Combustível.......: %s\n"  +
            "  Porta-malas.......: %.0f L\n" +
            "  Itens de Conforto.: %s\n"  +
            "  Seguro Incluso....: %s\n"  +
            "  Disponível........: %s\n"  +
            "  Diária............: R$ %.2f\n" +
            "  Última Manutenção.: %s\n"  +
            "  Custo Total Manut.: R$ %.2f",
            getId(), getPlaca(), getMarca(), getModelo(), getAno(),
            getQuilometragem(), getNumeroPortas(), getTipoCombustivel(),
            getCapacidadePortaMalas(), itensConforto,
            seguroIncluso ? "Sim" : "Não",
            isDisponivel() ? "Sim" : "Não",
            calcularValorDiaria(), getUltimaManutencao(),
            getCustoTotalManutencao()
        );
    }

    // --- Sobrescrita do cálculo de diária ---

    /**
     * Calcula a diária do carro de luxo.
     * Se o seguro estiver incluso, acrescenta 10% sobre a diária base.
     * @return valor da diária em reais
     */
    @Override
    public double calcularValorDiaria() {
        // Acréscimo de 10% quando o seguro já está embutido na diária
        return seguroIncluso ? DIARIA_LUXO * 1.10 : DIARIA_LUXO;
    }

    // --- Getters e Setters ---

    /** @return lista de itens de conforto */
    public String getItensConforto() { return itensConforto; }

    /** @param itensConforto novos itens de conforto */
    public void setItensConforto(String itensConforto) { this.itensConforto = itensConforto; }

    /** @return true se seguro está incluso */
    public boolean isSeguroIncluso() { return seguroIncluso; }

    /** @param seguroIncluso novo estado do seguro incluso */
    public void setSeguroIncluso(boolean seguroIncluso) { this.seguroIncluso = seguroIncluso; }
}
