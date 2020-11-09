
package ui;

import model.*;
import java.util.*;
public class menu {
    MCS  m;
    Scanner sc;
    Scanner cs;
    
    public menu(){
    m = new MCS();
    sc = new Scanner(System.in);
    cs = new Scanner(System.in);
    }
    
    public void Logo(){
        System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((\n"
                + "((((((((((((((((/((((((((((((((((((((((((((((((((\n"
                + "(((/  .(((((((*  .((((((*        (((((/      /(((\n"
                + "(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"
                + "(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"
                + "(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"
                + "(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"
                + "(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"
                + "(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"
                + "(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"
                + "(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"
                + "(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"
                + "(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"
                + "(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"
                + "(((/  .((((((((.  *((((((.        *((   .   .((((\n"
                + "(((((((((((((((/*/((((((((((///(((((((////(((((((\n"
                + "  (((((((((((((((((((((((((((((((((((((((((((((((((\n"
                + "                 ./(###((///((###(*                \n"
                + "             *#(,                   *((,           \n"
                + "          ,#/                           ((         \n"
                + "        .#*          .**/////*,.          ((       \n"
                + "       *(.      .//////////////////*       *#      \n"
                + "      .#,     *///////////////////////,     /(     \n"
                + "      /(    *///////////////////////////    .#.    \n"
                + "    ,/////,*/////////////////////////////,*////*.  \n"
                + "    /////////////////////////*,...,/////////////,  \n"
                + "    //////*,,,********,,.............,,,,,//////,  \n"
                + "    //////*.........//*........//*.......,//////,  \n"
                + "    //////*.........,,.........,,........,//////,  \n"
                + "    //////*..............................,//////,  \n"
                + "     *///*  ........,/.........**.......  .*///,   \n"
                + "              .......,/*.....,/*.......            \n"
                + "                     /*/........                   \n"
                + "           (    )   /*/                            \n"
                + "             (  )  /*/                             \n"
                + "              ( ) /*/                              \n"
                + "                 ///                               \n"
                + "  *************************************************");
    }
    
    public void addUser() {

        System.out.println("\t---------------------------");
        System.out.println("\tINFORMACION DEL USUARIO: ");
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
        System.out.print("Edad: ");
        byte age = cs.nextByte();

        System.out.println(m.addUser(name, password, age));
    }

    public void login() {
        System.out.println("----------------------");
        System.out.print("Nombre de usuario: ");
        String name = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
        
        
        System.out.println(m.loginU(name, password));
    }



    public void addPoolSong() {
        String title;
        String nameArtist;
        String releaseDate;
        String duration;
        int num;
        
        System.out.println("----------------------------");
        System.out.println("\tINFORMACION DE LA CANCIÓN: ");
        System.out.print("*Titulo: ");
        title = sc.nextLine();
        System.out.print("*Nombre del artista: ");
        nameArtist = sc.nextLine();
        System.out.print("*Fecha de lanzamiento: ");
        releaseDate = sc.nextLine();
        System.out.print("Ingrese la duración: \nFormato (00:00): ");
        duration = sc.nextLine();
        System.out.print("*Ingrese el genero de la canción");
        System.out.println("\n1. Rock\n" + "2. HipHop\n" + "3. Classical\n"
                + "4. Reggae\n" + "5. Salsa\n" + "6. Metal\n");
        System.out.print("\n\nOpcion: ");
        num = cs.nextInt();
        System.out.println(m.addSong(title, nameArtist, releaseDate, duration, num-1 ));

    }

    public void addPrivatePL() {

        String name;

        System.out.println("\tINFORMACION DE PLAYLIST PRIVADA: ");
        System.out.print("Nombre: ");
        name = sc.nextLine();

        System.out.println(m.addPrivatePL(name));
    }

    public void addRetrictedPL() {
        String name;

        System.out.println("\tINFORMACION DE PLAYLIST RESTRINGIDA:");
        System.out.print("Nombre: ");
        name = sc.nextLine();

        System.out.println(m.addRestrictedPL(name));
    }



    public void addPublicPL() {
        String name;

        System.out.println("\tINFORMACION DE PLAYLIST PUBLICA:");
        System.out.print("Nombre: ");
        name = sc.nextLine();
        System.out.println(m.addPublicPL(name));
    }
    public void addAccess() {
        System.out.println("\tEscoge el numero correspondiente de la PlayList");
        for (int i = 0; i < m.getPlayLists().length; i++) {
            if (m.getPlayLists()[i] instanceof RetrictedPL) {
                System.out.println((i + 1) + "). " + m.getPlayLists()[i].getName()+"\n");
            }
        }
        
        int retrictedPL = sc.nextInt();
        System.out.println("\tSeleccionar usuario: ");
        for (int i = 0; i < m.getnUsers().length; i++) {
            if(m.getnUsers()[i] != null){
                System.out.println((i + 1) + "). " + m.getnUsers()[i].getName());
            }
        }
        int access = cs.nextInt();

        System.out.println(m.addAccess(retrictedPL -1, access-1));
    }
    public void addCalificationPL() {
        
        System.out.println("\tEscoge el numero correspondiente de la PlayList");
        for (int i = 0; i < m.getPlayLists().length; i++) {
            if (m.getPlayLists()[i] instanceof PublicPL) {
                System.out.println((i + 1) + "). " + m.getPlayLists()[i].getName());
            }
        }
        int playList = cs.nextInt();

        System.out.println("");
        System.out.println("CALIFICAR EN UN RANGO DE 1 - 5\n(1 es la calificacion mas baja y 5 la mas alta)");
        float calification = cs.nextFloat();

        m.addqualification_PL(playList-1, calification);
    }

    public void addPlayListSong() {
        
        System.out.println("\tSeleccione la lista");
        for (int i = 0; i < m.getPlayLists().length; i++) {
            if(m.getPlayLists()[i] != null){
                System.out.println((i + 1) + ". " + m.getPlayLists()[i].getName());
            }
        }
        int numplayList = cs.nextInt()-1;//-1 por que el espacio del arreglo es 1 menos ue la opcion del usuario

        System.out.println("\tSeleccione la cancion que desea agregar");
        for (int i = 0; i < m.getnSongs().length; i++) {
            if(m.getnSongs()[i] != null){
                System.out.println((i + 1) + ". " + m.getnSongs()[i].getTitle());
            }
        }
        int song = cs.nextInt()-1;//-1 por que el espacio del arreglo es 1 menos ue la opcion del usuario
        
        
        
        if (m.getPlayLists()[numplayList] instanceof PrivatePL) {

            m.addSongPrivate(numplayList, song);

        } else if (m.getPlayLists()[numplayList] instanceof RetrictedPL) {

            m.addSongRestricted(numplayList, song);

        } else if(m.getPlayLists()[numplayList] instanceof PublicPL){

            m.addSongPublic(numplayList, song);

        }
        
        m.updatePlayList();
    }
    
    public void showPlayList() {

        System.out.println(m.showPlayList());

    }
        public void showPoolSongs() {

        System.out.println(m.infoSongs());

    }
    
    public void InfoUser() {

        System.out.println(m.infoUser());

    }
    public void startProgram() {
        int aux = 0;
        int cont = 0;

        Logo();
        while (aux > -1 && aux <= 13 ) {
            System.out.println("-----------------------------------------------");
            System.out.print("\tMENU  DE OPCIONES\n"
                    +"1. Registrar usuario.\n" 
                    + " |____2. Iniciar sesion.\n" 
                    + "3. Mostrar todos los usarios.\n"
                    + "4. Agregar cancion al pool.\n" 
                    + "5. Mostrar todas las canciones.\n" 
                    + "6. Agregar nueva playList publica.\n"
                    + " |____7. Calificar playList publica.\n" 
                    + "8. Agregar nueva playList privada.\n" 
                    + "9. Agregar nueva playList retringida.\n"
                    + " |____10. Agregar acceso de usuario a playList restringida.\n" 
                    + "11. Agregar cancion a un playList.\n"
                    + "12. Información de las playList.\n" 
                    + "Salir del menu: Ecribe un numero distinto a los de lista\n\n"
                    + "Opcion: ");

            aux = cs.nextInt();
            switch (aux) {
                case 1:
                    addUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    InfoUser();
                    break;
                case 4:
                    addPoolSong();
                    break;
                case 5:
                    showPoolSongs();
                    break;
                case 6:
                    addPublicPL();
                    break;
                case 7:
                    addCalificationPL();
                    break;
                case 8:
                    addPrivatePL();
                    break;
                case 9:
                    addRetrictedPL();
                    break;
                case 10:
                    addAccess();
                    break;
                case 11:
                    addPlayListSong();
                    break;
                case 12:
                    showPlayList();
                    break;
            }
        }
    }
}