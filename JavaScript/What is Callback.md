# What is callback function?

#### What is function(res, req, next)
  It is an anonymous function that have access to the request object, response object and the next function in the application request-response lifecycle. The **next function** is a function in the Express router which, when invoked, executes the middleware succeeding the current middleware.Middleware functions can perform the following tasks:
  
  * Execute any code.
  * Make changes to the request and the response objects.
  * End the request-response lifecycle.
  * Call the next middleware in the stack.
  
  If the current middleware function does not end the request-response cycle, it must call next() to pass control to the next middleware function. Otherwise, the request will be left hanging. You can get more details [here](https://expressjs.com/en/guide/writing-middleware.html)

#### What is High-order Functions
  In Javascripts, functions are of the type *Object* and they can be used like any other object(String, Array, Number, etc.) since they are infact object themselves. They can be _“stored in variables, passed as arguments to functions, created within functions, and returned from functions”._
  Because functions can be passed as an argument in another function, it can be executed later or even return it to be executed later. You can get mode details [here](http://javascriptissexy.com/understand-javascript-callback-functions-and-use-them/)

#### What is Promise
  Promise is a javascript class designed for **runing asynchronous tasks to synchronous**. The constructor of Promise take one argument, a callback function with two parameters, resolve and reject. Do something within the callback, perhaps async, then call resolve if everything worked, otherwise call reject.
  
![How Promises Work](https://cdn-images-1.medium.com/max/800/1*g1EZpcctuSoa6Jcwp68SUQ.png)
