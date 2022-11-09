import java.util.Calendar;
import java.util.Date;

public class Chamada {
	private Date data;
	private int duracao;

	public Chamada(Date data, int duracao) {
		super();
		this.data = data;
		this.duracao = duracao;
	}

	public Date getData() {
		return data;
	}

	public int getDuracao() {
		return duracao;
	}

	@Override
	public String toString() {
		return "Chamada [data=" + data + ", duracao=" + duracao + "]";
	}

	
	/* 
	 * testing if it works properly
	 *
	public static void main(String[] args) {
		
		Calendar ca = Calendar.getInstance();
		ca.set(1999, 1, 1);
		Date d = ca.getTime();
		Chamada c = new Chamada(d, 50);
		System.out.println(c);
		
	}
	*/
	
}
