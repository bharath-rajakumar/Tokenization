Tokenization
=========
---
To compile and run the program 

```
javac Main.java

java Main
Enter the complete path of the Cranfield documents directory
/path/to/cranfield/folder/

```

Assumptions
---
1. How long the program took to acquire the text characteristics. 
- Approximately `20863 milliseconds`

2. How the program handles:
- Upper and lower case words (e.g. "People", "people", "Apple", "apple")
    - All the words are converted to lower case before being inserted into a dictionary

-  Words with dashes (e.g. "1996-97", "middle-class", "30-year", "tean-ager")
    - Tokens with dashes have been made to a single word. For example, the token `middle-class` will be stored as `middleclass`, so that we dont lose the token's context
-  Possessives (e.g. "sheriff's", "university's")
    - Tokens with these are stored by eleminating the possesives. For example, the token `university's` will be stored as `universitys`. This will be further santized using Porter Stemmer algorithm
-  Acronyms (e.g., "U.S.", "U.N.")
    - Tokens with these are stored by eleminating the `.` symbols and converting all letters to lower case. For example, the token `U.S.A` will be stored as `usa`
- Numbers are also stored and are considered to be a token
- In addition to this, SGML tags were neglected

Major algorithms and data structures
---
- To store the dictionary of words, Hashmap has been used so that the retrieval and insertions are efficient (Complexity `O(1)`).
- The Hashmap stores the token (key) and the number of times(value) the token has occured (frequency)`HashMap<String, Integer>`
- To find the top 30 most frequent tokens, a Priority Queue was used with a custom comparator to sort the tokens based on its frequency

Output
---

```
Tokenization - Statistics
1. Total no of tokens = 143918
2. Number of unique tokens = 12319
3. Number of tokens that occur only once = 6221
4. 30 most frequent word tokens in Cranfield text collection are : 
found - 422
presented - 425
wing - 430
body - 439
ratio - 442
made - 449
supersonic - 460
equations - 477
temperature - 478
velocity - 481
heat - 483
solution - 496
these - 500
effects - 510
given - 520
obtained - 539
surface - 558
shock - 589
been - 590
method - 683
layer - 728
theory - 775
mach - 816
results - 885
boundary - 897
number - 964
which - 974
this - 1080
pressure - 1132
flow - 1736
5. Average tokens per document = 102.79857142857144

Stemming - Statistics
1. Number of unique stemmed tokens = 9570
2. Number of stemmed tokens that occur only once = 5083
3. 30 most frequent stemmed tokens in Cranfield text collection are : 
calcul - 551
approxim - 553
veloc - 554
temperatur - 583
ratio - 588
been - 590
problem - 591
shock - 614
distribut - 641
obtain - 643
surfac - 661
heat - 686
present - 699
wing - 710
us - 730
bodi - 740
equat - 777
mach - 817
solut - 847
layer - 859
theori - 868
method - 883
boundari - 926
which - 974
effect - 988
thi - 1080
result - 1086
pressur - 1307
number - 1337
flow - 1965
4. Average stemmed tokens per document = 102.79857142857144
Total time taken : 20864
```
Reference
---
[Porter Stemmer Implementation in Java](http://tartarus.org/martin/PorterStemmer/)
