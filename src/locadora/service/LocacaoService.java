package locadora.service;

import model.veiculo.*;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.locacao.Locacao;
import model.pagamento.*;
import interfaces.Pagavel;
import locadora.util.InputUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class LocacaoService {

    public static Locacao buscarPorId(List<Locacao> lista, int id) {
        for (Locacao l : lista)
            if (l.getId() == id)
                return l;
        return null;
    }

    public static void incluir(Scanner sc, List<Locacao> locacoes, List<Cliente> clientes,
            List<CarroLuxo> carrosLuxo,
            List<Carro> carros, List<Moto> motos, List<Van> vans,
            List<Funcionario> funcionarios, int[] proxId) {
        System.out.println("\n-- NOVA LOCAÇÃO --");
        ClienteService.listar(clientes);
        System.out.print("ID do Cliente: ");
        Cliente cli = ClienteService.buscarPorId(clientes, InputUtil.lerInt(sc));
        if (cli == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        VeiculoService.listarDisponiveis(carrosLuxo, carros, motos, vans);
        System.out.println("\nTipo: 1-CarroLuxo  2-Carro  3-Moto  4-Van");
        System.out.print("Tipo: ");
        int tipo = InputUtil.lerInt(sc);
        System.out.print("ID do Veículo: ");
        Veiculo vei = encontrarVeiculoDisponivel(tipo, InputUtil.lerInt(sc), carrosLuxo, carros, motos, vans);
        if (vei == null) {
            System.out.println("Veículo não encontrado ou indisponível.");
            return;
        }
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário disponível.");
            return;
        }
        Funcionario func = funcionarios.get((int) (Math.random() * funcionarios.size()));
        System.out.println("Funcionário responsável: " + func.getNome());
        System.out.print("Data de Retirada (dd/MM/aaaa): ");
        String ret = sc.nextLine().trim();
        System.out.print("Data de Devolução (dd/MM/aaaa): ");
        String dev = sc.nextLine().trim();
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            long dias = ChronoUnit.DAYS.between(LocalDate.parse(ret, fmt), LocalDate.parse(dev, fmt));
            System.out.printf("Período: %s - %s → %d dia(s)%n", ret, dev, dias > 0 ? dias : 1);
        } catch (Exception ignored) {}
        Locacao loc = new Locacao(proxId[0]++, cli, vei, func, ret, dev);
        locacoes.add(loc);
        System.out.printf("Locação ID %d criada! Valor total: R$ %.2f%n", loc.getId(), loc.getValorTotal());
    }

    private static Veiculo encontrarVeiculoDisponivel(int tipo, int id,
            List<CarroLuxo> carrosLuxo,
            List<Carro> carros, List<Moto> motos, List<Van> vans) {
        Veiculo v = null;
        switch (tipo) {
            case 1:
                v = VeiculoService.buscarPorId(carrosLuxo, id);
                break;
            case 2:
                v = VeiculoService.buscarPorId(carros, id);
                break;
            case 3:
                v = VeiculoService.buscarPorId(motos, id);
                break;
            case 4:
                v = VeiculoService.buscarPorId(vans, id);
                break;
        }
        return (v != null && v.isDisponivel()) ? v : null;
    }

    public static void alterar(Scanner sc, List<Locacao> lista) {
        System.out.print("\nID da Locação a alterar: ");
        int id = InputUtil.lerInt(sc);
        Locacao loc = buscarPorId(lista, id);
        if (loc == null) {
            System.out.println("Não encontrada.");
            return;
        }
        if (!loc.getStatus().equals("ABERTA")) {
            System.out.println("Só é possível alterar locações ABERTAS.");
            return;
        }
        System.out.print("Data Devolução [" + loc.getDataDevolucao() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            loc.setDataDevolucao(v);
        System.out.println("Locação ID " + id + " alterada com sucesso!");
    }

    public static void encerrar(Scanner sc, List<Locacao> lista) {
        System.out.print("\nID da Locação a encerrar: ");
        int id = InputUtil.lerInt(sc);
        Locacao loc = buscarPorId(lista, id);
        if (loc == null) {
            System.out.println("Não encontrada.");
            return;
        }
        if (!loc.getStatus().equals("ABERTA")) {
            System.out.println("Locação já está " + loc.getStatus());
            return;
        }
        System.out.print("Data dlução Real (dd/MM/aaaa): ");
        String data = sc.nextLine().trim();
        loc.encerrarLocacao(data);
        System.out.printf("Locação encerrada! Valor final: R$ %.2f%n", loc.getValorTotal());
        System.out.println("\n-- FORMA DE PAGAMENTO --");
        System.out.println("1. PIX   2. Cartão de Crédito");
        System.out.print("Opção: ");
        Pagavel pagamento = null;
        switch (InputUtil.lerInt(sc)) {
            case 1:
                pagamento = new PagamentoPix();
                break;
            case 2:
                System.out.print("Número de parcelas: ");
                int parcelas = InputUtil.lerInt(sc);
                pagamento = new PagamentoCartaoCredito(parcelas < 1 ? 1 : parcelas);
                break;
            default:
                System.out.println("Forma de pagamento inválida. Pagamento não registrado.");
        }
        if (pagamento != null) {
            pagamento.processarPagamento(loc.getValorTotal());
            loc.setFormaPagamento(pagamento);
        }
    }

    public static void cancelar(Scanner sc, List<Locacao> lista) {
        System.out.print("\nID da Locação a cancelar: ");
        int id = InputUtil.lerInt(sc);
        Locacao loc = buscarPorId(lista, id);
        if (loc == null) {
            System.out.println("Não encontrada.");
            return;
        }
        if (!loc.getStatus().equals("ABERTA")) {
            System.out.println("Locação já está " + loc.getStatus());
            return;
        }
        System.out.print("Confirma cancelamento? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            loc.cancelarLocacao();
            System.out.println("Locação cancelada e veículo liberado.");
        }
    }

    public static void listar(List<Locacao> lista) {
        System.out.println("\n=== LISTA DE LOCAÇÕES ===");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma locação cadastrada.");
            return;
        }
        for (Locacao l : lista)
            System.out.println(l);
    }

    public static void buscar(Scanner sc, List<Locacao> lista) {
        System.out.println("\n-- BUSCAR LOCAÇÃO --");
        System.out.println("1. Por ID   2. Por Cliente   3. Por Status");
        System.out.print("Opção: ");
        switch (InputUtil.lerInt(sc)) {
            case 1:
                System.out.print("ID: ");
                Locacao l = buscarPorId(lista, InputUtil.lerInt(sc));
                if (l != null)
                    System.out.println("\n" + l.getDescricaoCompleta());
                else
                    System.out.println("Não encontrada.");
                break;
            case 2:
                System.out.print("Nome do Cliente (parcial): ");
                String nome = sc.nextLine().trim().toLowerCase();
                boolean achou = false;
                for (Locacao loc : lista) {
                    if (loc.getCliente().getNome().toLowerCase().contains(nome)) {
                        System.out.println("\n" + loc.getDescricaoCompleta());
                        achou = true;
                    }
                }
                if (!achou)
                    System.out.println("Nenhuma locação encontrada.");
                break;
            case 3:
                System.out.print("Status (ABERTA/ENCERRADA/CANCELADA): ");
                String status = sc.nextLine().trim().toUpperCase();
                for (Locacao loc : lista) {
                    if (loc.getStatus().equals(status))
                        System.out.println(loc);
                }
                break;
        }
    }
}
