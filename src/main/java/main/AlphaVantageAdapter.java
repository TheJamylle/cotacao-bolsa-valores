/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


public class AlphaVantageAdapter implements ServiceCotacao {
    private AlphaVantage alphaVantage;

    public AlphaVantage getAlphaVantage() {
        return alphaVantage;
    }

    public void setAlphaVantage(AlphaVantage alphaVantage) {
        this.alphaVantage = alphaVantage;
    }
    
    @Override
    public void verCotacao(String codEmpresa) {
        String[] arrayDeSA = codEmpresa.split("[.]");
        if(arrayDeSA.length > 1) {
            codEmpresa = arrayDeSA[0];
        }
        
        String[] arrayComWIKI = codEmpresa.split("/");
        if(arrayComWIKI.length > 1) {
            codEmpresa = arrayComWIKI[1];
        }
        
        alphaVantage.cotacao(codEmpresa);
    }
}
