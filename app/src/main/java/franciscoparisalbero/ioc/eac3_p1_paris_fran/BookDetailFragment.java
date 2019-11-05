package franciscoparisalbero.ioc.eac3_p1_paris_fran;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import franciscoparisalbero.ioc.eac3_p1_paris_fran.model.Book;
import franciscoparisalbero.ioc.eac3_p1_paris_fran.repo.BookStore;

public class BookDetailFragment extends Fragment {

    public static final String ARG_BOOK_ID = "book_id";

    private Book mBook;

    public BookDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_BOOK_ID)) {
            mBook = BookStore.get(getArguments().getInt(ARG_BOOK_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mBook.getTitle());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_detail, container, false);

        if (mBook != null) {
            ((TextView) rootView.findViewById(R.id.book_detail)).setText(mBook.getSummary());
        }

        return rootView;
    }
}