package practico;

public class Usuario {
String nombreUsuario;
double capacidadDeCompra;
double capacidadDeVisita;

public String getNombreUsuario() {
	return nombreUsuario;
}
public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}
public double getCapacidadDeCompra() {
	return capacidadDeCompra;
}
public void setCapacidadDeCompra(double capacidadDeCompra) {
	this.capacidadDeCompra = capacidadDeCompra;
}
public double getCapacidadDeVisita() {
	return capacidadDeVisita;
}
public void setCapacidadDeVisita(double capacidadDeVisita) {
	this.capacidadDeVisita = capacidadDeVisita;
}
@Override
public String toString() {
	return "(nombreUsuario=" + nombreUsuario + ", capacidadDeCompra=" + capacidadDeCompra
			+ ", capacidadDeVisita=" + capacidadDeVisita +")\n";
}

}
