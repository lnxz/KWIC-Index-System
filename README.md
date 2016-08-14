# cs3219-assignment1 [KWIC (Key Word In Context) index system]
### Architecture 1: Pipe and Filter [Shaun]
### Architecture 2: ? [Bevin]
### About
KWIC provides a search mechanism for information in a list of lines. Given a list of lines and a list of ``words to ignore'', KWIC system should generate a KWIC (Key Word In Context) index of the input lines. In a KWIC-index, a line is listed once for each keyword that occurs in the line. 
The keyword cannot be in "words to ignore" . Also, KWIC-index is alphabetized by keyword.

How does KWIC work: For each input line, it shall be “circularly shifted” exhaustively by removing the first word and appending it at the end of the line to create a set of circularly shifted lines. 
The first word (not including "words to ignore") will be the keyword. The system outputs a listing of the circularly shifted lines for all input lines in ascending alphabetical order.

The keyword is often output with its starting letter in upper case and the rest in lower case.

For example, if the “words to ignore” are is, the, of, and, as, a, after and the input lines are movie titles The Day after Tomorrow, Fast and Furious, Man of Steel, the output should be as below:
Day after Tomorrow the
Fast and Furious
Furious Fast and
Man of Steel
Steel Man of
Tomorrow the Day after

#### Example

Input   

```sh
The Day after Tomorrow, Fast and Furious, Man of Steel
```
Ignored words  

```sh
is, the, of, and, as, a, after
```
Expected output  

```sh
Day after Tomorrow the
Fast and Furious
Furious Fast and
Man of Steel
Steel Man of
Tomorrow the Day after

```
