package enums;

public enum Fragmentation {
    Unstable(1),
    SemiStable(2),
    Stable(3);

    private final int level;

    Fragmentation(int level) {
        this.level = level;
    }

}
