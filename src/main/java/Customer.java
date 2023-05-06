public class Customer {

//    고객의 역할 : 주문을 할 수 있다.
    private int money;
    private MenuItem menuItem;

    Customer(int money){
        this.money = money;
    }

    //고객이 커피를 주문했다.
    public int menuOrder(MenuItem menuItem){
        this.menuItem = menuItem;
        this.money -= menuItem.getPrice();
        return money;
    }

    // 고객이 주문한 커피를 받았다.
    public boolean success(Coffee coffee){
        return this.menuItem.getMenuName().equals(coffee.getMenuName());
    }
}
