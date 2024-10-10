public abstract class ShapeStore{
    public ShapeStore(){}

    protected abstract ShapeStore createShape(String type);

    public ShapeStore orderShape(String type){
        ShapeStore shape = createShape(type);
    }
}