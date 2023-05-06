import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    @DisplayName("주문하기")
    public void 손님이_주문후_소지금검사(){
        MenuItem americano = new MenuItem("아메리카노",1500);
        Customer customer = new Customer(10000); //소지금 1만원
        int money = customer.menuOrder(americano); // 소지금에서 메뉴 금액만큼 빠짐

        Assertions.assertThat(money).isEqualTo(8500);
    }

}