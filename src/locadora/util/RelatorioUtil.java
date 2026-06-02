package locadora.util;

import model.locacao.Locacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class RelatorioUtil {

    private static final String ARQUIVO = "relatorio_locacoes.txt";

    public static void gerarRelatorioLocacoes(List<Locacao> locacoes) {
        List<Locacao> encerradas = locacoes.stream()
                .filter(l -> l.getStatus().equals("ENCERRADA"))
                .collect(Collectors.toList());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            String dataHora = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            bw.write("============================================================");
            bw.newLine();
            bw.write("       RELATÓRIO DE LOCAÇÕES ENCERRADAS");
            bw.newLine();
            bw.write("  Gerado em: " + dataHora);
            bw.newLine();
            bw.write("  Total de locações encerradas: " + encerradas.size());
            bw.newLine();
            bw.write("============================================================");
            bw.newLine();
            bw.newLine();

            if (encerradas.isEmpty()) {
                bw.write("Nenhuma locação encerrada encontrada.");
                bw.newLine();
            } else {
                for (Locacao loc : encerradas) {
                    bw.write(loc.getDescricaoCompleta());
                    bw.newLine();
                    bw.write("------------------------------------------------------------");
                    bw.newLine();
                }
            }

            System.out.println("Relatório gerado com sucesso: " + ARQUIVO
                    + " (" + encerradas.size() + " locação(ões) encerrada(s))");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}
