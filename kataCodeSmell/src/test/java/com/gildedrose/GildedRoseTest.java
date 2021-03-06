package com.gildedrose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void decrementQualityAndSellInByOne() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 10), new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
        
        assertEquals("Elixir of the Mongoose", app.items[1].name);
        assertEquals(4, app.items[1].sellIn);
        assertEquals(6, app.items[1].quality);
    }

    @Test
    public void validateQualityOfAnItemNegative() {
        Item[] items = new Item[] { 
                new Item("+5 Dexterity Vest", -1, 0) };
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
        
        assertNotEquals(-1, item.quality);
    }
    
    @Test
    public void validateQualityOfAnItemNoMajorToFifty() {
        Item[] items = new Item[] { 
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }
    
    @Test
    public void validateQualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { 
                new Item("+5 Dexterity Vest", -1, 20) };
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("+5 Dexterity Vest", item.name);
        assertEquals(-2, item.sellIn);
        assertEquals(18, item.quality);
    }
    
    @Test
    public void validateAgedBrieIncreaseInQualityWithTime() {
        Item[] items = new Item[] { 
                new Item("Aged Brie", 1, 5),
                new Item("Aged Brie", -2, 4)};
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item itemOne = app.items[0];
        
        assertEquals("Aged Brie", itemOne.name);
        assertEquals(0, itemOne.sellIn);
        assertEquals(6, itemOne.quality);
        
        Item itemTwo = app.items[1];
        
        assertEquals("Aged Brie", itemTwo.name);
        assertEquals(-3, itemTwo.sellIn);
        assertEquals(6, itemTwo.quality);
    }
    
    @Test
    public void validateBackstagePassesQualityDropsToZero() {
        Item[] items = new Item[] { 
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }
    
    @Test 
    public void validateBackstagePassesQualityIncreasesByTwoWithTenDaysOrLess() {
        Item[] items = new Item[] { 
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(9, item.sellIn);
        assertEquals(12, item.quality);
    }
 
    @Test 
    public void validateBackstagePassesQualityIncreasesByThreeWithFiveDaysOrLess() {
        Item[] items = new Item[] { 
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(2, item.sellIn);
        assertEquals(13, item.quality);
    }
    
    @Test
    public void validateSulfurasNeverHasToBeSold() {
        Item[] items = new Item[] { 
                new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("Sulfuras, Hand of Ragnaros", item.name);
        assertEquals(5, item.sellIn);
        assertEquals(80, item.quality);
        
    }
    
    @Test
    public void validateConjuredQualityIncrement() {
        Item[] items = new Item[] { 
                new Item("Conjured Mana Cake", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("Conjured Mana Cake", item.name);
        assertEquals(4, item.sellIn);
        assertEquals(8, item.quality);
        
    }
    
}
