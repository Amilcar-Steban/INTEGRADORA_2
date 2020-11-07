
package model;

public abstract class PublicPL extends PlayList{

    private float qualifications;
    private float qualifications_;
    private float average;
    
    public PublicPL(String name) {
        super(name);
        qualifications = 0;
        qualifications_ = 0;
        average = 0;
        
    }

    public float getQualifications() {
        return qualifications;
    }

    public void setQualifications(float qualifications) {
        this.qualifications = qualifications;
    }

    public float getQualifications_() {
        return qualifications_;
    }

    public void setQualifications_(float qualifications_) {
        this.qualifications_ = qualifications_;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
    
    public String average(float calification){
        String msg = "";
        
        qualifications_ +=calification;
        qualifications++;
        
            if(qualifications != 0){
                average = qualifications_ /qualifications;
                msg = "Gracias por calificar el PayList: " + getName() + ".";
            }
        return msg;
    }
    
    public String addSong(Song song){
        String msg = "";
        addAllSong(song);
        msg = "Cancion agregada\n";
        msg += "\n------------------";
        
        return msg;
    }
    
    @Override
    public String infoPlayList() {
        String  infoPL = "**************  Playlist **************";
                infoPL += "\n**  Title: " + getName();
                infoPL += "\n**  Duration: " + getDuration();
                infoPL += "\n**  Genre: " + getGenre();
                infoPL += "\n**  Calification: " + getAverage() + "\n\n";
        return infoPL;
    }
    
}
