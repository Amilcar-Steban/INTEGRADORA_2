
package model;

public class RetrictedPL extends PlayList{

    public RetrictedPL(String name) {
        super(name);
    }
    
    
    
    @Override
    public String infoPlayList() {
        String  infoPL = "**************  Playlist **************";
                infoPL += "\n**  Title: " + getName() + "\n";
                infoPL += "\n**  Duration: " + getDuration() + "\n";
                infoPL += "\n**  Genre: " + getGenre() + "\n";
                infoPL += "\n**  Usuarios con acceso: " + updateAccess() + "\n\n";
        
        return infoPL;
    }
    
}
