package com.chao.democollector.recyclerview.callback;

import android.support.v7.util.DiffUtil;

/**
 * Created by Jeffery on 17/9/14.
 */

public class DiffCallBack extends DiffUtil.Callback {


    @Override
    public int getOldListSize() {
        return 0;
    }

    @Override
    public int getNewListSize() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}
