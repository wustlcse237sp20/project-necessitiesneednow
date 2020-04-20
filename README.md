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
Run the project on IntelliJ or your favorite IDE.
  
  
  

## Log Iteration 1

We have incorporated the following user stories as of Iteration One (4/6/20):

* As a user, I can see what items, by name, are in my shopping cart.

* As a user, I will expect the program to store user information such as address and email for ease of saving preferences.

* As a user, I can add what necessities I need by typing it into the command line (by prompting for name and quantity)

* As a user, I want to be able to remove necessities from my shopping cart, either completely or just by an item or two.

  

  

We have a few user stories that we plan to incorporate into the project in the near future:

* As a user, the program I'm using can check if an item I want to add is available or not.

* We have not incorporated this because it would require the use of a functioning API from which we could draw upon

to get this information. We do have an API in mind at this point in time.

* As a user, I can see what items are in my shopping cart, along with a little blurb that describes them.

* As a user, I want to have a UI that is easy to use.

* Again, not having the API plays into why we don't have this user story incorporated quite yet. We plan to use this

feature to give the customer a better idea of what they're purchasing: for example, using existing product descriptions

that are taken from the API so that the user can make better, more informed decisions depending on their preferences.

## Log Iteration 2

* Added an Item class that contains information such as product name, ISBN code, price, and whether or not it is perishable
* Updated ShoppingListTest to reflect the new Item class
* Created utilities to read and write to csv files for local storage
* Updated existing utilities to use the new Item class
* Additional type and data structure conversions were also implemented
* Connected to ingredients API to retrieve information about ingredients
* Updated testing.java to connect with API
  
## Next for Iteration 2

For our next iteration of NecessitiesNeededNow we hope to have the following user stories completed.


* As a user, I will be able to use a categorization system for items for ease of finding what I want.

* As a user, I want my information and preferences saved/loaded as CSV files in a file management system.

* As a user, There should a way to access items from multiple retailors that match my needs.

## Next for Iteration 3

* Have a simple UI implementation

* Create add or remove Items from a shopping list

* Products could have a small description about them