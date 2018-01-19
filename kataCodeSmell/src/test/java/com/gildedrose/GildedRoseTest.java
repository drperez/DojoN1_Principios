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
    
}
