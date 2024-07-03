package com.java.ciudad.adapter.in;

import java.util.Scanner;

import com.java.ciudad.application.CiudadService;
import com.java.ciudad.domain.model.Ciudad;

public class CiudadConsoleAdapter {
    private final CiudadService ciudadService;
    

    public CiudadConsoleAdapter(CiudadService ciudadService) {
        this.ciudadService = ciudadService; 
    }


    public void start(){
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        while (bandera){
            System.out.println("1. Registrar Ciudad");
            System.out.println("2. Actualizar Ciudad");
            System.out.println("3. Eliminar Ciudad");
            System.out.println("4. Listar Ciudad");
            System.out.println("5. Buscar Ciudad");

            System.out.println("Seleccione una opcion");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el id de la ciudad");
                    int idCiudad = sc.nextInt();
                    System.out.println("Ingrese el nombre de la ciudad");
                    String nombre_ciudad = sc.next();
                    System.out.println("Ingrese el id del Pais");
                    int idPais = sc.nextInt();
                    Ciudad ciudad = new Ciudad(idCiudad, nombre_ciudad, idPais);
                    ciudadService.save(ciudad);
                    break;

                case 2:
                    System.out.println("Ingrese el id de la ciudad a actualizar");
                    int id_update = sc.nextInt();
                    System.out.println("Ingrese el nuevo nombre de la ciudad");
                    String name_update = sc.next();
                    System.out.println("Ingrese el nuevo id de la ciudad");
                    int id_paisUpdate = sc.nextInt();
                    Ciudad ciudad2 = new Ciudad(id_update, name_update, id_paisUpdate);
                    ciudadService.update(ciudad2);

                case 3:
                    System.out.println("Ingrese el id que desea eliminar:");
                    int idCiudadDelete = sc.nextInt();
                    ciudadService.delete(idCiudadDelete);

                default:
                    System.out.println("Opcion incorrecta seleccione una opcion valida");
                    break;
            }
        }
    }



    

    



}
