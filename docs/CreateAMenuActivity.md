# Creating a new Activity to implement a menu
This is an Activity that will be used just to start the demo, allowing the user to go through the **simple version** of the application (as it was implemented in the [MovieSearch application example][1]) or a more complex version that demonstrates the usage of a configured **ListView** that will display on the search results, immediately the name of the movie, the year and the poster.

## Create a new empty activity
Start by creating an **Empty Activity** on Android Studio. You may name this new activity has `MenuActicity`.

After this, you have to go to your project `AndroidManifest.xml` file and change it to refer that your `MainActivity` is no longer the **LAUNCHER** activity on your application, and the `MenuActivity` will be the new **LAUNCHER** activity (`<category android:name="android.intent.category.LAUNCHER" />`).

````xml
\<application  
    android:allowBackup="true"  
    android:icon="@mipmap/ic_launcher"  
    android:label="@string/app_name"  
    android:roundIcon="@mipmap/ic_launcher_round"  
    android:supportsRtl="true"  
    android:theme="@style/AppTheme"\>  
    \<activity android:name=".MainActivity" /\>  
    \<activity android:name=".MovieDetailsActivity" /\>  
    \<activity android:name=".MenuActivity"\>  
        \<intent-filter\>  
            \<action android:name="android.intent.action.MAIN" /\>  
  
            \<category android:name="android.intent.category.LAUNCHER" /\>  
        \</intent-filter\>  
    \</activity\>  
\</application\>
````

## Design the layout of the MenuActivity

[1]:	https://github.com/pontocom/MovieSearch