package com.geek.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.geek.myapplication.adapters.EmojiAdapter;
import com.geek.myapplication.databinding.ActivityMainBinding;
import com.geek.myapplication.domain.CustomContent;
 public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {

        private ActivityMainBinding binding;
        private EmojiAdapter emojiAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            initRecycler();

            CustomContent customContent = new CustomContent(1, "Card 1", 15.0);
            CustomContent customContent2 = new CustomContent(1, "Card 1", 15.0);

            boolean isMatch = customContent.equals(customContent2);

        }

        private void initRecycler() {
            emojiAdapter = new EmojiAdapter(this);
            binding.recView.setAdapter(emojiAdapter);
        }

        @Override
        public void choose() {
            runOnUiThread(() -> {
                emojiAdapter.notifyDataSetChanged();
//            binding.recView.setVisibility(View.INVISIBLE);
            });
        }

        @Override
        public void notifyCards() {
            runOnUiThread(() -> {
                emojiAdapter.notifyDataSetChanged();
            });
        }
    }