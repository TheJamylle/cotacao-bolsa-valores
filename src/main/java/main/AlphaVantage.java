/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.time.format.DateTimeFormatter;
import java.util.List;
import org.patriques.AlphaVantageConnector;
import org.patriques.BatchStockQuotes;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.quote.BatchStockQuotesResponse;
import org.patriques.output.quote.data.StockQuote;

/**
 *
 * @author Jamylle
 */
public class AlphaVantage {
    public void cotacao(String codEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Alpha Vantage: http://www.alphavantage.co%n", codEmpresa);

        /*
        Verifica se existe uma variável de ambiente para a chave da API do serviço Alpha Vantage.
        Você pode se cadastrar e obter uma chave em http://www.alphavantage.co
        */
        final String s = System.getenv("ALPHAVANTAGE_APIKEY");
        final String apiKey = s == null ? "50M3AP1K3Y" : s;
        final int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);

        //Permite obter a cotação (quotes) de ações (stocks).
        BatchStockQuotes stockQuotes = new BatchStockQuotes(apiConnector);

        try {
            BatchStockQuotesResponse response = stockQuotes.quote(codEmpresa);
            List<StockQuote> stockQuoteList = response.getStockQuotes();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            stockQuoteList.forEach(stock -> System.out.printf("Data: %s Preço: %s%n", formatter.format(stock.getTimestamp()), stock.getPrice()));
        } catch (AlphaVantageException e) {
            System.out.println("Erro ao solicitar cotação da empresa " + codEmpresa + ": " + e.getMessage());
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
