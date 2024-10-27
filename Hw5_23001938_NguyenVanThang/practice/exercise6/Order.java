package Hw5_23001938_NguyenVanThang.practice.exercise6;

public class Order {
    String type;
    int quantity;
    int price;

    public Order(String type, int quantity, int price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Loại cổ phiếu: " + type + ", số cổ phiếu: " + quantity + ", giá tiền: " + price + "$";
    }
}
