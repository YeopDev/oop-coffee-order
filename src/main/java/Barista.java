public class Barista {

    // 바리스타의 역할: 커피를 만든다.
    // 바리스타의 책임: 만든 커피를 점원에게 전달한다.

    private String menuName;

    public Barista(String menuName){
        this.menuName = menuName;
    }

//    커피를 만든다.
    public Coffee createCoffee(){
        Coffee coffee = new Coffee(this.menuName);
        return coffee;
    }

}
