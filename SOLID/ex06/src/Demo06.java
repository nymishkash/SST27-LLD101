public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        aviary.release(new FlyingBird());
        
        // Penguin can't be released from aviary since it can't fly
        Penguin penguin = new Penguin();
        penguin.swim(); // Penguins swim instead
    }
}
