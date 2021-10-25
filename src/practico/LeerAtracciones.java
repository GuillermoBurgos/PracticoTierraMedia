package practico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class LeerAtracciones {
	static ArrayList<Atraccion> listaAtracciones=new ArrayList<Atraccion>();

	public static void main(String[] args) {
		
		Atraccion aux;
		try{
			FileReader input = new FileReader(new File ("atracciones.csv"));
			BufferedReader bufInput = new BufferedReader(input);
			
			String line;
			String[] datos;
			
			int i=0;
			line = bufInput.readLine();
			
			
			
			while(line != null){
				
				aux = new Atraccion();
				datos= line.split(",");
							
				/*String nombreAtraccion = datos[0];
				double costoDeVisita = Double.parseDouble(datos[1]);
				double duracionDelRecorrido = Double.parseDouble(datos[2]);
				int cupoDiarioDePersonas = Integer.parseInt(datos[3]);
				
				
				
					System.out.println("" + nombreAtraccion + " " + costoDeVisita + " " + duracionDelRecorrido+" "+cupoDiarioDePersonas);
					//System.out.println( costoDeVisita + duracionDelRecorrido+cupoDiarioDePersonas);
				*/
					
					
					
					aux.setNombreAtraccion(datos[0]);
					aux.setCostoDeVisita(Double.parseDouble(datos[1]));
					aux.setDuracionDelRecorrido(Double.parseDouble(datos[2]));
					aux.setCupoDiarioDePersonas(Integer.parseInt(datos[3]));
					
					//System.out.println("" + datos[0] + " " + datos[1] + " " + datos[2]+" "+datos[3]);
					//System.out.println("" + aux.getNombreAtraccion() + " " + aux.getCostoDeVisita() + " " + aux.getDuracionDelRecorrido()+" "+aux.getCupoDiarioDePersonas());
					
					listaAtracciones.add(aux);
					//System.out.println(listaAtracciones);
					
				line = bufInput.readLine();
				
				
				
				

			}
			
			System.out.println(listaAtracciones);
			bufInput.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}


	}


