package locadora.service;

import model.veiculo.*;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.locacao.Locacao;
import model.pagamento.*;
import interfaces.Pagavel;
import locadora.util.InputUtil;

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
            List<CarroEconomico> carrosEco, List<CarroLuxo> carrosLuxo,
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
        VeiculoService.listarDisponiveis(carrosEco, carrosLuxo, carros, motos, vans);
        System.out.println("\nTipo: 1-CarroEco  2-CarroLuxo  3-Carro  4-Moto  5-Van");
        System.out.print("Tipo: ");
        int tipo = InputUtil.lerInt(sc);
        System.out.print("ID do Veículo: ");
        Veiculo vei = encontrarVeiculoDisponivel(tipo, InputUtil.lerInt(sc), carrosEco, carrosLuxo, carros, motos,
                vans);
        if (vei == null) {
            System.out.println("Veículo não encontrado ou indisponível.");
            return;
        }
        FuncionarioService.listar(funcionarios);
        System.out.print("ID do Funcionário: ");
        Funcionario func = FuncionarioService.buscarPorId(funcionarios, InputUtil.lerInt(sc));
        if (func == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }
        System.out.print("Data de Retirada (dd/MM/aaaa): ");
        String ret = sc.nextLine().trim();
        System.out.print("Data de Devolução (dd/MM/aaaa): ");
        String dev = sc.nextLine().trim();
        System.out.print("Quantidade de Dias: ");
        int dias = InputUtil.lerInt(sc);
        System.out.print("Observações: ");
        String obs = sc.nextLine().trim();
        Locacao loc = new Locacao(proxId[0]++, cli, vei, func, ret, dev, dias, obs);
        locacoes.add(loc);
        System.out.printf("Locação ID %d criada! Valor total: R$ %.2f%n", loc.getId(), loc.getValorTotal());
    }

    private static Veiculo encontrarVeiculoDisponivel(int tipo, int id,
            List<CarroEconomico> carrosEco, List<CarroLuxo> carrosLuxo,
            List<Carro> carros, List<Moto> motos, List<Van> vans) {
        Veiculo v = null;
        switch (tipo) {
            case 1:
                v = VeiculoService.buscarPorId(carrosEco, id);
                break;
            case 2:
                v = VeiculoService.buscarPorId(carrosLuxo, id);
                break;
            case 3:
                v = VeiculoService.buscarPorId(carros, id);
                break;
            case 4:
                v = VeiculoService.buscarPorId(motos, id);
                break;
            case 5:
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
        System.out.print("Observações [" + loc.getObservacoes() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            loc.setObservacoes(v);
        System.out.print("Data Devolução [" + loc.getDataDevolucao() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            loc.setDataDevolucao(v);
        System.out.print("Quantidade de Dias [" + loc.getQuantidadeDias() + "] (0=manter): ");
        int n = InputUtil.lerInt(sc);
        if (n > 0)
            loc.setQuantidadeDias(n);
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
        System.out.print("Data de Devolução Real (dd/MM/aaaa): ");
        String data = sc.nextLine().trim();
        System.out.print("Dias reais utilizados: ");
        int dias = InputUtil.lerInt(sc);
        loc.encerrarLocacao(data, dias);
        System.out.printf("Locação encerrada! Valor final: R$ %.2f%n", loc.getValorTotal());
        System.out.println("\n-- FORMA DE PAGAMENTO --");
        System.out.println("1. PIX   2. Cartão de Crédito   3. Dinheiro");
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
            case 3:
                System.out.printf("Valor a pagar: R$ %.2f%nValor entregue: R$ ", loc.getValorTotal());
                pagamento = new PagamentoDinheiro(InputUtil.lerDouble(sc));
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
