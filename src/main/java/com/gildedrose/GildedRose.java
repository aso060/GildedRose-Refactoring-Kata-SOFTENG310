package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            boolean isAgedBrie = item.name.equals("Aged Brie");
            boolean isBackstagePass = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
            boolean isConjured = item.name.contains("Conjured");

            if (!isAgedBrie && !isBackstagePass && item.quality > 0 && !isSulfuras) {
                item.quality--;
                // conjured items degrade twice as fast as standard items
                if (isConjured && item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    if (isBackstagePass) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras) {
                item.sellIn = item.sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                // could be simplified to items[i].quality--;
                                items[i].quality--;
                            }
                        }
                    } else {
                        // could be simplified to items[i].quality = 0;
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        // could be simplified to items[i].quality++;
                        items[i].quality++;
                    }
                }
            }
        }
    }
}