import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Customer customer = new Customer(10_000);
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
    }
}
