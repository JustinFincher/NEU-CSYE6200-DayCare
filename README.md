# DayCare Project

> GitHub repo for NEU CSYE6200 'DayCare' group assignment 

![Java CI with Gradle](https://github.com/JustinFincher/NEU-CSYE6200-DayCare/workflows/Java%20CI%20with%20Gradle/badge.svg)
![Native Executables](https://github.com/JustinFincher/NEU-CSYE6200-DayCare/workflows/Native%20Executables/badge.svg)
![[DayCare on Notion](https://www.notion.so/haotianzheng/Day-Care-Project-2dd785efa2bd46fb86c105c362ae5d76)](https://img.shields.io/badge/DayCare-on%20Notion-brightgreen)

## TOC


## Team members
- Haotian Zheng (@JustinFincher)
- Jingru Xiang
- Rongqi Sun
- Dawei Gu (@dwg31)
- Cheng Qian (@Aiden-Qian)
- Lan Gao

## Requirements
- NetBeans 12.0 (or IDEA 2020.2)
- JDK 8 with `JAVA_HOME` pointing to it
- A database viewer like [SQLite Browser](https://sqlitebrowser.org/dl/) (optional)

## Editing Guide

For NetBeans users:

- In `Tools/Plugins`, make sure `Gradle`, `Groovy and Gradle`, `Java SE`, and `Java` are all installed
- If you want to add swingx components to your GUI Designer:
    - Download `swingx.jar` from [Maven Repository](https://mvnrepository.com/artifact/org.swinglabs.swingx/swingx-all/1.6.5-1) (click jar button to download)
    - In `Tools/Palette/Swing AWT Components`, choose "Add from JAR..."
    - Select the `swing.jar` you just downloaded, and select all beans to import.
    - Now swingx components are visible on your GUI Designer palette.
