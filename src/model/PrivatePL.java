
package model;

public class PrivatePL extends PlayList{
    private User access;
    
    public PrivatePL(String name, User userAccess){
        super(name);
        this.access = userAccess;
    }

    public User getUserAccess() {
        return access;
    }

    public void setUserAccess(User userAccess) {
        this.access = userAccess;
    }
    public PrivatePL(String name, int hours, int minutes, int seconds) {
        super(name);
    }
    
    public String addSong(Song song, User userAccess){
        String msg = "";
        if(this.access.equals(access)){
            addAllSong(song);
            msg = "*Cancion agregada";
            msg += "\n------------------";
        } else {
            msg = "El usuario no tiene acceso ";
            msg += "\n--------------------------------------------------------";
        }
        
        return msg;
    }
    
    @Override
    public String infoPlayList() {
        
        String  infoPL = "**************  Playlist **************";
                infoPL += "\n**  Title: " + getName();
                infoPL += "\n**  Duration: " + getDuration();
                infoPL += "\n**  Usuario con acceso: " + getUserAccess().getName() + "\n";
                
        return infoPL;
        }
}
