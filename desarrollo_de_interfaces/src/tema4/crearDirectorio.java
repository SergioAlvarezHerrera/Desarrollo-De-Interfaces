package tema4;

import java.io.File;

public class crearDirectorio {
	public static void main(String[] args) {
		File directorio = new File ("imagenes");
		if(directorio.mkdir()) {
			System.out.println("Directorio 'images' creado exitosamente .");
		
		}else {
			System.out.println("Elm directorio 'images' ya existe o no se pudo crear.");
		}
	}
}

