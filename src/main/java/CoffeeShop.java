import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        MenuItem americano = new MenuItem("아메리카노",1500);
        MenuItem latta = new MenuItem("라떼",2000);
        MenuItem banilaLatta = new MenuItem("바닐라라떼",3000);

        Customer customer = new Customer(10000); //소지금 1만원
        System.out.println(" 손님이 메뉴를 주문합니다.");

        Cashier cashier = new Cashier(List.of(
                new MenuItem("아메리카노", 1_500),
                new MenuItem("라떼", 2_000),
                new MenuItem("바닐라라떼", 3_000)
        ), new Barista());

        String menuName = sc.next();
        cashier.buy(customer, menuName);

        System.out.println(" 손님의 소지금: " + customer.getMoney() + "원 남았습니다.");
        if (customer.hasCoffee()) {
            System.out.println("커피를 받았습니다.");
        }

        // 1. 손님이 메뉴를 주문한다.
        // 2. 캐시어가 주문을 받는다.
        // 3. 캐시어가 주문을 바리스타에게 넘긴다.
        // 4. 바리스타가 커피를 만든다.
        // 5. 바리스타가 커피를 캐시어에게 넘긴다.
        // 6. 캐시어가 손님에게 커피를 준다.

    }
}
