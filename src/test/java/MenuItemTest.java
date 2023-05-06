import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    @DisplayName("메뉴확인")
    void 메뉴확인(){
        MenuItem americano = new MenuItem("아메리카노",1500);

        Assertions.assertThat(americano.getMenuName()).isEqualTo("아메리카노");
        Assertions.assertThat(americano.getPrice()).isEqualTo(1500);

    }

}