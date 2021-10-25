package practico;


public class Atraccion {

	String nombreAtraccion;
	double costoDeVisita;
	double duracionDelRecorrido;
	int cupoDiarioDePersonas;
	
	public String getNombreAtraccion() {
		return nombreAtraccion;
	}
	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}
	public double getCostoDeVisita() {
		return costoDeVisita;
	}
	public void setCostoDeVisita(double costoDeVisita) {
		this.costoDeVisita = costoDeVisita;
	}
	public double getDuracionDelRecorrido() {
		return duracionDelRecorrido;
	}
	public void setDuracionDelRecorrido(double duracionDelRecorrido) {
		this.duracionDelRecorrido = duracionDelRecorrido;
	}
	public int getCupoDiarioDePersonas() {
		return cupoDiarioDePersonas;
	}
	public void setCupoDiarioDePersonas(int cupoDiarioDePersonas) {
		this.cupoDiarioDePersonas = cupoDiarioDePersonas;
	}
	@Override
	public String toString() {
		return "nombreAtraccion=" + nombreAtraccion + ", costoDeVisita=" + costoDeVisita
				+ ", duracionDelRecorrido=" + duracionDelRecorrido + ", cupoDiarioDePersonas=" + cupoDiarioDePersonas+"\n"
				;
	}




	
}
