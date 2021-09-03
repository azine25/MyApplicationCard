package com.geek.myapplication.adapters;

import static com.geek.myapplication.adapters.EmojiAdapter.EmojiViewHolder.*;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.myapplication.EmojiGame;
import com.geek.myapplication.R;
import com.geek.myapplication.domain.Card;

import java.util.Timer;
import java.util.TimerTask;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder> {

    private EmojiGame game = new EmojiGame();
    private Listener listener;

    @Override
    public EmojiAdapter.EmojiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itom_card, parent, false);
        return new EmojiViewHolder(view);
    }


    public EmojiAdapter(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiAdapter.EmojiViewHolder holder, int position) {
        holder.onBind(game.getCards().get(position));

    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    public class EmojiViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCard;

        public EmojiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.cardId);
        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);

            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);

            }
            itemView.setOnClickListener(v -> {
//                listener.choose();
//                game.choose(card);
                if (!card.isMatch()) {
                    game.choose(card);
                    notifyDataSetChanged();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            game.checkPairs(card);
                            if (game.removePairs() == game.getCards().size()) {
                                listener.choose();
                            }
                            listener.notifyCards();
                        }
                    }, 500);
                }
            });
        }
    }

    public interface Listener {
        void choose();
        void notifyCards();
    }


}
