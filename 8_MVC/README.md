﻿# [MVC (Model-View-Controller)](https://www.youtube.com/watch?v=ihtIcGkTFBU) **code translation in Java** 

*Published by* [Saman Pordanesh](https://github.com/sinapordanesh)


## **General Introduction** 

- [MVC (Model-View-Controller)](https://developer.mozilla.org/en-US/docs/Glossary/MVC) is a pattern in software design commonly used to implement user interfaces, data, and controlling logic. It emphasizes the separation between the software's business logic and display. For more, click [here](https://developer.mozilla.org/en-US/docs/Glossary/MVC).
- You need to watch the [video](https://www.youtube.com/watch?v=ihtIcGkTFBU) first, understand all principles, and then look at the translation codes in **Java**. This documentation will help you to understand the translation better
- This translation is based on the final code source of the **MVC** lessons in python programming languages (***mvc-after-strategy.py***).
- **Point**: This translation is **much more different** from the original **Python** version’s structure, libraries, and functionalities in this Java version. It’s caused as we have two different libraries for **UI** (user interface) in **Python** and **Java,** which follow different structures. 
- We need a separate class with the ***main*** function to run the program, despite **Python**, in which you can run each ***.py*** file individually. ***Main.java*** is the file with the main function for that purpose.
- Standard naming on **Java** is different. You can find more information [here](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html).

## **Directories changes** 

- This is one of the most significant changes we made to our translation. A **Java** project with the same directory with all dependencies can be good practice for OOP designing.
- We defined a package name for this project as ***edu.def.mvc*** ([package naming standards](https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)) and its specific directory under the ***src*** folder. This package name keeps all project components connected to gather when we implement them on different ***.java*** files. 
In addition, we have a sub package ***edu.def.mvc.uuid*** for the **UUID** interface and its children, as far as the **strategy** is concerned. (Have different strategies for generating different UUIDs)
- However, packages are unnecessary; you could use a default package or even have all classes in the same file; this is more **Java** best practice.
- More information about **Java’s** project directory standards is [here](https://www.ibm.com/docs/en/i/7.1?topic=topics-java-classes-packages-directories).

## **Implementational Instruction**

1. We will create one ***.java*** file per class under ***edu.def.mvc*** package.
They can be interfaces and child classes or simple classes.
In addition, in this lesson, we have a sub-package ***“edu.def.mvc.uuid”*** in a separate folder on the main package directory to hold a class category that behaves similarly. Learn more about sub-packages [here](https://www.refreshjava.com/java/sub-packages-in-java). 
1. In this project, we use **Java** **GUI** libraries [***AWT***](https://docs.oracle.com/javase/7/docs/api/java/awt/package-summary.html)  and [***Swing***](https://docs.oracle.com/javase/tutorial/uiswing/index.html), which have a different structure and functionality than **Python**’s [***Tkinter***](https://docs.python.org/3/library/tkinter.html) library for the same purpose. E.g., we don’t need a loop in the **Java** version to run the UI, although we need it in the **Python** version. Complete tutorial about **Java GUI** with ***Swing*** [here](https://docs.oracle.com/javase/tutorial/uiswing/index.html).
1. We have three MVC classes: ***Model.java***, ***Controller.java*** and ***View.java**.* In addition, we have a class called ***SwingView.java***, which implements ***View.java*** and handle all user interface codes. From that class, we combine all **MVC** principles to run an application. Finally, the [interface](https://www.w3schools.com/java/java_interface.asp) ***GenerateUuid.java*** and its children ***Uuid.java***, ***Uuid4.java*** and ***UuidString.java*** are classes to generate different **UUIDs**, depending on which one we choose on the ***main ()*** method. 
1. ***Main.java*** contains our ***main ()*** method to run the program.
1. Note that all steps here are entirely for the best **OOP** practice in **Java** programming; They can be done more straightforwardly, but not the best **OOP** ways.  

## **Compiling Instruction**

- Run the command prompt inside the ***src*** folder.
- Run the following command to compile all ***.java*** files:
```
javac edu/def/mvc/*.java
```
- To execute the program, we should run the ***Main.java*** file from the command prompt. To do this, from the same directory, run the following command on the command prompt:
```
java edu.def.mvc.Main
```
- If your main function is in a different class, but the name of that class instead of ***Main*** at the end of the command
- You can find more about compiling instructions [here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html).


## **Classes changes** 

### ***Model***

##### ***Python version***
```python 
class Model:
    def __init__(self):
        self.uuid = []
```

##### ***Java version***

```java
package edu.def.mvc;

import java.util.ArrayList;
import java.util.UUID;
/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */


/**
 * This is the Model class which should act as a database in this program.
 * This model is pretty simple, and we can hold the whole data on a simple ArrayList.
 * In complicated versions, Model class should connect with an external database.
 */
public class Model {

    private ArrayList<UUID> uuids;

    Model(){
        uuids = new ArrayList<>();
    }

    public void setUuids(ArrayList<UUID> uuids) {
        this.uuids = uuids;
    }

    public ArrayList<UUID> getUuids() {
        return uuids;
    }

    public void addUuid(UUID uuid){
        this.uuids.add(uuid);
    }

    public void clearModel(){
        this.uuids.clear();
    }
}
```

1. This class required an **ArrayList** to act as a data holder. We will keep all generated **UUIDs** in this **ArrayList** and use them through the program.
1. As the **ArrayList** is a private parameter and we need access to it in other classes, we have ***getter*** and ***setter*** methods for this purpose. In addition, ***addUuid ()*** is used to add a generated **UUID** to the model and ***clearModel ()*** is used to clear the whole model when needed.  However, by making the **ArrayList** a **public** parameter, we won’t need ***getter***, ***setter***, ***add*** and ***clean*** functions, but all of them are for best **OOP** practices.


### ***Controller***

##### ***Python version***
```python 
class Controller:
    def __init__(self, model, view, generate_uuid):
        self.model = model
        self.view = view
        self.generate_uuid = generate_uuid
    
    def start(self):
        self.view.setup(self)
        self.view.start_main_loop()

    def handle_click_generate_uuid(self):
        # generate a uuid and add it to the list
        self.model.uuid.append(self.generate_uuid())
        self.view.append_to_list(self.model.uuid[-1])

    def handle_click_clear_list(self):
        # clear the uuid list in the model and the view
        self.model.uuid = []
        self.view.clear_list()
```

##### ***Java version***

```java
/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import edu.def.mvc.uuid.GenerateUuid;

import java.util.UUID;

/**
 * Controller class
 */
public class Controller {

    private Model model;
    private View view;
    private GenerateUuid generateUuid;

    Controller(Model model, View view, GenerateUuid uuid){
        this.model = model;
        this.view = view;
        this.generateUuid = uuid;
    }

    //start the initial UI
    public void start(){
        this.view.setup(this);
    }

    //handle "Generate UUID" button and
    public void handleClickGenerateUuid(){
        this.model.addUuid(this.generateUuid.generateUuid());
    }

    //handle "Clear list" button and
    public void handleClickClearList(){
        this.model.clearModel();
        this.view.clearList();
    }

    //getting the Model object to use its data
    public Model getModel() {
        return model;
    }
}
```
1. This class controls all actions in the program and acts as a connector between ***View*** and ***Model*** as well (as you can see, we have both ***View*** and ***Model*** objects as parameters of this class). 
1. We have a parameter of the ***GeneratedUuid*** interface. We pass the ***GeneratedUuid*** children to the ***Controller*** class by its constructor to define which kind of **UUID** we want to generate in the application.  
1. In the ***start ()*** method, we call the ***setup ()*** method of the ***View*** object to start **GUI’s** engine. 
1. The following method is ***handleClickGenerateUuid ()*** when the user clicks on the ***“Generate UUID”*** button. This method should generate a **UUID** by ***generateUuid*** object and adding it to the model.
1. The method ***handleClickClearList ()*** handles the functionality of the ***“Clear List”*** button and clears the model entirely.   

### ***View*** 

##### ***Python version***
```python 
class View(ABC):
    @abstractmethod
    def setup(self, controller):
        pass

    @abstractmethod
    def append_to_list(self, item):
        pass

    @abstractmethod
    def clear_list(self):
        pass
    
    @abstractmethod
    def start_main_loop(self):
        pass
```

##### ***Java version***

```java
/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import javax.swing.*;
import java.util.UUID;

public abstract class View {
    public abstract void setup(Controller controller);
    public abstract void appendToList(UUID item);
    public abstract void clearList();
    public abstract void  startMainLoop();
}
```
1. This class is an [abstract](https://www.w3schools.com/java/java_abstract.asp) with four methods to handle the view of the application. 
1. The ***setup ()*** method will use to contain and start a GUI engine.  
1. The method ***appendToList ()*** is a method to run and handle the ***“Generate UUID”*** button view on the application. 
1. Also, the method ***clearList ()*** is a method to run and handle the ***“Clear List”*** button view on the application. 
1. Finally, ***startMainLoop()*** contains a method to make the frame visible. Unlike **Python**, in the **Java** version of **GUI,** we don’t need a loop to run the application.

### ***SwingView (as TkView in the Python version)***

##### ***Python version***
```python 
class TkView(View):
    def setup(self, controller):

        # setup tkinter
        self.root = tk.Tk()
        self.root.geometry("400x400")
        self.root.title("UUIDGen")

        # create the gui
        self.frame = tk.Frame(self.root)
        self.frame.pack(fill=tk.BOTH, expand=1)
        self.label = tk.Label(self.frame, text="Result:")
        self.label.pack()
        self.list = tk.Listbox(self.frame)
        self.list.pack(fill=tk.BOTH, expand=1)
        self.generate_uuid_button = tk.Button(self.frame, text="Generate UUID", command=controller.handle_click_generate_uuid)
        self.generate_uuid_button.pack()
        self.clear_button = tk.Button(self.frame, text="Clear list", command=controller.handle_click_clear_list)
        self.clear_button.pack()

    def append_to_list(self, item):
        self.list.insert(tk.END, item)

    def clear_list(self):
        self.list.delete(0, tk.END)
    
    def start_main_loop(self):
        # start the loop
        self.root.mainloop()
```

##### ***Java version***

```java
/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

/**
 * this class handles all three MVC classes to generate a UI application.
 * It uses Swing & AWT libraries for generating GUI.
 */

class SwingView extends View implements ActionListener {

    JFrame frame;
    TextArea display;
    JButton createButton;
    JButton clearButton;
    Controller controller;

    @Override
    public void setup(Controller controller) {

        // A controller object to control all principles in the program
        // from a unique class.
        this.controller = controller;

        this.frame = new JFrame();

        // Create a list for holding all generated uuids
        // responsive to add and clear by two "generateButton" and
        // "clearButton" buttons.
        this.display = new TextArea("", 20, 80);
        this.display.setEditable(false);

        this.startMainLoop();

        // Create two button for generating uuid and append to the list (generateButton)
        // and clear the least (clearButton)
        this.createButton = new JButton("Generate UUID");
        this.createButton.addActionListener(this);

        this.clearButton = new JButton("Clear List");
        this.clearButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,2));
        buttonPanel.add(this.createButton);
        buttonPanel.add(this.clearButton);

        Container content = this.frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add("Center", this.display);
        content.add("South", buttonPanel);

        this.frame.setPreferredSize(new Dimension(300, 200));
        this.frame.setTitle("UUID generator");
        this.frame.pack();


    }

    @Override
    public void appendToList(UUID item) {
        this.display.append(item.toString() + "\n");
    }

    @Override
    public void clearList() {
        this.display.setText("");
    }

    @Override
    public void startMainLoop() {
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.createButton) {
            this.controller.handleClickGenerateUuid();
            Model model = controller.getModel();
            this.appendToList(model.getUuids().get(model.getUuids().size()-1));

        }else if (e.getSource() == this.clearButton) {
            this.controller.handleClickClearList();
            this.clearList();
        }
    }
}
```
1. Java’s GUI and Swing library **principles are out of this course’s scope**. We recommend reading more about [Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html) library. Also, [this](https://www.youtube.com/watch?v=5o3fMLPY7qY) and [this](https://www.youtube.com/watch?v=iE8tZ0hn2Ws) video may help you to understand better.
1. As we said, this class inherits the ***View [abstract](https://www.w3schools.com/java/java_abstract.asp)***. As a result, we need to override all methods of that abstract in this child class. 

### ***GenerateUuid (plus all three children who are inheriting this interface)***

##### ***Python version***
```python 
# functional strategy 
def generate_uuid1():
    return uuid.uuid1()

def generate_uuid4():
    return uuid.uuid4()

def generate_simple_id():
    return ''.join(random.choices(string.ascii_lowercase, k=30))

class Model:
    def __init__(self):
        self.uuid = []
```

##### ***Java version***

```java
/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc.uuid;

import java.util.UUID;

/**
 * Interface for all UUIDs generators classes.
 * Only contains one method for generating a kind of UUIDs.
 */
public interface GenerateUuid {
    public UUID generateUuid();
}
```
```java
//For UUID1
public class Uuid1 implements GenerateUuid{
    @Override
    public UUID generateUuid() {
        byte[] byteName
                = { 50, 40, 30, 20, 10 };
        return UUID.nameUUIDFromBytes(byteName);
    }
}
```
```java
//For UUID4
public class Uuid4 implements GenerateUuid{

    @Override
    public UUID generateUuid() {
        return UUID.randomUUID();
    }
}
```
```java
//For UUIDString
public class UuidString implements GenerateUuid{
    @Override
    public UUID generateUuid() {
        return UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
    }
}
```
1. This [interface](https://www.w3schools.com/java/java_interface.asp) and its children under a sub package were substituted for three functions in Python language, which are responsible for generating different UUIDs. While this structure could be much simpler without any [interface](https://www.w3schools.com/java/java_interface.asp), inheritance, or sub-package, we are following OOP principles for the best practice.
1. This [interface](https://www.w3schools.com/java/java_interface.asp) has one method that will be overridden through different child classes. 
1. The ***generateUuid ()*** method generates different kinds of **UUID,** which the **Java** programming language allows us to generate. 
1. We created three other classes based on this [interface](https://www.w3schools.com/java/java_interface.asp) which are ***Uuid1.java***, ***Uuid4.java*** and ***UuidString.java**,* and each of them will generate a different **UUID** string. 
1. To generate those **UUIDs,** we used a native **Java** library called  “***java.util.UUID”***. We highly recommend reading about it [here](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html).
