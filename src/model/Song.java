
package model;

public class Song {
    
    private String title;    
    private String releaseDate;
    private String nameArtist;
    private String genre;
    private String duration;

    public Song(String title, String nameArtist, String releaseDate, String duration, int num){
        this.releaseDate = releaseDate;
        this.title = title;
        this.nameArtist = nameArtist;
        this.duration = duration;
        genre = String.valueOf(Genre.values()[num]);

        
    }
   
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
   
}
