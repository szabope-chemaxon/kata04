package hu.szabope.data;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * File format example (please stick to this format):
 *      Team            P     W    L   D    F      A     Pts
 *   1. Arsenal         38    26   9   3    79  -  36    87
 *   2. Liverpool       38    24   8   6    67  -  30    80
 */
public class FootballDataFile extends DataFile {

    private static final int ID_START = 7;
    private static final int ID_END = 22;
    private static final int MAX_FOR_START = 43;
    private static final int MAX_FOR_END = 45;
    private static final int MIN_AGAINST_START = 50;
    private static final int MIN_AGAINST_END = 52;

    public FootballDataFile(String path) throws IOException {
        super(path);
    }

    @Override
    protected boolean isLineUseless(String line) {
        if (StringUtils.isNotBlank(line)) {
            try {
                Integer.parseInt(line.substring(getMaxStart(), getMaxEnd()).trim());
                return false;
            } catch (NumberFormatException ex) {
                // intentionally left blank
            }
        }

        return true;
    }

    @Override
    protected int getIdStart() {
        return ID_START;
    }

    @Override
    protected int getIdEnd() {
        return ID_END;
    }

    @Override
    protected int getMaxStart() {
        return MAX_FOR_START;
    }

    @Override
    protected int getMaxEnd() {
        return MAX_FOR_END;
    }

    @Override
    protected int getMinStart() {
        return MIN_AGAINST_START;
    }

    @Override
    protected int getMinEnd() {
        return MIN_AGAINST_END;
    }
}
