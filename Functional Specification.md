# Functional Specification
## For "Fancy Calculator"

Version 1.0 approved  
Prepared by Lyhin Illia  
 
13.06.2022

Table of Contents
================
* 1 [Introduction](introduction)
   * 1.1 [Document Purpose](document-purpose)
   * 1.2 [Definitions, Acronyms and Abbreviations](definitions-acronyms-and-abbreviations)
* 2 [Scenarios](scenarios)
   * 2.1 [Usecases](usecases)
   * 2.2 [Personas](personas)
   * 2.3 [Product Scope](product-scope)
   * 2.4 [Unimportant Functions](unimportant-functions)
* 3 [Architecture Overview](architecture-overview)
   * 3.1 [Work Flow](work-flow)
   * 3.2 [Division by zero](division-by-zero)
   * 3.3 [User interface](details)
* [References](references)

## 1. Introduction  
### 1.1 Document Purpose
  This Functional Specification dovument describes all functions and interfaces that product will have purpose of this document is to present a description of the functions and interfaces of the final product. 
### 1.2 Intended Audience
This document intended for developers and testers.

## 2. Scenarios
### 2.1 Usecases
The functions of this app can be useful in doing everyday calculations. 
### 2.2 Personas
Main users of the product will be students, accountants and all those who may need calculator functions
 
### 2.3 Product Scope
The purpose of this software is to provide a convenient way of simple and accounting calculations using your Android smartphone. 

### 2.4 Unimportant Functions
The history of last calculations is not important may not be implemented. 

## 3. Architecture Overview
### 3.1 Work Flow
When an application is opened, it should always be in the initial state. User can click any button, altrough only digits and unary minus operation will work. Then, when number dialed, user can click on any binary operation to dial another number and only then perform the operation (pressing <kbd>=</kbd> key or any other operation key). Any time user can press <kbd>AC</kbd> button to return to initial state.
### 3.2 Division by zero
If the user decides to divide by zero, then the word "Error" should appear on the screen 
### 3.3 User interface
The blueprint of possible user interface is shown in the next picture:

<p align="center">
  <img src="https://github.com/ildun/Fancy-Calculator/blob/main/Blueprint.jpg?raw=true" />
</p>
  
  
  
##References
* Software Requirement Specification for "Fancy Calculator" - [https://github.com/ildun/Fancy-Calculator/blob/main/Software%20Requirements%20Specification.md](https://github.com/ildun/Fancy-Calculator/blob/main/Software%20Requirements%20Specification.md)
