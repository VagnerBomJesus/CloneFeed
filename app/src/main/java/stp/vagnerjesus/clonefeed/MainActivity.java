package stp.vagnerjesus.clonefeed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostAdapter postAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(postAdapter);

        List<Post> posts = new ArrayList<>();

        Post post0 = new Post();

        post0.setImageViewUser(R.drawable.user0);
        post0.setImageViewPost(R.drawable.post0);
        post0.setTextViewTime("2 min");
        post0.setTextViewUsername("Carlos Espírito Santo");
        post0.setTextViewContent("O tempo é precioso e viajar é preciso Irei, nem k seja pra perto.....");
        post0.setTextViewTitle("YOUTUBE.COM".toUpperCase());
        post0.setTextViewSubtitle("Algures em Lisboa Imagem feita com Xiaomi Yi");
        posts.add(post0);


        Post post21 = new Post();
        post21.setImageViewUser(R.drawable.vag);
        post21.setImageViewPost(R.drawable.vagpost);
        post21.setTextViewTime("25 de junho");
        post21.setTextViewUsername("Vagner Bom Jesus");
        post21.setTextViewContent("A reflexão, dispõe de diversas possibilidades e probabilidades quando feita.");
        posts.add(post21);

        Post post2 = new Post();
        post2.setImageViewUser(R.drawable.red_queen);
        post2.setImageViewPost(R.drawable.post_2);
        post2.setTextViewTime("12 min");
        post2.setTextViewUsername("Melisandre");
        post2.setTextViewContent("My ability to see visions in the flames, and completely trusts in the power of her god, R'hllor. Although she acknowledges that visions can be misinterpreted,[8] she has faith in her ability to correctly interpret visions, even if the vision does not entirely agree with the proposed interpretation.[4] ");
        posts.add(post2);

        Post post1 = new Post();

        post1.setImageViewUser(R.drawable.jon_snow);
        post1.setImageViewPost(R.drawable.post_1);
        post1.setTextViewTime("2 min");
        post1.setTextViewUsername("Jon Snow");
        post1.setTextViewContent("No matter what Ygritte says, Jon Snow knows a few things. The bastard son of Ned Stark (or is he?) grew up in a household where he was welcomed by Ned and his half-siblings but not so much by Catelyn Stark. When the opportunity came to join the Night's Watch at Castle Black, he saw");
        post1.setTextViewTitle("gameofthrones.com".toUpperCase());
        post1.setTextViewSubtitle("Game of Thrones is an American fantasy drama television series created by David Benioff and D. B. Weiss. It is an adaptation of A Song of Ice and Fire, George R. R. Martin's series of fantasy novels, the first of which is A Game of Thrones");
        posts.add(post1);

        postAdapter.setPosts(posts);
        postAdapter.notifyDataSetChanged();
    }
    private static  class PostViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewUser;
        private final TextView textViewTime;
        private final TextView textViewUsername;
        private final TextView textViewContent;
        private final ImageView imageViewPost;
        private final TextView textViewTitle;
        private final TextView textViewSubtitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.image_view_user);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewUsername = itemView.findViewById(R.id.text_view_username);
            textViewContent = itemView.findViewById(R.id.text_view_content);
            imageViewPost = itemView.findViewById(R.id.image_view_post);
            textViewTitle = itemView.findViewById(R.id.text_view_post_title);
            textViewSubtitle = itemView.findViewById(R.id.text_view_post_subtitle);
        }
        void bind(Post post){
            imageViewUser.setImageResource(post.getImageViewUser());
            textViewTime.setText(post.getTextViewTime());
            textViewUsername.setText(post.getTextViewUsername());
            textViewContent.setText(post.getTextViewContent());
            imageViewPost.setImageResource(post.getImageViewPost());
            textViewTitle.setText(post.getTextViewTitle());
            textViewSubtitle.setText(post.getTextViewSubtitle());

            if (post.getTextViewTitle() == null) {
                itemView.findViewById(R.id.post_conteiner).setVisibility(View.GONE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post, "1:1");
                constraintSet.applyTo((ConstraintLayout) itemView);
            } else {
                itemView.findViewById(R.id.post_conteiner).setVisibility(View.VISIBLE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post, "16:9");
                constraintSet.applyTo((ConstraintLayout) itemView);
            }
        }
    }
    private class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

        private List<Post> posts = new ArrayList<>();

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.feed_item, parent, false);
            return new PostViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {
            Post post = posts.get(position);
            postViewHolder.bind(post);
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }
        void setPosts(List<Post> posts) {
            this.posts = posts;
        }
    }
    private class Post{
        private int imageViewUser;
        private String textViewTime;
        private String textViewUsername;
        private String textViewContent;
        private int imageViewPost;
        private String textViewTitle;
        private String textViewSubtitle;

        public int getImageViewUser() {
            return imageViewUser;
        }

        public void setImageViewUser(int imageViewUser) {
            this.imageViewUser = imageViewUser;
        }

        public String getTextViewTime() {
            return textViewTime;
        }

        public void setTextViewTime(String textViewTime) {
            this.textViewTime = textViewTime;
        }

        public String getTextViewUsername() {
            return textViewUsername;
        }

        public void setTextViewUsername(String textViewUsername) {
            this.textViewUsername = textViewUsername;
        }

        public String getTextViewContent() {
            return textViewContent;
        }

        public void setTextViewContent(String textViewContent) {
            this.textViewContent = textViewContent;
        }

        public int getImageViewPost() {
            return imageViewPost;
        }

        public void setImageViewPost(int imageViewPost) {
            this.imageViewPost = imageViewPost;
        }

        public String getTextViewTitle() {
            return textViewTitle;
        }

        public void setTextViewTitle(String textViewTitle) {
            this.textViewTitle = textViewTitle;
        }

        public String getTextViewSubtitle() {
            return textViewSubtitle;
        }

        public void setTextViewSubtitle(String textViewSubtitle) {
            this.textViewSubtitle = textViewSubtitle;
        }
    }
}