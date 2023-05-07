public class Barista {

    // 바리스타의 역할: 커피를 만든다.
    // 바리스타의 책임: 만든 커피를 점원에게 전달한다.

    private String menuName;

    public Barista(String menuName, CreateCoffee createCoffee){
        this.menuName = menuName;
        this.createCoffee = createCoffee;
        if (new BaristaValidator(this).validate()){
            throw new IllegalArgumentException("메뉴가 올바르지 않습니다.");
        }
    }

    //행위
    // 유효성 검사용
    // 자바 Predicate라는거 써서 검사
    public String getMenuName() {
        return menuName;
    }

//    public void createCoffee(){
//    }

    // 커피를 만드는데 Coffee에 인자전달
    public Coffee execute(String menuName) {
        Coffee coffee1 = new Coffee(menuName);
        return this.createCoffee.execute(coffee1);
    }


    private class BaristaValidator{
        private final Barista target;

        BaristaValidator(Barista target){
            this.target = target;
        }
        Predicate<Barista> menuValidator(){
            return (Constructor) -> Constructor.menuName != null || Constructor.menuName != ""; //ㄱㄱㄱ
        }

        Boolean validate(){
            return menuValidator().test(target);
        }
    }
}
