# Gilded Rose Kata

## Description
This Kata was originally created by Terry Hughes (http://twitter.com/TerryHughes). It is already on GitHub here. 
See also Bobby Johnson's [description](https://iamnotmyself.com/refactor-this-the-gilded-rose-kata/) of the kata.

I get translated to Kotlin sources from Emily Bache [repository](https://github.com/emilybache/GildedRose-Refactoring-Kata). 
I did some preparation because original sources are not really convenient to use out-of-the-box. 
Feel free to use first commits as a starter.

## Requirements
[Gilded Rose Kata Requirements](REQUIREMENTS.MD)

## Solution
## SPOILER ALERT! SOLVE IT FIRST BY YOURSELF!

First of all, I noticed a variety of Items with a different 'aging' strategies: 'Item' class hierarchy. 
Also, I clearly saw from the requirements that the original Item should be treated as a component that I don't own. 
That's why I decided to wrap a 'third-party' Item with my own Domain Item class and put it on top of the hierarchy. 
So, any changes in 'third-party' Item would entail changes only in Domain Item. 
In addition, I wanted to add a more expressive protected API for subclasses, instead of the sparse setters to work 
safely with 'third-party' Item. 

Abstract Item class is pretty hard to test, but I decided to do it because I didn't want to pollute code with 
exposing protected API or duplicate these tests among subclasses (test triviality). 
To do it, I was forced to implement complex Test Item Fake with ugly setting up during Arrange phase.

Items can be instantiated with Static Factory Methods because it is a good place to put validations and construction logic in. 
Factories throw AssertionError as a Validation Error for simplicity. 

Probably, a client doesn't want to know about Items' so I added GildedRoseFactory as a high-level API which 
encapsulates Item name pattern -> Item type matching logic. 

_Time spent: 3 hours_
