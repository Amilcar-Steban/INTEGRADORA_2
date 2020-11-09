
package model;

public class MCS {
    private final static int MAX_USERS = 10; 
    private final static int MAX_SONGS = 30;
    private final static int MAX_PLAYLIST = 20;
    private User[] nUsers;
    private Song[] nSongs;
    private PlayList[] playLists;
    private int access;

    public MCS() {
        this.nUsers = new User[MAX_USERS];
        this.nSongs = new Song[MAX_SONGS];
        this.playLists = new PlayList[MAX_PLAYLIST];
        access = -1;
    }
    
    //Añadir usuario
    public String addUser(String name_, String password, byte age){
        User userx = new User(name_, password, age);
        String msg = "";
        
        for (int i = 0; i < nUsers.length; i++) {
            if(nUsers[i] == null){
                nUsers[i] = userx;
               
                msg = " \nUsuario registrado de manera exitosa.";
                i = nUsers.length;
            }
            else{
                msg = " \nNo se ha podido realizar el registro, Usuarios llenos";
                msg +="---------------------------------------------------------";
            }
        }
        return msg;
    }

    public String infoUser(){
        String infoUser = "";
        for (int i = 0; i < nUsers.length; i++) {
            if(nUsers[i] != null){
                infoUser += "*************  User **************\n"; 
                infoUser += "**  UserName: " + nUsers[i].getName() + "\n";
                infoUser += "**  Age: " + nUsers[i].getAge() + "\n";
                infoUser += "**  Category: " + nUsers[i].getCate_() + "\n";
                infoUser += "***********************************\n\n";
            }
        }
        return infoUser;
    }
    
    public String addSong(String title, String nameArtist, String releaseDate, String duration, int num){
        Song newSong= new Song(title, nameArtist, releaseDate, duration, num);
        String successfull =  "";
        if(access >= 0 ){
            for (int i = 0; i < nSongs.length; i++) {
                if(nSongs[i] == null){
                    nSongs[i] = newSong;
                    nUsers[access].increaseShareSongs(1);
                    nUsers[access].modifyCategory();
                    i = nSongs.length;
                    successfull = " \n\nCancion añadida de manera exitosa";
                    successfull += "\n------------------------------------"; 
            }
        }
        }
        else {
            System.out.println("Debes iniciar sesion primero");
        }
        return successfull;
    }
    

    public String infoSongs(){
        String infoSongs = "";
        Song s = null;
        for (int i = 0; i < nUsers.length; i++) {
            if(nSongs[i] != null){
                infoSongs +=  "**************  Song **************\n";
                infoSongs += "**  Title: " + nSongs[i].getTitle() + "\n";
                infoSongs += "**  Artist: " + nSongs[i].getNameArtist() + "\n";
                infoSongs += "**  Duration: " + nSongs[i].getDuration();
                infoSongs += "**  Genre: " + nSongs[i].getGenre() + "\n";
                infoSongs += "***********************************\n\n";
            }
        }
        return infoSongs;
    }
    
    public String loginU(String name, String password){
        String login = "";
        
        for(int i = 0; i < nUsers.length; i++){
            if(nUsers[i] != null){
                if(nUsers[i].getName().equals(name) && nUsers[i].getPassword().equals(password)){
                    setAccess(i);
                    login = "\nBIENVENIDO " +nUsers[i].getName()+" \n";
                    login += "-----------------------------------------------------";
                    break;
                } else {
                    login = "\n  Registrate primero"+" \n";
                    login += "-----------------------------------------------------";
                }
            }
        }
        return login;
    }    
    public String addPrivatePL(String name){
        String msg = "";
        if(access > -1){
            PlayList newPL = new PrivatePL(name, nUsers[access]);
            
            for(int i = 0; i < playLists.length; i++){

                if(playLists[i] == null){
                    
                    playLists[i] = newPL;

                    msg = "\nSe ha creado correctamente.";
                    break;
                } else {
                    msg = "\nlimite alcanzado de PlayList.";
                }
            }
        }
        
        return msg;
    }
    public String addRestrictedPL(String name){  //Añadir playList restringida
        String addTrue = "Debes logearte primero.";
        
        if(access > -1){
            PlayList newPL = new RetrictedPL(name, nUsers[access]);
            
            for(int i = 0; i < playLists.length; i++){

                if(playLists[i] == null){
                    playLists[i] = newPL;

                    addTrue = "\n5 usuarios disponibles";
                    break;
                } else {
                    addTrue = "\nlimite alcanzado de PlayList alcanzado";
                }
            }
        }
            
        return addTrue;
    }
        //
        
    public String addPublicPL(String name){
        String msg = "";
        PublicPL newPL = new PublicPL(name) {
        };
        for(int i = 0; i < playLists.length; i++){
            if(playLists[i] == null){
                playLists[i] =  newPL;
                msg = "\nSe ha creado correctamente.";
                i = playLists.length;
            }else {
                msg = "\nlimite alcanzado de PlayList.";
            }
        } 
        
        return msg;
    }
    
    public String addqualification_PL(int playList, float qualification){

        PublicPL qualification_;
        
        qualification_= (PublicPL) playLists[playList];
        
        String msg = qualification_.average(qualification);

        return msg;
    }

    public String addSongPrivate(int playList, int song){

        String msg;
            PrivatePL privatePL;
            privatePL = (PrivatePL)playLists[playList];
            msg = privatePL.addSong(nSongs[song], nUsers[access]);

        return msg;
    }
    
    public String addSongRestricted(int playList, int song){
        RetrictedPL retrictedPL;
        retrictedPL = (RetrictedPL) playLists[playList];
        String msg = retrictedPL.addSong(nSongs[song], nUsers[access]);
        return msg;
    }
    
    public String addSongPublic(int playList, int song){
        String msg = "";

        PublicPL publicPL;  
        publicPL = (PublicPL) playLists[playList];
         msg = publicPL.addSong(nSongs[song]);
        return msg;

    }

    public String showPlayList(){
        String InfoPL = "";

        for(int i = 0; i < playLists.length; i++){
            if(playLists[i] != null){
                InfoPL += playLists[i].infoPlayList();
            }
        }

        return InfoPL;
    }

    public String addAccess(int restrictedPL, int userAccess){

        RetrictedPL addAccess;
        addAccess = (RetrictedPL)playLists[restrictedPL];
        String user_ = addAccess.addUserAccess(nUsers[userAccess]);

        return user_;
    }

    //Getters y Setters

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
    

    public User[] getnUsers() {
        return nUsers;
    }

    public void setnUsers(User[] nUsers) {
        this.nUsers = nUsers;
    }

    public Song[] getnSongs() {
        return nSongs;
    }

    public void setnSongs(Song[] nSongs) {
        this.nSongs = nSongs;
    }

    public PlayList[] getPlayLists() {
        return playLists;
    }

    public void setPlayLists(PlayList[] playLists) {
        this.playLists = playLists;
    }
    
    public String updatePlayList(){
        
        for(int i = 0; i < playLists.length; i++){
        
            if(playLists[i] != null){
                playLists[i].upDatePLayList();
            }
        }
        String Update = "Se agrego correctamente";

        return Update; 
    }

} 