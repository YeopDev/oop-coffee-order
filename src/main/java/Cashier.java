import java.awt.*;

public class Cashier {
    // 점원의 역할 : 주문을 받음
    // 점원의 책임 : 바리스타에게 메뉴를 전달
    private final List<MenuItem> menuItems; // 점원은 메뉴를 전부 알아야함.
    private final Barista barista;

    public Cashier(List<MenuItem> menuItems, Barista barista) {
        this.menuItems = menuItems;
        this.barista = barista;
    }

    public void buy(Customer customer, String menuName) {
        MenuItem orderMenuItem = menuItem(menuName);

        customer.payment(orderMenuItem.getPrice());

        Coffee coffee = barista.menuReceive(orderMenuItem.getMenuName());
        customer.deliver(coffee);
    }

    private MenuItem menuItem(String menuName) {
        return menuItems.stream()
                .filter(item -> item.getMenuName().equals(menuName))
                .findFirst()
                .orElseThrow();
    }
}
