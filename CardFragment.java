package com.dianxinos.optimizer.module.appmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dianxinos.common.ui.fragment.DxFragment;
import com.dianxinos.optimizer.module.recommend.card.bean.Card;
import com.dianxinos.optimizer.module.recommend.card.cardview.CardView;
import com.dianxinos.optimizer.module.recommend.card.presenter.CardPresenter;
import com.dianxinos.optimizer.module.recommend.card.presenter.ICardView;
import com.dianxinos.optimizer.utils.LogHelper;

import java.util.ArrayList;

import cn.opda.a.phonoalbumshoushou.R;

/**
 * Created by zhangtengyuan on 15/10/18.
 */
public class CardFragment extends DxFragment implements ICardView {
    private CardView cardsView;
    private CardPresenter mCardPresenter;
    private ArrayList<Card> cards;

    @Override
    public void onResume() {
        super.onResume();
        LogHelper.i("Card", "CardFragment on resume");
        mCardPresenter.resumenCards();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.card_fragment_demo, container, false);
        mCardPresenter = new CardPresenter(this);
        initView();
        initEvent();
        initData();
        return mMainView;
    }

    private void initView() {
        mCardPresenter.buildCardData();

    }

    private void initEvent() {
    }

    private void initData() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogHelper.i("Card", "CardFragment on destory");
        mCardPresenter.destoryCards();
    }

    @Override
    public void buildCards() {
        cardsView = (CardView) mMainView.findViewById(R.id.cards_view);
//        cards = CardController.getInstance().createCardViews(getActivity(), cardsView);
    }

    @Override
    public void refreshCard() {
        if (cards != null && cards.size() > 0) {
            for (Card card : cards) {
                if (card != null) {
                    card.notifiyDataChanged();
                }
            }
        }
    }

    @Override
    public void resumeCardViews() {
        if (cards != null && cards.size() > 0) {
            for (Card card : cards) {
                if (card != null) {
                    card.resume();
                }
            }
        }
    }

    @Override
    public void destoryCardViews() {
        if (cards != null && cards.size() > 0) {
            for (Card card : cards) {
                if (card != null) {
                    card.destroy();
                }
            }
        }
        if (cardsView != null) {
            cardsView.removeAllViews();
        }
    }
}
