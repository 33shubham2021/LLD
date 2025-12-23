"""
Default Constructor chaining - No such concept in python, as __init__ has same name in both parent and child
and parent's constructor is overridden . We will have to use super keyword explicitly in Python



"""
class A:
    def __init__(self):
        print("Inside A class constructor")

class B(A):
    def __init__(self):
        print("Inside B class constructor")

def main():
    print("Initialising A class")
    a = A()
    print("Initialising B class")
    b = B()

if __name__ == '__main__':
    main()