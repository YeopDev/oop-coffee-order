import static java.util.Objects.isNull;

public class Customer {

//    고객의 역할 : 주문을 할 수 있다.
    private int money;
    private Coffee coffee;

    Customer(int money){
        this.money = money;
    }

    public int getMoney(){
        return this.money;
    }

    // 결제
    public void payment(int price) {
        if(money < price){
            throw new IllegalArgumentException("소지금보다 주문금액이 초과합니다.");
        }
        money -= price;
    }

    //커피를 받았다.
    public void deliver(Coffee coffee){
        this.coffee = coffee;
    }
}
