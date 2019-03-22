# Kata: Minesweeper

## Introduction
Add the numbers to a minesweeper board.

Minesweeper is a popular game where the user has to find the mines 
using numeric hints that indicate how many mines are directly adjacent 
(horizontally, vertically, diagonally) to a square.

In this exercise you have to create some code 
that counts the number of mines adjacent to a square 
and transforms boards like this (where * indicates a mine):

_Note:_ Only one-dimensional mines are implemented just now 
(should be extended in next session).

### Example
This input mine game...
```
+-----+
| * * |
+-----+
```

...should be computed into this:
```
+-----+
|1*2*1|
+-----+
```
## Other infos
* Date: 22. 3. 2019
* Language: Clojure
* IDE: Visual Studio Code
* Source: [exercism.io/Minesweeper](https://exercism.io/my/solutions/7bc33b4bbbd542e0857e4efa25c7d03b)
* Note: It's implemented the same problem as in [O2-dojo, kata 20190313-minesweeper](https://github.com/jjaros/o2-dojo/tree/master/20190313-minesweeper) but in other language.