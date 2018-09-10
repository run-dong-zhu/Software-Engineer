# What is callback function?
Quick guideline:
-function(res, req)

#### What is function(res, req, next)
  It is an anonymous function that have access to the request object, response object and the next function in the application
  request-response lifecycle. The **next function** is a function in the Express router which, when invoked, executes the 
  middleware succeeding the current middleware.
  Middleware functions can perform the following tasks:
    -Execute any code
    -Make changes to the request and the response objects
    -End the request-response lifecycle
    -Call the next middleware in the stack
  If the current middleware function does not end the request-response cycle, it must call next() to pass control to the next
  middleware function. Otherwise, the request will be left hanging.
  You can get more details [here](https://expressjs.com/en/guide/writing-middleware.html)
