public class ChocolateBoiler {
    private boolean empty, boiled;

    private static ChocolateBoiler instance = null;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            synchronized (ChocolateBoiler.class) {
                if (instance == null) {
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            System.out.println("Chocolate boiler is filling");
            empty = false;
            boiled = false;
        } else {
            System.out.println("Chocolate boiler is already filled");
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            System.out.println("Chocolate boiler is draining");
            empty = true;
        } else if (isEmpty()) {
            System.out.println("Chocolate boiler is empty");
        } else {
            System.out.println("Chocolate boiler needs to be boiled before draining");
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            System.out.println("Chocolate boiler is boiling");
            boiled = true;
        } else if (isEmpty()) {
            System.out.println("Chocolate boiler is empty");

            System.out.println("Chocolate boiler is already boiled");
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}