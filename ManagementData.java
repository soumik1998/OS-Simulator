import java.awt.*;
import java.io.*;

public class ManagementData{

    SimpleProcess processList[];
    int  Available [] = new int[4];
    animationFrame Animate;
    status s;

    ManagementData(int [] avail, animationFrame ani, status st){
	Available = avail;
	Animate = ani;
        s = st;
	processList = new SimpleProcess [5];
    }

    public void initialResource(int [] allocated){
	for (int i=0; i<Available.length; i++)
	    Available[i] =  Available[i] - allocated[i];
    }

    public boolean checkSafety(){
	int Work[] = new int [4];
	for (int i=0; i<4;i++) Work[i] = Available[i];
	boolean Finish[] = new boolean [5];
	boolean checkp;
	do{
	    checkp = false;
	    for (int i=0;i<5;i++){
              if (Finish[i] == false && lessThanWork(processList[i],Work)){
                  for (int j=0;j<4;j++){
                     Work[j] = Work[j] + processList[i].returnAllocation()[j];
                     checkp = true;
                  }
                  Finish[i] = true;
              }
	    }
	} while (checkp);
	boolean result = true;

	for (int i=0; i<5;i++)
	    if (Finish[i] == false){
                result = false;
                break;
	    }
	return result;
    }

    public boolean lessThanWork(SimpleProcess sp, int[] work){
        int need [] = sp.returnNeed();
        boolean result = true;
        for (int i=0; i<4;i++){
           if (work[i] < need[i])
            {
              result = false;
              break;
            }
        }
        return result;
    }

    public boolean resourceRequest(int pid, int[] request){

        SimpleProcess sp = processList[pid];
        boolean pFlag = false;
        boolean errorp = false;

        if (!errorp) {
            boolean waitp = false;
            for (int i=0;i<4;i++){
               if (request[i]> Available[i]){
                   waitp = true;
                   System.out.println("******** Request ********");
                   System.out.print("Request process" + pid + ": ");

                   for (i=0; i<4;i++)
                     System.out.print(request[i] + " ");
                   s.upStatus("Process" + pid + " request : "
                      +Integer.toString(request[0]) + "A "
                      +Integer.toString(request[1]) + "B "
                      +Integer.toString(request[2]) + "C "
                      +Integer.toString(request[3]) + "D "
                      +"... requested resources not available !!!");
                   System.out.println("request > available");
                   break;
                }
            }

            if (!waitp){
                for (int i=0;i<4;i++)
                   Available[i] = Available[i]-request[i];

                int requestCopy[] = new int [4];
                for (int m=0; m<4; m++)
                  requestCopy[m] = request[m];

                sp.successAllocation(request);
                boolean nextstate = checkSafety();
                String temp = "false";
                String temp_1 = "not allocated";
                if (nextstate == true) {temp = "true"; temp_1 = "allocated";}
                System.out.println();
                System.out.println("******** Request ********");
                System.out.print("Request process" + pid + ": ");

                for (int i=0; i<4;i++)
                   System.out.print(requestCopy[i] + " ");

                s.upStatus("Process" + pid + " request : "
                  +Integer.toString(requestCopy[0]) + "A "
                  +Integer.toString(requestCopy[1]) + "B "
                  +Integer.toString(requestCopy[2]) + "C "
                  +Integer.toString(requestCopy[3]) + "D  -- Resouces available"
                  +", resources "+temp_1+" to process " + pid + "--");

                System.out.println();
                System.out.println("-- Request Check --");
                System.out.println(nextstate);

                if (nextstate){
                    System.out.println("* State *");
                    printAvailable();
                    printNeed();
                    printAllocation();
			  Animate.repaint();
                    pFlag = true;
                }
                else{
                    for (int i=0;i<4;i++)
                       Available[i] = Available[i]+request[i];
                    sp.failAllocation(request);
                }
            }
         }
         return pFlag;
    }

    public boolean initialResourceRequest(int pid, int[] request){
        boolean flag = false;
        SimpleProcess sp = processList[pid];
        int need [] = sp.returnNeed();
        boolean errorp = false;
        for (int i=0; i<4;i++){
           if (request[i] > need[i]) {
                errorp = true;
                break;
           }
        }

        if (!errorp) {
            boolean waitp = false;
            for (int i=0;i<4;i++){
               if (request[i]> Available[i]){
                   waitp = true;
                   break;}
            }

            if (!waitp){
                for (int i=0;i<4;i++)
                   Available[i] = Available[i]-request[i];
                sp.successAllocation(request);

                flag = true;
            }
        }
        return flag;
    }


    public void release(int [] allocation){
        for (int i=0;i<4;i++){
           Available[i] = Available[i] + allocation[i];
        }
    }

    public void setSimpleProcess(int i, SimpleProcess s){
        processList[i] = s;
    }

    public  SimpleProcess[] returnProcessList(){
        return processList;
    }

    public void printNeed(){
        System.out.println("-- Needed Resources --");
        System.out.println("                A B C D");
        for (int i=0; i< processList.length;i++){
           processList[i].printNeedSet();
        }
    }

    public void printAllocation(){
        System.out.println("-- Allocated Resources --");
        System.out.println("                 A B C D");
        for (int i=0; i< processList.length;i++){
           processList[i].printAllocationSet();
        }
    }

    public void printAvailable(){
        System.out.println("-- Available Resources --");
        System.out.println("A B C D");
        for (int i=0; i < Available.length;i++){
           System.out.print(Available[i] + " ");
        }
        System.out.println();
    }
}