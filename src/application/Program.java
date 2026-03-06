package application;

import model.entities.User;
import model.service.UserAccountService;

import java.util.*;

public class Program {
    static void main(String[] args) {

        UserAccountService accountService = new UserAccountService();

        Set<User> users = new HashSet<>();
        Map<Double, Double> map = new HashMap<>();
        double balance = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("##### BEM VINDO #####");
        System.out.println();
        System.out.println("Crie sua conta grátis!");

        System.out.print("Digite o nome do usuário: ");
        String name = sc.nextLine();

        System.out.print("Digite o email do usuário: ");
        String email = sc.nextLine();

        System.out.println("Cadastro concluído com sucesso!");
        users.add(new User(name, email));

        System.out.println();
        System.out.print("Realizar um depósito inicial? (S/N) ");
        char ch = sc.next().charAt(0);

        if (ch == 'S' || ch == 's'){
            System.out.print("Digite o valor desejado: R$");
            balance = sc.nextDouble();
            System.out.println("Valor adicionado com sucesso!");

            System.out.println();
            System.out.print("Deseja realizar transações? (S/N) ");
            char ch1 = sc.next().charAt(0);

            if (ch1 == 'S' || ch1 == 's') {

                System.out.println();
                System.out.println("Oque deseja? ");
                System.out.println("1. Depositar\n2. Sacar\n3. Ver dados\n4. Sair");
                System.out.print("Opção: ");
                int option2 = sc.nextInt();
                System.out.println();

                if (option2 == 1) {

                    System.out.println();
                    System.out.print("Digite o valor a ser depositado: ");
                    double amount = sc.nextDouble();
                    accountService = new UserAccountService(amount, balance);
                    accountService.deposit();
                    System.out.println("Valor depositado: R$"+ amount);
                    System.out.println("Saldo total: R$"+ accountService.getBalance());

                }else if (option2 == 2){
                    System.out.print("Digite o valor a ser retirado: ");
                    double amount = sc.nextDouble();
                    accountService.withDraw(amount, balance);

                } else {
                    for (User u : users){
                        System.out.println(u + "\nSaldo = R$"+ balance);
                    }
                }
            }
        } else if (ch == 'N' || ch == 'n') {
            System.out.println("Ok! Volte sempre!");

        }else throw new IllegalArgumentException("Valor inválido!");

    }

}

