public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.add(new File("file1"));

        Folder folder1 = new Folder("folder1");
        folder1.add(new File("file2"));
        folder1.add(new File("file3"));

        root.add(folder1);

        Folder folder2 = new Folder("folder2");
        Folder folder3 = new Folder("folder3");
        folder3.add(new File("file4"));
        folder3.add(new File("file5"));

        folder2.add(folder3);
        root.add(folder2);

        root.display();
    }
}