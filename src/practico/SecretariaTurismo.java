package practico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import promociones.LeerPromociones;
import promociones.Promocion;

public class SecretariaTurismo {
	static ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();
	static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	static ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		// Leer usuarios
		LeerUsuario auxUser = new LeerUsuario();
		listaUsuarios = auxUser.leerUsuario();

		// Leer Atracciones
		LeerAtracciones auxAtr = new LeerAtracciones();
		listaAtracciones = auxAtr.leerAtracciones();
		
		
		//clono Atraccion
		ArrayList <Atraccion> atraccionMinima=new ArrayList<Atraccion>();
		atraccionMinima= (ArrayList<Atraccion>)listaAtracciones.clone();
		
		
		
		// Buscar la atraccion de menor valor y la de menor duracion
		int IndexMinima=0;
		boolean seAcabaronLasMinimas=false;

		// Leer Promociones
		LeerPromociones auxProm = new LeerPromociones();
		listaPromociones = auxProm.leerPromocion(listaAtracciones);

		// Promociones ordenado por precio de mayora menory tiempo de menor a mayor
		Collections.sort(listaPromociones, new Comparator<Promocion>() {
			@Override
			public int compare(Promocion p1, Promocion p2) {
				return Double.compare(p2.getCostoFinal(), p1.getCostoFinal());
			}
		}.thenComparing(Promocion::getDuracionTotal));

		// atracciones ordenado por precio de mayora menor y tiempo de menor a mayor
		Collections.sort(listaAtracciones, new Comparator<Atraccion>() {
			@Override
			public int compare(Atraccion a1, Atraccion a2) {
				return Double.compare(a2.costoDeVisita, a1.costoDeVisita);
			}
		}.thenComparing(Atraccion::getDuracionDelRecorrido));

		//arreglo auxiliar para minimas ordenado de menor a mayor
				Collections.sort(atraccionMinima, new Comparator<Atraccion>() {
					@Override
					public int compare(Atraccion a1, Atraccion a2) {
						return Double.compare(a1.costoDeVisita, a2.costoDeVisita);
					}
				}.thenComparing(Atraccion::getDuracionDelRecorrido));
				
		
		// Aqui viene lo bueno señores
		for (int i = 0; i < listaUsuarios.size(); i++) {

			// inicializo atracciones adquirida en false
			for (int t = 0; t < listaAtracciones.size(); t++) {
				listaAtracciones.get(t).adquirida = false;
			}
			// inicializo promociones adquirida en false
			for (int t = 0; t < listaPromociones.size(); t++) {
				listaPromociones.get(t).adquirida = false;
			}
			
			//Reviso si las atracciones tienen cupo y las descarto si es asi
			for(int at=0;at<listaAtracciones.size();at++) {
				if (listaAtracciones.get(at).cupoDiarioDePersonas==0)
					listaAtracciones.get(at).adquirida=true;
			}
			
			
			seAcabaronLasMinimas=false;

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Bienvenid@ a las tierras medias " + listaUsuarios.get(i).getNombreUsuario() + ".");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			ArchivoSalida.aniadirUsuario(listaUsuarios.get(i));
			System.out.println("Disponible:"+listaUsuarios.get(i).capacidadDeCompra+" Oros, "+listaUsuarios.get(i).capacidadDeVisita+" Hs.");
			// Valido que el usuario tiene dinero y tiempo
			
			
			while ((!seAcabaronLasMinimas)&&((listaUsuarios.get(i).getCapacidadDeCompra()>=atraccionMinima.get(IndexMinima).costoDeVisita)&&(listaUsuarios.get(i).getCapacidadDeVisita()>=atraccionMinima.get(IndexMinima).duracionDelRecorrido)))
			{


				
				// OfrezcoPromociones
				boolean bandera = false; // bandera para que no se vuelva a imprimir la promo si meten mal el dedo
				for (int j = 0; j < listaPromociones.size(); j++) {

					if ((listaPromociones.get(j).adquirida == false)
							&& ((listaUsuarios.get(i).capacidadDeCompra >= listaPromociones.get(j).getCostoFinal())
									&& (listaUsuarios.get(i).getCapacidadDeVisita() >= listaPromociones.get(j)
											.getDuracionTotal()))) {

						if (!bandera) {
							//System.out.println(listaUsuarios.get(i).capacidadDeCompra+" "+listaUsuarios.get(i).capacidadDeVisita);
							//System.out.println(minCosto+""+minDuracion);
							
							
							System.out.println("¡SOLO POR HOY!");
							System.out.println(listaPromociones.get(j).getNombrePromocion());
							System.out.println(
									"Atracciones incluidas:" + listaPromociones.get(j).getAtraccionesIncluidas());
							System.out.println("Atracciones gratis: " + listaPromociones.get(j).getAtraccionesGratis());
							System.out.println("Duracion: " + listaPromociones.get(j).getDuracionTotal() + " Hs.");
							System.out.println("Costo habitual: " + listaPromociones.get(j).getCostoTotal() + " Oros.");
							System.out.println("Precio amigo de la comunidad:" + listaPromociones.get(j).getCostoFinal()
									+ " Oros.");
							System.out.println("");
						}

						System.out.print("¿Acepta promoción? (S/N)");
						char respuesta = keyboard.next().charAt(0);

						boolean eleccionCorrecta = false;

						if (respuesta == 's' || respuesta == 'S') {

							eleccionCorrecta = true;
							ArchivoSalida.aniadirPromo(listaPromociones.get(j));

							// aqui disminuyo el cupo de las atracciones incluidas y marco atracciones y
							// Promociones Adquiridas
							for (String nomProm : listaPromociones.get(j).getAtraccionesIncluidas()) {
								String[] nombreGratis = listaPromociones.get(j).getAtraccionesGratis().split(", ");

								for (int z = 0; z < listaAtracciones.size(); z++) {
									if (nomProm.equals(listaAtracciones.get(z).nombreAtraccion)) {
										listaAtracciones.get(z).cupoDiarioDePersonas -= 1;
										listaAtracciones.get(z).adquirida = true;
									}

									for (int y = 0; y < nombreGratis.length; y++) {
										if (nombreGratis[y].equals(listaAtracciones.get(z).nombreAtraccion))
										// si el nombre de la atraccion figura en las gratis se descuenta cupo y marca
										// como adquirida
										{
											listaAtracciones.get(z).cupoDiarioDePersonas -= 1;
											listaAtracciones.get(z).adquirida = true;

										}
									}

								}

								for (int y = 0; y < listaPromociones.size(); y++) {
									for (String nomOtro : listaPromociones.get(y).getAtraccionesIncluidas()) {
										if (nomProm.equals(nomOtro)) {
											listaPromociones.get(y).adquirida = true;
										}
										for (int x = 0; x < nombreGratis.length; x++) {
											if (nombreGratis[x].equals(nomOtro)) {// si la atraccion Gratis figura en
																					// otro paquete se marca como
																					// adquirido
												listaPromociones.get(y).adquirida = true;
											}
										}
									}
								}
								// si la atraccion esta dentro de la promocion y figura como gratis en otro, se
								// marca adquirido en el otro.
								for (int w = 0; w < listaPromociones.size(); w++) {
									for (String buscProm : listaPromociones.get(w).getAtraccionesIncluidas()) {
										for (int x = 0; x < nombreGratis.length; x++) {
											if (nombreGratis[x].equals(buscProm)) {// si la atraccion Gratis figura en
																					// otro paquete se marca como
																					// adquirido
												listaPromociones.get(w).adquirida = true;
											}
										}
									}
								}
							}

							// aqui disminuyo tiempo y dinero del user
							listaUsuarios.get(i).capacidadDeCompra -= listaPromociones.get(j).getCostoFinal();
							listaUsuarios.get(i).capacidadDeVisita -= listaPromociones.get(j).getDuracionTotal();
							listaPromociones.get(j).adquirida = true;


							
							
							bandera = false;
						}
						if (respuesta == 'N' || respuesta == 'n') {
							eleccionCorrecta = true;
							bandera = false;
						}

						if (!eleccionCorrecta) {
							System.out.println("No sea orco, es S o N.");
							bandera = true;
							j--;
						}
						
					}
				} // Aqui terminan las promociones

				// Ofrezco Atracciones
				boolean bandera2 = false;
				for (int j = 0; j < listaAtracciones.size(); j++) {
					if ((listaAtracciones.get(j).adquirida == false)
							&& ((listaUsuarios.get(i).capacidadDeCompra >= listaAtracciones.get(j).costoDeVisita)
									&& (listaUsuarios.get(i)
											.getCapacidadDeVisita() >= listaAtracciones.get(j).duracionDelRecorrido))) {
						if (!bandera2) {
							System.out.println("____________________________________________");
							System.out.println("");
							System.out.println("Atracción: " + listaAtracciones.get(j).nombreAtraccion);
							System.out.println("Precio:" + listaAtracciones.get(j).costoDeVisita + " Oros.");
							System.out.println("Duracion: " + listaAtracciones.get(j).duracionDelRecorrido + " Hs.");
							System.out.println("");
						}
						System.out.print("¿Acepta Atracción? (S/N)");
						char respuesta = keyboard.next().charAt(0);
						boolean eleccionCorrecta = false;

						if (respuesta == 's' || respuesta == 'S') {

							eleccionCorrecta = true;
							ArchivoSalida.aniadirAtraccion(listaAtracciones.get(j));

							// aqui disminuyo el cupo de las atracciones incluidas y la marco como adquirida
							listaAtracciones.get(j).cupoDiarioDePersonas -= 1;
							listaAtracciones.get(j).adquirida = true;

							// aqui disminuyo tiempo y dinero del user
							listaUsuarios.get(i).capacidadDeCompra -= listaAtracciones.get(j).costoDeVisita;
							listaUsuarios.get(i).capacidadDeVisita -= listaAtracciones.get(j).duracionDelRecorrido;

							bandera2 = false;
						}
						if (respuesta == 'N' || respuesta == 'n') {
							eleccionCorrecta = true;
							bandera2 = false;
						}

						// Este if es para volver a ofrecer promo si es que no se introduce So N para no
						// recurrir al while mientras pruebo
						if (!eleccionCorrecta) {
							System.out.println("No sea orco, es S o N.");
							bandera2 = true;
							j--;
						}
					}
				}

				//aqui reinicio los minimos con los minimos de las atracciones que no fueron compradas

				
				for (int k = 0; k < atraccionMinima.size(); k++) {
					for(int l=0;l<listaAtracciones.size();l++) {
						if(listaAtracciones.get(l).adquirida==true) {
						if(atraccionMinima.get(k).nombreAtraccion.equals(listaAtracciones.get(l).nombreAtraccion)) {
							IndexMinima++;
						if (IndexMinima==atraccionMinima.size()) {IndexMinima--;
							seAcabaronLasMinimas=true;}}
						}
							}
				}

			}
			ArchivoSalida.escribirArchivo();
		} // Final del recorrido de Users

		
		System.out.println("Gracias por elegirnos.");
		keyboard.close();
	}
	
	
	
}