# Project 1 - cloneInstagram

Instagram is an android app that allows a user to check out popular photos from Instagram. 
Time spent: 09 hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **scroll through current popular photos** from Instagram
* [X] For each photo displayed, user can see the following details:
  * [X] Graphic, Caption, Username
  * [X] Relative timestamp, like count, user profile image

The following **optional** features are implemented:

* [X] *Advanced* Add *pull-to-refresh* for popular stream with SwipeRefreshLayout 
* [X] *Advanced* Show latest comments for each photo
* [X] *Advanced* Display each photo with the same style and proportions as the real Instagram
* [ ] Display each user profile image using a RoundedImageViewDisplay each user profile image using a [RoundedImageView](https://github.com/vinc3m1/RoundedImageView)
* [X] Display a nice default placeholder graphic for each image during loading
* [X] Improved the user interface through styling and coloring

The following **bonus** features are implemented:

* [X] Show last 2 comments for each photo
* [ ] Allow user to view all comments for an image within a separate activity or dialog fragment
* [X] Allow video posts to be played in full-screen using the VideoView


The following **additional** features are implemented:

* [X] Apply the Butterknife annotation library to reduce view boilerplate. 
* [X] Use GSON to create the models from the JSON response instead of manually parsing the JSON
* [ ] Display each user profile image using a RoundedImageViewDisplay each user profile image using a [RoundedImageView](https://github.com/vinc3m1/RoundedImageView)

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='https://cloud.githubusercontent.com/assets/1521460/12875699/902372da-cda4-11e5-8128-173cfd917d57.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.
- Genymotion can not create an emulator on my laptop, so i always use my Nexus as the test device. Somehow Android Studio couldn't connect with my phone last night.
- Using butterknife in the first time.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android
- [Butterknife](https://github.com/JakeWharton/butterknife) - reduce view boilerplate
- [GSON](https://github.com/google/gson) - Java serialization library for converting Java objects to JSON
- [CircleImageView](https://github.com/hdodenhof/CircleImageView) - circular image view


## License

    Copyright 2016 haiDang Ngo