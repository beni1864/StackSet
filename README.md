# Instance variables:
head: top of the stack \n
size: number of elements currently in the stack \n
limit: a maximum number of elements allowed, chosen by the user in construction

# StackSet
A StackSet is a combination of Java's Stack and Set classes. It performs similarly to a Stack, but it does not allow duplicate items. I implemented the StackSet using nodes.

# Push
If the stack is empty and stack size is under the limit, stack.push(element) pushes a node with a value equal to "element." If a node with the same value already exists within the stack, we do not push it; instead, that existing node is moved to the top of the stack.

# Pop
Similar to the Stack class, the StackSet removes the top element once stack.pop() is called. The StackSet.pop() function, however, does not return the top element like Stack.pop() does; instead, it returns a boolean value: true if the pop was successful, false if the pop was unsuccessful (in case of empty stack).

# Peek
If the stack is not empty, this returns the top element of the stack without removing it.

# Contains
Stack.contains(element) returns true if the stack contains a node with a value equal to "element".

# Size
Returns the current size of the stack.

# isEmpty
Returns true if the stack size is 0, false otherwise.

# isFull
Returns true if the stack size is equal to limit.

# Print
Prints each node in the stack from top to bottom.
