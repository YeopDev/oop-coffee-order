

public class CoffeeShop {
    public static void main(String[] args) {
        MenuItem americano = new MenuItem("아메리카노",1500);
        MenuItem latta = new MenuItem("라떼",2000);
        MenuItem banilaLatta = new MenuItem("바닐라라떼",3000);

        Customer customer = new Customer(10000); //소지금 1만원
        System.out.println(" 손님이 메뉴를 주문합니다.");
        int money = customer.menuOrder(americano); // 소지금에서 메뉴 금액만큼 빠짐.
        System.out.println(" 손님의 지갑사정: "+ money + "원 남았습니다.");
        Cashier cashier = new Cashier(); // 아메리카노 주문.
        Coffee coffee = cashier.receive(americano); //바리스타에게 주문정보 전달
        boolean catched = customer.success(coffee);
        if(catched){
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
