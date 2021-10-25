package promociones;

import java.util.ArrayList;
import java.util.Arrays;

public class Promocion {
String nombrePromocion;
int cantidadAtracciones;
ArrayList<String> atraccionesIncluidas;
String tipoDescuento;



public String getTipoDescuento() {
	return tipoDescuento;
}

public void setTipoDescuento(String tipoDescuento) {
	this.tipoDescuento = tipoDescuento;
}


public int getCantidadAtracciones() {
	return cantidadAtracciones;
}

public void setCantidadAtracciones(int cantidadAtracciones) {
	this.cantidadAtracciones = cantidadAtracciones;
}

public String getNombrePromocion() {
	return nombrePromocion;
}

public void setNombrePromocion(String nombrePromocion) {
	this.nombrePromocion = nombrePromocion;
}

public ArrayList<String> getAtraccionesIncluidas() {
	return atraccionesIncluidas;
}

public void setAtraccionesIncluidas(ArrayList<String> nombreAtracciones) {
	this.atraccionesIncluidas = nombreAtracciones;
}

double CalcularDuracionTotal(Promocion P) {
	double duracionTotal = 0;
	for(String duracionUnitaria : P.atraccionesIncluidas)
	duracionTotal+=Double.parseDouble(duracionUnitaria);
		
		return(duracionTotal);
}

double CalcularCostoTotalOriginal(Promocion P) {
	double costoTotal = 0;
	for(String costoUnitario : P.atraccionesIncluidas)
	costoTotal+=Double.parseDouble(costoUnitario);
		
		return(costoTotal);
}

@Override
public String toString() {
	return "Promocion [nombrePromocion=" + nombrePromocion + ", cantidadAtracciones=" + cantidadAtracciones
			+ ", atraccionesIncluidas=" + atraccionesIncluidas + ", tipoDescuento=" + tipoDescuento + "]\n";
}



}
