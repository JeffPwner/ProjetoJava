import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	protected float assinatura;

	public PosPago(long cpf, String nome, long numero) {
		super(cpf, nome, numero);

	}

	public String fazerChamada(GregorianCalendar data, int duracao) {
		this.numChamadas++;
		for(int i = 0; i < this.numChamadas; i++) {
			if (this.chamadas[i] == null) { 
				Chamada novaChamada = new Chamada(data, duracao);
				this.chamadas[i] = novaChamada;
				return "Chamada realizada com sucesso!";
				}
		}
		
		return "Chamada não pôde ser realizada...";
	}
	
	public void imprimirFatura(int mes) {
		float totalChamada = 0;
		System.out.println("Dados do assinante PosPago: ");
		for(int i = 0; i < this.numChamadas; i++) {
			if(this.chamadas[i] != null) {
				if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					int tempo = this.chamadas[i].getDuracao();
					float custoChamada = tempo * 1.04f;
					totalChamada = totalChamada + custoChamada;
					System.out.println(this.toString() + "\n" + this.chamadas[i].toString());
				}else {
					System.out.println("Não há chamadas realizadas até o momento neste mês.");
				}
			}
		}
		float custoTotal = this.assinatura + totalChamada;
		System.out.println("Valor da fatura: " + custoTotal);
		
	}
	/*
	public static void main(String[] args) {

		PosPago p = new PosPago(2, "nome", 55, 10f);

		p.fazerChamada(new Date(), 10);
		p.fazerChamada(new Date(), 100);
		p.fazerChamada(new Date(), 100);

		p.mostrarChamadas();

	}
	*/

}
