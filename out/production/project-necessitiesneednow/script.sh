#!/bin/bash
cd main
javac -cp main/json-20190722.jar org.json/JsonParser.java
javac CSVArrayUtils.java CSVUtils.java shoppingList.java testing.java User.java ShoppingAPI.java
java testing
