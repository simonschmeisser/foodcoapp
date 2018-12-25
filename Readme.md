#  Android FoodCoApp
point-of-sale checkout for food co-ops / food hubs

```
< Kornkammer >
 ------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||

```

Download version v1.3 apk [http://bit.ly/1SwqaUs](http://bit.ly/1SwqaUs)


 
    Copyright (C) 2015, 2016, 2017 by it's authors. Some rights reserved. See LICENSE

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

## How to hack on this

This should help you get started with developing/testing the foodcoapp, it will be written in a mixture of English and Deutsch, were parts in German are specific to our installation in Freiburg while the parts in English should be generally applicable. (Note that neither I nor the original author actually recommend anybody to use this app for a new project!)

Download Android SDK/Android studio for your OS

git clone this repo

open the folder in Android studio. It will download enormous amounts of stuff and display some warnings but it should compile

Create an Android Virtual Device to test it.

Das Gerät in der Kornkammer ist ein Nexus 7 mit Cyanogenmod 11(?) und Android Api Version 25, macht also Sinn sich solch eines als virtuelles Gerät anzulegen.

To enter the "power user interface" in the app you can simulate dual touch by pressing Control/Strg and then moving and clicking both buttons.

For testing import of bank transcripts (Kontoauszüge) or Backups you need to first copy them to the virtual device (View -> Tool Windows -> Device File Explorer) to somewhere in "Documents"/"Android SDK build for ..." (not all places seem to work). Then you need a file manager, I managed to open one by pressing on the virtual sdcard icon top left and clicking "explore". Then navigate to where you put the file (Hamburger menu top left). Click on the file and it will ask "Open with Import". This will start the "import intent" in the app and try to do stuff based on the file ending.

### Deployment

The app uses a salt to encript the user pin (used to authenticate payments). This repo contains a dummy salt. You should change it to your own one before deployment. Otherwise previous pins won't work anymore.

Sowohl Flo, der ursprüngliche Author, als auch Simon Schmeißer (ich) haben den in der Kornkammer verwendeten Salt. Meine Email Adresse findet sich im git log oder schreib an die KK-App Gruppe

## Further development

We intent to fix whatever is too broken or too annoying for daily use but we have no plans to turn this into the one APP to rule them all! Please open Issues describing your problem as good as possible and we will try to fix it or find a workaround.

Ihr könnt eure Probleme gern entweder als Issue anlegen oder mit der App Gruppe diskutieren und wir übernehmen das.

In generall I hope that "we" will be at least two (2) people, let's see how that works. If that turns out to be true we intent to have a pull request (PR) for each new feature/bugfix and have that reviewed and merged by another person.
