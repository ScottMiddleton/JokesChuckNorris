# Jokes - Chuck Norris

## Objective
The application should display a list of random jokes. The application should request the jokes
asynchronously when the application is opened. The number of jokes requested should be
random. This random number should be a number between 8 and 21. For the purpose of this
exercise, you can ignore duplicate jokes

## Deliverables
We expect you to create an Android Studio project that can be accessed by us via a
version-controlled repository (e.g., Github, Bitbucket), preferably with multiple commits so we
can see your progress while developing the application.
The application should target the latest version of Android and have version 24 (Nougat) as the
minimum supported version.
You are free to use whatever library you feel is appropriate to complete the task.
If you are unsure how best to proceed during the course of the exercise you should use your
own judgment to create what you think is the best solution. Part of this exercise is to see how
you approach problem-solving in the context of software development.

## Implementation
The application follows an MVVM, clean architecture pattern and I have used Hilt for dependency injection. 

The architecture setup for this project has been built with the intention that the application could easily scale should additional features be included.
Should we want to add many more features a multi-module setup could be considered.

The list implements swipe to refresh to load a new set of randomised jokes. Unit tests are provided for the GetRandomJokes use case and the JokesRepository. 
