package interfaces;

public interface Manutivel {
    void registrarManutencao(String descricao, double custo);
    boolean necessitaManutencao();
    double getCustoTotalManutencao();
}
