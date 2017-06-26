package com.dianxinos.optimizer.module.recommend.card.presenter;


/**
 * Card Presenter
 * <p/>
 * 卡片组的数据绑定与特定操作
 * Created by zhangtengyuan on 15/10/29.
 */
public class CardPresenter implements ICardPresenter {
    private ICardView mCardView;

    public CardPresenter(ICardView view) {
        mCardView = view;
        //controller
    }

    @Override
    public void buildCardData() {
        mCardView.buildCards();
    }

    @Override
    public int getCardCount() {
        return 0;
    }

    @Override
    public void resumenCards() {
        mCardView.resumeCardViews();
    }

    @Override
    public void destoryCards() {
        mCardView.destoryCardViews();
    }

    @Override
    public void refreshCardData(int checkedId) {
        mCardView.refreshCard();
    }
}
