public class MenuItem {
    private String menuName;
    private int price;

    MenuItem(String menuName, int price){
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }
    public int getPrice(){
        return price;
    }

}
