from dataclasses import dataclass

#difference between structure and class

#defining the class and adding the dataclass decorator 
#this makes the student class act like a structure 
@dataclass
class Student:
    name: str
    age: int
    gender: str

def print_student(student: Student):
    print(student.name)
    print(student.age)
    print(student.gender)

if __name__ == '__main__':
    s1 = Student(name="John", age=18, gender="Male")
    print_student(s1)
