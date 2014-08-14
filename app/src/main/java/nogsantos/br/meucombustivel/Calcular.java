package nogsantos.br.meucombustivel;

import java.text.DecimalFormat;

/**
 * Created by nogsantos on 8/13/14.
 */
public class Calcular {

    private Double valor;

    public Calcular(double valor) {
        this.valor = valor;
    }

    public String gasolina(){
        Double res       = valor * 0.7;
        DecimalFormat df = new DecimalFormat("#,###0.000");
        return "Abasteça com Etanol se o valor for menor que R$ " + df.format(res) + " caso contrário, utilize Gasolina!";
    }
}
