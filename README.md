# DayCare Project

> GitHub repo for NEU CSYE6200 'DayCare' group assignment 

![Java CI with Gradle](https://github.com/JustinFincher/NEU-CSYE6200-DayCare/workflows/Java%20CI%20with%20Gradle/badge.svg)
![Native Executables](https://github.com/JustinFincher/NEU-CSYE6200-DayCare/workflows/Native%20Executables/badge.svg)
![Java Docs](https://github.com/JustinFincher/NEU-CSYE6200-DayCare/workflows/Java%20Docs/badge.svg)
[![](https://img.shields.io/badge/DayCare-on%20Notion-brightgreen)](https://www.notion.so/haotianzheng/Day-Care-Project-2dd785efa2bd46fb86c105c362ae5d76)
[![](https://img.shields.io/badge/View-JavaDoc-blue)](https://justinfincher.github.io/NEU-CSYE6200-DayCare/)

## TOC

## Team members
- Haotian Zheng ([@JustinFincher](https://github.com/JustinFincher))
- Jingru Xiang ([@RubyXiang](https://github.com/RubyXiang))
- Rongqi Sun ([@Svelar](https://github.com/Svelar))
- Dawei Gu ([@dwg31](https://github.com/dwg31))
- Cheng Qian ([@Aiden-Qian](https://github.com/Aiden-Qian))
- Lan Gao ([GL-gaolan](https://github.com/GL-gaolan))

## Requirements
- NetBeans 12.0 (or IDEA 2020.2)
- JDK 8 with `JAVA_HOME` pointing to it
- A database viewer like [SQLite Browser](https://sqlitebrowser.org/dl/) or [Database Panel](https://www.jetbrains.com/help/idea/database-tool-window.html) in IDEA Ultimate (optional)

## Conventions
- Git message: [conventional commits](https://www.conventionalcommits.org/zh-hans/v1.0.0-beta.4/)
- Working branches: `dev/<your name>`

## Editing Guide

For NetBeans users:

- In `Tools/Plugins`, make sure `Gradle`, `Groovy and Gradle`, `Java SE`, and `Java` are all installed
- If you want to add swingx components to your GUI Designer:
    - Download `swingx.jar` from [Maven Repository](https://mvnrepository.com/artifact/org.swinglabs.swingx/swingx-all/1.6.5-1) (click jar button to download)
    - In `Tools/Palette/Swing AWT Components`, choose "Add from JAR..."
    - Select the `swing.jar` you just downloaded, and select all beans to import.
    - Now swingx components are visible on your GUI Designer palette.

## CI

```
// Mac users only
sudo xattr -rd com.apple.quarantine DayCare.app
```