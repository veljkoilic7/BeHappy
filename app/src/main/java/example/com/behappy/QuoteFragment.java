package example.com.behappy;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);
        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardView);
        Button btnSend = quoteView.findViewById(R.id.btnSend);

        final String quote = getArguments().getString("quote");
        final String author = getArguments().getString("name");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","email@email.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, author);
                intent.putExtra(Intent.EXTRA_TEXT, quote);
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });

        quoteText.setText(quote);
        byAuthor.setText("-" + author);


        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {

        QuoteFragment quoteFragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("name", author);
        quoteFragment.setArguments(bundle);

        return quoteFragment;
    }

}
