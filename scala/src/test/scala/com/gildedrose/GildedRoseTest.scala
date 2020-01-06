package com.gildedrose

import org.scalatest._

class GildedRoseTest extends FlatSpec with Matchers with TestComons {

  it should "degrade quality and sell in date" in {
    itemAfterOnTwoSteps("Testas", 5, 30)(4, 29, 3, 28)
  }

  it should "degrade quality twice as fast after sell in date" in {
    itemAfterOnTwoSteps("Testas", 1, 30)(0, 29, -1, 27)
  }

  it should "not decrease quality below 0" in {
    itemAfterOnTwoSteps("Testas", 1, 2)(0, 1, -1, 0)
  }

  it should "increase quality for \"Aged Brie\" items" in {
    itemAfterOnTwoSteps("Aged Brie", 5, 0)(4, 1, 3, 2)
  }

  it should "limit quality up to 50" in {
    itemAfterOnTwoSteps("Aged Brie", 5, 49)(4, 50, 3, 50)
  }

  it should "'Sulfuras' newer to be sold and Quality is always 80" in {
    itemAfterOnTwoSteps("Sulfuras item", 0, 80)(0, 80, 0, 80)
  }

  it should "'Backstage passes' should increase quality by one up to 10 days left" in {
    itemAfterOnTwoSteps("Backstage passes to concert", 20, 10)(19, 11, 18, 12)
  }

  it should "'Backstage passes' should increase quality by two up to 5 days left" in {
    itemAfterOnTwoSteps("Backstage passes to concert", 10, 10)(9, 12, 8, 14)
  }

  it should "'Backstage passes' should increase quality by two up to 0 days left" in {
    itemAfterOnTwoSteps("Backstage passes to concert", 5, 10)(4, 13, 3, 16)
  }

  it should "'Backstage passes' should make quality 0 on day 0" in {
    itemAfterOnTwoSteps("Backstage passes to concert", 1, 10)(0, 13, -1, 0)
  }

  it should "degrade Conjured quality and sell in date" in {
    itemAfterOnTwoSteps("Conjured Testas", 5, 30)(4, 28, 3, 26)
  }

  it should "degrade Conjured quality twice as fast after sell in date" in {
    itemAfterOnTwoSteps("Conjured Testas", 1, 30)(0, 28, -1, 24)
  }

  it should "not decrease Conjured quality below 0" in {
    itemAfterOnTwoSteps("Conjured Testas", 1, 3)(0, 1, -1, 0)
  }

}