
package model;

public class Song {
    private String releaseDate;
    private String title;
    private String nameArtist;
    private String genre;
    private int minutes;
    private int seconds;

    public Song(String title, String nameArtist, String releaseDate, int minutes, int seconds, int num){
        this.releaseDate = releaseDate;
        this.title = title;
        this.nameArtist = nameArtist;
        this.minutes = minutes;
        this.seconds = seconds;
        genre = String.valueOf(Genre.values()[num-1]);
    }
    
    public Song(){
        minutes = 0;
        seconds = 0;
    }
    
    public void convertDuration(int minutes, int seoconds){
        while(seconds >= 60){
            minutes++;
            seconds-= 60;
        }
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }
    
    public String infoCancion(){
        String infoPool;
        
        infoPool = "----------------------------------------------";
        infoPool+= "\n\tINFORMACION DE CANCIÓN";
        infoPool+= "\n-----------------------------------------------";
        infoPool+= "\n*Titulo: "+getTitle();
        infoPool+= "\n*Artista: "+getNameArtist();
        infoPool+= "\n*Duración: "+getMinutes()+":"+getSeconds();
        infoPool+= "\n*Genero: "+getGenre();
        
        return infoPool;
    }
}
