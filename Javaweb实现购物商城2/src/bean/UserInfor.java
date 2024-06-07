package bean;


import java.io.Serializable;

public class UserInfor implements Serializable {


    @Override
    public String toString() {
        return "UserInfor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", imgs='" + imgs + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public UserInfor(int id, String name, String pwd, String imgs, String phone, String address) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.imgs = imgs;
        this.phone = phone;
        this.address = address;
    }

    private int id;
    private String name;
    private String pwd;
    private String imgs;
    private String phone;
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String relname) {
        this.imgs = imgs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }




}
