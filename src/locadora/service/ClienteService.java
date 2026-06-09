package locadora.service;

import model.pessoa.Cliente;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class ClienteService {

    public static Cliente buscarPorId(List<Cliente> lista, int id) {
        for (Cliente c : lista)
            if (c.getId() == id)
                return c;
        return null;
    }

    public static void incluir(Scanner sc, List<Cliente> lista, int[] proxId) {
        System.out.println("\n-- INCLUIR CLIENTE --");
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();
        System.out.print("Telefone: ");
        String tel = sc.nextLine().trim();
        System.out.print("E-mail: ");
        String email = sc.nextLine().trim();
        System.out.print("Endereço: ");
        String end = sc.nextLine().trim();
        System.out.print("Nº CNH: ");
        String cnh = sc.nextLine().trim();
        System.out.print("Categoria CNH: ");
        String cat = sc.nextLine().trim();
        System.out.print("Data Nascimento (dd/MM/aaaa): ");
        String nasc = sc.nextLine().trim();
        Cliente cli = new Cliente(proxId[0]++, nome, cpf, tel, email, end, cnh, cat, nasc);
        lista.add(cli);
        System.out.println("Cliente ID " + cli.getId() + " incluído com sucesso!");
    }

    public static void alterar(Scanner sc, List<Cliente> lista) {
        System.out.print("\nID do Cliente a alterar: ");
        int id = InputUtil.lerInt(sc);
        Cliente cli = buscarPorId(lista, id);
        if (cli == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Nome [" + cli.getNome() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            cli.setNome(v);
        System.out.print("Telefone [" + cli.getTelefone() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cli.setTelefone(v);
        System.out.print("E-mail [" + cli.getEmail() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cli.setEmail(v);
        System.out.print("Endereço [" + cli.getEndereco() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cli.setEndereco(v);
        System.out.print("Nº CNH [" + cli.getNumeroCnh() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cli.setNumeroCnh(v);
        System.out.print("Categoria CNH [" + cli.getCategoriaCnh() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cli.setCategoriaCnh(v);
        System.out.println("Cliente ID " + id + " alterado com sucesso!");
    }

    public static void excluir(Scanner sc, List<Cliente> lista) {
        System.out.print("\nID do Cliente a excluir: ");
        int id = InputUtil.lerInt(sc);
        Cliente cli = buscarPorId(lista, id);
        if (cli == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.print("Confirma exclusão de '" + cli.getNome() + "'? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            lista.remove(cli);
            System.out.println("Cliente excluído.");
        } else
            System.out.println("Exclusão cancelada.");
    }

    public static void listar(List<Cliente> lista) {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : lista)
            System.out.println(c);
    }

    public static void buscar(Scanner sc, List<Cliente> lista) {
        System.out.println("\n-- BUSCAR CLIENTE --");
        System.out.println("1. Por ID   2. Por Nome");
        System.out.print("Opção: ");
        int op = InputUtil.lerInt(sc);
        if (op == 1) {
            System.out.print("ID: ");
            int id = InputUtil.lerInt(sc);
            Cliente c = buscarPorId(lista, id);
            if (c != null)
                System.out.println("\n" + c.getDescricaoCompleta());
            else
                System.out.println("Não encontrado.");
        } else {
            System.out.print("Nome (parcial): ");
            String nome = sc.nextLine().trim().toLowerCase();
            boolean achou = false;
            for (Cliente c : lista) {
                if (c.getNome().toLowerCase().contains(nome)) {
                    System.out.println("\n" + c.getDescricaoCompleta());
                    achou = true;
                }
            }
            if (!achou)
                System.out.println("Nenhum cliente encontrado.");
        }
    }
}
