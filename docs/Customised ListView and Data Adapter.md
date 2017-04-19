# Customised ListView and Data Adapter
Tradicional ListViews hold and item per line, typically a String. In this example we want to have a ListView that on each line is composed by the poster of the movie, the name of the movie and the year it was released.

![][image-1]

## Create layout for the item on the Listview
We have to create a new layout file that will contain the layout of each item that will appear on the ListView lines. Let’s call it, for instance, `item_movie.xml`.

This what it look like:

![][image-2]

The XML source-code for this layout [is here][1].

## Create specific adapter for the ListView
Since we don’t have “_out of the box_” an specific adapter that is capable of taking a `Movie` object and map it directly to the layout, we need to create one.


[1]:	https://github.com/pontocom/MovieDatabase/blob/master/app/src/main/res/layout/item_movie.xml

[image-1]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/images/Voila_Capture%202017-04-19_07-40-38_PM.png "Item of the ListView"
[image-2]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/images/Voila_Capture%202017-04-19_07-45-39_PM.png "Layout format"