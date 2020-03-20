# Write a program which prints out all numbers between 1 and 100.
# When the program would print out a number exactly divisible by 4, print "Linked" instead.
# When it would print out a number exactly divisible by 6, print "In" instead.
# When it would print out a number exactly divisible by both 4 and 6, print "LinkedIn" instead.

def fizzbuzz():
    for i in range(1, 101):
        if i % 4 == 0 and i % 6 == 0:
            print("{} -- LinkedIn".format(i))
        elif i % 4 == 0:
            print("{} -- Linked".format(i))
        elif i % 6 == 0:
            print("{} -- In".format(i))


fizzbuzz()