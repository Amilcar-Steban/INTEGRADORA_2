
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
    public String addUser(String name, String password, byte age){
        User user = new User(name, password, age);
        String msg= "";
        
        for (int i = 0; i < nSongs.length; i++) {
            if(nUsers[i] == null){
                nUsers[i] = user;
                msg = "Usuario registrado de manera exitosa.";
                msg +="---------------------------------------";
                i = nUsers.length;
            }
            else{
                msg = "No se ha podido realizar el registro, Usuarios llenos";
                msg +="---------------------------------------------------------";
            }
        }
        return msg;
    }
    
    public String infoUser(){
        String infoAllUsers = "";
        User u = null;
        for (int i = 0; i < nUsers.length; i++) {
            if (nUsers[i] != null){
                infoAllUsers = u.infoUser();
            }
        }
        return infoAllUsers;
    }
    
    public String addSong(String title, String nameArtist, String releaseDate, int minutes, int seconds, int num){
        Song newSong= new Song(title, nameArtist, releaseDate, minutes, seconds, num);
        String successfull =  "";
        
        for (int i = 0; i < nSongs.length; i++) {
            if(nSongs[i] == null){
                nSongs[i] = newSong;
                nUsers[access].increaseShareSongs();
                nUsers[access].modifyCategory();
                i = nSongs.length;
                successfull = "Cancion añadida de manera exitosa";
                successfull += "\n------------------------------------"; 
            }
        }
        return successfull;
    }
    

    public String infoSongs(){
        String infoSongs = "";
        Song s = null;
        for (int i = 0; i < nUsers.length; i++) {
            if (nUsers[i] != null){
                infoSongs = s.infoCancion();
            }
        }
        return infoSongs;
    }
    
    public String login(String name, String password){
        String msg = "";
        
        for(int i = 0; i < nUsers.length; i++){
            if(nUsers[i] != null){
                if(nUsers[i].getName().equals(name) && nUsers[i].getPassword().equals(password)){
                    setAccess(i);
                    msg = "\nBIENVENIDO" +nUsers[i].getName();
                    msg += "\n-----------------------------------------------------";
                    i = nUsers.length;
                } else {
                    msg = "\n\n  Registrate primero";
                    msg += "\n-----------------------------------------------------";
                }
            }
        }
        return msg;
    }    
        public String addPrivatePL(String name){
        String msg = "";
        if(access > -1){
            PlayList newPL = new PrivatePL(name, nUsers[access]);
            
            for(int i = 0; i < playLists.length; i++){

                if(playLists[i] == null){
                    
                    playLists[i] = newPL;

                    msg = "\n\nSe ha creado correctamente.";
                    break;
                } else {
                    msg = "\n\nlimite alcanzado de PlayList.";
                }
            }
        }
        
        return msg;
    }
    
        //
        
    public String addPublicPL(String name){
        String msg = "";
        PublicPL newPL = new PublicPL(name) {
        };
        for(int i = 0; i < playLists.length; i++){
            if(playLists[i] == null){
                playLists[i] =  newPL;
                msg = "\n\nSe ha creado correctamente.";
                i = playLists.length;
            }else {
                msg = "\n\nlimite alcanzado de PlayList.";
            }
        } 
        
        return msg;
    }
    
    public String addCalificationPL(int playList, float calification){
        
        
        PublicPL qualification_;
        
        qualification_= (PublicPL) playLists[playList];
        
        qualification_.average(calification);
        
        String msg = "Gracias por calificar";
                
        return msg;
    }
    
    public String addSongPrivate(int playList, int song){
    
        String addTrue;
        
            PrivatePL privatePL;
            privatePL = (PrivatePL)playLists[playList];
            addTrue = privatePL.addSong(nSongs[song], nUsers[access]);
                
        return addTrue;
    }
    
    public String addSongRestricted(int playList, int song){
        RetrictedPL retrictedPL;
        retrictedPL = (RetrictedPL) playLists[playList];
        String msg = retrictedPL.addSong(nSongs[song], nUsers[access]);
        return msg;
    }
    
    public String addSongPublic(int playList, int song){
        String addTrue;
        PublicPL publicPL = (PublicPL) playLists[playList];
        addTrue = publicPL.addSong(nSongs[song]);
        
        return addTrue;
    }
    
    public String showPlayList(){
        String allInfo = "";
    
        for(int i = 0; i < playLists.length; i++){
            if(playLists[i] != null){
                allInfo += playLists[i].showInformation();
            }
        }
        
        return allInfo;
    }
    
    
    public void UpdatePlayList(){
        
        for(int i = 0; i < playLists.length; i++){
        
            if(playLists[i] != null){
                playLists[i].UpdatePLayList();
            }
        }
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
    
}
