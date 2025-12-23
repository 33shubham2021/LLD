"""
Memory Management and Garbage Collector in Python  

Memory is allocated at runtime to the program

Reference Count in python 
    Same object, all variables are pointed to the same object and 
    the reference count is increased (but object count is still 1)
    If reference count becomes 0, the object gets deleted by the garbage collector
    Same object will have same id

    gc library - collect method, used for manual garbage collection 

"""

a = 10
b = 10

if id(a) == id(b):
    print ("Same identity")
else:
    print("Different Identity")