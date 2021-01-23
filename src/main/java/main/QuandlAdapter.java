/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.lang.reflect.Array;
import java.util.List;


public class QuandlAdapter implements ServiceCotacao {
    private Quandl quandl;
    
    public Quandl getQuandl() {
        return quandl;
    }

    public void setQuandl(Quandl quandl) {
        this.quandl = quandl;
    }
    
    @Override
    public void verCotacao(String codEmpresa) {
        String[] arrayDeSA = codEmpresa.split("[.]");
        if(arrayDeSA.length > 1) {
            codEmpresa = arrayDeSA[0];
        }
        
        String[] arraySemWIKI = codEmpresa.split("/");
        if(arraySemWIKI.length == 1) {
            codEmpresa = "WIKI/" + codEmpresa;
        }
        
        quandl.cotacao(codEmpresa);
    }
    
}
