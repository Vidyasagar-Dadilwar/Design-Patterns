import java.util.ArrayList;

class Folder implements FileSystemComponent {
    private String name;
    private ArrayList<FileSystemComponent> children;
    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void display() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent child : children){
            child.display();
        }
    }
    @Override
    public void add(FileSystemComponent f){
        children.add(f);
        System.out.println(f.getName() + " added to folder " + name);
    }
    @Override
    public void remove(FileSystemComponent f) {
        children.remove(f);
        System.out.println(f.getName() + " removed from folder " + name);
    }
    @Override
    public FileSystemComponent getChild(int i) {
        return children.get(i);
    }
}