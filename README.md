# 2D Adventure

A 2D top-down RPG built in **Java** as a personal programming project.

This project was created to practise Java programming and explore how different systems within a game interact, including player movement, collision detection, NPCs, combat, inventory management, tile-based maps and pathfinding.

The project is still a work in progress, with new features and improvements being added as I continue developing my Java and Computer Science skills.

---

## Features

### Player

* 2D player movement
* Direction-based animations
* Player health and mana
* Level and experience system
* Weapons and shields
* Different attack animations
* Guarding
* Knockback
* Invincibility frames
* Projectile attacks

### Combat

* Melee combat
* Different weapon types
* Enemy damage and defence
* Enemy knockback
* Enemy death states
* Experience gained from defeated enemies
* Player levelling system

### NPCs

* Interactive NPCs
* NPC dialogue
* NPC movement
* Player/NPC collision detection

### Inventory & Items

* Inventory system
* Weapons and shields
* Consumable items
* Stackable items
* Item pickup
* Item interaction
* Equipment selection
* Item-specific abilities

### World & Maps

* Tile-based world
* Multiple maps
* Separate interior and dungeon areas
* Tile collision
* Interactive map objects
* Destructible interactive tiles
* Map transitions

### Game Systems

* Game loop
* Collision detection
* NPC interaction
* Pathfinding
* Event handling
* Projectile management
* Particle effects
* Game states
* Dialogue system
* Level progression

---

## Technologies

* **Java**
* Java Swing / AWT
* Object-Oriented Programming
* 2D Graphics
* File I/O
* Arrays and collections
* Game loops
* Collision detection
* Pathfinding
* Event-driven programming

---

## What I Learned

This project has given me practical experience with several programming and Computer Science concepts.

### Object-Oriented Programming

The game is separated into different classes responsible for individual systems and entities.

For example:

* `Player`
* `Entity`
* `NPC`
* `Monster`
* `Tile`
* `TileManager`
* `GamePanel`
* `CollisionChecker`
* `PathFinder`

This helped me practise concepts such as **inheritance, encapsulation, objects and class organisation**.

### Game Loops

The game continuously updates and redraws the game world through a game loop.

The loop handles things such as:

1. Reading player input
2. Updating entities
3. Checking collisions
4. Updating game systems
5. Rendering the game

### Collision Detection

The project uses collision detection to prevent the player and other entities from moving through objects, NPCs, monsters and parts of the environment.

### Pathfinding

NPC movement uses a pathfinding system to allow entities to navigate around the tile-based world.

This introduced me to concepts such as:

* Nodes
* Open and closed nodes
* Movement costs
* Goal nodes
* Path searching
* Grid-based navigation

### Debugging

A significant part of developing the game has involved finding and fixing runtime errors and logic problems.

For example, I encountered array index errors caused by mismatched tile and map indexes and learned how to use Java stack traces to identify the class and line responsible for an error.

This has helped me improve my ability to **debug and understand larger codebases**.

## Current Progress

The game currently contains the core systems required for a playable 2D RPG, including player movement, maps, collisions, NPCs, combat, inventory management and multiple game systems.

The project is still under development, and I am continuing to improve the codebase and add new functionality.

---

## Future Improvements

Some features I would like to explore as the project develops include:

* More enemies and NPCs
* Additional maps and environments
* More weapons and items
* Improved enemy AI
* More advanced quests
* Additional dialogue
* Better save/load functionality
* More combat mechanics
* Improved UI
* Additional animations
* Further optimisation and code organisation

---

## Why I Built This

I built this project to gain more practical experience with **Java and Object-Oriented Programming** while applying Computer Science concepts to a larger project.

Unlike smaller projects, developing a game requires multiple systems to communicate with each other, which has given me experience with designing, debugging and maintaining a more complex codebase.

It has also helped me develop my problem-solving skills by requiring me to investigate issues, understand stack traces and debug interactions between different parts of the program.

---

## Tutorial Credits
A big shout-out to RyiSnow for his excellent Java 2D RPG tutorial series on YouTube. This project was built by following along with his tutorials, which provided a great introduction to game development in Java and helped me learn about game loops, tile maps, collision detection, NPCs, pathfinding and many other game development concepts.
Huge thanks to RyiSnow for creating and sharing such a helpful resource!
