NegadecimalCalculator
=====================
Design: This assignment was created by Professor Dave Matuszek at the University of Pennsylvania. Design and implementation by Ryan Smith and Lu Lu.

Overview: Calculator providing arithmetic operations for the negadecimal (base -10) number system.

The calculator will display the current value in negadecimal format. The display value can be set by entering a single number and will then clear any previous operations from memory.

With a value in the calculator the following commands are possible:
“+ number” - adds a number to the value in the display
“- number” - subtracts a number from the value in the display
“* number” - multiplies a number to the value in the display
“/ number” - divides the value in the display by a number
“% number” - divides the value in the display by a number and displays the remainder
“~” - negates the display
“?” - shows the decimal value of the negadecimal number in the display
“decimal integer” - converts the integer from decimal to negadecimal and displays
“c” | “clear” - clears the display and sets to 0
“q” | “quit” - end operation of the program

Use: The display with show “Error” when a command has not been understood does not fit any of the above formats. When “Error” is displayed a user must “clear” the display before execution can resume. 

Other Info: This project does not contain a GUI. It is intended to be run from the command line. This project contains unit tests for each class.