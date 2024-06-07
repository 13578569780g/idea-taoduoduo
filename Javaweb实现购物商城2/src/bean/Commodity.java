package bean;

public class Commodity {

    private int id;
    private String name;
    private String price;
    private String introduce;
    private String img;

    public Commodity(){

    }

    public Commodity(int id, String name, String price, String introduce,String img) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.introduce=introduce;
        this.img = img;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", introduce='" + introduce + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
