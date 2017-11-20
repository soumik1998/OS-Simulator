import java.util.Observable;

public class GUI extends Observable {   

   /*--------------------------------------------------------
                        Constructor
   PURPOSE:  To refresh the watch
   --------------------------------------------------------*/
   public GUI() {
      clearChanged();
   } // constructor

   /*--------------------------------------------------------
                        input
   PURPOSE:  To pass back user's response to watchers
   --------------------------------------------------------*/
   public void input(Object info) {
      setChanged();
      notifyObservers(info);
   } // get user input

} // GUI class
