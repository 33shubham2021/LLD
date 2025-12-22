"""
Traditional java way of getter setter will also work, but we use the standard pythonic way
Java like getter-setter
def get_marks(self):
        return self.__marks
similarly, set_marks()

Pythonic way is shown below
It looks like normal variable access, but logic is hidden inside

Reason for using pythonic way :
    Python philosophy :
        “We are all consenting adults here”
        Trust the developer, don’t force boilerplate
        Use attributes directly unless control is needed
    
    Pythonic @property is preferred because it keeps the interface simple
    (attribute-style access) while still allowing encapsulation and future logic changes.
"""


class Student:
    def __init__(self, marks):
        self.__marks = marks   # private variable

    @property
    def marks(self):           # getter
        return self.__marks

    @marks.setter
    def marks(self, value):    # setter
        if value < 0 or value > 100:
            raise ValueError("Marks must be between 0 and 100")
        self.__marks = value




def main():
    student = Student(80)
    print("Initial value : ",student.marks)  # calls the getter
    student.marks = 95                       # calls the setter
    print("Marks after setting : ", student.marks)
    


if __name__ == '__main__':
    main()
