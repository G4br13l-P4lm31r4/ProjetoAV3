package locadora;

import model.veiculo.*;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.locacao.Locacao;

import java.util.List;

public class PreCadastro {

    public static void executar(
            List<CarroLuxo> carrosLuxo,
            List<Carro> carros,
            List<Moto> motos,
            List<Van> vans,
            List<Cliente> clientes,
            List<Funcionario> funcionarios,
            List<Locacao> locacoes,
            int[] proxIdVeiculo,
            int[] proxIdCliente,
            int[] proxIdFunc,
            int[] proxIdLocacao) {

        // Carros de Luxo
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo[0]++, "LUX-0001", "BMW", "Série 3", 2022, 9000, 4, "Gasolina", 480,
                "Couro, Teto Solar, GPS, Bang&Olufsen", true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo[0]++, "LUX-0002", "Mercedes", "Classe C", 2023, 4000, 4, "Gasolina",
                455, "Couro, Sunroof, Câmera 360°", true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo[0]++, "LUX-0003", "Audi", "A4", 2022, 12000, 4, "Gasolina", 460,
                "Couro, Teto Solar, MMI Touch", true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo[0]++, "LUX-0004", "Volvo", "XC60", 2021, 22000, 4, "Gasolina", 505,
                "Couro, Piloto Automático, Harman", false));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo[0]++, "LUX-0005", "Jaguar", "XE", 2020, 31000, 4, "Gasolina", 455,
                "Couro, JaguarDrive Control", false));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo[0]++, "LUX-0006", "Porsche", "Panamera", 2023, 2000, 4, "Gasolina",
                495, "Full Premium, Bose, Night Vision", true));
        carrosLuxo.add(new CarroLuxo(proxIdVeiculo[0]++, "LUX-0007", "Tesla", "Model 3", 2023, 7000, 4, "Elétrico", 425,
                "Piloto Automático, Autopilot Full", true));

        // Carros Genéricos
        carros.add(new Carro(proxIdVeiculo[0]++, "CAR-0001", "Toyota", "Corolla", 2021, 28000, 4, "Flex", 528));
        carros.add(new Carro(proxIdVeiculo[0]++, "CAR-0002", "Hyundai", "Creta", 2022, 15000, 4, "Flex", 422));
        carros.add(new Carro(proxIdVeiculo[0]++, "CAR-0003", "Honda", "Civic", 2020, 38000, 4, "Gasolina", 519));
        carros.add(new Carro(proxIdVeiculo[0]++, "CAR-0004", "Chevrolet", "Cruze", 2019, 47000, 4, "Flex", 508));
        carros.add(new Carro(proxIdVeiculo[0]++, "CAR-0005", "Volkswagen", "Virtus", 2022, 21000, 4, "Flex", 500));
        carros.add(new Carro(proxIdVeiculo[0]++, "CAR-0006", "Jeep", "Compass", 2021, 32000, 4, "Diesel", 515));
        carros.add(new Carro(proxIdVeiculo[0]++, "CAR-0007", "Nissan", "Sentra", 2020, 41000, 4, "Gasolina", 513));

        // Motos
        motos.add(new Moto(proxIdVeiculo[0]++, "MOT-0001", "Honda", "CB 300R", 2022, 8000, 300, "Naked", true));
        motos.add(new Moto(proxIdVeiculo[0]++, "MOT-0002", "Yamaha", "MT-07", 2021, 14000, 700, "Naked", true));
        motos.add(new Moto(proxIdVeiculo[0]++, "MOT-0003", "Kawasaki", "Z400", 2023, 2000, 400, "Naked", true));
        motos.add(new Moto(proxIdVeiculo[0]++, "MOT-0004", "Honda", "PCX 150", 2022, 9000, 150, "Scooter", false));
        motos.add(new Moto(proxIdVeiculo[0]++, "MOT-0005", "Suzuki", "Burgman 400", 2020, 22000, 400, "Scooter", true));
        motos.add(new Moto(proxIdVeiculo[0]++, "MOT-0006", "BMW", "R 1250 GS", 2022, 18000, 1250, "Trail", true));
        motos.add(new Moto(proxIdVeiculo[0]++, "MOT-0007", "Honda", "CG 160", 2021, 31000, 160, "Street", false));

        // Vans
        vans.add(new Van(proxIdVeiculo[0]++, "VAN-0001", "Mercedes", "Sprinter 415", 2021, 55000, 15, true, "Passeio"));
        vans.add(new Van(proxIdVeiculo[0]++, "VAN-0002", "Fiat", "Ducato", 2020, 70000, 13, true, "Carga"));
        vans.add(new Van(proxIdVeiculo[0]++, "VAN-0003", "Ford", "Transit", 2022, 30000, 15, true, "Passeio"));
        vans.add(new Van(proxIdVeiculo[0]++, "VAN-0004", "Renault", "Master", 2019, 88000, 16, false, "Passeio"));
        vans.add(new Van(proxIdVeiculo[0]++, "VAN-0005", "Volkswagen", "Crafter", 2021, 42000, 17, true, "Passeio"));
        vans.add(new Van(proxIdVeiculo[0]++, "VAN-0006", "Iveco", "Daily", 2020, 65000, 16, false, "Carga"));
        vans.add(new Van(proxIdVeiculo[0]++, "VAN-0007", "Mercedes", "Vito", 2022, 19000, 8, true, "Passeio"));

        // Clientes
        clientes.add(new Cliente(proxIdCliente[0]++, "Ana Beatriz Lima", "111.222.333-01", "(11)91111-1111",
                "ana@email.com", "Rua das Flores, 10", "AB111111", "B", "15/03/1990"));
        clientes.add(new Cliente(proxIdCliente[0]++, "Bruno Souza", "222.333.444-02", "(21)92222-2222",
                "bruno@email.com", "Av. Brasil, 200", "BR222222", "AB", "22/07/1985"));
        clientes.add(new Cliente(proxIdCliente[0]++, "Carla Mendes", "333.444.555-03", "(31)93333-3333",
                "carla@email.com", "Rua Ipê, 55", "CM333333", "B", "10/11/1992"));
        clientes.add(new Cliente(proxIdCliente[0]++, "Diego Ferreira", "444.555.666-04", "(41)94444-4444",
                "diego@email.com", "Rua das Palmeiras, 7", "DF444444", "A", "05/01/1988"));
        clientes.add(new Cliente(proxIdCliente[0]++, "Elisa Costa", "555.666.777-05", "(51)95555-5555",
                "elisa@email.com", "Av. das Nações, 300", "EC555555", "B", "30/06/1995"));
        clientes.add(new Cliente(proxIdCliente[0]++, "Fernando Rocha", "666.777.888-06", "(61)96666-6666",
                "fernando@email.com", "SQS 308, Bloco A", "FR666666", "AB", "18/09/1980"));
        clientes.add(new Cliente(proxIdCliente[0]++, "Gabriela Oliveira", "777.888.999-07", "(71)97777-7777",
                "gabi@email.com", "Ladeira do Sol, 12", "GO777777", "B", "25/02/1998"));

        // Funcionários
        funcionarios.add(new Funcionario(proxIdFunc[0]++, "João Carlos Pereira", "011.022.033-01", "(11)98000-1001",
                "joao@locadora.com", "Rua A, 1", "F001", "Gerente", 5500.00, "01/03/2015"));
        funcionarios.add(new Funcionario(proxIdFunc[0]++, "Maria Silva", "022.033.044-02", "(11)98000-1002",
                "maria@locadora.com", "Rua B, 2", "F002", "Atendente", 2800.00, "05/07/2018"));
        funcionarios.add(new Funcionario(proxIdFunc[0]++, "Pedro Alves", "033.044.055-03", "(11)98000-1003",
                "pedro@locadora.com", "Rua C, 3", "F003", "Mecânico", 3200.00, "12/01/2019"));
        funcionarios.add(new Funcionario(proxIdFunc[0]++, "Luisa Ramos", "044.055.066-04", "(11)98000-1004",
                "luisa@locadora.com", "Rua D, 4", "F004", "Atendente", 2800.00, "20/04/2020"));
        funcionarios.add(new Funcionario(proxIdFunc[0]++, "Carlos Teixeira", "055.066.077-05", "(11)98000-1005",
                "carlos@locadora.com", "Rua E, 5", "F005", "Motorista", 2500.00, "08/09/2017"));
        funcionarios.add(new Funcionario(proxIdFunc[0]++, "Patrícia Duarte", "066.077.088-06", "(11)98000-1006",
                "pat@locadora.com", "Rua F, 6", "F006", "Supervisora", 4200.00, "15/02/2016"));
        funcionarios.add(new Funcionario(proxIdFunc[0]++, "Roberto Campos", "077.088.099-07", "(11)98000-1007",
                "roberto@locadora.com", "Rua G, 7", "F007", "Financeiro", 3800.00, "03/06/2021"));

        // Locações
        locacoes.add(new Locacao(proxIdLocacao[0]++, clientes.get(0), carros.get(0), funcionarios.get(1),
                "01/06/2026", "05/06/2026"));
        locacoes.add(new Locacao(proxIdLocacao[0]++, clientes.get(1), carrosLuxo.get(0), funcionarios.get(1),
                "02/06/2026", "07/06/2026"));
        locacoes.add(new Locacao(proxIdLocacao[0]++, clientes.get(2), motos.get(0), funcionarios.get(3),
                "03/06/2026", "04/06/2026"));
        locacoes.add(new Locacao(proxIdLocacao[0]++, clientes.get(3), vans.get(0), funcionarios.get(3),
                "05/06/2026", "10/06/2026"));
        locacoes.add(new Locacao(proxIdLocacao[0]++, clientes.get(4), carros.get(2), funcionarios.get(1),
                "07/06/2026", "12/06/2026"));
        locacoes.add(new Locacao(proxIdLocacao[0]++, clientes.get(5), carros.get(3), funcionarios.get(3),
                "08/06/2026", "14/06/2026"));
        locacoes.add(new Locacao(proxIdLocacao[0]++, clientes.get(6), carrosLuxo.get(2), funcionarios.get(1),
                "09/06/2026", "16/06/2026"));
    }
}
