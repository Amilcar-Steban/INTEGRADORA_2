
package model;

public abstract class PlayList {
    private String name;
    private Song[] songsPL;
    private String genre;
    private String duration;
    private int hours;
    private int minutes;
    private int seconds;

    public PlayList(String name) {
        this.name = name;
        this.songsPL = new Song[10];
        this.genre = "N/A";
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void UpdatePLayList(){   
        Song s = null;final int MAX_GENDERS = 6;final int MAX_TIME =60;
            
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String[] totalGenders = new String[MAX_GENDERS];
        String genders = "";
        int aux = 0;
        
        
        for(int i = 0; i < songsPL.length; i++){

            minutes  += s.getMinutes();
            seconds += s.getSeconds();
        }

        while(seconds >= MAX_TIME){
            minutes++;
            seconds -= MAX_TIME;
        }

        while(minutes >= MAX_TIME){
           hours++;
           minutes -=MAX_TIME;
        }
        duration = hours + ":" + minutes + ":" +seconds;

            if(songsPL != null){

                for(int i = 0; i < songsPL.length; i++){
                
                    for(int j = 0; j < totalGenders.length; j++){
                        if(songsPL[i].getGenre().equals(totalGenders[j])){
                        aux++;
                    }
                }
                
                if(aux == 0){
                    for(int j = 0; j < totalGenders.length; j++){
                        if(totalGenders[j] == null){
                            totalGenders[j] = songsPL[i].getGenre();
                            j = totalGenders.length;
                        }
                    }
                }
            }
            
            for(int i = 0; i < totalGenders.length; i++){
                if(totalGenders[i] != null){
                    genders += totalGenders[i] + "\n  * ";
                }
            }
            }
            else{
                this.genre = genre.substring(0,genre.length() - 2);
            }
    }
    
    public void addAllSong(Song song){
        for (int i = 0; i < songsPL.length; i++) {
            if(songsPL[i] != null){
                songsPL[i] = song;
                i = songsPL.length;
            }
        }
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Song[] getSongsPL() {
        return songsPL;
    }

    public void setSongsPL(Song[] songsPL) {
        this.songsPL = songsPL;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getHours(){
        return hours;
    }

    public void setHours(int hours) {
        this.hours += hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes += minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds += seconds;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract String infoPlayList();

}
