import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	private Recarga[] recargas = new Recarga[5];
	private float creditos;
	private int numRecargas = 0;

	public PrePago(long cpf, String nome, int numero) {
		super(cpf, nome, numero);
		this.creditos = creditos;
		this.numRecargas = numRecargas;
		this.recargas = recargas;
	}

	public float fazerChamada(GregorianCalendar data, int duracao) {
		if (this.numChamadas >= this.chamadas.length) {
			System.out.println("Atenção, número máximo de chamadas atingido!");
			return 0;
		}
		float custoChamada = duracao * 1.45f;
		if (custoChamada > creditos) {
			System.out.println("Saldo insuficiente");
			return 0;
		}
		Chamada novaChamada = new Chamada(data, duracao);
		this.chamadas[this.numChamadas] = novaChamada;
		this.numChamadas++;
		return 0;
	}

	public void recarregar(GregorianCalendar data, float valor) {
		if (numRecargas >= recargas.length) {
			System.out.println("Atenção, número máximo de recargas atingida!");
			return;
		}
		creditos = creditos + valor;
		Recarga novaRecarga = new Recarga(data, valor);
		recargas[numRecargas] = novaRecarga;
		numRecargas++;
		return;
	}

	public void imprimirFatura(int mes) {
		System.out.println("Dados do assinante: ");
		System.out.println(this.toString());
		for(int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i].getData().MONTH == mes) {
				System.out.println(this.chamadas[i].toString());
				//imprimir todas recargas
				//imprimir valor total de todas as ligacoes e recargas (quanto deve ser pago)
			}
		}
	}
}
