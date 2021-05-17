# Lekáreň
Matej Pavlík

# Prihlásenie
Manažér snip3rsvk@gmail.com 1234  
Lekárnik hrasko@gmail.com 1234

# Main
src/App/Main.java

# Zmeny od prezentácie
Commit: [c57fae8](https://github.com/OOP-FIIT/oop-2021-uto-18-c-krizan-Snip3rSVK/commit/29584a512a098ca7383a953375f91c2f2f21c960).
## Použitie rozhraní
V projekte sa používa rozhranie Database, ktoré implementujú všetky databázy v balíku App.Db. Toto rozhranie sa používa prevažne na serializáciu a deserializáciu. Môžeme to vidieť aj v triede Main (balík App) v metóde stop().

##RTTI
V interfaci Database (App.Db) používam getClass().getSimpleName() na zistenie mena triedy.

##Vhniezdené triedy
Trieda Comparators (balík Util) je vhniezdená. Táto trieda sa používa v databázach OrderDatbase a WarehouseDatabase.

##Default method implementation
V interfaci Database (App.Db) sú použité defaultné metódy

##Serializácia
Serializácia sa používa vo všetkých databázach v balíku App.Db. Na serializáciu databázy používajú jeden interface Database. Databázy sú serializované pri ukončení programu v triede Main.

