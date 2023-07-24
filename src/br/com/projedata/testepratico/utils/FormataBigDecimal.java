package br.com.projedata.testepratico.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormataBigDecimal {

    public String formata(BigDecimal valor) {
        DecimalFormat df = new DecimalFormat("###,###.##");
        DecimalFormatSymbols customSymbol = new DecimalFormatSymbols();
        customSymbol.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(customSymbol);
        return df.format(valor);
    }

}
