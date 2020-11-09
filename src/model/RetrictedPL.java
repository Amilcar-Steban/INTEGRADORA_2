
package model;

public class RetrictedPL extends PlayList{
    private final static int ACCESS_USERS = 5;
    private User[] access;
    
    public RetrictedPL(String name, User access) {
        super(name);
        this.access = new User[ACCESS_USERS];
        this.access[0] = access;
    }

    public User[] getAccess() {
        return access;
    }

    public void setAccess(User[] access) {
        this.access = access;
    }
    
    public String addUserAccess(User access){
        String msg = "";
        int aux = 0;
        
        for(int i = 0; i < ACCESS_USERS; i++){
        
            if(this.access[i] == null){
                this.access[i] = access;
                for(int j = 0; j < ACCESS_USERS; j++){
                    if(this.access[j] == null){
                        aux++;
                        msg = "'\n\n---------------------------------------------------------------------------";
                        msg += "\n "+ this.access[i].getName() + "Ahora tiene acceso a la PlayList Restringida. \n quedan " + (5-aux) + " cupos disponibles";
                        j = ACCESS_USERS;
                    } else {
                        msg ="\n\n-------------------------------------------------------------------------";
                        msg += "\n"+ this.access[i].getName() + "Ahora tiene acceso a la PlayList restringida";
                    }
                }
                i = ACCESS_USERS;
            }else{
                msg = "\n\n -----------------------------------------------------";
                msg += "\nNo hay espacio disponible para otro usuario mas :c";
                
            }
        }
        return msg;
    }
    
    public String addSong(Song song, User access){
        String msg = "";
        
        for(int i = 0; i < ACCESS_USERS; i++){
            if(this.access[i].equals(access)){
                addAllSong(song);
                msg = "Cancion agregada";
                i = ACCESS_USERS;
            } else {
                msg = "No tienes acceso a este PlayList";
            }                                                                         
        }
        
        return msg;
    }
    
    public String updateAccess(){
        String Users_r = "";
        for (int i = 0; i < getAccess().length; i++){
            if(getAccess()[i] != null){
                 Users_r += "*"+getAccess()[i].getName() + "\n* ";
            }
        }
        Users_r = Users_r.substring(0, Users_r.length() - 2);
        return Users_r;
    }
    
    
    @Override
    public String infoPlayList() {
        String  infoPL = "**************  Playlist **************";
                infoPL += "\n**  Title: " + getName();
                infoPL += "\n**  Duration: " + getDuration();
                infoPL += "\n**  Genre: " + getGenre();
                infoPL += "\n**  Usuarios con acceso: " + updateAccess() + "\n\n";
        
        return infoPL;
    }
    
}