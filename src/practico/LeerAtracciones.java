package practico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.*;

public class LeerAtracciones {
	static ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

	public ArrayList<Atraccion> leerAtracciones() {

		Atraccion aux;
		try {
			FileReader input = new FileReader(new File("atracciones.csv"), StandardCharsets.UTF_8);
			BufferedReader bufInput = new BufferedReader(input);

			String line;
			String[] datos;

			line = bufInput.readLine();

			while (line != null) {

				aux = new Atraccion();
				datos = line.split(",");

				aux.setNombreAtraccion(datos[0]);
				aux.setCostoDeVisita(Double.parseDouble(datos[1]));
				aux.setDuracionDelRecorrido(Double.parseDouble(datos[2]));
				aux.setCupoDiarioDePersonas(Integer.parseInt(datos[3]));

				listaAtracciones.add(aux);

				line = bufInput.readLine();

			}

			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (listaAtracciones);
	}

	@Override
	public String toString() {
		return "LeerAtracciones [leerAtracciones()=" + leerAtracciones() + "]";
	}

}
