import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


class CustomerTest {

    // -> 1. 생성 테스트
    // -> 2. 유효성 검사
    // -> 3. method
    // -> e.g ) 행위만 있는 경우 인터페이스화
    // -> e.g ) 필드만 있는 경우 데이터 클래스화 ( record, final )

    // git convention ->
    // 행위 ( 도메인 ) : 설명
    // eg ) feature ( coffee) : 생성 유효성 검사 추가

    @ParameterizedTest
    @ValueSource(
            ints = {10000}
    )
    @DisplayName("손님이 올바른 소지금을 전달받았을 경우")
    void customerConstructorNoThrownBy(int money){
        Customer customer = new Customer(money);
        Assertions.assertThat(customer.getMoney()).isEqualTo(money);
    }

    @ParameterizedTest
    @ValueSource(
            ints = {10000}
    )
    @DisplayName("손님이 올바르지 않은 소지금을 전달받았을 경우")
    void customerConstructorThrownBy(int money){
        Assertions.assertThatThrownBy(
                () -> {
                  Customer customer = new Customer(money);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    //payment
    //deliver

    @ParameterizedTest
    @CsvSource(
            value = {"1500","2000","3000"}
    )
    @DisplayName("손님의 소지금으로 주문결제를 올바르게 하지 못했을 경우.")
    void customerPaymentsNoThrownBy(Integer value){
        Customer customer = new Customer(10000);
        customer.payment(value);
        Assertions.assertThat(customer.getMoney()).isNotEqualTo(10000);
    }

    @ParameterizedTest
    @CsvSource(
            value = {"1500","2000","3000"}
    )
    @DisplayName("손님의 소지금으로 주문결제를 올바르게 했을 경우")
    void customerPaymentsThrownBy(Integer value){
        Assertions.assertThatThrownBy(
                () ->{
                    Customer customer = new Customer(10000);
                    customer.payment(value);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(
            strings = {"아메리카노"}
    )
    @DisplayName("손님이 주문한 커피를 받았다.")
    void customerDeliverNoThrownBy(String menuName){
        Customer customer = new Customer(10000);
        Cashier cashier = new Cashier(List.of(
                new MenuItem("아메리카노", 1_500),
                new MenuItem("라떼", 2_000),
                new MenuItem("바닐라라떼", 3_000)
        ), new Barista());
        cashier.buy(customer, menuName);
        Assertions.assertThat(customer.hasCoffee()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(
            strings = {"아메리카노"}
    )
    @DisplayName("손님이 주문하지 않은 커피를 받았다.")
    void customerDeliverThrownBy(String menuName){
        Assertions.assertThatThrownBy(
                () -> {
                    Customer customer = new Customer(10000);
                    Cashier cashier = new Cashier(List.of(
                            new MenuItem("아메리카노",1_500),
                            new MenuItem("라떼",2_000),
                            new MenuItem("바닐라라떼",3_000)
                    ),new Barista());
                    cashier.buy(customer, menuName);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}