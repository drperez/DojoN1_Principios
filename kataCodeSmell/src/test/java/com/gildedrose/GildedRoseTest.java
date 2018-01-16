package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

  Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 1, 1) };

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void decrementarItemSulfuras(){
      GildedRose app = new GildedRose(this.items);
      Item item = app.decrementarSellInSulfuras(app.items[0]);
      
      assertEquals(0, item.sellIn);
      assertEquals("Sulfuras, Hand of Ragnaros", item.name);
    }
}
