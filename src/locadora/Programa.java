package locadora;

import model.veiculo.*;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.locacao.Locacao;
import model.pagamento.*;
import interfaces.Pagavel;
import locadora.util.RelatorioUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

    private static List<CarroEconomico> carrosEconomicos = new ArrayList<>();
    private static List<CarroLuxo>      carrosLuxo       = new ArrayList<>();
    private static List<Carro>          carros           = new ArrayList<>();
    private static List<Moto>           motos            = new ArrayList<>();
    private static List<Van>            vans             = new ArrayList<>();
    private static List<Cliente>        clientes         = new ArrayList<>();
    private static List<Funcionario>    funcionarios     = new ArrayList<>();
    private static List<Locacao>        locacoes         = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    private static int proxIdVeiculo = 100;
    private static int proxIdCliente = 1;
    private static int proxIdFunc    = 1;
    private static int proxIdLocacao = 1;

    public static void main(String[] args) {
        preCadastrar();
        menuPrincipal();
        sc.close();
        System.out.println("\nSistema encerrado. Até logo!");
    }

    private static void preCadastrar() {

        // Carros Econômicos (8)
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0001", "Volkswagen", "Gol",       2020, 35000, 4, "Flex",     255, 12.5));
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0002", "Fiat",       "Uno",       2019, 52000, 4, "Flex",     240, 13.0));
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0003", "Chevrolet",  "Onix",      2021, 18000, 4, "Flex",     205, 14.2));
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0004", "Renault",    "Kwid",      2022,  8000, 4, "Flex",     210, 15.0));
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0005", "Ford",       "Ka",        2019, 44000, 4, "Flex",     257, 12.8));
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0006", "Hyundai",    "HB20",      2021, 26000, 4, "Flex",     270, 13.5));
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0007", "Toyota",     "Etios",     2018, 61000, 4, "Flex",     250, 12.2));
        carrosEconomicos.add(new CarroEconomico(proxIdVeiculo++, "ECO-0008", "Fiat",       "Mobi",      2023,  3000, 4, "Flex",     220, 15.5));

        // Carros de Luxo (8)
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0001", "BMW",        "Série 3",  2022,  9000, 4, "Gasolina", 480, "Couro, Teto Solar, GPS, Bang&Olufsen", true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0002", "Mercedes",   "Classe C", 2023,  4000, 4, "Gasolina", 455, "Couro, Sunroof, Câmera 360°",         true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0003", "Audi",       "A4",       2022, 12000, 4, "Gasolina", 460, "Couro, Teto Solar, MMI Touch",         true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0004", "Volvo",      "XC60",     2021, 22000, 4, "Gasolina", 505, "Couro, Piloto Automático, Harman",     false));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0005", "Jaguar",     "XE",       2020, 31000, 4, "Gasolina", 455, "Couro, JaguarDrive Control",           false));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0006", "Porsche",    "Panamera", 2023,  2000, 4, "Gasolina", 495, "Full Premium, Bose, Night Vision",     true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0007", "Tesla",      "Model 3",  2023,  7000, 4, "Elétrico", 425, "Piloto Automático, Autopilot Full",    true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo++, "LUX-0008", "Lexus",      "ES 350",   2022, 15000, 4, "Gasolina", 470, "Couro, Mark Levinson, Sunroof",        false));

        // Carros Genéricos (8)
        carros.add(new Carro(proxIdVeiculo++, "CAR-0001", "Toyota",     "Corolla",   2021, 28000, 4, "Flex",     528));
        carros.add(new Carro(proxIdVeiculo++, "CAR-0002", "Hyundai",    "Creta",     2022, 15000, 4, "Flex",     422));
        carros.add(new Carro(proxIdVeiculo++, "CAR-0003", "Honda",      "Civic",     2020, 38000, 4, "Gasolina", 519));
        carros.add(new Carro(proxIdVeiculo++, "CAR-0004", "Chevrolet",  "Cruze",     2019, 47000, 4, "Flex",     508));
        carros.add(new Carro(proxIdVeiculo++, "CAR-0005", "Volkswagen", "Virtus",    2022, 21000, 4, "Flex",     500));
        carros.add(new Carro(proxIdVeiculo++, "CAR-0006", "Jeep",       "Compass",   2021, 32000, 4, "Diesel",   515));
        carros.add(new Carro(proxIdVeiculo++, "CAR-0007", "Nissan",     "Sentra",    2020, 41000, 4, "Gasolina", 513));
        carros.add(new Carro(proxIdVeiculo++, "CAR-0008", "Fiat",       "Cronos",    2023,  6000, 4, "Flex",     475));

        // Motos (8)
        motos.add(new Moto(proxIdVeiculo++, "MOT-0001", "Honda",   "CB 300R",     2022,  8000, 300,  "Naked",   true));
        motos.add(new Moto(proxIdVeiculo++, "MOT-0002", "Yamaha",  "MT-07",       2021, 14000, 700,  "Naked",   true));
        motos.add(new Moto(proxIdVeiculo++, "MOT-0003", "Kawasaki","Z400",        2023,  2000, 400,  "Naked",   true));
        motos.add(new Moto(proxIdVeiculo++, "MOT-0004", "Honda",   "PCX 150",     2022,  9000, 150,  "Scooter", false));
        motos.add(new Moto(proxIdVeiculo++, "MOT-0005", "Suzuki",  "Burgman 400", 2020, 22000, 400,  "Scooter", true));
        motos.add(new Moto(proxIdVeiculo++, "MOT-0006", "BMW",     "R 1250 GS",   2022, 18000, 1250, "Trail",   true));
        motos.add(new Moto(proxIdVeiculo++, "MOT-0007", "Honda",   "CG 160",      2021, 31000, 160,  "Street",  false));
        motos.add(new Moto(proxIdVeiculo++, "MOT-0008", "Ducati",  "Monster 937", 2023,  1500, 937,  "Naked",   true));

        // Vans (8)
        vans.add(new Van(proxIdVeiculo++, "VAN-0001", "Mercedes",   "Sprinter 415", 2021, 55000, 15, true,  "Passeio"));
        vans.add(new Van(proxIdVeiculo++, "VAN-0002", "Fiat",       "Ducato",       2020, 70000, 13, true,  "Carga"));
        vans.add(new Van(proxIdVeiculo++, "VAN-0003", "Ford",       "Transit",      2022, 30000, 15, true,  "Passeio"));
        vans.add(new Van(proxIdVeiculo++, "VAN-0004", "Renault",    "Master",       2019, 88000, 16, false, "Passeio"));
        vans.add(new Van(proxIdVeiculo++, "VAN-0005", "Volkswagen", "Crafter",      2021, 42000, 17, true,  "Passeio"));
        vans.add(new Van(proxIdVeiculo++, "VAN-0006", "Iveco",      "Daily",        2020, 65000, 16, false, "Carga"));
        vans.add(new Van(proxIdVeiculo++, "VAN-0007", "Mercedes",   "Vito",         2022, 19000,  8, true,  "Passeio"));
        vans.add(new Van(proxIdVeiculo++, "VAN-0008", "Toyota",     "HiAce",        2023,  7000, 12, true,  "Passeio"));

        // Clientes (8)
        clientes.add(new Cliente(proxIdCliente++, "Ana Beatriz Lima",    "111.222.333-01", "(11)91111-1111", "ana@email.com",      "Rua das Flores, 10",   "AB111111", "B",  "15/03/1990"));
        clientes.add(new Cliente(proxIdCliente++, "Bruno Souza",         "222.333.444-02", "(21)92222-2222", "bruno@email.com",    "Av. Brasil, 200",      "BR222222", "AB", "22/07/1985"));
        clientes.add(new Cliente(proxIdCliente++, "Carla Mendes",        "333.444.555-03", "(31)93333-3333", "carla@email.com",    "Rua Ipê, 55",          "CM333333", "B",  "10/11/1992"));
        clientes.add(new Cliente(proxIdCliente++, "Diego Ferreira",      "444.555.666-04", "(41)94444-4444", "diego@email.com",    "Rua das Palmeiras, 7", "DF444444", "A",  "05/01/1988"));
        clientes.add(new Cliente(proxIdCliente++, "Elisa Costa",         "555.666.777-05", "(51)95555-5555", "elisa@email.com",    "Av. das Nações, 300",  "EC555555", "B",  "30/06/1995"));
        clientes.add(new Cliente(proxIdCliente++, "Fernando Rocha",      "666.777.888-06", "(61)96666-6666", "fernando@email.com", "SQS 308, Bloco A",     "FR666666", "AB", "18/09/1980"));
        clientes.add(new Cliente(proxIdCliente++, "Gabriela Oliveira",   "777.888.999-07", "(71)97777-7777", "gabi@email.com",     "Ladeira do Sol, 12",   "GO777777", "B",  "25/02/1998"));
        clientes.add(new Cliente(proxIdCliente++, "Henrique Nascimento", "888.999.000-08", "(81)98888-8888", "henrique@email.com", "Rua do Mar, 88",       "HN888888", "B",  "12/12/1975"));

        // Funcionários (8)
        funcionarios.add(new Funcionario(proxIdFunc++, "João Carlos Pereira", "011.022.033-01", "(11)98000-1001", "joao@locadora.com",   "Rua A, 1", "F001", "Gerente",     5500.00, "01/03/2015"));
        funcionarios.add(new Funcionario(proxIdFunc++, "Maria Silva",         "022.033.044-02", "(11)98000-1002", "maria@locadora.com",  "Rua B, 2", "F002", "Atendente",   2800.00, "05/07/2018"));
        funcionarios.add(new Funcionario(proxIdFunc++, "Pedro Alves",         "033.044.055-03", "(11)98000-1003", "pedro@locadora.com",  "Rua C, 3", "F003", "Mecânico",    3200.00, "12/01/2019"));
        funcionarios.add(new Funcionario(proxIdFunc++, "Luisa Ramos",         "044.055.066-04", "(11)98000-1004", "luisa@locadora.com",  "Rua D, 4", "F004", "Atendente",   2800.00, "20/04/2020"));
        funcionarios.add(new Funcionario(proxIdFunc++, "Carlos Teixeira",     "055.066.077-05", "(11)98000-1005", "carlos@locadora.com", "Rua E, 5", "F005", "Motorista",   2500.00, "08/09/2017"));
        funcionarios.add(new Funcionario(proxIdFunc++, "Patrícia Duarte",     "066.077.088-06", "(11)98000-1006", "pat@locadora.com",    "Rua F, 6", "F006", "Supervisora", 4200.00, "15/02/2016"));
        funcionarios.add(new Funcionario(proxIdFunc++, "Roberto Campos",      "077.088.099-07", "(11)98000-1007", "roberto@locadora.com","Rua G, 7", "F007", "Financeiro",  3800.00, "03/06/2021"));
        funcionarios.add(new Funcionario(proxIdFunc++, "Simone Freitas",      "088.099.000-08", "(11)98000-1008", "simone@locadora.com", "Rua H, 8", "F008", "Atendente",   2800.00, "10/10/2022"));

        // Locações (8)
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(0), carrosEconomicos.get(0), funcionarios.get(1), "01/05/2026", "05/05/2026", 4, "Sem observações"));
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(1), carrosLuxo.get(0),       funcionarios.get(1), "02/05/2026", "07/05/2026", 5, "Cliente VIP"));
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(2), motos.get(0),            funcionarios.get(3), "03/05/2026", "04/05/2026", 1, "Passeio fim de semana"));
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(3), vans.get(0),             funcionarios.get(3), "05/05/2026", "10/05/2026", 5, "Viagem em grupo"));
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(4), carros.get(0),           funcionarios.get(1), "06/05/2026", "09/05/2026", 3, "Viagem a trabalho"));
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(5), carrosEconomicos.get(1), funcionarios.get(3), "07/05/2026", "11/05/2026", 4, "Carro reserva"));
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(6), carrosLuxo.get(1),       funcionarios.get(1), "08/05/2026", "12/05/2026", 4, "Lua de mel"));
        locacoes.add(new Locacao(proxIdLocacao++, clientes.get(7), motos.get(2),            funcionarios.get(3), "09/05/2026", "10/05/2026", 1, "Passeio cidade"));

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║       BEM-VINDO À LOCADORA DE VEÍCULOS           ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.printf ("║  %d carros econômicos, %d carros luxo, %d carros    ║%n",
                carrosEconomicos.size(), carrosLuxo.size(), carros.size());
        System.out.printf ("║  %d motos, %d vans pré-cadastrados                 ║%n",
                motos.size(), vans.size());
        System.out.printf ("║  %d clientes, %d funcionários cadastrados          ║%n",
                clientes.size(), funcionarios.size());
        System.out.printf ("║  %d locações em andamento                         ║%n",
                locacoes.size());
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║           MENU PRINCIPAL             ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Carros Econômicos                 ║");
            System.out.println("║ 2. Carros de Luxo                    ║");
            System.out.println("║ 3. Carros                            ║");
            System.out.println("║ 4. Motos                             ║");
            System.out.println("║ 5. Vans                              ║");
            System.out.println("║ 6. Clientes                          ║");
            System.out.println("║ 7. Funcionários                      ║");
            System.out.println("║ 8. Locações                          ║");
            System.out.println("║ 9. Exportar relatório de encerradas  ║");
            System.out.println("║ 0. Sair                              ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: menuCarroEconomico(); break;
                case 2: menuCarroLuxo();      break;
                case 3: menuCarro();          break;
                case 4: menuMoto();           break;
                case 5: menuVan();            break;
                case 6: menuCliente();        break;
                case 7: menuFuncionario();    break;
                case 8: menuLocacao();        break;
                case 9: RelatorioUtil.gerarRelatorioLocacoes(locacoes); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuCarroEconomico() {
        int opcao;
        do {
            System.out.println("\n--- CARROS ECONÔMICOS ---");
            System.out.println("1. Incluir   2. Alterar   3. Excluir");
            System.out.println("4. Listar    5. Buscar    0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirCarroEconomico(); break;
                case 2: alterarCarroEconomico(); break;
                case 3: excluirVeiculo(carrosEconomicos, "Carro Econômico"); break;
                case 4: listarVeiculos(carrosEconomicos, "CARROS ECONÔMICOS"); break;
                case 5: buscarVeiculo(carrosEconomicos, "Carro Econômico"); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirCarroEconomico() {
        System.out.println("\n-- INCLUIR CARRO ECONÔMICO --");
        System.out.print("Placa: ");           String placa  = sc.nextLine().trim();
        System.out.print("Marca: ");           String marca  = sc.nextLine().trim();
        System.out.print("Modelo: ");          String modelo = sc.nextLine().trim();
        System.out.print("Ano: ");             int    ano    = lerInt();
        System.out.print("Quilometragem: ");   double km     = lerDouble();
        System.out.print("Nº de Portas: ");    int    portas = lerInt();
        System.out.print("Combustível: ");     String comb   = sc.nextLine().trim();
        System.out.print("Porta-malas (L): "); double pm     = lerDouble();
        System.out.print("Consumo (km/L): ");  double cons   = lerDouble();
        CarroEconomico ce = new CarroEconomico(proxIdVeiculo++, placa, marca, modelo, ano, km, portas, comb, pm, cons);
        carrosEconomicos.add(ce);
        System.out.println("Carro Econômico ID " + ce.getId() + " incluído com sucesso!");
    }

    private static void alterarCarroEconomico() {
        System.out.print("\nID do Carro Econômico a alterar: ");
        int id = lerInt();
        CarroEconomico ce = buscarCarroEconomicoPorId(id);
        if (ce == null) { System.out.println("Não encontrado."); return; }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Placa [" + ce.getPlaca() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) ce.setPlaca(v);
        System.out.print("Marca [" + ce.getMarca() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) ce.setMarca(v);
        System.out.print("Modelo [" + ce.getModelo() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) ce.setModelo(v);
        System.out.print("Ano [" + ce.getAno() + "] (0=manter): ");
        int n = lerInt(); if (n != 0) ce.setAno(n);
        System.out.print("Quilometragem [" + ce.getQuilometragem() + "] (0=manter): ");
        double d = lerDouble(); if (d != 0) ce.setQuilometragem(d);
        System.out.print("Nº de Portas [" + ce.getNumeroPortas() + "] (0=manter): ");
        n = lerInt(); if (n != 0) ce.setNumeroPortas(n);
        System.out.print("Combustível [" + ce.getTipoCombustivel() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) ce.setTipoCombustivel(v);
        System.out.print("Porta-malas [" + ce.getCapacidadePortaMalas() + "] (0=manter): ");
        d = lerDouble(); if (d != 0) ce.setCapacidadePortaMalas(d);
        System.out.print("Consumo [" + ce.getConsumoMedio() + "] (0=manter): ");
        d = lerDouble(); if (d != 0) ce.setConsumoMedio(d);
        System.out.println("Carro Econômico ID " + id + " alterado com sucesso!");
    }

    private static CarroEconomico buscarCarroEconomicoPorId(int id) {
        for (CarroEconomico ce : carrosEconomicos) if (ce.getId() == id) return ce;
        return null;
    }

    private static void menuCarroLuxo() {
        int opcao;
        do {
            System.out.println("\n--- CARROS DE LUXO ---");
            System.out.println("1. Incluir   2. Alterar   3. Excluir");
            System.out.println("4. Listar    5. Buscar    0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirCarroLuxo(); break;
                case 2: alterarCarroLuxo(); break;
                case 3: excluirVeiculo(carrosLuxo, "Carro de Luxo"); break;
                case 4: listarVeiculos(carrosLuxo, "CARROS DE LUXO"); break;
                case 5: buscarVeiculo(carrosLuxo, "Carro de Luxo"); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirCarroLuxo() {
        System.out.println("\n-- INCLUIR CARRO DE LUXO --");
        System.out.print("Placa: ");              String placa  = sc.nextLine().trim();
        System.out.print("Marca: ");              String marca  = sc.nextLine().trim();
        System.out.print("Modelo: ");             String modelo = sc.nextLine().trim();
        System.out.print("Ano: ");                int    ano    = lerInt();
        System.out.print("Quilometragem: ");      double km     = lerDouble();
        System.out.print("Nº de Portas: ");       int    portas = lerInt();
        System.out.print("Combustível: ");        String comb   = sc.nextLine().trim();
        System.out.print("Porta-malas (L): ");    double pm     = lerDouble();
        System.out.print("Itens de Conforto: ");  String itens  = sc.nextLine().trim();
        System.out.print("Seguro Incluso (s/n): "); boolean seg = sc.nextLine().trim().equalsIgnoreCase("s");
        CarroLuxo cl = new CarroLuxo(proxIdVeiculo++, placa, marca, modelo, ano, km, portas, comb, pm, itens, seg);
        carrosLuxo.add(cl);
        System.out.println("Carro de Luxo ID " + cl.getId() + " incluído com sucesso!");
    }

    private static void alterarCarroLuxo() {
        System.out.print("\nID do Carro de Luxo a alterar: ");
        int id = lerInt();
        CarroLuxo cl = buscarCarroLuxoPorId(id);
        if (cl == null) { System.out.println("Não encontrado."); return; }
        System.out.print("Placa [" + cl.getPlaca() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) cl.setPlaca(v);
        System.out.print("Marca [" + cl.getMarca() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cl.setMarca(v);
        System.out.print("Modelo [" + cl.getModelo() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cl.setModelo(v);
        System.out.print("Ano [" + cl.getAno() + "] (0=manter): ");
        int n = lerInt(); if (n != 0) cl.setAno(n);
        System.out.print("Itens Conforto [" + cl.getItensConforto() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cl.setItensConforto(v);
        System.out.print("Seguro Incluso [" + (cl.isSeguroIncluso() ? "s" : "n") + "] (s/n, vazio=manter): ");
        v = sc.nextLine().trim();
        if (v.equalsIgnoreCase("s")) cl.setSeguroIncluso(true);
        else if (v.equalsIgnoreCase("n")) cl.setSeguroIncluso(false);
        System.out.println("Carro de Luxo ID " + id + " alterado com sucesso!");
    }

    private static CarroLuxo buscarCarroLuxoPorId(int id) {
        for (CarroLuxo cl : carrosLuxo) if (cl.getId() == id) return cl;
        return null;
    }

    private static void menuCarro() {
        int opcao;
        do {
            System.out.println("\n--- CARROS ---");
            System.out.println("1. Incluir   2. Alterar   3. Excluir");
            System.out.println("4. Listar    5. Buscar    0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirCarro(); break;
                case 2: alterarCarro(); break;
                case 3: excluirVeiculo(carros, "Carro"); break;
                case 4: listarVeiculos(carros, "CARROS"); break;
                case 5: buscarVeiculo(carros, "Carro"); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirCarro() {
        System.out.println("\n-- INCLUIR CARRO --");
        System.out.print("Placa: ");           String placa  = sc.nextLine().trim();
        System.out.print("Marca: ");           String marca  = sc.nextLine().trim();
        System.out.print("Modelo: ");          String modelo = sc.nextLine().trim();
        System.out.print("Ano: ");             int    ano    = lerInt();
        System.out.print("Quilometragem: ");   double km     = lerDouble();
        System.out.print("Nº de Portas: ");    int    portas = lerInt();
        System.out.print("Combustível: ");     String comb   = sc.nextLine().trim();
        System.out.print("Porta-malas (L): "); double pm     = lerDouble();
        Carro c = new Carro(proxIdVeiculo++, placa, marca, modelo, ano, km, portas, comb, pm);
        carros.add(c);
        System.out.println("Carro ID " + c.getId() + " incluído com sucesso!");
    }

    private static void alterarCarro() {
        System.out.print("\nID do Carro a alterar: ");
        int id = lerInt();
        Carro c = buscarCarroPorId(id);
        if (c == null) { System.out.println("Não encontrado."); return; }
        System.out.print("Placa [" + c.getPlaca() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) c.setPlaca(v);
        System.out.print("Marca [" + c.getMarca() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) c.setMarca(v);
        System.out.print("Modelo [" + c.getModelo() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) c.setModelo(v);
        System.out.print("Ano [" + c.getAno() + "] (0=manter): ");
        int n = lerInt(); if (n != 0) c.setAno(n);
        System.out.print("Nº de Portas [" + c.getNumeroPortas() + "] (0=manter): ");
        n = lerInt(); if (n != 0) c.setNumeroPortas(n);
        System.out.print("Combustível [" + c.getTipoCombustivel() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) c.setTipoCombustivel(v);
        System.out.println("Carro ID " + id + " alterado com sucesso!");
    }

    private static Carro buscarCarroPorId(int id) {
        for (Carro c : carros) if (c.getId() == id) return c;
        return null;
    }

    private static void menuMoto() {
        int opcao;
        do {
            System.out.println("\n--- MOTOS ---");
            System.out.println("1. Incluir   2. Alterar   3. Excluir");
            System.out.println("4. Listar    5. Buscar    0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirMoto(); break;
                case 2: alterarMoto(); break;
                case 3: excluirVeiculo(motos, "Moto"); break;
                case 4: listarVeiculos(motos, "MOTOS"); break;
                case 5: buscarVeiculo(motos, "Moto"); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirMoto() {
        System.out.println("\n-- INCLUIR MOTO --");
        System.out.print("Placa: ");           String placa  = sc.nextLine().trim();
        System.out.print("Marca: ");           String marca  = sc.nextLine().trim();
        System.out.print("Modelo: ");          String modelo = sc.nextLine().trim();
        System.out.print("Ano: ");             int    ano    = lerInt();
        System.out.print("Quilometragem: ");   double km     = lerDouble();
        System.out.print("Cilindrada (cc): "); int    cil    = lerInt();
        System.out.print("Tipo (Naked/Trail/Scooter/...): "); String tipo = sc.nextLine().trim();
        System.out.print("Exige CNH-A (s/n): "); boolean cnh = sc.nextLine().trim().equalsIgnoreCase("s");
        Moto m = new Moto(proxIdVeiculo++, placa, marca, modelo, ano, km, cil, tipo, cnh);
        motos.add(m);
        System.out.println("Moto ID " + m.getId() + " incluída com sucesso!");
    }

    private static void alterarMoto() {
        System.out.print("\nID da Moto a alterar: ");
        int id = lerInt();
        Moto m = buscarMotoPorId(id);
        if (m == null) { System.out.println("Não encontrada."); return; }
        System.out.print("Placa [" + m.getPlaca() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) m.setPlaca(v);
        System.out.print("Marca [" + m.getMarca() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) m.setMarca(v);
        System.out.print("Modelo [" + m.getModelo() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) m.setModelo(v);
        System.out.print("Cilindrada [" + m.getCilindrada() + "] (0=manter): ");
        int n = lerInt(); if (n != 0) m.setCilindrada(n);
        System.out.print("Tipo [" + m.getTipoMoto() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) m.setTipoMoto(v);
        System.out.print("Exige CNH-A [" + (m.isExigeHabilitacaoA() ? "s" : "n") + "] (s/n, vazio=manter): ");
        v = sc.nextLine().trim();
        if (v.equalsIgnoreCase("s")) m.setExigeHabilitacaoA(true);
        else if (v.equalsIgnoreCase("n")) m.setExigeHabilitacaoA(false);
        System.out.println("Moto ID " + id + " alterada com sucesso!");
    }

    private static Moto buscarMotoPorId(int id) {
        for (Moto m : motos) if (m.getId() == id) return m;
        return null;
    }

    private static void menuVan() {
        int opcao;
        do {
            System.out.println("\n--- VANS ---");
            System.out.println("1. Incluir   2. Alterar   3. Excluir");
            System.out.println("4. Listar    5. Buscar    0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirVan(); break;
                case 2: alterarVan(); break;
                case 3: excluirVeiculo(vans, "Van"); break;
                case 4: listarVeiculos(vans, "VANS"); break;
                case 5: buscarVeiculo(vans, "Van"); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirVan() {
        System.out.println("\n-- INCLUIR VAN --");
        System.out.print("Placa: ");                 String placa  = sc.nextLine().trim();
        System.out.print("Marca: ");                 String marca  = sc.nextLine().trim();
        System.out.print("Modelo: ");                String modelo = sc.nextLine().trim();
        System.out.print("Ano: ");                   int    ano    = lerInt();
        System.out.print("Quilometragem: ");         double km     = lerDouble();
        System.out.print("Cap. Passageiros: ");      int    cap    = lerInt();
        System.out.print("Ar-condicionado (s/n): "); boolean ar    = sc.nextLine().trim().equalsIgnoreCase("s");
        System.out.print("Finalidade (Passeio/Carga): "); String fin = sc.nextLine().trim();
        Van van = new Van(proxIdVeiculo++, placa, marca, modelo, ano, km, cap, ar, fin);
        vans.add(van);
        System.out.println("Van ID " + van.getId() + " incluída com sucesso!");
    }

    private static void alterarVan() {
        System.out.print("\nID da Van a alterar: ");
        int id = lerInt();
        Van van = buscarVanPorId(id);
        if (van == null) { System.out.println("Não encontrada."); return; }
        System.out.print("Placa [" + van.getPlaca() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) van.setPlaca(v);
        System.out.print("Marca [" + van.getMarca() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) van.setMarca(v);
        System.out.print("Modelo [" + van.getModelo() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) van.setModelo(v);
        System.out.print("Cap. Passageiros [" + van.getCapacidadePassageiros() + "] (0=manter): ");
        int n = lerInt(); if (n != 0) van.setCapacidadePassageiros(n);
        System.out.print("Ar-condicionado [" + (van.isArCondicionado() ? "s" : "n") + "] (s/n, vazio=manter): ");
        v = sc.nextLine().trim();
        if (v.equalsIgnoreCase("s")) van.setArCondicionado(true);
        else if (v.equalsIgnoreCase("n")) van.setArCondicionado(false);
        System.out.print("Finalidade [" + van.getFinalidade() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) van.setFinalidade(v);
        System.out.println("Van ID " + id + " alterada com sucesso!");
    }

    private static Van buscarVanPorId(int id) {
        for (Van van : vans) if (van.getId() == id) return van;
        return null;
    }

    private static void menuCliente() {
        int opcao;
        do {
            System.out.println("\n--- CLIENTES ---");
            System.out.println("1. Incluir   2. Alterar   3. Excluir");
            System.out.println("4. Listar    5. Buscar    0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirCliente(); break;
                case 2: alterarCliente(); break;
                case 3: excluirCliente(); break;
                case 4: listarClientes(); break;
                case 5: buscarCliente(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirCliente() {
        System.out.println("\n-- INCLUIR CLIENTE --");
        System.out.print("Nome: ");          String nome  = sc.nextLine().trim();
        System.out.print("CPF: ");           String cpf   = sc.nextLine().trim();
        System.out.print("Telefone: ");      String tel   = sc.nextLine().trim();
        System.out.print("E-mail: ");        String email = sc.nextLine().trim();
        System.out.print("Endereço: ");      String end   = sc.nextLine().trim();
        System.out.print("Nº CNH: ");        String cnh   = sc.nextLine().trim();
        System.out.print("Categoria CNH: "); String cat   = sc.nextLine().trim();
        System.out.print("Data Nascimento (dd/MM/aaaa): "); String nasc = sc.nextLine().trim();
        Cliente cli = new Cliente(proxIdCliente++, nome, cpf, tel, email, end, cnh, cat, nasc);
        clientes.add(cli);
        System.out.println("Cliente ID " + cli.getId() + " incluído com sucesso!");
    }

    private static void alterarCliente() {
        System.out.print("\nID do Cliente a alterar: ");
        int id = lerInt();
        Cliente cli = buscarClientePorId(id);
        if (cli == null) { System.out.println("Não encontrado."); return; }
        System.out.print("Nome [" + cli.getNome() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) cli.setNome(v);
        System.out.print("Telefone [" + cli.getTelefone() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cli.setTelefone(v);
        System.out.print("E-mail [" + cli.getEmail() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cli.setEmail(v);
        System.out.print("Endereço [" + cli.getEndereco() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cli.setEndereco(v);
        System.out.print("Nº CNH [" + cli.getNumeroCnh() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cli.setNumeroCnh(v);
        System.out.print("Categoria CNH [" + cli.getCategoriaCnh() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) cli.setCategoriaCnh(v);
        System.out.println("Cliente ID " + id + " alterado com sucesso!");
    }

    private static void excluirCliente() {
        System.out.print("\nID do Cliente a excluir: ");
        int id = lerInt();
        Cliente cli = buscarClientePorId(id);
        if (cli == null) { System.out.println("Não encontrado."); return; }
        System.out.print("Confirma exclusão de '" + cli.getNome() + "'? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) { clientes.remove(cli); System.out.println("Cliente excluído."); }
        else System.out.println("Exclusão cancelada.");
    }

    private static void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) { System.out.println("Nenhum cliente cadastrado."); return; }
        for (Cliente c : clientes) System.out.println(c);
    }

    private static void buscarCliente() {
        System.out.println("\n-- BUSCAR CLIENTE --");
        System.out.println("1. Por ID   2. Por Nome");
        System.out.print("Opção: ");
        int op = lerInt();
        if (op == 1) {
            System.out.print("ID: "); int id = lerInt();
            Cliente c = buscarClientePorId(id);
            if (c != null) System.out.println("\n" + c.getDescricaoCompleta());
            else System.out.println("Não encontrado.");
        } else {
            System.out.print("Nome (parcial): "); String nome = sc.nextLine().trim().toLowerCase();
            boolean achou = false;
            for (Cliente c : clientes) {
                if (c.getNome().toLowerCase().contains(nome)) { System.out.println("\n" + c.getDescricaoCompleta()); achou = true; }
            }
            if (!achou) System.out.println("Nenhum cliente encontrado.");
        }
    }

    private static Cliente buscarClientePorId(int id) {
        for (Cliente c : clientes) if (c.getId() == id) return c;
        return null;
    }

    private static void menuFuncionario() {
        int opcao;
        do {
            System.out.println("\n--- FUNCIONÁRIOS ---");
            System.out.println("1. Incluir   2. Alterar   3. Excluir");
            System.out.println("4. Listar    5. Buscar    0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirFuncionario(); break;
                case 2: alterarFuncionario(); break;
                case 3: excluirFuncionario(); break;
                case 4: listarFuncionarios(); break;
                case 5: buscarFuncionario(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirFuncionario() {
        System.out.println("\n-- INCLUIR FUNCIONÁRIO --");
        System.out.print("Nome: ");       String nome  = sc.nextLine().trim();
        System.out.print("CPF: ");        String cpf   = sc.nextLine().trim();
        System.out.print("Telefone: ");   String tel   = sc.nextLine().trim();
        System.out.print("E-mail: ");     String email = sc.nextLine().trim();
        System.out.print("Endereço: ");   String end   = sc.nextLine().trim();
        System.out.print("Matrícula: ");  String mat   = sc.nextLine().trim();
        System.out.print("Cargo: ");      String cargo = sc.nextLine().trim();
        System.out.print("Salário: ");    double sal   = lerDouble();
        System.out.print("Data Admissão (dd/MM/aaaa): "); String adm = sc.nextLine().trim();
        Funcionario f = new Funcionario(proxIdFunc++, nome, cpf, tel, email, end, mat, cargo, sal, adm);
        funcionarios.add(f);
        System.out.println("Funcionário ID " + f.getId() + " incluído com sucesso!");
    }

    private static void alterarFuncionario() {
        System.out.print("\nID do Funcionário a alterar: ");
        int id = lerInt();
        Funcionario f = buscarFuncionarioPorId(id);
        if (f == null) { System.out.println("Não encontrado."); return; }
        System.out.print("Nome [" + f.getNome() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) f.setNome(v);
        System.out.print("Cargo [" + f.getCargo() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) f.setCargo(v);
        System.out.print("Salário [" + f.getSalario() + "] (0=manter): ");
        double d = lerDouble(); if (d != 0) f.setSalario(d);
        System.out.print("Telefone [" + f.getTelefone() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) f.setTelefone(v);
        System.out.println("Funcionário ID " + id + " alterado com sucesso!");
    }

    private static void excluirFuncionario() {
        System.out.print("\nID do Funcionário a excluir: ");
        int id = lerInt();
        Funcionario f = buscarFuncionarioPorId(id);
        if (f == null) { System.out.println("Não encontrado."); return; }
        System.out.print("Confirma exclusão de '" + f.getNome() + "'? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) { funcionarios.remove(f); System.out.println("Funcionário excluído."); }
        else System.out.println("Exclusão cancelada.");
    }

    private static void listarFuncionarios() {
        System.out.println("\n=== LISTA DE FUNCIONÁRIOS ===");
        if (funcionarios.isEmpty()) { System.out.println("Nenhum funcionário cadastrado."); return; }
        for (Funcionario f : funcionarios) System.out.println(f);
    }

    private static void buscarFuncionario() {
        System.out.println("\n-- BUSCAR FUNCIONÁRIO --");
        System.out.println("1. Por ID   2. Por Nome");
        System.out.print("Opção: ");
        int op = lerInt();
        if (op == 1) {
            System.out.print("ID: "); int id = lerInt();
            Funcionario f = buscarFuncionarioPorId(id);
            if (f != null) System.out.println("\n" + f.getDescricaoCompleta());
            else System.out.println("Não encontrado.");
        } else {
            System.out.print("Nome (parcial): "); String nome = sc.nextLine().trim().toLowerCase();
            boolean achou = false;
            for (Funcionario f : funcionarios) {
                if (f.getNome().toLowerCase().contains(nome)) { System.out.println("\n" + f.getDescricaoCompleta()); achou = true; }
            }
            if (!achou) System.out.println("Nenhum funcionário encontrado.");
        }
    }

    private static Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario f : funcionarios) if (f.getId() == id) return f;
        return null;
    }

    private static void menuLocacao() {
        int opcao;
        do {
            System.out.println("\n--- LOCAÇÕES ---");
            System.out.println("1. Nova Locação    2. Alterar Locação");
            System.out.println("3. Encerrar        4. Cancelar");
            System.out.println("5. Listar          6. Buscar");
            System.out.println("7. Listar Disponíveis  0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1: incluirLocacao(); break;
                case 2: alterarLocacao(); break;
                case 3: encerrarLocacao(); break;
                case 4: cancelarLocacao(); break;
                case 5: listarLocacoes(); break;
                case 6: buscarLocacao(); break;
                case 7: listarVeiculosDisponiveis(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirLocacao() {
        System.out.println("\n-- NOVA LOCAÇÃO --");
        listarClientes();
        System.out.print("ID do Cliente: ");
        int idCli = lerInt();
        Cliente cli = buscarClientePorId(idCli);
        if (cli == null) { System.out.println("Cliente não encontrado."); return; }
        listarVeiculosDisponiveis();
        System.out.println("\nTipo: 1-CarroEco  2-CarroLuxo  3-Carro  4-Moto  5-Van");
        System.out.print("Tipo: "); int tipo = lerInt();
        System.out.print("ID do Veículo: "); int idVei = lerInt();
        Veiculo vei = encontrarVeiculoDisponivel(tipo, idVei);
        if (vei == null) { System.out.println("Veículo não encontrado ou indisponível."); return; }
        listarFuncionarios();
        System.out.print("ID do Funcionário: ");
        int idFunc = lerInt();
        Funcionario func = buscarFuncionarioPorId(idFunc);
        if (func == null) { System.out.println("Funcionário não encontrado."); return; }
        System.out.print("Data de Retirada (dd/MM/aaaa): ");  String ret  = sc.nextLine().trim();
        System.out.print("Data de Devolução (dd/MM/aaaa): "); String dev  = sc.nextLine().trim();
        System.out.print("Quantidade de Dias: ");             int    dias = lerInt();
        System.out.print("Observações: ");                    String obs  = sc.nextLine().trim();
        Locacao loc = new Locacao(proxIdLocacao++, cli, vei, func, ret, dev, dias, obs);
        locacoes.add(loc);
        System.out.printf("Locação ID %d criada! Valor total: R$ %.2f%n", loc.getId(), loc.getValorTotal());
    }

    private static Veiculo encontrarVeiculoDisponivel(int tipo, int id) {
        Veiculo v = null;
        switch (tipo) {
            case 1: v = buscarCarroEconomicoPorId(id); break;
            case 2: v = buscarCarroLuxoPorId(id);      break;
            case 3: v = buscarCarroPorId(id);           break;
            case 4: v = buscarMotoPorId(id);            break;
            case 5: v = buscarVanPorId(id);             break;
        }
        return (v != null && v.isDisponivel()) ? v : null;
    }

    private static void alterarLocacao() {
        System.out.print("\nID da Locação a alterar: ");
        int id = lerInt();
        Locacao loc = buscarLocacaoPorId(id);
        if (loc == null) { System.out.println("Não encontrada."); return; }
        if (!loc.getStatus().equals("ABERTA")) { System.out.println("Só é possível alterar locações ABERTAS."); return; }
        System.out.print("Observações [" + loc.getObservacoes() + "]: ");
        String v = sc.nextLine().trim(); if (!v.isEmpty()) loc.setObservacoes(v);
        System.out.print("Data Devolução [" + loc.getDataDevolucao() + "]: ");
        v = sc.nextLine().trim(); if (!v.isEmpty()) loc.setDataDevolucao(v);
        System.out.print("Quantidade de Dias [" + loc.getQuantidadeDias() + "] (0=manter): ");
        int n = lerInt(); if (n != 0) loc.setQuantidadeDias(n);
        System.out.println("Locação ID " + id + " alterada com sucesso!");
    }

    private static void encerrarLocacao() {
        System.out.print("\nID da Locação a encerrar: ");
        int id = lerInt();
        Locacao loc = buscarLocacaoPorId(id);
        if (loc == null) { System.out.println("Não encontrada."); return; }
        if (!loc.getStatus().equals("ABERTA")) { System.out.println("Locação já está " + loc.getStatus()); return; }
        System.out.print("Data de Devolução Real (dd/MM/aaaa): "); String data = sc.nextLine().trim();
        System.out.print("Dias reais utilizados: "); int dias = lerInt();
        loc.encerrarLocacao(data, dias);
        System.out.printf("Locação encerrada! Valor final: R$ %.2f%n", loc.getValorTotal());
        System.out.println("\n-- FORMA DE PAGAMENTO --");
        System.out.println("1. PIX");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Dinheiro");
        System.out.print("Opção: ");
        int opcPag = lerInt();
        Pagavel pagamento = null;
        switch (opcPag) {
            case 1:
                pagamento = new PagamentoPix();
                break;
            case 2:
                System.out.print("Número de parcelas: ");
                int parcelas = lerInt();
                if (parcelas < 1) parcelas = 1;
                pagamento = new PagamentoCartaoCredito(parcelas);
                break;
            case 3:
                System.out.printf("Valor a pagar: R$ %.2f%nValor entregue: R$ ", loc.getValorTotal());
                double entregue = lerDouble();
                pagamento = new PagamentoDinheiro(entregue);
                break;
            default:
                System.out.println("Forma de pagamento inválida. Pagamento não registrado.");
        }
        if (pagamento != null) {
            pagamento.processarPagamento(loc.getValorTotal());
            loc.setFormaPagamento(pagamento);
        }
    }

    private static void cancelarLocacao() {
        System.out.print("\nID da Locação a cancelar: ");
        int id = lerInt();
        Locacao loc = buscarLocacaoPorId(id);
        if (loc == null) { System.out.println("Não encontrada."); return; }
        if (!loc.getStatus().equals("ABERTA")) { System.out.println("Locação já está " + loc.getStatus()); return; }
        System.out.print("Confirma cancelamento? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) { loc.cancelarLocacao(); System.out.println("Locação cancelada e veículo liberado."); }
    }

    private static void listarLocacoes() {
        System.out.println("\n=== LISTA DE LOCAÇÕES ===");
        if (locacoes.isEmpty()) { System.out.println("Nenhuma locação cadastrada."); return; }
        for (Locacao l : locacoes) System.out.println(l);
    }

    private static void buscarLocacao() {
        System.out.println("\n-- BUSCAR LOCAÇÃO --");
        System.out.println("1. Por ID   2. Por Cliente   3. Por Status");
        System.out.print("Opção: ");
        int op = lerInt();
        switch (op) {
            case 1:
                System.out.print("ID: "); int id = lerInt();
                Locacao l = buscarLocacaoPorId(id);
                if (l != null) System.out.println("\n" + l.getDescricaoCompleta());
                else System.out.println("Não encontrada.");
                break;
            case 2:
                System.out.print("Nome do Cliente (parcial): ");
                String nome = sc.nextLine().trim().toLowerCase();
                boolean achou = false;
                for (Locacao loc : locacoes) {
                    if (loc.getCliente().getNome().toLowerCase().contains(nome)) { System.out.println("\n" + loc.getDescricaoCompleta()); achou = true; }
                }
                if (!achou) System.out.println("Nenhuma locação encontrada.");
                break;
            case 3:
                System.out.print("Status (ABERTA/ENCERRADA/CANCELADA): ");
                String status = sc.nextLine().trim().toUpperCase();
                for (Locacao loc : locacoes) {
                    if (loc.getStatus().equals(status)) System.out.println(loc);
                }
                break;
        }
    }

    private static Locacao buscarLocacaoPorId(int id) {
        for (Locacao l : locacoes) if (l.getId() == id) return l;
        return null;
    }

    private static void listarVeiculosDisponiveis() {
        System.out.println("\n=== VEÍCULOS DISPONÍVEIS ===");
        System.out.println("-- Carros Econômicos --");
        for (CarroEconomico ce : carrosEconomicos) if (ce.isDisponivel()) System.out.println(ce);
        System.out.println("-- Carros de Luxo --");
        for (CarroLuxo cl : carrosLuxo) if (cl.isDisponivel()) System.out.println(cl);
        System.out.println("-- Carros --");
        for (Carro c : carros) if (c.isDisponivel()) System.out.println(c);
        System.out.println("-- Motos --");
        for (Moto m : motos) if (m.isDisponivel()) System.out.println(m);
        System.out.println("-- Vans --");
        for (Van v : vans) if (v.isDisponivel()) System.out.println(v);
    }

    private static <T extends Veiculo> void excluirVeiculo(List<T> lista, String titulo) {
        System.out.print("\nID do " + titulo + " a excluir: ");
        int id = lerInt();
        T alvo = null;
        for (T v : lista) if (v.getId() == id) { alvo = v; break; }
        if (alvo == null) { System.out.println("Não encontrado."); return; }
        if (!alvo.isDisponivel()) { System.out.println("Veículo está locado e não pode ser excluído."); return; }
        System.out.print("Confirma exclusão de '" + alvo.getMarca() + " " + alvo.getModelo() + "'? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) { lista.remove(alvo); System.out.println(titulo + " excluído."); }
        else System.out.println("Exclusão cancelada.");
    }

    private static <T extends Veiculo> void listarVeiculos(List<T> lista, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        if (lista.isEmpty()) { System.out.println("Nenhum registro."); return; }
        for (T v : lista) System.out.println(v);
    }

    private static <T extends Veiculo> void buscarVeiculo(List<T> lista, String titulo) {
        System.out.println("\n-- BUSCAR " + titulo.toUpperCase() + " --");
        System.out.println("1. Por ID   2. Por Placa   3. Por Marca");
        System.out.print("Opção: ");
        int op = lerInt();
        boolean achou = false;
        switch (op) {
            case 1:
                System.out.print("ID: "); int id = lerInt();
                for (T v : lista) { if (v.getId() == id) { System.out.println("\n" + v.getDescricaoCompleta()); achou = true; } }
                break;
            case 2:
                System.out.print("Placa: "); String placa = sc.nextLine().trim().toUpperCase();
                for (T v : lista) { if (v.getPlaca().equalsIgnoreCase(placa)) { System.out.println("\n" + v.getDescricaoCompleta()); achou = true; } }
                break;
            case 3:
                System.out.print("Marca (parcial): "); String marca = sc.nextLine().trim().toLowerCase();
                for (T v : lista) { if (v.getMarca().toLowerCase().contains(marca)) { System.out.println("\n" + v.getDescricaoCompleta()); achou = true; } }
                break;
        }
        if (!achou) System.out.println("Nenhum resultado encontrado.");
    }

    private static int lerInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    private static double lerDouble() {
        try { return Double.parseDouble(sc.nextLine().trim().replace(",", ".")); }
        catch (NumberFormatException e) { return 0.0; }
    }
}
