# Hash-Table

###Which is a better hash function:
####<li>x % n where n is a large number with several factors</li>
####<li>x % n where n is a large prime number</li>

A large prime number is a better hash function. If the data is distributed evenly, then there is no difference between the two. But real world data often occurs in multiples of a number. In that case, the buckets that aren't coprime with the multple will be more filled than other buckets if n has several factors.

###Is char values summed % 599 a good hash function for strings? Why or why not?

No. Summing the char values means that permutations of the same set of characters would cause hash collisions.

###Take a look at Java's HashMap class and how it produces hashed values, then describe how it works.

Java's String hashing works by using a polynomial function to produce a hash value (s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1])
