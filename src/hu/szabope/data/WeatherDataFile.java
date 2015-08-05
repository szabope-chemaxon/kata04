package hu.szabope.data;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * File format example (please stick to this format, including empty line):
 * Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP
 *
 *  1  88*   59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5
 *  2  79    43*   71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5
 */
public class WeatherDataFile extends DataFile {

    private static final int ID_START = 1;
    private static final int ID_END = 4;
    private static final int MAX_TEMP_START = 6;
    private static final int MAX_TEMP_END = 8;
    private static final int MIN_TEMP_START = 12;
    private static final int MIN_TEMP_END = 14;

    public WeatherDataFile(String path) throws IOException {
        super(path);
    }

    @Override
    protected boolean isLineUseless(String line) {
        if (StringUtils.isNotBlank(line)) {
            try {
                Integer.parseInt(line.substring(getIdStart(), getIdEnd()).trim());
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
        return MAX_TEMP_START;
    }

    @Override
    protected int getMaxEnd() {
        return MAX_TEMP_END;
    }

    @Override
    protected int getMinStart() {
        return MIN_TEMP_START;
    }

    @Override
    protected int getMinEnd() {
        return MIN_TEMP_END;
    }


}
