public class Main {
    public static void main(String[] args) {
        Dishes p = new Dishes("Chana Poha");
        Dishes s = new Dishes("Samosa");
        Dishes d = new Dishes("Dal Tadka");
        Dishes r = new Dishes("Jira Rice");

        DishType brkfst = new DishType("Breakfast");
        DishType lnch = new DishType("Lunch");

        brkfst.add(p);
        brkfst.add(s);

        lnch.add(d);
        lnch.add(r);

        DishType fullMenu = new DishType("Full Menu");
        fullMenu.add(brkfst);
        fullMenu.add(lnch);
        System.err.println();
        fullMenu.print();
        System.out.println();
        brkfst.print();
        System.out.println();
        lnch.print();
        System.out.println();
    }
}
