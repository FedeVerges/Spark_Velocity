/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark.ejercicios.holaMundo;

import java.util.HashMap;
import spark.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author fede_
 */
public class holaMundoControlador {
    
    public static Route holaMundo = (Request req, Response res) -> {
        
        HashMap model = new HashMap();
        String palabra = ("Hola Mundo");
        
        model.put("palabra", palabra);
        model.put("template", "templates/holaMundo");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/holaMundo.vtl"));
       
    };
    
}
