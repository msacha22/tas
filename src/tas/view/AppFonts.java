package view;

import java.awt.Font;
import java.io.InputStream;

public final class AppFonts {

    public static final Font TITEL;
    public static final Font TEXT;
    public static final Font BUTTON;

    static {
        TITEL = lade("/fonts/LuckiestGuy-Regular.ttf", 68f);
        TEXT = lade("/fonts/Inter-VariableFont_opsz,wght.ttf", 17f);
        BUTTON = lade("/fonts/Inter-VariableFont_opsz,wght.ttf", 15f).deriveFont(Font.BOLD);
    }

    private AppFonts() {}

    private static Font lade(String pfad, float groesse) {
        try (InputStream is = AppFonts.class.getResourceAsStream(pfad)) {
            if (is == null) {
                throw new RuntimeException("Font nicht gefunden: " + pfad);
            }
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(groesse);
        } catch (Exception e) {
            throw new RuntimeException("Font konnte nicht geladen werden: " + pfad, e);
        }
    }
}
