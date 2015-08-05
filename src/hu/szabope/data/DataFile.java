package hu.szabope.data;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public abstract class DataFile {

    private final List<MeasureRow> measureRows;

    public DataFile(String path) throws IOException {
        measureRows = parse(path);
    }

    public String getSmallestSpreadIdentity() {
        return getSmallestSpreadRow().getId();
    }

    protected abstract boolean isLineUseless(String line);

    protected abstract int getIdStart();
    protected abstract int getIdEnd();
    protected abstract int getMaxStart();
    protected abstract int getMaxEnd();
    protected abstract int getMinStart();
    protected abstract int getMinEnd();

    private MeasureRow getSmallestSpreadRow() {
        MeasureRow result = measureRows.get(0);
        for(int i = 1, n = measureRows.size(); i < n; i++) {
            MeasureRow measureRow = measureRows.get(i);
            if (measureRow.getSpread() < result.getSpread()) {
                result = measureRow;
            }
        }

        return result;
    }

    /**
     * Parse data file into MeasureRow s
     * @return list of MeasureRow s
     * @param path to data file of format seen in implementing class' doc
     */
    private List<MeasureRow> parse(String path) throws IOException {
        try (FileInputStream fis = new FileInputStream(path)) {
            return deserialize(IOUtils.readLines(fis, StandardCharsets.UTF_8.name()));
        }
    }

    private List<MeasureRow> deserialize(List<String> lines) {
        List<MeasureRow> measureRowList = new ArrayList<>(lines.size() - 1);

        for(String line: lines) {
            if (isLineUseless(line)) {
                continue;
            }

            String serial = line.substring(getIdStart(), getIdEnd()).trim();
            int maximumTemperature = Integer.parseInt(line.substring(getMaxStart(), getMaxEnd()).trim());
            int minimumTemperature = Integer.parseInt(line.substring(getMinStart(), getMinEnd()).trim());

            measureRowList.add(
                    new MeasureRow(
                            serial,
                            maximumTemperature,
                            minimumTemperature
                    )
            );
        }

        return measureRowList;
    }

}
