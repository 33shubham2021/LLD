"""
Almost everything about constructors in same as that of Java, 
ONLY, python does not allow multiple __init__ methods, it will overwrite with the latest

Python by default calls the destructor, once the program completes, its garbage collector does this.
comment out del ... line, and check the logs
"""

class Student:
    #Default constructor
    def __init__(self):
        print("Inside default constructor")

    #Parametarised Constructor
    def __init__(self, name:str):
        print("Inside param constructor")
        self.name = name
    
    #Destructor
    def __del__(self):
        print("Destructor called")

def main():
    # s1 = Student()
    # Student.name = "John"
    s2 = Student("James")
    del s2               # calling destructor
    print("Student deleted")
    
if __name__ == '__main__':
    main()