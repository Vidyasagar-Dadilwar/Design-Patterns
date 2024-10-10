import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner sc = new Scanner(System.in);
        LaptopBuilder lb = null;
        String ram, processor, touch, screen;
        System.out.println("Enter type of the laptop you want to build: ");
        String choice = sc.next();
        if(choice.contains("Gaming")){
            lb = new GamingLaptop();
            System.out.println("Enter RAM for gaming laptop: ");
            ram = sc.next();
            System.out.println("Enter Processor for gaming laptop: ");
            processor = sc.next();
            System.out.println("Enter touch for gaming laptop: ");
            touch = sc.next();
            System.out.println("Enter screen for gaming laptop: ");
            screen = sc.next();
        }
        else if(choice.contains("Work")){
            lb = new WorkLaptop();
            System.out.println("Enter RAM for work laptop: ");
            ram = sc.next();
            System.out.println("Enter Processor for work laptop: ");
            processor = sc.next();
            System.out.println("Enter touch for work laptop: ");
            touch = sc.next();
            System.out.println("Enter screen for work laptop: ");
            screen = sc.next();
        }
        else{
            System.out.println("Invalid choice");
            sc.close();
            return ;
        }
        Director dir1 = new Director(lb);
        dir1.construct(ram, processor, touch, screen);
        Laptop l = dir1.geLaptop();
        System.out.println("Created laptop with: RAM = " + l.ram + " Processor = " + l.processor + " Touch = " + l.touchPad + " Screen = " + l.screen);

        sc.close();
    }
}
