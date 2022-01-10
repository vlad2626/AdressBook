/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressbook;

/**
 *
 * @author valmi
 */
public class People {
    protected String name,nickname, gender;
    protected String phone;

    public People(String name, String nickname, String gender,String phone) {
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.phone = phone;
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String  phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nContact" + "\nName=" + name + "\nNickname=" + nickname + "\nGender=" + gender + "\nphone=" + phone;
    }
    
    public String writeFile()
    {
        return name+" "+nickname+" "+phone+" "+gender;
    }

    
    
    
    
   
}
