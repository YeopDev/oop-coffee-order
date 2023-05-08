import static java.util.Objects.isNull;

public class Barista{

    // 바리스타의 역할: 커피를 만든다.
    // 바리스타의 책임: 만든 커피를 점원에게 전달한다.

    public Barista(){

    }

    // 행위 - 유효성 검사용 - 자바 Predicate라는거 써서 검사
    public Coffee menuReceive(String menuName){
        if(isNull(menuName) || menuName.isBlank()){
            throw new IllegalArgumentException("메뉴이름이 올바르지 않습니다.");
        }
        return executeCoffee(menuName);
    }


    public Coffee executeCoffee(String menuName) {
        return new Coffee(menuName);
    }
}
