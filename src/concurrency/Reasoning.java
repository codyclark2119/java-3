package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        System.out.println("A process is an executing program whereas, the thread is a small part of a process. Each process has its own address space whereas, the threads of the same process share the address space as that of the process.\n");
        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
        System.out.println("Start creates new thread while run doesn't create any thread and simply execute in current thread like a normal method call.\n");
    }
    public void run() {
        distinguish();
    }
}

