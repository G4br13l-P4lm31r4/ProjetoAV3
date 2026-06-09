package model.veiculo;

public class CarroLuxo extends Carro {

    private String itensConforto;
    private boolean seguroIncluso;

    private static final double DIARIA_LUXO = 350.0;

    public CarroLuxo(int id, String placa, String marca, String modelo, int ano,
            double quilometragem, int numeroPortas, String tipoCombustivel,
            double capacidadePortaMalas, String itensConforto, boolean seguroIncluso) {
        super(id, placa, marca, modelo, ano, quilometragem,
                numeroPortas, tipoCombustivel, capacidadePortaMalas);
        this.itensConforto = itensConforto;
        this.seguroIncluso = seguroIncluso;
    }

    @Override
    public String getDescricaoCompleta() {
        return String.format(
                "CARRO LUXO\n" +
                        "  ID................: %d\n" +
                        "  Placa.............: %s\n" +
                        "  Marca.............: %s\n" +
                        "  Modelo............: %s\n" +
                        "  Ano...............: %d\n" +
                        "  Quilometragem.....: %.0f km\n" +
                        "  Nº de Portas......: %d\n" +
                        "  Combustível.......: %s\n" +
                        "  Porta-malas.......: %.0f L\n" +
                        "  Itens de Conforto.: %s\n" +
                        "  Seguro Incluso....: %s\n" +
                        "  Disponível........: %s\n" +
                        "  Diária............: R$ %.2f\n" +
                        "  Última Manutenção.: %s\n" +
                        "  Custo Total Manut.: R$ %.2f",
                getId(), getPlaca(), getMarca(), getModelo(), getAno(),
                getQuilometragem(), getNumeroPortas(), getTipoCombustivel(),
                getCapacidadePortaMalas(), itensConforto,
                seguroIncluso ? "Sim" : "Não",
                isDisponivel() ? "Sim" : "Não",
                calcularValorDiaria(), getUltimaManutencao(), getCustoTotalManutencao());
    }

    @Override
    public double calcularValorDiaria() {
        return seguroIncluso ? DIARIA_LUXO * 1.10 : DIARIA_LUXO;
    }

    public String getItensConforto() {
        return itensConforto;
    }

    public void setItensConforto(String i) {
        this.itensConforto = i;
    }

    public boolean isSeguroIncluso() {
        return seguroIncluso;
    }

    public void setSeguroIncluso(boolean s) {
        this.seguroIncluso = s;
    }
}
