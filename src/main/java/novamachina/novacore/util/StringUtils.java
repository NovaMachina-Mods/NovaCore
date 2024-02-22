package novamachina.novacore.util;

import java.text.DecimalFormat;
import java.text.Format;
import org.apache.commons.lang3.text.WordUtils;

public class StringUtils {

  private static final Format PERCENT_FORMAT = new DecimalFormat("#.##%");

  private StringUtils() {}

  public static String formatPercent(Float num) {
    return PERCENT_FORMAT.format(num);
  }

  public static String capitalize(String input) {
    //noinspection deprecation
    return WordUtils.capitalizeFully(input);
  }
}
