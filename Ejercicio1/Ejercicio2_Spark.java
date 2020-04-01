package spark.ejercicios.Ejercicio1;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
public class Ejercicio2_Spark {
    public static void main(String[] args) {
        get("/numeros", (request, response) -> {
            int cantidadNumeros = 6;
            List<Integer> numeros = new ArrayList<>();
            String parametro = null;
            String tipoBoton = request.queryParams("boton");
            for(int i=1; i<=cantidadNumeros; i++){
                parametro = request.queryParams("numero"+ i);
                if(parametro != null && !parametro.equals("")) {
                    numeros.add(Integer.parseInt(parametro));
                }
            }
            try {
                if (tipoBoton.equals("ordenar")) {
                    Collections.sort(numeros);
                } else if (tipoBoton.equals("desordenar")) {
                    Collections.shuffle(numeros);
                }
            }catch (NullPointerException e){
                System.out.println("Tipo boton Nulo");
            }

            HashMap model = new HashMap();

            model.put("cantidad", cantidadNumeros);
            model.put("listaNumeros", numeros);
            model.put("template", "templates/numeros.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model,"templates/layout.vtl"));
        });
    }
}
