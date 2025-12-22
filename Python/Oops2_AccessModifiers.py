""""
Access modifiers
Officially, no access modifiers supported in python
public - default
protected - single underscore (_) is used as just a conventional guideline for programmers
private - can be achieved using double underscore ( __ )
         internally python converts the variable name to _ClassName__variableName
         eg, for varible named batchId for class Student -> _Student__batchId
         this is called Name Mangling, discussed in details in Inheritance topic 

"""

class Student:

    def __init__(self, name:str, batchId:int, universityName:str):
        self.name = name
        #setting batchId as private, using Name Mangling
        self.__batchId = batchId
        self.universityName = universityName

    def changeBatch(self, newBatchId:int):
        self.__batchId = newBatchId
        #Notice here that I am directly accessing batchId variable, 
        #as I am accessing it inside the same class, so no need to access it like 
        # _Student__batchId

#Test class to test access modifiers
class Test():
    batchId:int

    def __init__(self, s:Student):
        #This line will throw error
        #self.batchId = s.__batchId

        self.batchId = s._Student__batchId




def main():
    student = Student(name = "James" , batchId=3, universityName="MIT")
    print("Old batch : ", student._Student__batchId)
    student.changeBatch(4)
    print("New batch : ", student._Student__batchId)

    t = Test(student)
    print("Batch id of Test object : ",t.batchId)


if __name__ == '__main__':
    main()