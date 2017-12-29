package example.com.behappy;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import example.com.behappy.data.QuoteData;
import example.com.behappy.data.QuoteListAsyncResponse;
import example.com.behappy.data.QuoteViewPagerAdapter;
import example.com.behappy.model.Quote;

public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdapter);
    }

    private List<QuoteFragment> getFragments() {

        final List<QuoteFragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {

                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment qtFragment = QuoteFragment.newInstance(quotes.get(i).getQuote(), quotes.get(i).getAuthor());
                    fragmentList.add(qtFragment);
                }

                quoteViewPagerAdapter.notifyDataSetChanged(); //very vazno!!!!!!!!!
            }
        });

        return fragmentList;
    }
}
