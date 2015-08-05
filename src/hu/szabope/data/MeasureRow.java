package hu.szabope.data;

public class MeasureRow {

    private final String id;
    private final int spread;

    public MeasureRow(String id, int maxTemperature, int minTemperature) {
        this.id = id;
        this.spread = Math.abs(maxTemperature - minTemperature);
    }

    public String getId() {
        return id;
    }

    public int getSpread() {
        return spread;
    }
}
