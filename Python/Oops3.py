"""
OOPS has one principle, called Abstraction, which is implememted using below 3 pillars :
Encapsulation -> using classes and access modifiers
Inheritance -> using parent-child relation
Polymorphism -> one behaviour, multiple implemenmtations 


Animal
    Mammal
        Dog
        Cat
        Human
    Reptiles
        Snake
        Lizard    

Attributes and behaviour of parents are inherited by children

"""
# Parent Class
class User:
    def __init__(self,username, password):
        self.username = username
        self.password = password
    
    def login(self):
        #Logic to login
        print("Login")

    def logout(self):
        #Logic to logout
        print("Logged out")


#Child class of User
class Instructor(User):
    def __init__(self , username, password, batch_name, average_rating):
        super().__init__(username, password)
        self.batch_name = batch_name
        self.average_rating = average_rating

    def schedule_class(self):
        #Logic to schedule class
        print("Class Scheduled")


def main():
    manav = Instructor("Manav" , "12345" , "Python" , 4.5)
    manav.login()
    manav.schedule_class()
    manav.logout()

    manav_new = User("Manav" , "1234")
    manav_new.login()
    #below line will throw error
    #manav_new.schedule_class()
    manav_new.logout()

if __name__ == '__main__':
    main()

