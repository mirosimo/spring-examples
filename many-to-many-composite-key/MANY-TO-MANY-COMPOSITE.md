# Overview
  This example is focused on Jpa **many to many** relationship with extra columns (fields) in connection table (entity). Is used manner 
with **composite key** which is created by class **model.CarEquipmentPackCarEngineId**. Extra fields in connection table have sense 
just for **one particular combination** in relation many to many. In this example you can also find how use enums with Thymeleaf, Comparator for 
ordering entities by multiple fields and maybee something more.

# CarEquipmentPack - CarEngine
  For our purpose are applied two entities **CarEquipmentPack** and **CarEngine**. Each equipment pack (Style, Ambition, Sportline, etc...) could has
one or more available engines (1.8 Tsi, 1.4 Mpi, 2.0 Tdi, etc). And each engine could be available in one or more equipment packs. Connection entity between theese 
two is **CarEquipmentPackCarEngine** - contains composite primary key **CarEquipmentPackCarEngineId** and extra fields:
+ **added** - date, when was particular engine assigned to particular equipment pack.
+ **active** - could be in active state or not. (Production problems, or engine could become obsolete and therfore removed from offer)
+ **marketingCarVariantName**

# Thymeleaf views

+ **car-equipment-pack-engine-list.html** - view displayes equipment packs which are in active states. And under each equipment pack are
             displayed its available engines.
+ **car-engine-new.html** - view for adding new engine into system.
+ **car-engine-list.html** - view displays list of all engines
+ **car-equipment-pack-new.html** - view for adding new equipment pack into system.
+ **car-equipment-pack-list.html** - view displays list of all equipment packs


# Screenshots
## Equipment pack - Engines 
![login view](/many-to-many-composite-key/screen-shots/eq-pack-engines-list2.png)

## Equipment pack - List
![login view](/many-to-many-composite-key/screen-shots/eq-pack-list.png)

## Equipment pack - NEW record
![login view](/many-to-many-composite-key/screen-shots/eq-pack-new.png)

## Engines - List
![login view](/many-to-many-composite-key/screen-shots/engine-list.png)

  
