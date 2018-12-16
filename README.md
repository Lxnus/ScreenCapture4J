# ScreenCapture4J
Screen capture tool to capture or grab an specific window on Desktop in Java

###*USAGE*

```java
public void grabScreen() {
     ScreenCapture screenCaputre = new ScreenCapture("<yourWindowName>"); // <yourWindowName> -> change to the title of you window, you want to capture!
     BufferedImage image = null;
     while(true) {
          image = screenCapture.current_image();
          try {
               new Thread();
               Thread.sleep(25); // change number -> how fast the image gets updated!
          } catch(IOExeption e) {}
     }
     
     /**
      * If you want to save the image!
      * formats ["png", "jpg", "gif"]
      */
      screenCapture.save_image("MyFile", "png"); // change first param to edit the fileName ; change second param to edit the format!
}

```
