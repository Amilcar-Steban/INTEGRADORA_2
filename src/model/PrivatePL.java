
package model;

public class PrivatePL extends PlayList{
    private User access;
    
    public PrivatePL(String name, User access){
        super(name);
        this.access = access;
    }

    public User getAccess() {
        return access;
    }

    public void setAccess(User access) {
        this.access = access;
    }
    public PrivatePL(String name, int hours, int minutes, int seconds) {
        super(name);
    }
    
    public String addSong(Song song, User access){
        String msg = "";
        if(this.access.equals(access)){
            addAllSong(song);
            msg = "*Cancion agregada";
            msg += "\n------------------";
        } else {
            msg = "No tienes acceso a este PlayList ";
            msg += "\n---------------------------";
        }
        
        return msg;
    }
    
    @Override
    public String infoPlayList() {
        
        String  infoPL = "**************  Playlist **************";
                infoPL += "\n**  Title: " + getName();
                infoPL += "\n**  Duration: " + getDuration();
                infoPL += "\n**  Usuario con acceso: " + getAccess().getName() + "\n";
                
        return infoPL;
        }
}