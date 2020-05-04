# Necessities Needed Now

  

Due to the current coronavirus pandemic, many people are panicking and as a result many have been stocking

up on necessities — groceries, toiletries, etc. As a result, less able people like the elderly are troubled not only because

of the lack of supplies, but also because they are more at risk when they go outside. For our final project, we want to build

a platform targeted at the elderly to help them shop for their necessities and lessen their burden during this pandemic.

  

## Installation

### Clone

Clone this repo to your local machine.
```
git clone https://github.com/wustlcse237sp20/project-necessitiesneednow.git
```



### Setup
<!-- * There is a bash script for you to run that does all of the hard work for you.
* In your terminal, change directories to ../project-necessitiesneednow/necessitiesneedednow/src
* Then, run the bash script 
```
./script.sh
``` -->
Run the project on IntelliJ.
  
  
  

## Log Iteration 1


* As a user, I can see what items, by name, are in my shopping cart.

* As a user, I will expect the program to store user information such as address and email for ease of saving preferences.

* As a user, I can add what necessities I need by typing it into the command line (by prompting for name and quantity)

* As a user, I want to be able to remove necessities from my shopping cart, either completely or just by an item or two.


## Log Iteration 2

* Added an Item class that contains information such as product name, ISBN code, price, and whether or not it is perishable
* Updated ShoppingListTest to reflect the new Item class
* Created utilities to read and write to csv files for local storage
* Updated existing utilities to use the new Item class
* Additional type and data structure conversions were also implemented
* Connected to ingredients API to retrieve information about ingredients
* Updated testing.java to connect with API
  
## Log Iteration 3
* Successfully incorporated a three-screen GUI system that is linked to our API and CSV file management system
* Can log-in using the GUI.
* Can add items to one's shoppingList using this GUI, which is visible to the User live-time. 
* While selecting items, one can pick the amount of a certain item that they want as well.
* Once someone is finished shopping, they have their shoppingList stored as a .csv file.
* We were unable to successfully have 100% functionality on an IDE that is not IntelliJ due to the nature of the GUI designer that we used. For instance, those that are using Eclipse will find that our program is not completely functional.
* We were unable to successfully create a functioning bash script for this iteration.
* Future goals that we would add to this project is to address the previous issues, but also address ways to enhance the user experience: adding photos of the products they select and including blurbs about them, for example.

Thank you for using Necessities Needed Now!