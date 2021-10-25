package practico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import promociones.Promocion;

public class ArchivoSalida {
	
	static ArrayList<Usuario> arraySalidaUsuario=new ArrayList<Usuario>();
	static ArrayList<Promocion> arraySalidaPromocion=new ArrayList<Promocion>();
	static ArrayList<Atraccion> arraySalidaAtraccion=new ArrayList<Atraccion>();
	static ArrayList <String> formulario=new ArrayList<String>();
	
	public static void aniadirUsuario(Usuario usuario) {
		arraySalidaUsuario.add(usuario);
		
	}

	public static void aniadirPromo(Promocion promocion) {
		System.out.println("Promoción añadida.");
		arraySalidaPromocion.add(promocion);
		

	}

	

	public static void aniadirAtraccion(Atraccion atraccion) {
		System.out.println("Atracción añadida.");
		arraySalidaAtraccion.add(atraccion);
		
	}

	
	private static double costoTotal(ArrayList<Promocion> a,ArrayList<Atraccion> b) {
		double costoTotal=0;
		for(int i=0;i<a.size();i++) {
			costoTotal+=a.get(i).getCostoFinal();
		}
		for(int i=0;i<b.size();i++) {
			costoTotal+=b.get(i).costoDeVisita;
		}
		
		return(costoTotal);
	}
	
	private static double tiempoTotal(ArrayList<Promocion> a,ArrayList<Atraccion> b) {
		double tiempoTotal=0;
		for(int i=0;i<a.size();i++) {
			tiempoTotal+=a.get(i).getDuracionTotal();
		}
		for(int i=0;i<b.size();i++) {
			tiempoTotal+=b.get(i).duracionDelRecorrido;
		}
		
		return(tiempoTotal);
	}
	
private static void generarformulario() {
		formulario.add("Usuario: "+arraySalidaUsuario.get(0).nombreUsuario+"\n");
		if(arraySalidaPromocion.size()>0) {
		formulario.add("Promociones compradas: \n");
		for(int i=0;i<arraySalidaPromocion.size();i++) {
			formulario.add(arraySalidaPromocion.get(i).getNombrePromocion()+"\t"+arraySalidaPromocion.get(i).getDuracionTotal()+" Hs. \t\t"+arraySalidaPromocion.get(i).getCostoFinal()+" Oros.");
		}
		}
		if(arraySalidaAtraccion.size()>0) {
		formulario.add("\nAtracciones compradas: \n");
		for(int i=0;i<arraySalidaAtraccion.size();i++) {
			formulario.add(arraySalidaAtraccion.get(i).nombreAtraccion+"\t"+arraySalidaAtraccion.get(i).duracionDelRecorrido+" Hs.\t\t"+arraySalidaAtraccion.get(i).costoDeVisita+" Oros.");
		}
		}
		formulario.add("\nTOTAL:\t\t"+tiempoTotal(arraySalidaPromocion,arraySalidaAtraccion)+" Hs.\t\t"+costoTotal(arraySalidaPromocion,arraySalidaAtraccion)+" Oros.\n");
}
public static void escribirArchivo() throws IOException{
		generarformulario();
		
		PrintWriter salida = new PrintWriter(new FileWriter(arraySalidaUsuario.get(0).nombreUsuario+".txt"));
		for(String a:formulario) {
			salida.println(a);
			
			System.out.println(a);
		}
		salida.close();
		formulario.clear();
		arraySalidaUsuario.clear();
		arraySalidaPromocion.clear();
		arraySalidaAtraccion.clear();
		
		
	}


}