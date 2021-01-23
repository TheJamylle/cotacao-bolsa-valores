/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


public class YahooFinanceAdapter implements ServiceCotacao {
    private YahooFinance yahooFinance;

    public YahooFinance getYahooFinance() {
        return yahooFinance;
    }

    public void setYahooFinance(YahooFinance yahooFinance) {
        this.yahooFinance = yahooFinance;
    }
    
    @Override
    public void verCotacao(String codEmpresa) {
        String[] arraySemSA = codEmpresa.split("[.]");
        if(arraySemSA.length == 1) {
            codEmpresa = codEmpresa + ".SA";
        }
        
        String[] arrayComWIKI = codEmpresa.split("/");
        if(arrayComWIKI.length > 1) {
            codEmpresa = arrayComWIKI[1];
        }
        yahooFinance.cotacao(codEmpresa);
    }
}
