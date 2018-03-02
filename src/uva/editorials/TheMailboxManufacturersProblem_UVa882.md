Hint: DP 
You have k mailboxes and a range [min, max] (initially [0, m]) of crackers that the mailbox might stand. 
Your goal is to find the minimum number of crackers to cover the entire range. 
For every x in [min + 1, max], if you test with x crackers there are two possibilities: the box explodes, then the range becomes [min, x - 1], or the box doesn't explode then the range becomes [x, max]. We take the maximum of the two scenarios + x, since we don't know in advance which one will happen.   
 