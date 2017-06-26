package com.dianxinos.optimizer.module.recommend.card.presenter;

/**
 * Created by zhangtengyuan on 15/10/29.
 */
public interface ICardPresenter {
    public void buildCardData();

    public int getCardCount();

    public void resumenCards();

    public void destoryCards();

    public void refreshCardData(int checkedId);
}
