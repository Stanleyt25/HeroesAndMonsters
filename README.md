# HeroesAndMonsters

An exercise in objected-oriented programming principles, applied in Java!

In this project, I implement the game Legends: Monsters and Heroes following the specifications outlined in the assignment document. It allows the user to create a party
of one to three heroes and to navigate around an 8x8 grid area to fight monsters and to purchase new weapons, armor, potions, and spells.

The board consists of an 8x8 2D array of Tile objects, and each tile has one of three types: Inaccessible, Market, and Common. Inacessible tiles cannot be stepped on, Market
tiles allow the player to visit and buy/sell items at the market, and Uncommon tiles have a chance of spawning a hoard of monsters to initiate combat. Each market in the world
randomly selects eight (8) items from the preset Item list to offer.

There is a preset list of Heroes (the HeroList class), Monsters (the MonsterList class), Weapons, Armor, Spells, and Potions (all four are in the ItemList class) as specified
in text documents contained in the Legends_Monsters_Heroes file.

By using W/A/S/D to navigate around the map, the player can level up their heroes by engaging in combat and purchase wares at markets to strengthen their party until they are satisfied.

------------------------------------------------------

Project Infrastructure:

First and foremost, the Controller class is the driver class which allows a user to play Legends: Monsters and Heroes. It contains several methods that facilitate party creation,
transactions at markets, and simulates battles against enemies.

The Tile class represents a unit on the 2D board. Each tile has a type that designates it as an inaccessible tile, market tile, or common tile. The Board class represents a 2D array
of Tile objects that emulates a fantasy world for the party to traverse on. The Tuple class provides a simple 2-tuple structure for storing the party coordinates on the grid.

<pre>
+---+
| X | The party is located on the tile with an 'X' on it
+---+

+---+
|   | Common tile: Combat is possible whenever the party steps onto a common tile
+---+

+---+
| M | Market tile: The party can visit the market by hitting (M/m) when they land on a Market tile
+---+

+---+
| I | Inaccessible tile: The party cannot traverse on these tiles
+---+
</pre>

The CreatureBehavior interface contains abstract methods, such as attack(), dodge(), and takeDamage(), which all creatures -- heroes and monsters alike -- share in their behavior.

The Creature class is a superclass of the Hero and Monster class, and contains fields that are shared between all creatures in the world.

The Hero class is a subclass of the Creature class and allows heroes to level up, purchase items, sell items, cast spells, equip items, and more. The Hero class also adds two structures: an
Inventory and Equipment. Two auxillary classes are created to facilitate functionality. The Inventory class stores an ArrayList of Item objects, and the Equipment class stores a
weapon slot and armor slot to keep track of the equipment that each hero has equipped.

The Monster class is a subclass of the Creature class and allows monsters to engage in combat by attacking and dodging.

The Item class is a superclass of the Weapon, Armor, Spell, and Potion class, and it contains fields that are shared between all items in the world, such as item name, cost, and
required level.

The Weapon class and Armor class are subclasses of the Item class, and they amplify the hero's attack and defense stat, respectively. These are non-consumable items. The Potion
class and Spell class are also subclasses of the Item class, and they are consumable, one-time use items. Items are stored in inventories, equipped in equipments, used in combat,
and exchanged at markets.

------------------------------------------------------

Compile Instructions:

1. Compile all nineteen (19) of the Java files using the command "javac [filename]".
	- javac Armor.java
	- javac Board.java
	- javac Controller.java
	- javac Creature.java
	- javac CreatureBehavior.java
	- javac Equipment.java
	- javac Hero.java
	- javac HeroList.java
	- javac Inventory.java
	- javac Item.java
	- javac ItemList.java
	- javac Market.java
	- javac Monster.java
	- javac MonsterList.java
	- javac Potion.java
	- javac Spell.java
	- javac Tile.java
	- javac Tuple.java
	- javac Weapon.java
2. Run the driver class, Controller.java using the command "java Controller".
	- java Controller

------------------------------------------------------

Imeplementation Example:

Let's take a look at combat. For my implementation, I implement combat in the Controller driver class. whenever the party leader makes a move and lands on a Common tile, there is an
18% chance that the party engages in combat with a hoard of enemies. The method checkForEnemies() rolls a die each time the user inputs W/A/S/D and the resulting coordinate is a Common
tile.

If the roll lands on combat, the engageBattle() method is called. 
- First, a group of monsters is randomly generated. The size of the monster group is equal to the party size of heroes, and each monster matches a corresponding hero in level for a fair fight.
- Secondly, a while loop starts, and the heroes are asked, one by one, to perform battle actions (Attack/Cast Spell/Equip Weapon or Armor/Use Potion/View Information/Skip). Once they have
completed a combat action, the monsters attack the heroes. I wrote a monsterTargeting() method that allows each monster to randomly target a hero between the ones that are still standing.
At the end of each round, each surviving hero regenerates 10% of their health and mana. This cycle repeats until either all heroes or all monsters are below zero (0) health.
- Lastly, I resolve the result of the combat. If the monsters win, the terminal announces "Game Over!" and ends the game. If the heroes win, each surviving hero gains gold and experience
that scales off of the number and level of monsters they defeated, and level up if they have enough experience points.

------------------------------------------------------

Commands:

General\
-------\
W/w: Move up\
A/a: Move left\
S/s: Move down\
D/d: Move right\
Q/q: Quit game\
I/i: Show party information\
M/m: Enter market (when on Market tile)\
O/o: Show map\
P/p: Show inventory

In-Combat\
---------\
A/a: Attack\
P/p: Access inventory to cast spell, equip weapon/armor, or use potion\
I/i: Show party information\
X/x: Pass turn

Note that character creation, transactions at markets, targeting during combat, and more rely on inputting an index. Options will be listed with a numerical index, and the user will be
asked to input a numerical index to indicate which option they want to select.


------------------------------------------------------

Example Output (from combat):

<pre>
Output: STAND GUARD! AN ENEMY HAS APPEARED!
Output: -----------------------------------

Output: Your party:
Output: -----------
Output: Gaerdal Ironhand | HP: 100.0 | MP: 100

Output: Enemy party:
Output: ------------
Output: Blinky | HP: 100.0
Gaerdal Ironhand, it's your turn. Which action would you like to take?
Output: A/a: Attack || P/p: Access inventory to cast spell/equip item/use potion || I/i: View party information || X/x: pass turn
Input:  I
Output: Here is your party information: 
Output: Gaerdal Ironhand
Output: Level 1
Output: EXP: 7/10
Output: HP: 100.0
Output: Mana: 100
Output: Class: Warrior
Output: Strength: 700
Output: Dexterity: 600
Output: Agility: 500
Output: Gold: 1354

Output: Equipped weapon: Wooden Sword / Level: 1 / Damage: 100
Output: Equipped armor: Wooden Chestplate / Level: 1 / Damage reduction: 100

Output: Gaerdal Ironhand, it's your turn. Which action would you like to take?
Output: A/a: Attack || P/p: Access inventory to cast spell/equip item/use potion || I/i: View party information || X/x: pass turn
Input:  P
Output: Your inventory is currently empty.

Output: Gaerdal Ironhand, it's your turn. Which action would you like to take?
Output: A/a: Attack || P/p: Access inventory to cast spell/equip item/use potion || I/i: View party information || X/x: pass turn
Input: A
Output: Who would you like to attack? Select the index next to the name of the enemy you would like to attack.

Output: Enemy party:
Output: ------------
Output: 0 Blinky | HP:100.0
Input:  0
Output: Gaerdal Ironhand attacks Blinky for 312.5 damage!
Output: Blinky faints!
Output: Victory!
Output: Gaerdal Ironhand gains 100 gold and 1 EXP!
</pre>
