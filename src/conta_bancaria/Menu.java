package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		// Teste da Classe Conta
		Conta c1 = new Conta(13, 1313, 1, "Carlos Marquinhos", 13000.00f);
		c1.visualizar();
		c1.sacar(1000.00f);
		c1.visualizar();
		c1.depositar(900.00f);
		c1.visualizar();
		
		// Teste Conta corrente
		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Felipe", 100000.00f, 2000.00f);
		cc1.visualizar();
		
		// teste saque com limite
		cc1.sacar(101000.00f);
		cc1.visualizar();
		
		// teste conta poupança
		ContaPoupanca cp1 = new ContaPoupanca(0002, 13, 2, "Gilles Lipovestsky", 10000.00f, 13);
		cp1.visualizar();
		
		int opcao;

		while (true) {

			System.out.println(Cores.ANSI_RED_BACKGROUND);
			System.out.println("**********************************************");
			System.out.println("                                              ");
			System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "                 BANComuna                    ");
			System.out.println(Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_RED_BACKGROUND + "           Onde quem lucra é você!            ");
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

			opcao = leia.nextInt();

			switch (opcao) {
			case 9:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + "Até a próxima, camarada!");
				System.exit(9);
				break;
			case 1:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + 
						"Seja bem vindo ao BanComuna, camarada!\nAqui quem recebe os lucros é você, e quem paga são os super-ricos e super-taxados!\nIniciaremos agora seu cadastro.");
				break;
			case 2:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + 
						"A comunidade BanComuna não para de crescer, por que quem ganha aqui é você! Até o momento contamos com a presença de: ");
				break;
			case 3:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + "Nenhum camarada ficará para trás! Localize agora sua conta: ");
				break;
			case 4:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + "Camaradas em constante evolução! Atualize agora seus dados: ");
				break;
			case 5:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + 
						"Dizem que o bom filho a casa torna. As portas sempre estarão abertas para o seu retorno.\nSe tiver certeza de sua decisão, segiuiremos com o encerramento de sua conta.");
				break;
			case 6:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + "Vivemos em um mundo capitalista, camarada! Quanto vai querer sacar hoje?");
				break;
			case 7:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + 
						"Nossos lucros não param, camarada! Quanto você vai querer deixar rendendo conosco dessa vez?");
				break;
			case 8:
				System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD + "O futuro é colaborativo, camarada! Vamos iniciar sua transferência");
				break;
			default:
				System.out.println("Para nossos camaradas o céu é o limite, mas essa opção é inválida.\nSelecione um número de 1 a 9 para seguirmos na luta!");
			}

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
