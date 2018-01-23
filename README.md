# Travie

Sample android app built using Kotlin, RxJava, Dagger 2, Retrofit, and inspired by Clean Architecture.

## Architecture
The app's architecture consists of three layers: 
* presentation
* domain
* data. 

`Presentation` is responsible for handle the presentation logic. There will be a presenter, that manipulates the view. 
The view is an interface which implemented by our activity or fragment, and then passed to the presenter.

`Domain` layer has the app's business logic, and it is platform independent, so that it can be covered with unit tests.

`Data` layer handles interacting with outer world, i.e. processing network calls, caching or persisting data, and etc.

## Tests
Unit tests have been added to test important parts of the app. In order to check them out, please look at `test` package, or 
to run, you need to execute following in your command line:

> `./gradlew test`
