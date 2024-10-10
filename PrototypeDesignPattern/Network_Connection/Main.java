public class Main {
    public static void main(String[] args) {
        NetworkConnection nc1 = new NetworkConnection();
        nc1.loadVeryImpData();
        System.out.println("1)\n"+ nc1);

        try {
            NetworkConnection nc2 = (NetworkConnection)nc1.clone();
            System.out.println("2)\n" + nc2);
            
            NetworkConnection nc3 = (NetworkConnection) nc1.clone();
            System.out.println("3)\n" + nc3);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}