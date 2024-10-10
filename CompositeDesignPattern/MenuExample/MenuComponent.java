interface MenuComponent{
    String getName();
    void print();

    default void add(MenuComponent i){
        throw new UnsupportedOperationException();
    }
    default void remove(MenuComponent i){
        throw new UnsupportedOperationException();
    }
    default MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }
}