# KMP-Boyer-Moore-Optimization
A more efficient pattern matching algoithm
<br></br>
## Files 

* [Algorithm](https://github.com/jschaedler/KMP-Boyer-Moore-Optimization/blob/master/Algorithm.java)
* [Unit Tests](https://github.com/jschaedler/KMP-Boyer-Moore-Optimization/blob/master/KMPBoyerMooreTests.java)



## Knuth-Morris-Pratt and Boyer-Moore Background
Knuth-Morris-Pratt (KMP) and Boyer-Moore are both pattern matching algorithms that involve the preprocessing of the pattern data to optimize the efficientcy of brute force.
KMP uses an array of integers, called a failure table, intelligently grade the amount of repetition in the pattern. KMP performs much better when the pattern contains repeated 
characters and strings, as it was initailly developed for DNA sequencing, which requires an algorithm to perform well when there is a small alphabet and much repetition. Boyer-
Moore uses a Hashmap with a key value pair (Character, Integer), which records the last index that every distinct character appears in the pattern. Boyer-Moore performs well when
the text has a very large alphabet, where many comparisions can be skipped. Both of these algorithms use their preprocessed data structures to perform inteligent "shifts" of the 
pattern when comparing it to the text, which effectivly optimizes the brute force method of comparing every character in the pattern with every character in the text. These shifts
skip many unnecessary comparisions giving them more desirable time complexities.



## Time Complexity
The goal of this project is to optimize both algorithms to perform less comparisions than either of the two algorithms in the context of their respective worst cases. These basic
[tests](https://github.com/jschaedler/KMP-Boyer-Moore-Optimization/blob/master/KMPBoyerMooreTests.java) that I have included show that my algorithm performs less comparisions in
each of the worst case scenarios for KMP and Boyer-Moore respectivley. The worst case time complexity for KMP is *O(n + m)* where n is the number of characters in the pattern 
and m is the number of charaters in the text. The worst case time complexity for Boyer-Moore is *O(mn)*. While Boyer-Moore has a worst case time complexity the same as brute force
its best case can be more efficient than KMP's best case time complexity meaning a more general algoritm can harness the power of both preprocessing methods and improve the 
cuurent state of pattern matching algorithms. 


## Unit Tests
In my basic set of tests I test my optimized algorithm on the worst case of both KMP and Boyer-Moore. In each test my algorithm performs less comparisons than either algorithm 
would perform on its own. 
