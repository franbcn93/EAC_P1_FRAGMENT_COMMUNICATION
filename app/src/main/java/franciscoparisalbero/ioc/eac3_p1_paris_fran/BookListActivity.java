package franciscoparisalbero.ioc.eac3_p1_paris_fran;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import franciscoparisalbero.ioc.eac3_p1_paris_fran.model.Book;
import franciscoparisalbero.ioc.eac3_p1_paris_fran.repo.BookStore;

public class BookListActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.book_detail_container) != null) {
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        BookStore.createBookList();
        recyclerView.setAdapter(new SimpleBookRecyclerViewAdapter(this, BookStore.getAllBooks(), mTwoPane));
    }

    public static class SimpleBookRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleBookRecyclerViewAdapter.ViewHolder> {

        private final BookListActivity mParentActivity;
        private final List<Book> mBooks;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = (Book) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putInt(BookDetailFragment.ARG_BOOK_ID, book.getId());
                    BookDetailFragment fragment = new BookDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.book_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    intent.putExtra(BookDetailFragment.ARG_BOOK_ID, book.getId());

                    context.startActivity(intent);
                }
            }
        };

        SimpleBookRecyclerViewAdapter(BookListActivity parent,
                                      List<Book> books,
                                      boolean twoPane) {
            mBooks = books;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.book_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(String.valueOf(mBooks.get(position).getId()));
            holder.mContentView.setText(mBooks.get(position).getTitle());

            holder.itemView.setTag(mBooks.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mBooks.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}