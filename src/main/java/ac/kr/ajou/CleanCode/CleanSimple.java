package ac.kr.ajou.CleanCode;

public class CleanSimple {

    Item[] items;

    public CleanSimple(Item[] items) {
        this.items = items;
    }
    //코드 의도 파악 -> 테스트를 만들어라 -> refactoring해라 -> refactoring 과정 작성
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                Reduce_Quality_UnlessName_Is_Sulfuras(items, i);
            }
            else {
                Handle_Insufficient_Quality(items, i);
            }
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (items[i].sellIn < 0) {
                Handle_Insufficient_SellIn(items, i);
            }
        }
    }


    public static void Reduce_Quality_UnlessName_Is_Sulfuras(Item[] items, int i) {
        if (items[i].quality > 0) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    public static void Handle_Insufficient_Quality(Item[] items, int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;

            Handle_Backstage_Passes(items, i);
        }
    }

    public static void Handle_Backstage_Passes(Item[] items, int i) {
        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            Update_Quality_Based_On_Quality_And_SellIn(items, i);
        }
    }

    public static void Update_Quality_Based_On_Quality_And_SellIn(Item[] items, int i) {
        if (items[i].sellIn < 11 && items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
        if (items[i].sellIn < 6 && items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

    public static void Handle_Insufficient_SellIn(Item[] items, int i) {
        if (!items[i].name.equals("Aged Brie")) {
            Handle_Items_That_Are_Not_AgedBrie(items, i);
        }
        else {
            Handle_Other_Items(items, i);
        }
    }

    public static void Handle_Items_That_Are_Not_AgedBrie(Item[] items, int i) {
        if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            If_Not_Sulfuras_And_Quality_Is_Sufficient(items, i);
        }
        else {
            items[i].quality = 0;
        }
    }

    public static void If_Not_Sulfuras_And_Quality_Is_Sufficient(Item[] items, int i){
        if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].quality = items[i].quality - 1;
        }
    }

    public static void Handle_Other_Items(Item[] items, int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

}