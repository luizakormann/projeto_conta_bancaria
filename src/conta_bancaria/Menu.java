package conta_bancaria;

import java.util.Scanner;

public class Menu {
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;

		while (true) {

			System.out.println("**********************************************");
			System.out.println("                                              ");
			System.out.println("                 BANComuna                    ");
			System.out.println("                                              ");
			System.out.println("**********************************************");
			System.out.println("                                              ");
			System.out.println("             1 - Criar Conta                  ");
			System.out.println("             2 - Listar Todas as Contas       ");
			System.out.println("             3 - Buscar Conta por Número      ");
			System.out.println("             4 - Atualizar Dados da Conta     ");
			System.out.println("             5 - Apagar Conta                 ");
			System.out.println("             6 - Sacar                        ");
			System.out.println("             7 - Depositar                    ");
			System.out.println("             8 - Transferir entre Contas      ");
			System.out.println("             9 - Sair                         ");
			System.out.println("                                              ");
			System.out.println("**********************************************");
			System.out.println("Entre com a opção desejada:                   ");
			System.out.println("                                              ");

			opcao = leia.nextInt();

			switch (opcao) {
			case 9:
				System.out.println("Até a próxima, camarada!");
				System.exit(9);
				break;
			case 1:
				System.out.println(
						"Seja bem vindo ao BanComuna, camarada!\nAqui quem recebe os lucros é você, e quem paga são os super-ricos, super-taxados!\nIniciaremos agora seu cadastro.");
				break;
			case 2:
				System.out.println(
						"A comunidade BanComuna não para de crescer, por que quem ganha aqui é você! Até o momento contamos com a presença de: ");
				break;
			case 3:
				System.out.println("Nenhum camarada ficará para trás! Localize agora sua conta: ");
				break;
			case 4:
				System.out.println("Camaradas em constante evolução! Atualize agora seus dados: ");
				break;
			case 5:
				System.out.println(
						"Dizem que o bom filho a casa torna. As portas sempre estarão abertas para o seu retorno.\nSe tiver certeza de sua decisão, segiuiremos com o encerramento de sua conta.");
				break;
			case 6:
				System.out.println("Vivemos em um mundo capitalista, camarada! Quanto vai querer sacar hoje?");
				break;
			case 7:
				System.out.println(
						"Nossos lucros não param, camarada! Quanto você vai querer deixar rendendo conosco dessa vez?");
				break;
			case 8:
				System.out.println("O futuro é colaborativo, camarada! Vamos iniciar sua transferência");
				break;
			default:
				System.out.println("Opção inválida!");
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
