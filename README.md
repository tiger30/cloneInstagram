# Project - cloneInstagram

cloneInstagram is an android app that allows a user to check out popular photos from Instagram. 

Time spent: 09 hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **scroll through current popular photos** from Instagram
* [X] For each photo displayed, user can see the following details:
  * [X] Graphic, Caption, Username
  * [X] Relative timestamp, like count, user profile image

The following **optional** features are implemented:

* [X] *Advanced*: Add *pull-to-refresh* for popular stream with SwipeRefreshLayout 
* [X] *Advanced*: Show latest comments for each photo
* [ ] *Advanced*: Display each user profile image using a [RoundedImageView](https://github.com/vinc3m1/RoundedImageView)
* [X] *Advanced*: Display a nice default placeholder graphic for each image during loading (read more about Picasso)
* [X] *Advanced*: Improve the user interface through styling and coloring

* [ ] *Bonus*: Allow user to view all comments for an image within a separate activity or dialog fragment
* [X] *Bonus*: Allow video posts to be played in full-screen using the VideoView
* [X] *Bonus*: Apply the popular Butterknife annotation library to reduce view boilerplate

The following **additional** features are implemented:

* [X] Use GSON to create the models from the JSON response instead of manually parsing the JSON
* [X] Display each user profile image using a RoundedImageViewDisplay each user profile image using a [CircleImageView](https://github.com/hdodenhof/CircleImageView)

The following **ADVANCED** features will be implemented:
* [ ] User can login/register/logout an Instagram account.
* [ ] User can pick picture from Android gallery as well as taking a photo by camera.
* [ ] Using RecycleView to display all uploaded photos.
* [ ] When user taps on a photo in the photo list screen, open up a photo viewer screen. This photo viewer screen should enlarge the photo and support gesture zooming.

* [ ] Test

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='https://github.com/tiger30/cloneInstagram/blob/master/Resources/Demo.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [Recordit](http://recordit.co/).

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android
- [Butterknife](https://github.com/JakeWharton/butterknife) - reduce view boilerplate
- [GSON](https://github.com/google/gson) - Java serialization library for converting Java objects to JSON
- [CircleImageView](https://github.com/hdodenhof/CircleImageView) - circular image view

## Notes

Describe any challenges encountered while building the app.
- Genymotion can not create an emulator on my laptop, so i always use my Nexus as the test device. Somehow Android Studio couldn't connect with my phone last night.
- Using butterknife in the first time.


## License

    Free
    Copyright 2016 haiDang Ngo
