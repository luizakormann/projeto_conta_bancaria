package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();
		int opcao, numero, agencia, tipo, aniver, numDestino;
		String titular = "";
		float saldo, limite, valor;

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 1313, 1, "Marquinhos", 131300.0f, 2000.0f);
		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 1313, 2, "Carlos", 130.0f, 3);
		contas.cadastrar(cp1);

		while (true) {

			System.out.println(Cores.ANSI_RED_BACKGROUND);
			System.out.println("**********************************************");
			System.out.println("                                              ");
			System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "                 BANComuna                    ");
			System.out.println(Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_RED_BACKGROUND
					+ "           Onde quem lucra é você!            ");
			System.out.println("**********************************************");
			System.out.println("                                              ");
			System.out.println("          1 - Criar Conta                     ");
			System.out.println("          2 - Listar Todas as Contas          ");
			System.out.println("          3 - Buscar Conta por Número         ");
			System.out.println("          4 - Atualizar Dados da Conta        ");
			System.out.println("          5 - Apagar Conta                    ");
			System.out.println("          6 - Sacar                           ");
			System.out.println("          7 - Depositar                       ");
			System.out.println("          8 - Transferir entre Contas         ");
			System.out.println("          9 - Sair                            ");
			System.out.println("                                              ");
			System.out.println("**********************************************");
			System.out.println("Entre com a opção desejada:                   ");
			System.out.println("                                              ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 9:
				System.out.println(
						Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + "Até a próxima, camarada!");
				sobre();
				System.exit(9);
				break;
			case 1:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "Seja bem vindo ao BanComuna, camarada!\nAqui quem recebe os lucros é você, e quem paga são os super-ricos e super-taxados!\nIniciaremos agora seu cadastro.");
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite o nome do Camarada: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("Digite o tipo da Conta (1 - CC ou 2 - CP): ");
				tipo = leia.nextInt();

				System.out.println("Digite o saldo inicial (valor do depósito de abertura) da Conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite aprovado para a conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o aniversário de rendimento da conta: ");
					aniver = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniver));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "A comunidade BanComuna não para de crescer, por que quem ganha aqui é você!\nAté o momento contamos com a presença de: ");
				contas.listarTodas();
				keyPress();
				break;
			case 3: {
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "Nenhum camarada ficará para trás! Localize agora sua conta. Qual número de sua conta: ");
				numero = leia.nextInt();
				contas.procurarPorNum(numero);
				keyPress();
				break;
			}
			case 4: {
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "Camaradas em constante evolução! Atualize agora seus dados. \nQual o número da conta que vamos atualizar: ");
				numero = leia.nextInt();

				Optional<Conta> conta = contas.buscarNaCollection(numero);
				if (conta.isPresent()) {
					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt();

					System.out.println("Digite o nome do Camarada: ");
					leia.skip("\\R");
					titular = leia.nextLine();

					tipo = conta.get().getTipo();

					System.out.println("Digite o saldo da Conta: ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Define o valor do limite: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o aniversário da conta: ");
						aniver = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniver));
					}
					}
				} else
					System.out.println("A conta " + numero + " não foi encontrada.");

				keyPress();
				break;
			}
			case 5:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "Dizem que o bom filho a casa torna. As portas sempre estarão abertas para o seu retorno.\nSe tiver certeza de sua decisão, digite o número da conta a ser deletada:.");
				numero = leia.nextInt();
				contas.delete(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "Vivemos em um mundo capitalista, camarada! Informe o número da conta para realizar o saque:");
				numero = leia.nextInt();
				System.out.println("Qual será o valor de seu saque hoje?");
				valor = leia.nextFloat();

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "Nossos lucros não param, camarada! Qual conta receberá seu rico dinheirinho hoje?");
				numero = leia.nextInt();
				System.out.println("Seu dinheiro rende mais coma gente! Qual o valor de seu depósito?");
				valor = leia.nextFloat();

				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
						+ "O futuro é colaborativo, camarada! Vamos iniciar sua transferência");
				System.out.println("Digite o número da conta que realizará a transferência:");
				numero = leia.nextInt();
				System.out.println("Agora digite o número da conta que receberá sua transferência: ");
				numDestino = leia.nextInt();
				if (numero != numDestino) {
					System.out.println("Informe o valor da transferência: ");
					valor = leia.nextFloat();
				
					contas.transferir(numero, numDestino, valor);
				} else 
					System.out.println("Não é possível transferir para contas iguais");
				keyPress();
				break;
			default:
				System.out.println(
						"Para nossos camaradas o céu é o limite, mas essa opção é inválida.\nSelecione um número de 1 a 9 para seguirmos na luta!");
				keyPress();
				break;
			}

		}

	}

	private static void keyPress() {
		try {
			System.out.println("\n\n **** Pressione a tecla Enter para continuar ****");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida. Por favor, tecle Enter para continuar.");
		}

	}

	public static void sobre() {
		System.out.println("        BanComuna - onde os lucros são de todos");
		System.out.println("********************************************************");
		System.out.println("        Projeto desenvolvido por: Luiza Kormann");
		System.out.println("Desenvolvimento FullStack Java - Generation Brasil - T68");
		System.out.println("            https://github.com/luizakormann");
		System.out.println("********************************************************");
	}
}
