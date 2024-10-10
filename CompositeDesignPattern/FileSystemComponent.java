interface FileSystemComponent {
    String getName();
    void display();

    default void add(FileSystemComponent f) {
        throw new UnsupportedOperationException();
    }
    default void remove(FileSystemComponent f) {
        throw new UnsupportedOperationException();
    }
    default FileSystemComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
}