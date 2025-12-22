# super keyword in python -> almost like java super keyword

class Parent:
    def __init__(self, name: str):
        self._name = name
    
    def printName(self):
        print("Parent : Hey ",self._name)

class Child(Parent):
    def __init__(self, name:str):
        super().__init__(name)

    def printName(self):
        print("Child : Hey ", self._name)

    def printParentName(self):
        super().printName()


def main():
    p = Parent("Parent")
    p.printName()

    c = Child('Child')
    c.printName()
    c.printParentName()


if __name__ == '__main__':
    main()