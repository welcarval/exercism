public class Twofer {
    public String twofer(String name) {
        String s = name == null ? "you" : name;
        return "One for " + s + ", one for me.";
    }
}
