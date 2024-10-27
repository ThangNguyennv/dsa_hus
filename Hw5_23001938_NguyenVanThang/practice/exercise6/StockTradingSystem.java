package Hw5_23001938_NguyenVanThang.practice.exercise6;

import Hw5_23001938_NguyenVanThang.exercise.exercise2.MinHeapPriorityQueue;

public class StockTradingSystem {

    private MinHeapPriorityQueue<Integer, Order> buyOrders;
    private MinHeapPriorityQueue<Integer, Order> sellOrders;

    public StockTradingSystem() {
        buyOrders = new MinHeapPriorityQueue<>();
        sellOrders = new MinHeapPriorityQueue<>();
    }

    public void placeOrder(String type, int quantity, int price) {
        Order order = new Order(type, quantity, price);
        if (type.equalsIgnoreCase("buy")) {
            buyOrders.insert(price, order);
            processOrders();
        } else if (type.equalsIgnoreCase("sell")) {
            sellOrders.insert(price, order);
            processOrders();
        }
    }

    private void processOrders() {
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            if (buyOrders.min() != null && sellOrders.min() != null) {
                Order buyOrder = buyOrders.min().getValue();
                Order sellOrder = sellOrders.min().getValue();
                if (buyOrder.price >= sellOrder.price) {
                    if (buyOrder.quantity > 0 && sellOrder.quantity > 0) {
                        int quantityToTrade = Math.min(buyOrder.quantity, sellOrder.quantity);
                        System.out.println("[số lượng cổ phiếu giao dịch: " +
                                quantityToTrade + ", giá bán: " +
                                sellOrder.price + " $]");
                        buyOrder.quantity -= quantityToTrade;
                        sellOrder.quantity -= quantityToTrade;
                    }
                    if (buyOrder.quantity == 0) {
                        buyOrders.removeMin();
                    }
                    if (sellOrder.quantity == 0) {
                        sellOrders.removeMin();
                    }
            }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        StockTradingSystem s = new StockTradingSystem();
        s.placeOrder("buy", 100, 50);
        s.placeOrder("sell", 50, 45);
        s.placeOrder("sell", 100, 55);
        s.placeOrder("buy", 100, 60);
        s.placeOrder("sell", 100, 50);
    }
}
