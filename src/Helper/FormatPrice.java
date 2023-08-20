/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author MINH
 */
public class FormatPrice {
    public String formatWithCommas(double number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        return numberFormat.format(number);
    }
}
