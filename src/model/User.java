
package model;

public class User {
    private String name;
    private String password;
    private byte age;
    private int shareSongs;
    private String cate_;
    
    public User(String name, String password, byte age) {
        this.name = name;
        this.password = password;
        this.age = age;
        cate_ = "NEWBIE";
        shareSongs = 0;
        
    }

    public void modifyCategory(){
        String aux = "";
        
        if(shareSongs < 3){
            aux = String.valueOf(Category.NEWBIE);
        }
        else if(shareSongs < 10){
            aux = String.valueOf(Category.LITTLE_CONTRIBUTOR);
        }
        else if(shareSongs < 30){
            aux = String.valueOf(Category.STAR_CONTRIBUTOR);
        }
        cate_ = aux;
    }
    
    public void increaseShareSongs(int add){
        shareSongs += add; 
    }
    
    //Getters y Setters
    
    
    public String getCate_() {
        return cate_;
    }

    public void setCate_(String cate_) {
        this.cate_ = cate_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public int getShareSongs() {
        return shareSongs;
    }

    public void setShareSongs(int shareSongs) {
        this.shareSongs = shareSongs;
    }

}