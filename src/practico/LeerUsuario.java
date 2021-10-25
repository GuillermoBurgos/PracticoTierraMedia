package practico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerUsuario {

	static ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();

	public static void main(String[] args) {
		
		Usuario aux;
		try{
			FileReader input = new FileReader(new File ("usuarios.csv"));
			BufferedReader bufInput = new BufferedReader(input);
			
			String line;
			String[] datos;
			
			int i=0;
			line = bufInput.readLine();
			
			
			
			while(line != null){
				
				aux = new Usuario();
				datos= line.split(",");
							
		
					
					aux.setNombreUsuario(datos[0]);
					aux.setCapacidadDeCompra(Double.parseDouble(datos[1]));
					aux.setCapacidadDeVisita(Double.parseDouble(datos[2]));
					
					
					
					listaUsuarios.add(aux);
					//System.out.println(listaUsuarios);
					
				line = bufInput.readLine();
				
				
				
				

			}
			
			System.out.println(listaUsuarios);
			bufInput.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}


}
