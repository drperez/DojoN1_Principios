package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
                continue;
            }
            
            item.sellIn = item.sellIn - 1;

            if ("Conjured Mana Cake".equalsIgnoreCase(item.name)) {
                item.quality = item.quality - 2;
            } else if ("Aged Brie".equals(item.name)) {
                increaseQuality(item);
                if (item.sellIn < 0) {
                    increaseQuality(item); 
                }
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
                increaseQuality(item);
                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
                    if (item.sellIn < 10) {
                        increaseQuality(item);
                    }
                    if (item.sellIn < 5) {
                        increaseQuality(item);
                    }
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                }

            } else {
                decreaseQuality(item);
                if (item.sellIn < 0) {
                    decreaseQuality(item);
                }
            }     
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public Item decrementSellInSulfuras(Item item) {
        return item;
    }
}
