import java.util.Date;
import java.util.GregorianCalendar;

public class PrePago extends Assinante{
	private Recarga[] recargas = new Recarga[5];
	private float creditos;
	private int numRecargas = 0;
	
	public PrePago(long cpf, String nome, int numero) {
		super(cpf, nome, numero);
		this.creditos = creditos;
		this.numRecargas = numRecargas;
		this.recargas = recargas; //instanciando
	}
	// faz as duas verificaçoes 
	public float fazerChamada(GregorianCalendar data, int duracao) { //num chamadas é maior que o numero de chamadas disponivel
		if (this.numChamadas >= this.chamadas.length ) { //pegando o num max de chamadas
			 
		}
		float custoChamada = duracao * 1.45f;
		if(custoChamada > creditos) { //verificando se há crédito
			System.out.println("Saldo insuficiente");
			 return 0; //conta, se o numero nao for maior que o tamanho do vetor chamadas (5)
		}
		Chamada novaChamada = new Chamada(data, duracao);//obj nova chamada do tipo chamada, atributoda data e duraçao
		this.chamadas[this.numChamadas] = novaChamada; //chamando o vetor e atualizando o numero de chamadas e adicionando uma nova chamada em numchamadas. Vai adicionar no 0, dps 1, 2, etc
		this.numChamadas++; 
		return 0; //quando o return esta na função ela encerra o processo
	}
	
	public void recarregar(GregorianCalendar data, float valor) {
		if(numRecargas >= this.recargas.length) {
			System.out.println("Atenção, número máximo de recargas atingido.");
			return;
		} //se passar, efetua a recarga
		creditos = creditos + valor; //recarregando creditos e documentando recargas
		Recarga novaRecarga = new Recarga(data, valor); //chamando o vetor e atualizando o numero de chamadas e adicionando uma nova chamada em numchamadas. Vai adicionar no 0, dps 1, 2, etc
		recargas[numRecargas] = novaRecarga; 
		numRecargas++;
		return; 
	}
	
	
	
	public void imprimirFatura(int mes) { //olhar no vetor qual o mes
		System.out.println("Dados do assinante: ");
		System.out.println(this.toString()); //converter em string ao retornar o valores
		for(i = 0; i <= this.chamadas.length; i++) {
			if(this.chamadas[i].getData().MONTH == mes) {//inteirar todas as chamadas que temos e verificar se o if
				System.out.println(this.chamadas[i].toString()); //verificando cada chamada no vetor, se o mes = chamada da fatura entra  na linha 50 e print os dados da chamada e mostra os dados do mes que foram pedidos
				//imprimir todas as recargas
				//imprimir valor total de todas as ligaçoes e recargas de quanto deve ser pago
			}
	}
}
