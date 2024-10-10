import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart(new RegDiscountStrategy());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Apply Regular Discount Strategy");
            System.out.println("2. Apply Premium Discount Strategy");
            System.out.println("3. Apply Holiday Discount Strategy");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    sc.setDiscountStrategy(new RegDiscountStrategy());
                    break;
                case 2:
                    sc.setDiscountStrategy(new PremDiscountStrategy());
                    break;
                case 3:
                    sc.setDiscountStrategy(new HoliDiscountStrategy());
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            double total = sc.calculateTotal(amount);
            System.out.println("Price after applying discount: " + total + "\n\n");
        }

        scanner.close();
    }
}




// public class Main {
//     public static void main(String[] args) {
//         ShoppingCart sc = new ShoppingCart(new RegDiscountStrategy());
//         System.out.println("Price after applying regular strategy discount: " + sc.calculateTotal(100));

//         sc.setDiscountStrategy(new PremDiscountStrategy());
//         System.out.println("Price after applying premium strategy discount: " + sc.calculateTotal(100));

//         sc.setDiscountStrategy(new HoliDiscountStrategy());
//         System.out.println("Price after applying holiday strategy discount: " + sc.calculateTotal(100));
//     }
// }