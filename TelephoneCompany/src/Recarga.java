import java.util.Date;
import java.util.GregorianCalendar;

public class Recarga {
	private GregorianCalendar data;
	private float valor;
	
	//constructor
	public Recarga(GregorianCalendar data, float valor) {
		super();
		this.data = data;
		this.valor = valor;
	}

	//getters
	public GregorianCalendar getData() {
		return data;
	}

	public float getValor() {
		return valor;
	}

	//toString
	@Override
	public String toString() {
		return "Recarga [data=" + data + ", valor=" + valor + "]";
	}
	
	
}
