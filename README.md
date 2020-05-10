<img src="https://raw.githubusercontent.com/RedMadRobot/input-mask-ios/assets/Assets/input-mask-cursor.gif" alt="Input Mask" height="40" />

[![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat-square)](https://android-arsenal.com/api?level=14)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg?style=flat-square)]()
[![source](https://img.shields.io/badge/forked-RedMadRobot/input--mask--android-red?style=flat-square)](https://github.com/RedMadRobot/input-mask-android)

<img src="https://github.com/RedMadRobot/input-mask-android/blob/assets/assets/gif-animations/direct-input.gif" alt="Direct input" width="210"/>

## Description

`Input Mask` is an [Android](https://github.com/RedMadRobot/input-mask-android) & [iOS](https://github.com/RedMadRobot/input-mask-ios) native library allowing to format user input on the fly.

The library provides you with a text field listener; when attached, it puts separators into the text while user types it in, and gets rid of unwanted symbols, all according to custom predefined pattern.

This allows to reformat whole strings pasted from the clipboard, e.g. turning pasted `8 800 123-45-67` into  
`8 (800) 123 45 67`.

Each pattern allows to extract valuable symbols from the entered text, returning you the immediate result with the text field listener's callback when the text changes. Such that, you'll be able to extract `1234567` from `8 (800) 123 45 67` or `19991234567` from `1 (999) 123 45 67` with two different patterns.

All separators and valuable symbol placeholders have their own syntax. We call such patterns "masks".

Mask examples:

1. International phone numbers: `+1 ([000]) [000] [00] [00]`
2. Local phone numbers: `([000]) [000]-[00]-[00]`
3. Names: `[A][-----------------------------------------------------]` 
4. Text: `[A…]`
5. Dates: `[00]{.}[00]{.}[9900]`
6. Serial numbers: `[AA]-[00000099]`
7. IPv4: `[099]{.}[099]{.}[099]{.}[099]`
8. Visa card numbers: `[0000] [0000] [0000] [0000]`
9. MM/YY: `[00]{/}[00]`
10. UK IBAN: `GB[00] [____] [0000] [0000] [0000] [00]`

## Questions & Issues

Check out our [wiki](https://github.com/RedMadRobot/input-mask-android/wiki) for further reading.  
Please also take a closer look at our [Known issues](https://github.com/RedMadRobot/input-mask-android#knownissues) section before you incorporate our library into your project.

For your bugreports and feature requests please file new issues as usually.

Should you have any questions, search for closed [issues](https://github.com/RedMadRobot/input-mask-android/issues?q=is%3Aclosed) or open new ones at **[StackOverflow](https://stackoverflow.com/questions/tagged/input-mask)** with the `input-mask` tag.

We also have a community-driven [cookbook](https://github.com/RedMadRobot/input-mask-android/blob/master/Documentation/COOKBOOK.md) of recipes, be sure to check it out, too.

<a name="installation" />

## Installation

### Gradle

Make sure you've added Kotlin support to your project.

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
        implementation 'com.github.lndmflngs:input-mask-android:1.0.0'
}
```

## Special thanks

These folks rock:

* Artem [Fi5t](https://github.com/Fi5t) Kulakov
* Nikita [nbarishok](https://github.com/nbarishok) Barishok
* Roman [yatsinar](https://github.com/yatsinar) Iatcyna
* Alexander [xanderblinov](https://github.com/xanderblinov) Blinov
* Vladislav [Shipaaaa](https://github.com/Shipaaaa) Shipugin
* Vadim [vkotovv](https://github.com/vkotovv) Kotov

# License

The library is distributed under the MIT [LICENSE](https://opensource.org/licenses/MIT).
