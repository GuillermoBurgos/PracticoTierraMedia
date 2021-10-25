package promociones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import practico.Atraccion;
import practico.LeerAtracciones;

public class LeerPromociones {

	static ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();
	static ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

	public ArrayList<Promocion> leerPromocion(ArrayList<Atraccion> a) {

		listaAtracciones = a;

		Promocion aux;
		try {
			FileReader input = new FileReader(new File("promociones.csv"), StandardCharsets.UTF_8);
			BufferedReader bufInput = new BufferedReader(input);

			String line;
			String[] datos;

			// Creo las Strings para poder comparar en los if para cada tipo de promocion
			String Sdescuento = new String("descuento");
			String Sabsoluta = new String("absoluta");
			String Sgratis = new String("gratis");

			line = bufInput.readLine();

			while (line != null) {

				aux = new Promocion();
				datos = line.split(",");
				ArrayList<String> nombreAtracciones = new ArrayList<>();

				double costoAcumulado = 0;
				double tiempoAcumulado = 0;

				aux.setNombrePromocion(datos[0]);

				aux.setCantidadAtracciones(Integer.parseInt(datos[2]));
				for (int i = 1; i <= aux.cantidadAtracciones; i++) {
					nombreAtracciones.add(datos[2 + i]);

					for (int j = 0; j < listaAtracciones.size(); j++) {
						if (datos[2 + i].equals(listaAtracciones.get(j).getNombreAtraccion())) {

							costoAcumulado += listaAtracciones.get(j).getCostoDeVisita();

							tiempoAcumulado += listaAtracciones.get(j).getDuracionDelRecorrido();
						}
					}

				}
				aux.setAtraccionesIncluidas(nombreAtracciones);
				aux.setCostoTotal(costoAcumulado);
				aux.setDuracionTotal(tiempoAcumulado);

				if (datos[1].equals(Sdescuento)) {
					double descuento;

					descuento = Double.parseDouble(datos[3 + (Integer.parseInt(datos[2]))]);

					aux.setTipoDescuento(Sdescuento + " de " + String.valueOf(descuento * 100) + "%");
					aux.setAtraccionesGratis("No aplican para esta promoción.");
					aux.setCostoFinal(costoAcumulado - (costoAcumulado * descuento));

				}

				if (datos[1].equals(Sabsoluta)) {

					aux.setTipoDescuento(Sabsoluta + " de " + (datos[3 + (Integer.parseInt(datos[2]))]) + " monedas.");
					aux.setAtraccionesGratis("No aplican para esta promoción.");
					aux.setCostoFinal(Double.parseDouble(datos[3 + (Integer.parseInt(datos[2]))]));
				}

				if (datos[1].equals(Sgratis)) {
					int cantidadGratis;
					String NombreAtraccionesGratis = "";
					aux.setCostoFinal(costoAcumulado);

					cantidadGratis = Integer.parseInt(datos[3 + (Integer.parseInt(datos[2]))]);

					for (int i = 0; i < cantidadGratis; i++) {

						NombreAtraccionesGratis += datos[i + 4 + (Integer.parseInt(datos[2]))];

						if (i + 1 < cantidadGratis)
							NombreAtraccionesGratis += ", ";

						for (int j = 0; j < listaAtracciones.size(); j++) {
							if (datos[i + 4 + (Integer.parseInt(datos[2]))]
									.equals(listaAtracciones.get(j).getNombreAtraccion())) {
								costoAcumulado += listaAtracciones.get(j).getCostoDeVisita();
								tiempoAcumulado += listaAtracciones.get(j).getDuracionDelRecorrido();
							}
						}
					}
					aux.setTipoDescuento("Gratis");
					aux.setAtraccionesGratis(NombreAtraccionesGratis);
					aux.setDuracionTotal(tiempoAcumulado);
					aux.setCostoTotal(costoAcumulado);
				}

				listaPromociones.add(aux);

				line = bufInput.readLine();

			}

			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (listaPromociones);
	}

}
