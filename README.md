# jgd-library


[![GitHub (pre-)release](https://img.shields.io/github/release/tjcde/jgd-library/all.svg)](https://github.com/tjcde/jgd-library/releases/latest)
[![GitHub downloads](https://img.shields.io/github/downloads/tjcde/jgd-library/total.svg)](#)
[![GitHub closed issues](https://img.shields.io/github/issues-closed-raw/tjcde/jgd-library.svg)](#)
[![GitHub](https://img.shields.io/github/license/tjcde/jgd-library.svg)](#)

**JGD-library** is a Java library that uses [Graphics2D](https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html) and [JFrame](https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html). With this library it is easier to create a frame. Since the library works with Graphics2D you have much more possibilities to design the individual components of your frame.

## Getting started
Create a new `JGDWindow` and initialize it with the `run()` function.
Note: Don't forget to make it visible.
```java
JGDWindow window = new JGDWindow();
window.run();
window.setVisible(true);
```
If you run the code, you should be able to see a simple JFrame on the screen.

Next we will create a `JGDComponent` which will be added to the frame.
```java
JGDComponent comp = new JGDComponent(window.getContainer(), 1000){
...
};
```
Since this is not the whole code you will get some errors first. So let's fix it.
Just add the *unimplemented method*s to the component.



