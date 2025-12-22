class Student:
    name: str
    age: int
    gender: str

    #defining constructor of the class
    def __init__(self, name:str, age:int, gender:str):
        self.name = name
        self.age = age
        self.gender = gender

    def print_student(self):
        print(self.name)
        print(self.age)
        print(self.gender)

if __name__ == '__main__':
    s1 = Student(name="John", age=18, gender="Male")
    s1.print_student()