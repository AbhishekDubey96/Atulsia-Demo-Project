package com.example.atulsiademo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideviewpagerAdapter extends PagerAdapter {
    Context context;

    public SlideviewpagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    // instantiate method when we slide the viewpager
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //XML files that define a layout, and converting them into View objects.
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen, container, false);
        ImageView log = view.findViewById(R.id.imageViewjew);
        ImageView ind1 = view.findViewById(R.id.imageViewd1);
        ImageView ind2 = view.findViewById(R.id.imageViewd2);
        ImageView ind3 = view.findViewById(R.id.imageViewd3);
        Button button1 = view.findViewById(R.id.button);
//        Button buttonback=view.findViewById(R.id.imageViewback);
//        Button buttonnext=view.findViewById(R.id.imageViewnext);
        TextView title = view.findViewById(R.id.textViewtitle);
        TextView subtitle = view.findViewById(R.id.textViewsubtitle);

        ImageView next = view.findViewById(R.id.imageViewnext);
        ImageView back = view.findViewById(R.id.imageViewback);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.Pager.setCurrentItem(position - 1);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.Pager.setCurrentItem(position + 1);
            }
        });


        switch (position) {
            case 0:
                log.setImageResource(R.drawable.goldremove);
                ind1.setImageResource(R.drawable.selected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);

                title.setText("Shopping jewellery");
                subtitle.setText("A jewellery make you beautifully");
                back.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
                button1.setVisibility(View.INVISIBLE);
                break;

            case 1:
                log.setImageResource(R.drawable.gale);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.selected);
                ind3.setImageResource(R.drawable.unselected);

                title.setText("Shopping the way");
                subtitle.setText("A jewellery make you beautifully");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                button1.setVisibility(View.INVISIBLE);
                break;

            case 2:

                log.setImageResource(R.drawable.ear);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.selected);

                title.setText("Pay on Delivery");
                subtitle.setText("A jewellery make you beautifully");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.VISIBLE);
        }

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
