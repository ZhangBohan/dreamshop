package me.nengzhe.goods.dto;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午10:34
 */
public class GoodsSearch {
    private String text;

    @Override
    public String toString() {
        return "GoodsSearch{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
