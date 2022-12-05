import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	private Recarga[] recargas = new Recarga[5];
	protected float creditos;
	private int numRecargas = 0;

	public PrePago(long cpf, String nome, long numero) {
		super(cpf, nome, numero);
		this.numRecargas = numRecargas;
		this.recargas = recargas;
	}

	// faz as duas verificações
	public String fazerChamada(GregorianCalendar data, int duracao) {
		if (this.numChamadas >= this.chamadas.length) {
			return "Atenção, número máximo de chamadas atingido!";
		}
		float custoChamada = duracao * 1.45f;
		if (custoChamada > creditos) { // verificando se há crédito
			return "Saldo insuficiente"; // conta, se o numero nao for maior que o tamanho do vetor chamadas (5)
		}
		Chamada novaChamada = new Chamada(data, duracao); // obj nova chamada do tipo chamada, atributoda data e duraçao
		this.chamadas[this.numChamadas] = novaChamada; // chamando o vetor e atualizando o numero de chamadas e
														// adicionando uma nova chamada em numchamadas. Vai adicionar no
														// 0, dps 1, 2, etc
		this.numChamadas++;
		return "Chamada efetuada com sucesso.";
	}

	public void recarregar(GregorianCalendar data, float valor) {
		if (numRecargas >= recargas.length) {
			System.out.println("Atenção, número máximo de recargas atingida!");
			return;
		} // se passar, efetua a recarga
		creditos = creditos + valor; // recarregando creditos e documentando recargas
		Recarga novaRecarga = new Recarga(data, valor); // chamando o vetor e atualizando o numero de chamadas e
														// adicionando uma nova chamada em numchamadas. Vai adicionar no
														// 0, dps 1, 2, etc
		recargas[numRecargas] = novaRecarga;
		numRecargas++;
		return;
	}

	public void imprimirFatura(int mes) { // olhar no vetor qual o mês
		float totalChamada = 0;
		float totalRecarga = 0;
		System.out.println("Dados do assinante: ");
		System.out.println(this.toString()); // converter em string ao retornar o valores
		for (int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) { // inteirar todas as chamadas que
																					// temos e verificar se o if
				System.out.println(this.chamadas[i].toString()); // verificando cada chamada no vetor, se o mes =
																	// chamada da fatura entra na linha 50 e print os
																	// dados da chamada e mostra os dados do mes que
																	// foram pedidos
				int tempo = this.chamadas[i].getDuracao();
				float custo = tempo * 1.45f;
				totalChamada = totalChamada + custo;
				System.out.println(this.toString() + "\n" + this.chamadas[i].toString());
			} else {
				System.out.println("Não há chamadas realizadas até o momento neste mês.");
			}
		}
		for (int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
				float valorRecarga = this.recargas[i].getValor();
				totalRecarga = totalRecarga + valorRecarga;
				System.out.println("Recarga: " + this.recargas[i].toString());
			} else {
				System.out.println("Não há recargas realizadas neste mês.");
			}
		}
		System.out.println("Total de chamadas: " + totalChamada + " , " + "Total de recarga: " + totalRecarga + " , " + "Créditos: " + creditos);
	}
}