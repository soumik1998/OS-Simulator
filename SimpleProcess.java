import java.awt.*;
import java.io.*;

public class SimpleProcess {

    int id;
    ManagementData md;
    int Max[];
    int Allocation[];
    int Need [];
    boolean finish;
    animationFrame anim;
    status stat;

    SimpleProcess(int i, ManagementData m, int[] ma, int[] a,
      animationFrame ani, status st){
        id = i;
        md = m;
        Max = ma;
        Allocation = a;
	anim = ani;
        stat = st;
        Need = new int [4];
        finish = false;
        md.setSimpleProcess(i, this);
        initialSet();
    }

    private void initialSet(){
        for(int i=0; i < Max.length; i++)
           Need[i] = Max[i] - Allocation[i];
        md.initialResource(Allocation);
    }

    public void successAllocation(int request[]){

        for (int j=0; j<4;j++){
            Allocation[j] = Allocation[j] + request[j];
            Need[j] = Need[j] - request[j];
        }
    }

    public void failAllocation(int request[]){

        for (int j=0; j<4;j++){
            Allocation[j] = Allocation[j] - request[j];
            Need[j] = Need[j] + request[j];
        }
    }

    public void Finish(){
        boolean checkEnd = true;
        for (int i=0;i<4;i++){
           if (Need[i] != 0) checkEnd = false;
        }

        if (checkEnd){
            md.release(Allocation);
//            anim.prtFinish(id);
            for (int i=0;i<4;i++) Allocation[i] = 0;
            finish = true;

            System.out.println("******** Release ********");
            System.out.println("Release process" + id);
            stat.upStatus("Process " + id + " finished... Process "+id+" release all resources it is currently holding");
            System.out.println("* State *");
            md.printAvailable();
            md.printNeed();
            md.printAllocation();
		anim.repaint();
        }
    }

    public int[] returnNeed(){
        return Need;
    }

    public int[] returnAllocation(){
        return Allocation;
    }

    public boolean returnFinish(){
        return finish;
    }

    public void printNeedSet(){
        System.out.print("Process " + id + " Need: ");
        for(int i=0; i < Max.length; i++){
           System.out.print(Need[i] + " ");
        }
        System.out.println();
    }

    public void printAllocationSet(){
        System.out.print("Process " + id + " Alloc: ");
        for (int i=0; i < Max.length; i++) {
           System.out.print(Allocation[i] + " ");
        }
        System.out.println();
    }
}