/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author fdn-user
 */
public class CurrencyUtil {
    public static String formatRupiah(double amount) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeID);
        return formatter.format(amount);
    }
}
