import java.awt.*;
import javax.swing.*;
import java.applet.Applet;
import java.io.*;

public class banker implements Runnable {
	int Max [][] = new int [5][4];
	int Allocation [][]= new int [5][4];
	int request[] = new int [4];
	int available[] = new int [4];
	int p;
        int speed;
	inputFrame input;
	animationFrame animate;
    status st;
    int flagList [] = new int [5];

	public boolean processFinishp(){
		boolean finish = true;
		for(int i=0;i<5;i++){
	    		if (!processList[i].returnFinish()) {
                		finish = false;
                		break;
	    		}
		}
		return finish;
  	}

	public Thread thread;

	SimpleProcess processList [];

	public banker(int[][] ma, int[][] alloc, int[] avail, int[] req,
          int proc, inputFrame in, animationFrame an, status sta, int anim_spd){
		Max = ma;
		Allocation = alloc;
		request = req;

		p = proc;
                speed = anim_spd;
		available = avail;
		input = in;
		animate = an;
                st = sta;

		thread = new Thread(this, "banker");
		thread.start();
	}

	public void run() {

		ManagementData md = new ManagementData(available, animate, st);

		for (int i=0; i<5; i++)
		  new SimpleProcess(i, md, Max[i], Allocation[i], animate, st);

    		System.out.println("* Initial State *");
                st.upStatus("* Initial State *") ;
    		md.printAvailable();
    		md.printNeed();
    		md.printAllocation();
                animate.repaint();
                try{thread.sleep(400*speed);}catch(Exception e){}

		System.out.println("-- Initial Request Check --");
                st.upStatus("-- Initial Request Check --") ;
                System.out.println(md.checkSafety());
                System.out.println();
                try{thread.sleep(400*speed);}catch(Exception e){}

    		boolean flag = md.initialResourceRequest(p, request);
                try{thread.sleep(400*speed);}catch(Exception e){}

                if (flag==false) {
                  System.out.println("Initial request NOT possible!!! Please modify your inputs...");
                  st.upStatus("Initial request NOT possible!!! Please modity your inputs...") ;
                  thread.stop() ;
                }
                else {
                  animate.repaint();
                  System.out.println("Initial request possible...");
                  st.upStatus("Initial request possible, now pretend to allocate initial request to the process...");
                }try{thread.sleep(400*speed);}catch(Exception e){}

    		processList  = md.returnProcessList();
    		int request[] = new int[4];

		while (!processFinishp()){
                        if (checkFlagList()) {
                          System.out.println("Deadlock!!!");
                          st.upStatus("Unsafe state!!! Initial request might generate deadlock...");
                          thread.stop();
                          break;
                        }

                        boolean pFlag = false;

			int action = (int)(Math.random() * 2);
			int process = (int)(Math.random() * 5);

			if (action == 0 && !processList[process].returnFinish())
		    		processList[process].Finish();
			else{
                          int need [] = processList[process].returnNeed();

                          request = need;

	    		  for (int i=0;i<4;i++)
                            if (request[i] != 0){
                	      pFlag = md.resourceRequest(process, request);
                	      if (pFlag)
                                clearFlagList();
                              else if (!pFlag)
                                addFlagList(process);
                              break;
	    		    }
			}
			try{thread.sleep(400*speed);} catch (Exception e){}
		}
		System.out.println("program ended successfully...");
		st.upStatus("Safe state... Initial request does not generate deadlock...");
	}

        private void addFlagList(int pid) {
            flagList[pid] = 1;
        }

        private void clearFlagList() {
            for (int i=0; i<5; i++)
                flagList[i] = 0;
        }

        private boolean checkFlagList() {
            boolean result = true;
            for (int i=0; i<5; i++) {
                if (flagList[i]==0) {
                    result = false;
                    break;
                }
            }
            return result;
        }


}