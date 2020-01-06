package com.gildedrose

import org.scalatest.Matchers

trait TestComons {
  self: Matchers =>

  def gildedRoseWithItem(name: String, sellIn: Int, quality: Int): (Item, GildedRose) = {
    val item = new Item(name, sellIn, quality)
    item -> new GildedRose(Array(item))
  }

  def itemAfterOnTwoSteps(name: String, sellIn: Int, quality: Int)
                         (sellIn1: Int, quality1: Int, sellIn2: Int, quality2: Int): Unit = {
    val (item, gildedRose) = gildedRoseWithItem(name, sellIn, quality)

    gildedRose.updateQuality()
    item.quality should be (quality1)
    item.sellIn should be (sellIn1)

    gildedRose.updateQuality()
    item.quality should be (quality2)
    item.sellIn should be (sellIn2)
  }

}
