package example.com.behappy.data;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import example.com.behappy.QuoteFragment;

/**
 * Created by Korisnik on 15-Dec-17.  MAKING EACH CARD, SO WE DONT HAVE TO CREATE 100 FRAGMENT QUOTE XMLS
 */

public class QuoteViewPagerAdapter extends FragmentPagerAdapter {

    private List<QuoteFragment> fragments;

    public QuoteViewPagerAdapter(FragmentManager fm, List<QuoteFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
