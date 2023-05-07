import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaristaTest {

    // -> 1. 생성 테스트
    // -> 2. 유효성 검사
    // -> 3. method
    // -> e.g ) 행위만 있는 경우 인터페이스화
    // -> e.g ) 필드만 있는 경우 데이터 클래스화 ( record, final )

    // git convention ->
    // 행위 ( 도메인 ) : 설명
    // eg ) feature ( coffee) : 생성 유효성 검사 추가


    // 생성은 이미 유효성 검사가 되었으니 assertions는 불필요
    @ParameterizedTest
    @ValueSource(
            strings = {"menuName","createCoffee"}
    )
    @DisplayName("바리스타가 메뉴를 올바르게 입력받은 경우")
    void baristaConstructorNoThrownBy(String menuName, CreateCoffee createCoffee){
        Assertions.assertThatThrownBy(
                () -> {
                    new Barista(menuName,createCoffee);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    // 유효성 검사가 실패되는 경우 테스트
    @ParameterizedTest
    @CsvSource({
            "menuName, 아메리카노",
            "createCoffee, 커피를만든다"
    })
    @DisplayName("바리스타가 메뉴를 올바르게 입력받지 못한 경우")
    void baristaConstructorThrownBy(String menuName, CreateCoffee createCoffee){
        Assertions.assertThatThrownBy(
                () -> new Barista(menuName, createCoffee)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    //메서드 검사
    @ParameterizedTest
    @ValueSource(
            strings = {"menuName","createCoffee"}
    )
    @DisplayName("바리스타가 커피를 만든다는 메서드가 올바르게 실행됐을 경우")
    void baristaMethodThrownBy(String menuName, CreateCoffee createCoffee){
        Assertions.assertThatThrownBy(
                () -> {
                    Coffee coffee = new Barista(menuName, createCoffee).execute(menuName);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(
            "menuName, 아메리카노"
    )
    @DisplayName("바리스타가 커피를 만든다는 메서드가 올바르게 실행되지 않았을 경우")
    void baristaMehodNoThrownBy(String menuName, CreateCoffee createCoffee){
        Assertions.assertThatThrownBy(
                () -> {
                    Coffee coffee = new Barista(menuName, createCoffee).execute(menuName);
                    Assertions.assertThat(coffee.getMenuName()).isEqualTo(menuName);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    // 유효성 검사는 생성자에 있으니까 따로안해도댐
    // 에러나면 터진거 안나면 정상인가
    // 터지는 경우는 위에있으니까 안해도댐

    //유효성 검사는 barista 클래스에서 생성자에서 이미 되고 있어서 테스트케이스가 필요 없다는 말씀이신

    //바리스타에 샘플 만들어둿음

/*
    @Test
    @DisplayName("바리스타가 주문을 받았을때")
    void 주문메뉴_만든다() {
        Barista barista = new Barista("아메리카노");
        Coffee coffee = barista.createCoffee();

        Assertions.assertThat(coffee).isEqualTo(barista.createCoffee());
    }


    @ParameterizedTest
    @ValueSource(
            strings = {"test", "test2"}
    )
    @DisplayName("주문을 받았을때 예외가 생기는 경우")
    void throwTest(String input) {
        Assertions.assertThatThrownBy(
                () -> {
                    System.out.println("input = " + input);
                    // action
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void adsf() {
        // given
        final String menuName = "name";
        //when
        Barista barista = new Barista(menuName);
        Coffee coffee = barista.createCoffee();
        //then
        Assertions.assertThat(coffee).isEqualTo("name");
    }

    @Test
    void noThrownBy() {
        // given
        final String menuName = "name";
        Assertions.assertThatCode(() -> {
            Barista barista = new Barista(menuName);
        }).doesNotThrowAnyException();
    }

    @Test
    void thrownBy() {
        // given
        final String menuName = "name";
        Assertions.assertThatThrownBy(() -> {
            Barista barista = new Barista(menuName);
        }).isInstanceOf(IllegalArgumentException.class);
    }*/


}