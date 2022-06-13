# Software Requirements Specification
## For "Fancy Calculator"
Version 1.0 approved

Prepared by Lyhin Illia


30.05.2022

Table of Contents
=================
  * [Introduction](introduction)
    * 1.1 [Purpose](purpose)
    * 1.2 [Document Conventions](document-conventions)
    * 1.3 [Intended Audience and Reading Suggestions](intended-audience-and-reading-suggestions)
    * 1.4 [Product Scope](product-scope)
  * [Overall Description](overall-description)
    * 2.1 [Product Perspective](product-perspective)
    * 2.2 [Product Functions](product-functions)
    * 2.3 [Operating Environment](operating-environment)
    * 2.4 [Design and Implementation Constraints](design-and-implementation-constraints)
  * [System Features](system-features)
    * 3.1 [Display of entered digits](display-of-entered-digits)
    * 3.2 [Display of the last previous entered number](display-of-the-last-previous-entered-number)
    * 3.3 [Input Tool](input-tool)
  * [Other Nonfunctional Requirements](other-nonfunctional-requirements)
    * 4.1 [Performance Requirements](performance-requirements)
    * 4.2 [Security Requirements](security-requirements)
* [Appendix A: Glossary](appendix-a-glossary)




## 1. Introduction 
### 1.1 Purpose 

This SRS describes a Calculator application for smartphones and tablets with Android operating system. 

### 1.2 Document Conventions
Every requirement statement in this document has its own priority. This SRS document shoud be in "Markdown" format and follow the IEEE standart for SRS document.

### 1.3 Intended Audience and Reading Suggestions
This document intended for developers, users, testers and project managers.

### 1.4 Product Scope
The purpose of this software is to provide a convenient way of simple and accounting calculations using your Android smartphone. 

## Overall Description
### 2.1 Product Perspective
This project is single, has no parent projects, let alone parent SRS. The product will be an application for Android phones and tablets. Supported versions of the operating system can be found in the **2.4** section.

### 2.2 Product Functions
The application should have all the functions of a conventional calculator (addition, subtraction, multiplication and division) and also the function of taking a percentage of a previously entered number (for the convenience of an accountant). Details will be provided in Section 3.

### 2.3 Operating Environment

* Android version — 5.0 (API level 21) and higher.
* RAM — Minimum RAM of 2 GB.
* Processor modes — Qualcomm Snapdragon (version 630 and higher), Samsung Exynos, Hisilicon Kirim.

### 2.4 Design and Implementation Constraints
* SRS should be done before 2022.07.08.
* Application's user iterface must be done before 2022.07.13.
* MVP should be done before 2022.07.20.


## System Features

### 3.1 Display of entered digits
The display of entered digits must display at least 6 characters before and after the delimiter.

### 3.2 Display of the last previous entered number
The display should be smaller than the main one and display the number that was used in the previous action.

### 3.3 Input Tool
The components of the tool must be unified and inseparable, located on the same screen.

* **3.3.1 Number pad.** Number pad should contain 10 buttons for every digit.
* **3.3.2 The "AC" button.** This function button should return the application to its initial state.
* **3.3.3 The "DEL" button.** This function button should delete one last typed digit.
* **3.3.4 The "%" button.** This operation button 
should replace the entered number with its percentage of the previous number.
* **3.3.5 The "/" button.** This operation button 
should perform the division operation.
* **3.3.6 The "X" button.** This operation button 
should perform the multiplication operation.
* **3.3.7 The "-" button.** This operation button 
should perform the subtraction operation.
* **3.3.8 The "+" button.** This operation button 
should perform the addition operation.
* **3.3.9 The "=" button.** This operation button 
should show the result of the operations performed.

## Other Nonfunctional Requirements
### 4.1 Performance Requirements
Each action through application must not cause a delay greater than 0.7 seconds on all supported platforms.

### 4.2 Security Requirements
For security reasons, each time the application is launched again, it must be in the initial state and not save the results of the previous session.


## Appendix A: Glossary

1. **IEEE** - The Institute of Electrical and Electronics Engineers Standards Association (IEEE SA) is an operating unit within IEEE that develops global standards in a broad range of industries.
2. **Markdown** - a lightweight markup language for creating formatted text using a plain-text editor. 
3. **MVP** - Minimum Viable Product - a prototype of a product, as a software app or video game, that includes functional versions of key elements that are planned for inclusion in the final product, and that is shared with a small audience whose feedback is used to inform and direct further product development.
4. **SRS** - Software Requirements Specification - a document of a software system to be developed.