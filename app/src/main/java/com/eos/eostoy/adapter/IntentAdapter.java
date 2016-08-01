package com.eos.eostoy.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eos.eostoy.R;
import com.eos.eostoy.data.IntentData;
import com.eos.eostoy.data.Manager;

import java.util.ArrayList;

/**
 * Created by jyoung on 16. 7. 31..
 */
public class IntentAdapter extends RecyclerView.Adapter<IntentAdapter.ViewHolder> {
    private ArrayList<IntentData> intentList = new ArrayList<>();
    private Context context;

    public IntentAdapter(Context context, ArrayList<IntentData> intentList) {
        this.context = context;
        this.intentList = intentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.intent_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final IntentData intent = intentList.get(position);

        if (intent != null) {
            holder.image.setImageDrawable(context.getResources().getDrawable(intent.getImageId()));
            holder.title.setText(intent.getTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (intent.getCode()) {
                        case Manager.INTENT_DIAL:
                            Intent dial = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01055862682"));
                            context.startActivity(dial);
                            break;
                        case Manager.INTENT_CALL:
                            Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01055862682"));
                            context.startActivity(call);
                            break;
                        case Manager.INTENT_MSG:
                            Intent msg = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:01055862682"));
                            msg.putExtra("sms_body", "예제다!");
                            context.startActivity(msg);
                            break;
                        case Manager.INTENT_EMAIL:
                            Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:violentjy@naver.com"));
                            context.startActivity(email);
                            break;
                        case Manager.INTENT_INTERNET:
                            Intent internet = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
                            context.startActivity(internet);
                            break;
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return intentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.intent_image);
            title = (TextView)itemView.findViewById(R.id.intent_title);
        }
    }
}
