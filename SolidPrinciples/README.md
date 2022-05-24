- ` `**[SOLID principles](https://www.youtube.com/watch?v=pTB30aXS77U&feature=youtu.be) code translation in Java** 
- **Introduction on translation** 
- This translation is based on the final code source of Solid Principles lessons in python programming languages (***dependency-inversion-after.py***)
- You need to watch the video first, understand all principles, and then look at the translation codes in Java. This documentation will help you to understand the translation better  
- We need a separate class with the ***main*** function to run the program, despite Python, which you can each ***.py*** file individually. ***Solid.java*** is the file with the main function for that purpose.
- Standard naming on java is different. You can find more information [here](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html).
- **Directories changes** 

This is one of the most significant changes we made to our translation. A Java project needs an exact directory with all dependencies to remain OOP and run smoothly. 

We defined a package name for this project as ***edu.def.solid*** ([package naming standards](https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)) and its specific directory under the ***src*** folder. This package name keeps all project components connected to gather when we implement them on different .java files. 

More information about Java’s project directory standards is [here](https://www.ibm.com/docs/en/i/7.1?topic=topics-java-classes-packages-directories).







- **Classes changes** 
- ***Order***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.001.png)

1. In this class, we need to clarify each array’s size as a Java programming rule. We can do it at the initializer by passing the number of items on the class constructor. 
1. We implemented all variables (items, quantities, …) as class attributes on Java with **private** visibility to protect them from direct access out of the class. Also, ***status*** has a default value of “*open*”.
1. A variable like ***numberOfItems*** is needed to keep track of the arrays and access them later, as Java doesn’t automatically detect where should add a new item in the array (nothing like append in python). In addition, we should keep updating this variable by adding every single item (in the ***addItem*** function).
1. As an OOP rule, we need to define the **getter** and **setter** function for each private parameter in the class if we want to access (**get**) them in the future and change (**set**) their value. As we will need to access ***status*** in other classes, we defined getter and setter for this class’s parameter. 
- ***Authorizer***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.002.png)

This class was an abstract class on the python version. Abstracts are usually used when we want to implement a specific function with all its functionalities that all children will use in the future. But when we need only the prototype (function naming, return type and arguments only), which will be implemented by each child later, we use [interfaces](https://d.docs.live.net/1a7d4b5a20685305/Documents/w3schools.com/java/java_interface.asp) in Java programming.

As a result, we implement the ***Authorizer*** class as an [interface](https://www.w3schools.com/java/java_interface.asp) class containing the ***isAuthotized*** function prototype.

- **Point**

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.003.png)A class in Java can inherit an [interface](https://www.w3schools.com/java/java_interface.asp) by the “***implements***” keyword after the class name.

Also, all [interface](https://www.w3schools.com/java/java_interface.asp) methods should be overridden in this child class (implement them completely)







- ***AuthorizerSMS***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.004.png)

1. We defined the variable ***authorized*** as a private class attribute.
1. The ***isAuthorized*** method was **overridden** based on its [interface](https://www.w3schools.com/java/java_interface.asp), inheriting that ([***Authorizer***](#solid_class_authorizer)). 

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.005.png)

1. At the ***verifyCode*** method, we appended the variable to the printed text by the “***+**”* sign, although in python, a formatting printing method was used (the ***f*** char at the start of the string)
- ***AuthorizerGoogle***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.006.png)

The same points as [***AuthorizerSMS***](#solid_class_authorizersms)

- ***AuthorizerRobot***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.007.png)

The same points as [***AuthorizerSMS***](#solid_class_authorizersms)

- ***PaymentProcessor***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.008.png)

1. this class is an [interface](https://www.w3schools.com/java/java_interface.asp) and acts the same as the [***Authorizer***](#solid_class_authorizer) class. This is an [interface](https://www.w3schools.com/java/java_interface.asp) which imposes the implementation of a specific method on each child, which will be inherent in this [interface](https://www.w3schools.com/java/java_interface.asp). 
1. In addition, be careful that the ***order*** argument in the payment method is in the type of [***Order***](#solid_class_order) class. (We call it [**non-primitive data type**](https://www.geeksforgeeks.org/data-types-in-java/))
1. We have an Exception method under a specific condition in the python. In Java, we must specify the “***throws Exception***” keyword on the function’s prototype and [interface](https://www.w3schools.com/java/java_interface.asp). 





- ***DebitPaymentProcessor***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.009.png)

1. We have a constructor to specify two-class parameter values, ***securitycode*** and ***authorizer***. Notice that authorizer is a [***non-primitive data type***](https://www.geeksforgeeks.org/data-types-in-java/) in the type of [***Authorizer***](#solid_class_authorizer). 
1. We specified all parameters as private because of the Java OOP rules and without getter and setter, as they are being used only for internal purposes.
1. The ***pay*** method is an overridden method from the [***PaymentProcessor***](#solid_class_paymentProcessor) [interface](https://www.w3schools.com/java/java_interface.asp). It shows us that this class inherits the [***PaymentProcessor***](#solid_class_paymentProcessor) [interface](https://www.w3schools.com/java/java_interface.asp).
1. The ***pay*** method in this class throws an exception, so we need “***throws Exception***” keyword at the method’s prototype.









- ***CreditPaymentProcessor***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.010.png)

The same points of [***debitPaymentProcessor](#solid_class_debitpaymentProcessor)*** will apply for this class, except we don’t *have the **authorizer*** parameter and any exceptions for the ***pay*** method.

- ***PaypalPaymentProcessor***

![](Aspose.Words.943877be-70ad-45c6-b2a0-b632004a0583.011.png)

The same points of [***debitPaymentProcessor](#solid_class_debitpaymentProcessor)*** will apply to this class. Only some changes about authentication and change from security code to email verification.
