package bean;

public class Car {

    private int id;
    private String name;
    private String price;
    private String introduce;
    private String img;
    private String amount;

    public Car(){

    }

    public Car(int id, String name, String price, String introduce,String img,String amount) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.introduce=introduce;
        this.img = img;
        this.amount=amount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", introduce='" + introduce + '\'' +
                ", img='" + img + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
