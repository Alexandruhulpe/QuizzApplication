# quiz-android

## Copyright © 2016 Samuel Walladge

Simple quiz app for testing your knowledge on capital cities.


## INFO

- minimum api set is api 19 (kitkat)
- tested on and optimized for api 23 (marshmallow)


## FEATURES

Within scope:

- contains a banner image on the main activity to announce itself
- ability to reset your saved answers and highscore
- contains XX questions
- automatically saves answers while taking the quiz for resuming later
- results screen gives feedback on individual answers (including showing correct answer in cases where you gave the wrong answer)
- counts and displays your score (percentage of correct answers)
- all questions are multiple choice and include a "don't know" option
- webview for an "about" page

Extra features:

- stores the highscore (Beat your previous score! Compete with your friends!)
- back button overridden where required to make it more useful within the app
- custom launcher icon with support for a range of different dpi
- confirmation dialogs for major actions (reset answers, submit quiz, etc.)
- full localization support with use of resources (for strings, images, and files)
- French translation included

## TODO

- more questions

## SCREENSHOTS

### Main activity

![main activity in english](screenshots/main-en.png)

### Also with landscape

![landscape main activity](screenshots/main-landscape-en.png)

### And main activity in French

![main activity in french](screenshots/main-fr.png)

### About view

![about page in english](screenshots/about-en.png)

### Question view (French)

![question page in french](screenshots/question-fr.png)

### With warning dialogs when needed

![confirm dialog on reset](screenshots/dialog-en.png)


## LICENSE

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
