package example.com.behappy.data;

import java.util.ArrayList;

import example.com.behappy.model.Quote;

/**
 * Created by Korisnik on 15-Dec-17.
 */

public interface QuoteListAsyncResponse {

    void processFinished(ArrayList<Quote> quotes);
}
