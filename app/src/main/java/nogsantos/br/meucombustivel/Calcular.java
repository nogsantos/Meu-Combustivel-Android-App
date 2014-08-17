package nogsantos.br.meucombustivel;

import android.provider.DocumentsContract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.lang.annotation.Documented;
import java.text.DecimalFormat;

/**
 * Created by nogsantos on 8/13/14.
 */
public class Calcular {

    private Double valor;
    /**
     * Construtor
     */
     Calcular(double valor) {
        this.valor = valor;
    }
    /**
     * Realiza o calculo
     */
    public String gasolina(){
        Double res       = valor * 0.7;
        DecimalFormat df = new DecimalFormat("#,###0.000");
        String html      = "R$ " + df.format(res);
        Document doc     = Jsoup.parse(html);
        String text      = doc.body().text();
        return text;
    }
}
