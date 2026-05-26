/**
 * Classe Carro
 * Representa um carro genérico da frota da locadora.
 * Estende Veiculo e acrescenta atributos específicos de um automóvel:
 * número de portas, tipo de combustível e capacidade do porta-malas.
 * Serve de base para as subclasses CarroEconomico e CarroLuxo.
 */
public class Carro extends Veiculo {

    // --- Atributos específicos do Carro ---
    private int    numeroPortas;      // Número de portas (2 ou 4)
    private String tipoCombustivel;   // Gasolina, Etanol, Flex, Elétrico...
    private double capacidadePortaMalas; // Volume do porta-malas em litros

    // Valor base de diária para a categoria Carro
    private static final double DIARIA_BASE = 120.0;

    /**
     * Construtor completo de Carro.
     * @param id                    identificador único
     * @param placa                 placa do veículo
     * @param marca                 marca fabricante
     * @param modelo                modelo do veículo
     * @param ano                   ano de fabricação
     * @param quilometragem         quilometragem atual
     * @param numeroPortas          número de portas
     * @param tipoCombustivel       tipo de combustível
     * @param capacidadePortaMalas  volume do porta-malas em litros
     */
    public Carro(int id, String placa, String marca, String modelo, int ano,
                 double quilometragem, int numeroPortas,
                 String tipoCombustivel, double capacidadePortaMalas) {
        // Chama o construtor da superclasse Veiculo
        super(id, placa, marca, modelo, ano, quilometragem);
        this.numeroPortas         = numeroPortas;
        this.tipoCombustivel      = tipoCombustivel;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    // --- Implementação do método abstrato de Veiculo ---

    /**
     * Retorna a descrição completa do carro com todos os seus atributos.
     * @return String formatada com dados do carro
     */
    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "CARRO\n" +
            "  ID................: %d\n"  +
            "  Placa.............: %s\n"  +
            "  Marca.............: %s\n"  +
            "  Modelo............: %s\n"  +
            "  Ano...............: %d\n"  +
            "  Quilometragem.....: %.0f km\n" +
            "  Nº de Portas......: %d\n"  +
            "  Combustível.......: %s\n"  +
            "  Porta-malas.......: %.0f L\n" +
            "  Disponível........: %s\n"  +
            "  Diária............: R$ %.2f\n" +
            "  Última Manutenção.: %s\n"  +
            "  Custo Total Manut.: R$ %.2f",
            getId(), getPlaca(), getMarca(), getModelo(), getAno(),
            getQuilometragem(), numeroPortas, tipoCombustivel,
            capacidadePortaMalas, isDisponivel() ? "Sim" : "Não",
            calcularValorDiaria(), getUltimaManutencao(),
            getCustoTotalManutencao()
        );
    }

    // --- Implementação de calcularValorDiaria (Locavel) ---

    /**
     * Calcula a diária do carro com base no valor fixo da categoria.
     * @return valor da diária em reais
     */
    @Override
    public double calcularValorDiaria() {
        return DIARIA_BASE;
    }

    // --- Getters e Setters ---

    /** @return número de portas */
    public int getNumeroPortas() { return numeroPortas; }

    /** @param numeroPortas novo número de portas */
    public void setNumeroPortas(int numeroPortas) { this.numeroPortas = numeroPortas; }

    /** @return tipo de combustível */
    public String getTipoCombustivel() { return tipoCombustivel; }

    /** @param tipoCombustivel novo tipo de combustível */
    public void setTipoCombustivel(String tipoCombustivel) { this.tipoCombustivel = tipoCombustivel; }

    /** @return capacidade do porta-malas em litros */
    public double getCapacidadePortaMalas() { return capacidadePortaMalas; }

    /** @param capacidadePortaMalas nova capacidade do porta-malas */
    public void setCapacidadePortaMalas(double capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }
}
