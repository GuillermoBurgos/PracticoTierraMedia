package promociones;

import java.util.ArrayList;
import java.util.Arrays;

public class Promocion {
public  boolean adquirida;
String nombrePromocion;
int cantidadAtracciones;
ArrayList<String> atraccionesIncluidas;
String tipoDescuento;
String atraccionesGratis;

double duracionTotal;
double costoTotal;
double costoFinal;


public double getCostoFinal() {
	return costoFinal;
}

public void setCostoFinal(double costoFinal) {
	this.costoFinal = costoFinal;
}


public double getDuracionTotal() {
	return duracionTotal;
}

public void setDuracionTotal(double duracionTotal) {
	this.duracionTotal = duracionTotal;
}

public double getCostoTotal() {
	return costoTotal;
}

public void setCostoTotal(double costoTotal) {
	this.costoTotal = costoTotal;
}

public String getAtraccionesGratis() {
	return atraccionesGratis;
}

public void setAtraccionesGratis(String atraccionesGratis) {
	this.atraccionesGratis = atraccionesGratis;
}

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

@Override
public String toString() {
	return "Promocion [adquirida=" + adquirida + ", nombrePromocion=" + nombrePromocion + ", atraccionesIncluidas="
			+ atraccionesIncluidas + ", atraccionesGratis=" + atraccionesGratis + ", duracionTotal=" + duracionTotal
			+ ", costoFinal=" + costoFinal + "]\n";
}



}
