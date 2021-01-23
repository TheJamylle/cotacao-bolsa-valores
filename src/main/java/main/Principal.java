package main;

/**
 * Classe principal que mostra como obter a cotação de empresas da bolsa de valores
 * utilizando 3 serviços diferentes: Yahoo Finance, AlphaVantage e Quandl.
 * Os métodos implementados tem todo o código para utilizar as bibliotecas
 * que implementam o acesso a tais serviços.
 * Mas como podem ver, o código dos 3 métodos é totalmente diferente um do outro.
 * Ou seja, a forma de usar cada uma das bibliotecas é diferente.
 * Por isso, é preciso criar um adapter para padronizar a utilização das bibliotecas
 * e permitir trocar uma pela outra sem alterar o código do projeto.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println();

        //No Yahoo Finance, as empresas brasileiras terminam com ".sa"
        //cotacaoUsandoYahooFinance("MGLU3.SA"); //MGLU3 = Magazine Luiza

        ///cotacaoUsandoAlphaVantage("INTL"); //INTL = Intel
        
        //cotacaoUsandoQuandl("WIKI/AAPL"); //AAPL = Apple
        
        // Abaixo se encontra o funcionamento dos Adaptadores com a 
        // nomeclatura "errada" de cada um para fins de teste
        
        AlphaVantage alpha = new AlphaVantage();
        YahooFinance yahoo = new YahooFinance();
        Quandl quandl = new Quandl();
        
        AlphaVantageAdapter adapter = new AlphaVantageAdapter();
        adapter.setAlphaVantage(alpha);
        adapter.verCotacao("MGLU3.SA");
        
        YahooFinanceAdapter adapterY = new YahooFinanceAdapter();
        adapterY.setYahooFinance(yahoo);
        adapterY.verCotacao("WIKI/AAPL");

        QuandlAdapter qadapter = new QuandlAdapter();
        qadapter.setQuandl(quandl);
        qadapter.verCotacao("INTL");
       
        
    }
    
}
