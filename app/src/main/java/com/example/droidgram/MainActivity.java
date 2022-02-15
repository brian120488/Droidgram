package com.example.droidgram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Post[] postArray = {
            //new Post("Gangster", "Want some candy?", R.drawable.gangster),
            new Post("Bunjee", "I have cool hair.", R.drawable.bunjee),
            new Post("Ché", "I'm better Abolaji and James.", R.drawable.che),
            new Post("James", "live with passion, live musical.ly", R.drawable.james),
            new Post("Elijah", "i'M sWaGgEd OuT", R.drawable.elijah),
            new Post("Freezer", "I am a freezer", R.drawable.freezer),
            new Post("Anthony", "I'n good at games.", R.drawable.anthony),
            new Post("Insect", "Dancing bug", R.drawable.insect),
            new Post("Oshie", "It's game time!", R.drawable.oshie),
            new Post("Mr. Zee", "It's zee time!", R.drawable.zee),
            new Post("Cool Mama", "Peace and love", R.drawable.coolmama),
            new Post("Ikon", "Icon.", R.drawable.ikon),
            new Post("Daves", "Just whatever.", R.drawable.daves)
    };

    private TextView postName;
    private ImageView postImage;
    private ImageButton heart;
    private TextView likes;
    private EditText insertComments;
    private LinearLayout comments;
    private int postNum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postName = findViewById(R.id.postName);
        postImage = findViewById(R.id.postImage);
        heart = findViewById(R.id.heart);
        likes = findViewById(R.id.likes);
        insertComments = findViewById(R.id.insertComments);
        comments = findViewById(R.id.comments);

        newPost();
    }

    //load another post
    public void newPost() {

        comments.removeAllViews();

        //changing values of texts and images
        postName.setText(postArray[postNum].getName());
        postImage.setImageResource(postArray[postNum].getImage());
        heart.setImageResource(R.drawable.heart);
        int num = postArray[postNum].getLikes();
        if(num != 1) {
            likes.setText(num + " Likes");
        }
        else {
            likes.setText(num + " Like");
        }

        TextView caption = new TextView(this);
        caption.setText(postArray[postNum].getCaption());
        caption.setTextColor(getResources().getColor(R.color.black));
        caption.setTypeface(null, Typeface.BOLD);
        caption.setTextSize(15);
        comments.addView(caption);

        //comments
        for(int i = 0; i < postArray[postNum].getComments().size(); i++) {
            TextView comment = new TextView(this);
            comment.setText(postArray[postNum].getComments().get(i));
            comment.setTextColor(getResources().getColor(R.color.black));
            comments.addView(comment);
        }
    }

    //like post
    public void like(View view) {
        int num = postArray[postNum].getLikes();
        postArray[postNum].setLikes(num+1);
        if(num != 1) {
            likes.setText(num + " Likes");
        }
        else {
            likes.setText(num + " Like");
        }
    }

    //send comment
    public void send(View view) {
        if(insertComments.getText().toString().trim().length() > 0) {
            postArray[postNum].getComments().add(insertComments.getText().toString());
            TextView comment = new TextView(this);
            comment.setText(insertComments.getText().toString());
            comment.setTextColor(getResources().getColor(R.color.black));
            comment.setTextSize(15);
            comments.addView(comment);
            insertComments.getText().clear();
        }
    }

    //previous post
    public void moveLeft(View view) {
        if(postNum != 0) {
            postNum--;
        }
        else {
            postNum = postArray.length-1;
        }
        newPost();
    }

    //next post
    public void moveRight(View view) {
        if(postNum != postArray.length-1) {
            postNum++;
        }
        else {
            postNum = 0;
        }
        newPost();
    }
}
