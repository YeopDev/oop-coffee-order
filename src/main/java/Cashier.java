import java.awt.*;

public class Cashier {
    // 점원의 역할 : 주문을 받음
    // 점원의 책임 : 바리스타에게 메뉴를 전달

    private Coffee coffee; //바리스타에게 전달받은 커피
    private MenuItem menuItem;

    Cashier(MenuItem menuItem){
        this.menuItem = menuItem;
    }

    // 바리스타한테 주문 전달
    public String receive(MenuItem menuItem){
        return menuItem.getMenuName();
    }

    public Coffee receiveCoffee(Coffee coffee){
        return coffee;
    }

}
