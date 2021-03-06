# Alina's Personal Project: Greenhouse Game

## What will the application do?
The application that I will be making for the personal project is similar to the idea of a 'desk pet' or
tamagotchi. Although instead of a pet, the user taking care of a pet it will be a plant within the Greenhouse game.
The user game will consist of the following;


- Taking care of a seedling

<p> 
    The user will be given a seedling and have the choice of what type of plant. The user will then be able to water
the plant and give it sun to help it grow at reach the 'mature' stage.
</p>

- Sending off mature plants

<p> 
Once a plant reaches the mature state it is ready to leave the greenhouse into the real world! 
the user will be able to send off the plant the 'garden'. 
</p>

- Visiting the Garden

<p>
After sending a plant to a garden the user will be able to see it in the garden
along with the genus of plant and the total number of plants they sent.
</p>

## Who will use it?
The demographic is similar to that of the tamagotchi wherein it is a game that appeals to people with a nurturing
instinct, in this case the urge to care for something and be able to see its growth and development and will lead into
seeing the development of the garden. Aside from people who enjoy nurture appeal games, parents can give this application to
their children to teach them the reward of taking care of something.

## Why is this project of interest to you? 
One of my hobbies outside of academics is gardening and, I also work at a florist shop. So a big part of my job
is centered around the premise of the game. I raise plants and flowers until they are mature and can be sold to 
customers can take them to their gardens. Although I notice some people find it difficult to take care of actual plants so,
the digitalization will allow people to still have the satisfaction of taking care of plants despite not having a green thumb.


## User Stories

- 'As a user, I want to be able to make a new plant'
- 'As a user, I want to be able to water the plant'
- 'As a user, I want to be able to give the plant sunshine'
- 'As a user, I want to be able to go to see plant I raised in the garden'
  ( the case of adding an arbitrary amount of X(Plants a designed class) to Y(Garden another designed class))
- 'As a user, I want to be able to save the current state of the garden to file'
- 'As a user, I want to be able to have the option in the main display screen to 
load the garden from file'

## Phase 4: Task 3

Refactoring

<p>
I found that during phase four that I had to create multiple new
methods as a result of not making methods effectively the first time.
If I had more time I would refactor the way I have dealt getting the genus of the plants in the garden
as of right now it is mainly 'hard coded'. Instead of using the boolean method I would make a new method in the 
Garden class the checks if the list of 'gardenPlants' contains a genus. If it does 
tack the type on to the base phrase "Your garden currently has genus types:". I would also refactor the way I have set
the windows as I currently have different windows but, instead I could have created a single window
and passed the window along and each screen would be represented with a panel and 'changing screens' could be done by
setting the panel's visibility to false rather than the entire window.
</p>

##Logging Example

<p>
The following is the expected log print out to the console for the event of
a lily being made, incremented to the maximum sun and water, added to the garden and
checked within the garden to have the size of one (the added lily), with the genus present in the 
garden as genus lily

 EVENT LOG BEGINNING 

Fri Apr 01 15:05:50 PDT 2022
Created a new plant

Fri Apr 01 15:05:51 PDT 2022
Created plant genus has been set to lily

Fri Apr 01 15:05:52 PDT 2022
Plant incremented sun by 1 with the current sun: 1

Fri Apr 01 15:05:52 PDT 2022
Plant incremented sun by 1 with the current sun: 2

Fri Apr 01 15:05:52 PDT 2022
Plant incremented sun by 1 with the current sun: 3

Fri Apr 01 15:05:53 PDT 2022
Plant incremented water by 1 with the current sun: 1

Fri Apr 01 15:05:53 PDT 2022
Plant incremented water by 1 with the current sun: 2

Fri Apr 01 15:05:53 PDT 2022
Plant incremented water by 1 with the current sun: 3

Fri Apr 01 15:05:53 PDT 2022
Plant with genus lily added to garden

Fri Apr 01 15:05:56 PDT 2022
garden checked to contain type: lily

Fri Apr 01 15:05:56 PDT 2022
Garden size checked to be 1

EVENT LOG FINISHED
</p>


