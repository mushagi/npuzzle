public class TestingClass {
    private int modifiedPlayer;
    private String name;

    public int getModifiedPlayer() {
        this.name = name;
        return modifiedPlayer;
    }

    public void setModifiedPlayer(int modifiedPlayer) {
        this.modifiedPlayer = modifiedPlayer;
    }

    public TestingClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
