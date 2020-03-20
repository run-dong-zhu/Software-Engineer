# Python Overview #

* Python is an interpreted language. That means that, unlike languages like C and its variants, Python does not need to be **compiled before run**
* Python is dynamic language, don’t need to state data type
* functions are first-class objects. They can be assigned to variables, returned from other functions and passed into functions. Classes are also first class objects

## Data Types ##

* Text Type: str
* Numeric Types: int, float, complex
* Sequence Types: list, tuple, range
* Mapping Type: dict
* Set Types: set, frozenset
* Boolean Type: bool
* Binary Types: bytes, bytearray, memoryview

## List ##

|               | List                   | Tuple                  |Set                     |Dict                    |
| ------------- |:----------------------:| ----------------------:|:----------------------:|:----------------------:|
| Create        | list = [1, 2, 3]       | tuple = (1, 2, 3)      | set = {'a', 'b', 'c}   | dict = {'key': 'value'}|
| Ordered       | Yes                    | Yes                    | No                     | No                     |
| Immutable     | No                     | Yes                    | No                     | No                     |
| Insert        | list.append()/insert() | N/A                    | set.add()              | dict['k] = 'value'     |
| Update        | list[0] = 10           | N/A                    | set.update()           | dict['key'] = 'value   |
| Delete        | list.remove()/pop()    | N/A                    | set.remove()           | dict.pop()             |