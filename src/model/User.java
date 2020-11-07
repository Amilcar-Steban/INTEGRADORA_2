
package model;

public class User {
    private final static int MAXIMUM_PL = 5;
    private String name;
    private String password;
    private byte age;
    private int shareSongs;
    private Category cate_;
    
    public User(String name, String password, byte age) {
        this.name = name;
        this.password = password;
        this.age = age;
        shareSongs = 0;
        cate_ = Category.NEWBIE;
    }    
    public User() {
        name = new String();
        password = new String();
        age = 0;
        shareSongs = 0;
        cate_ = Category.NEWBIE;
    }     
    
    
    //modificar la categoria
    public void modifyCategory(){
        if(getShareSongs() == 3){
            cate_ = Category.LITTLE_CONTRIBUTOR;
        }
        else if(getShareSongs() == 10){
            cate_ = Category.MILD_CONTRIBUTOR;
        }
        else if(getShareSongs() == 30){
            cate_ = Category.STAR_CONTRIBUTOR;
        }
    }
    
    public void increaseShareSongs(){
        shareSongs += 1; 
    }
    
    //Getters y Setters
    public String getCate_() {
        return cate_.toString();
    }

    public void setCate_(String cate_) {
        this.cate_ = Category.valueOf(cate_);
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

    public int getAge() {
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

    //Mostrar datos
    public String infoUser(){
        String infoUser;
        
        infoUser = "-------------------------------------------------------";
        infoUser += "\n\tINFORMACION DE USUARIO";
        infoUser+= "\n-----------------------------------------------------";
        infoUser+= "\nNombre: "+getName();
        infoUser+= "\nEdad: "+getAge();
        infoUser+= "\nCategoria: "+getCate_();
    return infoUser;
    }
}
