package com.igroup.signals.trial.HanWang.model;

/**
 * this class contains the basic information displayed in the page.
 */
public class PageStockInform
{

    private StockBasic stockBasic;
    private StockCompany stockCompany;
    private NewsLink newsLink;

    public StockBasic getStockBasic() {
        return stockBasic;
    }

    public void setStockBasic(StockBasic stockBasic) {
        this.stockBasic = stockBasic;
    }

    public StockCompany getStockCompany() {
        return stockCompany;
    }

    public void setStockCompany(StockCompany stockCompany) {
        this.stockCompany = stockCompany;
    }

    public NewsLink getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(NewsLink newsLink) {
        this.newsLink = newsLink;
    }
}
