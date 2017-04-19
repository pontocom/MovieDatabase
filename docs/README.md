# MovieDatabase application
This example, builds on top of what was achieved in the [MovieSearch application example][1], and introduces some more details, such as the usage of a complex **ListView**.

Please refer to the [MovieSearch application example][2] first, **following the steps depicted there**, and then continue to make the changes proposed here to extend its functionalities.

This sample depends on Volley for the network API calls and [Glide][3] to 
download and show the images. Moreover, this project uses the awesome [Open Movie Database][4]
that allows the usage of their own API to get information about movies.

![Architeture of the application][image-1]

The following image depicts the layout and the storyboard of our application.
![Layout and storyboard of the application][image-2]

The additional steps that are needed to complete this example are the following:
1. [Add an additional activity for the menu][5]
2. [Create new activity for complex Listview][6]
3. [Create a customised ListView and develop an customised data adapter][7]


So, go ahead to the first step and [add an additional activity for the menu][8].

[1]:	https://github.com/pontocom/MovieSearch
[2]:	https://github.com/pontocom/MovieSearch
[3]:	https://github.com/bumptech/glide
[4]:	http://www.omdbapi.com
[5]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/CreateAMenuActivity.md
[6]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/CreateComplexActivity.md
[7]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/Customised%20ListView%20and%20Data%20Adapter.md
[8]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/CreateAMenuActivity.md

[image-1]:	https://github.com/pontocom/MovieSearch/blob/master/docs/images/Voila_Capture%202017-04-17_09-49-43_PM.png
[image-2]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/images/Voila_Capture%202017-04-19_12-05-47_PM.png