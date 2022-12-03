
import java.util.Scanner;

public class Telefonia {
	private PrePago[] prePagos = new PrePago[5];
	int numPrePagos = 0;

	private PosPago[] posPagos = new PosPago[5];
	int numPosPagos = 0;

	Scanner input = new Scanner(System.in);

	public void cadastrarAssinante() {
		long cpf;
		String nome;
		long numero;

		System.out.println("Bem-vindo. Para prosseguir, indique seu tipo de assinatura.");
		System.out.println("Digite o número da opção desejada.");
		System.out.println("[1]: pré-pago | [2]: pós-pago");
		int tipoDeAssinatura = input.nextInt();

		switch (tipoDeAssinatura) {
		case 1:
			if (numPrePagos >= prePagos.length) {
				System.out.println("Atenção! Número de assinantes atingido.");
				break;
			}

			System.out.println("Cadastro de pré-pago selecionado ");
			System.out.println("Entre com cpf do assinante: ");
			cpf = input.nextLong();

			input.nextLine();
			System.out.println("Entre com nome do assinante: ");
			nome = input.nextLine();

			System.out.println("Entre com número do assinante: ");
			numero = input.nextLong(); // n esta aceitando mais que uma certa quantidade de caracteres, da o erro
										// java.util.InputMismatchException no scanner (quando estava usando tipo int,
										// quando mudamos para long, funcionou normalmente

			PrePago novoAssinantePre = new PrePago(cpf, nome, numero);

			// verifica que a informação está em prepago

			prePagos[numPrePagos] = novoAssinantePre;
			numPrePagos += 1;
			System.out.println("Novo Assinante cadastrado: ");
			System.out.println(novoAssinantePre.toString());
			break;

		case 2:
			if (numPosPagos >= posPagos.length) {
				System.out.println("Atenção! Número de assinantes atingido.");
				System.exit(0);
			}

			System.out.println("Cadastro de pós-pago selecionado ");
			System.out.println("Entre com cpf do assinante: ");
			cpf = input.nextLong();

			input.nextLine();
			System.out.println("Entre com nome do assinante: ");
			nome = input.nextLine();

			System.out.println("Entre com número do assinante: ");
			numero = input.nextInt();

			PosPago novoAssinantePos = new PosPago(cpf, nome, numero, 0);
			posPagos[numPosPagos] = novoAssinantePos;
			numPosPagos += 1;
			System.out.println("Novo Assinante cadastrado: ");
			System.out.println(novoAssinantePos.toString());
			break;

		default:
			System.out.println("Opção inválida.");
			break;
		}
	}

	public void listarAssinantes() {
		System.out.println("Listando assinantes");
		System.out.println("Assinantes pré-pagos: ");
		for (int i = 0; i < prePagos.length; i++) {
			if (prePagos[i] == null) {
				continue;
			}
			System.out.println(prePagos[i].toString());
		}
		System.out.println("Assinantes pós-pagos: ");
		for (int i = 0; i < posPagos.length; i++) {
			if (posPagos[i] == null) {
				continue;
			}
			System.out.println(posPagos[i].toString());
		}
	}

	public void fazerChamada() {
		System.out.println("Fazendo chamada...");

		System.out.println("Selecione o tipo de assinatura: ");
		System.out.println("[1]: pré-pago | [2]: pós-pago");
		int tipoAssinatura = input.nextInt();

		System.out.println("Insira o seu CPF");
		long cpf = input.nextLong();

		/*
		 * switch (tipoDeAssinatura) { case 1: localizarPrePago(cpf); break; case 2:
		 * localizarPosPago(cpf); break; default:
		 * System.out.println("Tipo de assinatura inexistente."); break; }
		 */

		if (tipoAssinatura == 1) {
			localizarPosPago(cpf);
		} else if (tipoAssinatura == 2) {
			localizarPrePago(cpf);
		} else {
			System.out.println("Tipo de assinatura inexistente.");
		}

	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i < this.posPagos.length; i++) {
			if (this.posPagos[i] != null && this.posPagos[i].getCpf() == cpf) {
				return this.posPagos[i];
			}
		}
		return null;
	}

	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i > this.prePagos.length; i++) {
			if (this.prePagos[i] != null && this.posPagos[i].getCpf() == cpf) {
				return this.prePagos[i];
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner menu = new Scanner(System.in);
		System.out.println("Funcionou.");
		Telefonia telefonia = new Telefonia();
		while (true) {
			System.out.println("Bem-vindes ao sistema de telefonia!");
			System.out.println("Digite o número da opção desejada.");
			System.out.println("[1]: Cadastrar Assinante");
			System.out.println("[2]: Listar Assinantes");
			System.out.println("[3]: Fazer chamada");
			System.out.println("[4]: Fazer recarga");
			System.out.println("[5]: Imprimir faturas");
			System.out.println("[6]: Sair do programa");

			int opcao = menu.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Cadastro de assinante selecionado ");
				telefonia.cadastrarAssinante();
				break;

			case 2:
				System.out.println("Listar assinantes selecionado ");
				telefonia.listarAssinantes();
				break;

			case 3:
				System.out.println("Fazer chamada selecionado ");
				telefonia.fazerChamada(); // ainda testeando
				break;
			// escolhe o tipo e recebe o cpf, pega o vetor prepagos, fazer um for
			// prepago.cpf == cpf digitado, quando achar o cpf do prepago, vamos usar o
			// assinante.fazerChamada. Public void fazerChamada lá em cima. metodo que chama
			// o prépago.

			case 4:
				System.out.println("Fazer recarga selecionado ");
				System.out.println("METODO NÃO IMPLEMENTADO");
				break;

			case 5:
				System.out.println("Imprimir fatura selecionado ");
				System.out.println("METODO NÃO IMPLEMENTADO");
				break;

			case 6:
				System.out.println("Sair do programa selecionado ");
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}

		}

	}
}
