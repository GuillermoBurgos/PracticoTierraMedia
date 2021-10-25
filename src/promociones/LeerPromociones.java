package promociones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerPromociones {

	static ArrayList<Promocion> listaPromociones=new ArrayList<Promocion>();

	public static void main(String[] args) {
		
		Promocion aux;
		try{
			FileReader input = new FileReader(new File ("promociones.csv"));
			BufferedReader bufInput = new BufferedReader(input);
			
			String line;
			String[] datos;
			
			//Creo las Strings para poder comparar en los if para cada tipo de promocion
			String Sdescuento=new String ("descuento");
			String Sabsoluta=new String ("absoluta");
			String Sgratis=new String ("gratis");
			
			
			line = bufInput.readLine();
			
			
			
			while(line != null){
				
				aux = new Promocion();
				datos= line.split(",");
				ArrayList<String> nombreAtracciones=new ArrayList<>();
				
					
					aux.setNombrePromocion(datos[0]);
					
					aux.setCantidadAtracciones(Integer.parseInt(datos[2]));
					for(int i=1;i<=aux.cantidadAtracciones;i++) {
						nombreAtracciones.add(datos[2+i]);
					}
					aux.setAtraccionesIncluidas(nombreAtracciones);
					
					
				if (datos[1].equals(Sdescuento)) {
					double descuento;
					
					descuento= Double.parseDouble(datos [3+(Integer.parseInt(datos[2]))]);
					
					aux.setTipoDescuento(Sdescuento+" de "+ String.valueOf(descuento*100)+"%");
					
					//System.out.println(descuento*100+"%");
					
				}
					
				if (datos[1].equals(Sabsoluta)) {
					
				}
					
				if (datos[1].equals(Sgratis)) {
					
				}
						
					
					listaPromociones.add(aux);
					
					
				line = bufInput.readLine();
				
				
				
				

			}
			
			System.out.println(listaPromociones);
			bufInput.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}


}
