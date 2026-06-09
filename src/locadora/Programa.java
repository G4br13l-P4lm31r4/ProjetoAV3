package locadora;

import model.veiculo.*;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.locacao.Locacao;
import locadora.service.*;
import locadora.util.InputUtil;
import locadora.util.RelatorioUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        List<CarroLuxo> carrosLuxo = new ArrayList<>();
        List<Carro> carros = new ArrayList<>();
        List<Moto> motos = new ArrayList<>();
        List<Van> vans = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Locacao> locacoes = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int[] proxIdVeiculo = { 100 };
        int[] proxIdCliente = { 1 };
        int[] proxIdFunc = { 1 };
        int[] proxIdLocacao = { 1 };

        PreCadastro.executar(carrosLuxo, carros, motos, vans,
                clientes, funcionarios, locacoes, proxIdVeiculo, proxIdCliente, proxIdFunc, proxIdLocacao);

        System.out.println("------- BEM-VINDO À LOCADORA DE VEÍCULOS -------");
        System.out.printf("%d carros luxo, %d carros %n",
                carrosLuxo.size(), carros.size());
        System.out.printf("%d motos, %d vans pré-cadastrados %n",
                motos.size(), vans.size());
        System.out.printf("%d clientes, %d funcionários cadastrados %n",
                clientes.size(), funcionarios.size());
        System.out.printf("%d locações em andamento %n",
                locacoes.size());

        int opcao;
        do {
            System.out.println("------- MENU PRINCIPAL -------");
            System.out.println("1. Carros de Luxo");
            System.out.println("2. Carros");
            System.out.println("3. Motos");
            System.out.println("4. Vans");
            System.out.println("5. Clientes");
            System.out.println("6. Funcionários");
            System.out.println("7. Locações");
            System.out.println("8. Exportar relatório de encerradas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = InputUtil.lerInt(sc);
            switch (opcao) {
                case 1: {
                    int op;
                    do {
                        System.out.println("\n--- CARROS DE LUXO ---");
                        System.out.println("1. Incluir   2. Alterar   3. Excluir");
                        System.out.println("4. Listar    5. Buscar    0. Voltar");
                        System.out.print("Opção: ");
                        op = InputUtil.lerInt(sc);
                        switch (op) {
                            case 1: CarroLuxoService.incluir(sc, carrosLuxo, proxIdVeiculo); break;
                            case 2: CarroLuxoService.alterar(sc, carrosLuxo); break;
                            case 3: VeiculoService.excluir(carrosLuxo, "Carro de Luxo", sc); break;
                            case 4: VeiculoService.listar(carrosLuxo, "CARROS DE LUXO"); break;
                            case 5: VeiculoService.buscar(carrosLuxo, "Carro de Luxo", sc); break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (op != 0);
                    break;
                }
                case 2: {
                    int op;
                    do {
                        System.out.println("\n--- CARROS ---");
                        System.out.println("1. Incluir   2. Alterar   3. Excluir");
                        System.out.println("4. Listar    5. Buscar    0. Voltar");
                        System.out.print("Opção: ");
                        op = InputUtil.lerInt(sc);
                        switch (op) {
                            case 1: CarroService.incluir(sc, carros, proxIdVeiculo); break;
                            case 2: CarroService.alterar(sc, carros); break;
                            case 3: VeiculoService.excluir(carros, "Carro", sc); break;
                            case 4: VeiculoService.listar(carros, "CARROS"); break;
                            case 5: VeiculoService.buscar(carros, "Carro", sc); break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (op != 0);
                    break;
                }
                case 3: {
                    int op;
                    do {
                        System.out.println("\n--- MOTOS ---");
                        System.out.println("1. Incluir   2. Alterar   3. Excluir");
                        System.out.println("4. Listar    5. Buscar    0. Voltar");
                        System.out.print("Opção: ");
                        op = InputUtil.lerInt(sc);
                        switch (op) {
                            case 1: MotoService.incluir(sc, motos, proxIdVeiculo); break;
                            case 2: MotoService.alterar(sc, motos); break;
                            case 3: VeiculoService.excluir(motos, "Moto", sc); break;
                            case 4: VeiculoService.listar(motos, "MOTOS"); break;
                            case 5: VeiculoService.buscar(motos, "Moto", sc); break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (op != 0);
                    break;
                }
                case 4: {
                    int op;
                    do {
                        System.out.println("\n--- VANS ---");
                        System.out.println("1. Incluir   2. Alterar   3. Excluir");
                        System.out.println("4. Listar    5. Buscar    0. Voltar");
                        System.out.print("Opção: ");
                        op = InputUtil.lerInt(sc);
                        switch (op) {
                            case 1: VanService.incluir(sc, vans, proxIdVeiculo); break;
                            case 2: VanService.alterar(sc, vans); break;
                            case 3: VeiculoService.excluir(vans, "Van", sc); break;
                            case 4: VeiculoService.listar(vans, "VANS"); break;
                            case 5: VeiculoService.buscar(vans, "Van", sc); break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (op != 0);
                    break;
                }
                case 5: {
                    int op;
                    do {
                        System.out.println("\n--- CLIENTES ---");
                        System.out.println("1. Incluir   2. Alterar   3. Excluir");
                        System.out.println("4. Listar    5. Buscar    0. Voltar");
                        System.out.print("Opção: ");
                        op = InputUtil.lerInt(sc);
                        switch (op) {
                            case 1: ClienteService.incluir(sc, clientes, proxIdCliente); break;
                            case 2: ClienteService.alterar(sc, clientes); break;
                            case 3: ClienteService.excluir(sc, clientes); break;
                            case 4: ClienteService.listar(clientes); break;
                            case 5: ClienteService.buscar(sc, clientes); break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (op != 0);
                    break;
                }
                case 6: {
                    int op;
                    do {
                        System.out.println("\n--- FUNCIONÁRIOS ---");
                        System.out.println("1. Incluir   2. Alterar   3. Excluir");
                        System.out.println("4. Listar    5. Buscar    0. Voltar");
                        System.out.print("Opção: ");
                        op = InputUtil.lerInt(sc);
                        switch (op) {
                            case 1: FuncionarioService.incluir(sc, funcionarios, proxIdFunc); break;
                            case 2: FuncionarioService.alterar(sc, funcionarios); break;
                            case 3: FuncionarioService.excluir(sc, funcionarios); break;
                            case 4: FuncionarioService.listar(funcionarios); break;
                            case 5: FuncionarioService.buscar(sc, funcionarios); break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (op != 0);
                    break;
                }
                case 7: {
                    int op;
                    do {
                        System.out.println("\n--- LOCAÇÕES ---");
                        System.out.println("1. Nova Locação    2. Alterar Locação");
                        System.out.println("3. Encerrar        4. Cancelar");
                        System.out.println("5. Listar          6. Buscar");
                        System.out.println("7. Listar Disponíveis  0. Voltar");
                        System.out.print("Opção: ");
                        op = InputUtil.lerInt(sc);
                        switch (op) {
                            case 1:
                                LocacaoService.incluir(sc, locacoes, clientes, carrosLuxo, carros,
                                        motos, vans, funcionarios, proxIdLocacao);
                                break;
                            case 2: LocacaoService.alterar(sc, locacoes); break;
                            case 3: LocacaoService.encerrar(sc, locacoes); break;
                            case 4: LocacaoService.cancelar(sc, locacoes); break;
                            case 5: LocacaoService.listar(locacoes); break;
                            case 6: LocacaoService.buscar(sc, locacoes); break;
                            case 7:
                                VeiculoService.listarDisponiveis(carrosLuxo, carros, motos, vans);
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (op != 0);
                    break;
                }
                case 8:
                    RelatorioUtil.gerarRelatorioLocacoes(locacoes);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
        System.out.println("\nSistema encerrado. Até logo!");
    }
}
