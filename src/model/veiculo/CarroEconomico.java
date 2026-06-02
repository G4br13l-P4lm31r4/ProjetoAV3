package model.veiculo;

public class CarroEconomico extends Carro {

    private double consumoMedio;

    private static final double DIARIA_ECONOMICO = 80.0;

    public CarroEconomico(int id, String placa, String marca, String modelo, int ano,
                          double quilometragem, int numeroPortas, String tipoCombustivel,
                          double capacidadePortaMalas, double consumoMedio) {
        super(id, placa, marca, modelo, ano, quilometragem,
              numeroPortas, tipoCombustivel, capacidadePortaMalas);
        this.consumoMedio = consumoMedio;
    }

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
            calcularValorDiaria(), getUltimaManutencao(), getCustoTotalManutencao()
        );
    }

    @Override public double calcularValorDiaria() { return DIARIA_ECONOMICO; }

    public double getConsumoMedio()            { return consumoMedio; }
    public void setConsumoMedio(double c)      { this.consumoMedio = c; }
}
