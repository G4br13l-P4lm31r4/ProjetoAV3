package locadora.service;

import model.pessoa.Funcionario;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class FuncionarioService {

    public static Funcionario buscarPorId(List<Funcionario> lista, int id) {
        for (Funcionario f : lista)
            if (f.getId() == id)
                return f;
        return null;
    }

    public static void incluir(Scanner sc, List<Funcionario> lista, int[] proxId) {
        System.out.println("\n-- INCLUIR FUNCIONÁRIO --");
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
        System.out.print("Matrícula: ");
        String mat = sc.nextLine().trim();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine().trim();
        System.out.print("Salário: ");
        double sal = InputUtil.lerDouble(sc);
        System.out.print("Data Admissão (dd/MM/aaaa): ");
        String adm = sc.nextLine().trim();
        Funcionario f = new Funcionario(proxId[0]++, nome, cpf, tel, email, end, mat, cargo, sal, adm);
        lista.add(f);
        System.out.println("Funcionário ID " + f.getId() + " incluído com sucesso!");
    }

    public static void alterar(Scanner sc, List<Funcionario> lista) {
        System.out.print("\nID do Funcionário a alterar: ");
        int id = InputUtil.lerInt(sc);
        Funcionario f = buscarPorId(lista, id);
        if (f == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Nome [" + f.getNome() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            f.setNome(v);
        System.out.print("Cargo [" + f.getCargo() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            f.setCargo(v);
        System.out.print("Salário [" + f.getSalario() + "] (0=manter): ");
        double d = InputUtil.lerDouble(sc);
        if (d != 0)
            f.setSalario(d);
        System.out.print("Telefone [" + f.getTelefone() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            f.setTelefone(v);
        System.out.println("Funcionário ID " + id + " alterado com sucesso!");
    }

    public static void excluir(Scanner sc, List<Funcionario> lista) {
        System.out.print("\nID do Funcionário a excluir: ");
        int id = InputUtil.lerInt(sc);
        Funcionario f = buscarPorId(lista, id);
        if (f == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.print("Confirma exclusão de '" + f.getNome() + "'? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            lista.remove(f);
            System.out.println("Funcionário excluído.");
        } else
            System.out.println("Exclusão cancelada.");
    }

    public static void listar(List<Funcionario> lista) {
        System.out.println("\n=== LISTA DE FUNCIONÁRIOS ===");
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Funcionario f : lista)
            System.out.println(f);
    }

    public static void buscar(Scanner sc, List<Funcionario> lista) {
        System.out.println("\n-- BUSCAR FUNCIONÁRIO --");
        System.out.println("1. Por ID   2. Por Nome");
        System.out.print("Opção: ");
        int op = InputUtil.lerInt(sc);
        if (op == 1) {
            System.out.print("ID: ");
            int id = InputUtil.lerInt(sc);
            Funcionario f = buscarPorId(lista, id);
            if (f != null)
                System.out.println("\n" + f.getDescricaoCompleta());
            else
                System.out.println("Não encontrado.");
        } else {
            System.out.print("Nome (parcial): ");
            String nome = sc.nextLine().trim().toLowerCase();
            boolean achou = false;
            for (Funcionario f : lista) {
                if (f.getNome().toLowerCase().contains(nome)) {
                    System.out.println("\n" + f.getDescricaoCompleta());
                    achou = true;
                }
            }
            if (!achou)
                System.out.println("Nenhum funcionário encontrado.");
        }
    }
}
