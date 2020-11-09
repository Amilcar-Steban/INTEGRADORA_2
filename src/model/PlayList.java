
package model;
import java.util.ArrayList;

public abstract class PlayList {
    private String name;
    private String genre;
    private String duration;
    private ArrayList<Song> songsPL;

    public PlayList(String name) {
        this.name = name;
        genre = "";
        duration  = "";
        songsPL = new ArrayList<Song>();
    }
    
    public void upDatePLayList(){
        final int MAX = 6;
        String[] Genres_ = new String[MAX];
        String genres = "";
        int aux = 0;
        int s = 00;
        int m = 00;
        int h = 00;
        
        for(int i = 0; i < songsPL.size(); i++){

            m  += Integer.parseInt(songsPL.get(i).getDuration().substring(0, 2));
            s += Integer.parseInt(songsPL.get(i).getDuration().substring(3,5));
            

        }
        while(s >= 60){
            m++;
            s -= 60;
        }

        while(m >= 60){
           h++;
           m -=60;
        }        

        duration = String.valueOf(h) + ":" + String.valueOf(m) + ":" + String.valueOf(s);

        if(songsPL == null || songsPL.isEmpty()){
            
        }else{
            for(int i = 0; i < songsPL.size(); i++){
                
                for(int o = 0; o < Genres_.length; o++){
                    if(songsPL.get(i).getGenre().equals(Genres_[o])){
                      aux++;
                    }
                }
                
                if(aux == 0){
                    for(int o = 0; o < Genres_.length; o++){
                        if(Genres_[o] == null){
                            Genres_[o] = songsPL.get(i).getGenre();
                            o = Genres_.length;
                        }
                    }
                }
            }
            
            for(int i = 0; i < Genres_.length; i++){
                if(Genres_[i] != null){
                    genres += "*"+Genres_[i] + "\n           ";
                }
            }
            
            genre = genres.substring(0, genres.length());
        }

    }

    public void addAllSong(Song song){
        songsPL.add(song);
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<Song> getSongsPL() {
        return songsPL;
    }

    public void setSongsPL(ArrayList<Song> songsPL) {
        this.songsPL = songsPL;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract String infoPlayList();

}
