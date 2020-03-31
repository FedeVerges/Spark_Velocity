/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark.ejercicios.holaMundo;

import static spark.Spark.get;

/**
 *
 * @author Federico Verges
 */
public class holaMundo {
    public static void main(String[] args) {
        get("/holaMundo",  holaMundoControlador.holaMundo);
        }
    }
