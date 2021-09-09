package project.vo;

import lombok.*;

@Getter
@Setter
public
class DaangnVO{
    private String itemTitle;
    private String itemPrice;
    private String searchItem;

    public String getSearchItem() {
        return this.searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }


    // 데이터 가공 코드 첨가 
}