package prova_poo;

import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Conta> conta = new ArrayList<Conta>();
        ArrayList<Poupanca> poupanca = new ArrayList<Poupanca>();

        boolean yes = true;
        while (yes) {
            System.out.println("\nBanco IFPE" + "\n1. Cadastrar Conta ou Poupança " + "\n2. Realizar depósito "
                    + "\n3. Render Juros" + "\n4. Consultar número e nome da agência "
                    + "\n5. Alterar o número e nome da agência " + "\n0. Sair");

            int o = scan.nextInt();

            switch (o) {
                case 1:
                    System.out.println(
                            "Cadastrar conta ? (digite 'y' para abrir  uma conta ou uma poupança 'n' para cancelar)");
                    char escolha_da_conta = scan.next().charAt(0);

                    switch (escolha_da_conta) {
                        case 'y':
                            int contador = 0;
                            while (contador < 9) {
                                System.out.println("Digite o número da conta: ");
                                String numero_conta = scan.next();
                                System.out.println("Digite o numero da agência: ");
                                String numero_agencia = scan.next();
                                System.out.println("Digite o nome da agência: ");
                                String nome_da_agencia = scan.next();
                                System.out.println("Digite seu nome: ");
                                String nome = scan.next();
                                System.out.println("Digite seu cpf: ");
                                String cpf = scan.next();
                                System.out.println("Saldo inicial: ");
                                double saldo = scan.nextDouble();

                                Banco banco = new Banco(numero_agencia, nome_da_agencia);
                                Cliente c = new Cliente(nome, cpf);

                                System.out.println("Deseja fazer poupança ? (1 SIM)- (2 NÃO)");
                                int decidir_conta = scan.nextInt();

                                if (decidir_conta == 1) {
                                    double juros = 0.5;
                                    Poupanca poupanca2 = new Poupanca(numero_conta, banco, c, saldo, juros);
                                    poupanca.add(poupanca2);
                                    break;
                                } else if (decidir_conta == 2) {
                                    Conta c1 = new Conta(numero_conta, banco, c, saldo);
                                    conta.add(c1);
                                    break;
                                } else {
                                    System.out.println("Operação inválida!");
                                    ;
                                }
                            }

                    }
                    break;
                case 2:
                    System.out.println("Para realizar depósito digite o cpf: ");
                    String cpf_teste = scan.next();
                    for (Conta c2 : conta) {
                        if (c2.getCliente().getCpf().equals(cpf_teste)) {
                            System.out.println("Digite o valor: ");
                            double deposito1 = scan.nextDouble();
                            c2.depositar(deposito1);
                            System.out.println("Saldo atual:  " + c2.getSaldo());

                        }
                    }
                    for(Poupanca poupanca3 : poupanca){
                        if (poupanca3.getCliente().getCpf().equals(cpf_teste)) {
                            System.out.println("Digite o valor: ");
                            double deposito2 = scan.nextDouble();
                            poupanca3.depositar(deposito2);
                            System.out.println("Saldo atual da poupança: " + poupanca3.getSaldo());
                        }
                    }

                    break;

                case 3:
                    System.out.println("Render juros(Apenas para poupanças)");
                    for (Poupanca poupanca3 : poupanca) {
                        if (poupanca3.getSaldo() == 0) {
                            System.out.println("Você não possui conta poupança");
                        } else {
                            poupanca3.Render_juros();
                            System.out.println("Saldo atual:" + poupanca3.getSaldo());
                            System.out.println("Total de contas poupanças:" + poupanca.size());
                        }

                    }
                    break;

                case 4:

                    System.out.println("Nome: ");
                    String nome2 = scan.next();
                    System.out.println("CPF: ");
                    String cpf4 = scan.next();
                    for (Conta conta4 : conta) {
                        if (conta4.getCliente().getNome().equals(nome2) & conta4.getCliente().getCpf().equals(cpf4)) {
                            System.out.println("número agência conta: " + conta4.getBanco().getNum_agencia());
                            System.out.println("Nome da agência conta: " + conta4.getBanco().getNome_agencia());
                        } else {
                            System.out.println("Sem info na conta");
                        }
                        for (Poupanca poupanca4 : poupanca) {

                            if (poupanca4.getCliente().getNome().equals(nome2)
                                    & poupanca4.getCliente().getCpf().equals(cpf4)) {
                                System.out.println("Número Agência poupança: " + poupanca4.getBanco().getNum_agencia());
                                System.out.println("Nome agência poupança: " + poupanca4.getBanco().getNome_agencia());

                            } else {
                                System.out.println("Sem info na poupança");
                            }

                        }

                    }
                    break;
                case 5:

                    System.out.println("Digite o nome do cliente: ");
                    String nome5 = scan.next();
                    for (Conta c5 : conta) {
                        if (c5.getCliente().getNome().equals(nome5)) {
                            System.out.println("Digite o nome da agência: ");
                            String nome_agencia = scan.next();
                            System.out.println("Digite o número da agência: ");
                            String nume_agencia = scan.next();
                            c5.getBanco().setNUm_agencia(nume_agencia);
                            c5.getBanco().setNome_agencia(nome_agencia);
                            System.out.println("Alteração realizada com sucesso!");
                            break;
                        } else {
                            System.out.println("Operação inválida");
                            break;

                        }

                    }

                    break;
                case 0:

                    System.out.println("Saiu");
                    yes = false;

                default:
                    System.out.println("Operação inválida!");
                    yes = false;
            }
        }
    }
}