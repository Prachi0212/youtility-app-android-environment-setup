package com.youtility.scene.onboarding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youtility.R;
import com.youtility.common.Constants;

public class OnboardingPagerAdapter extends PagerAdapter {

    private final int[] imgResIds;
    private final String[] bottomTexts;
    private final String[] topTexts;
    private Context context;

    public OnboardingPagerAdapter(Context context, String[] topTexts, String[] bottomTexts, int[] imgResIds) {
        this.topTexts = topTexts;
        this.bottomTexts = bottomTexts;
        this.imgResIds = imgResIds;
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, final int position) {
        ViewGroup layout = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.item_pager_onboarding, collection, false);
        TextView tvTop = layout.findViewById(R.id.tvTop);
        TextView tvBottom = layout.findViewById(R.id.tvBottom);
        ImageView ivCentreImg = layout.findViewById(R.id.ivCentreImg);
        populateTexts(position, tvTop, tvBottom);
        ivCentreImg.setImageResource(imgResIds[position]);
        collection.addView(layout);
        return layout;
    }

    private void populateTexts(int position, TextView tvTop, TextView tvBottom) {
        Spannable wordToSpan = new SpannableString(topTexts[position]);
        switch (position) {
            case 0:
                wordToSpan.setSpan(new ForegroundColorSpan(context.getColor(R.color.colorAccent)), topTexts[position].indexOf(context.getString(R.string.home_finances)), topTexts[position].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tvBottom.setText(bottomTexts[position]);
                break;
            case 1:
                wordToSpan.setSpan(new ForegroundColorSpan(context.getColor(R.color.colorAccent)), 0, context.getString(R.string.switch_providers).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tvBottom.setText(bottomTexts[position]);
                break;
            case 2:
                wordToSpan.setSpan(new ForegroundColorSpan(context.getColor(R.color.colorAccent)), topTexts[position].indexOf(context.getString(R.string.bank_accounts)), topTexts[position].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Spannable bottomWordToSpan = new SpannableString(bottomTexts[position]);
                bottomWordToSpan.setSpan(new ForegroundColorSpan(context.getColor(R.color.darkPurple)), bottomTexts[position].indexOf(context.getString(R.string.financial_conduct_authority)), bottomTexts[position].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tvBottom.setText(bottomWordToSpan);
                break;
            case 3:
                wordToSpan.setSpan(new ForegroundColorSpan(context.getColor(R.color.colorAccent)), topTexts[position].indexOf(context.getString(R.string.citizens_advice)), topTexts[position].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tvBottom.setText(bottomTexts[position]);
                break;
        }
        tvTop.setText(wordToSpan);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return bottomTexts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constants.General.EMPTY;
    }

    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
