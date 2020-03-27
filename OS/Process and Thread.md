# Process and Thread #

## Process ##

- Process is an instance of program.
- Any command that given to Linux machine starts a new process.

### Types of Process ###

- Foreground Process: Run on the screen needs input from user
- Backgound Process: Do not need user input (e.g. antivirus)

### Parent and Child Process ###

In both UNIX and Windows systems, after a process is created, the parent and child have their own distinct address spaces. If either process changes a word in its address space, the change is not visible to the other process. In UNIX, the child’s initial address space is a copy of the parent’s, but there are definitely two distinct address spaces involved; **NO** writable memory is shared. Some UNIX implementations share the program text between the two since that cannot be modified. Alternatively, the child may share all of the parent’s memory, but in that case the memory is shared copy-on-write, which means that whenever either of the two wants to modify part of the memory, that chunk of memory is explicitly copied first to make sure the modification occurs in a private memory area. Again, no writable memory is shared.

When a process is created, the parent is given a special token (called a handle) that it can use to control the child. However, it is free to pass this token to some other process, thus invalidating the hierarchy. Processes in UNIX cannot disinherit their children.

### Process Termination ###

1. Normal exit (voluntary).
2. Error exit (voluntary).
3. Fatal error (involuntary).
4. Killed by another process (involuntary).

### Process States ###

1. Running (actually using the CPU at that instant).
2. Ready (runnable; temporarily stopped to let another process run).
3. Blocked (unable to run until some external event happens).

![process states](https://www.researchgate.net/profile/Mohsen_Sharifi/publication/268347340/figure/fig6/AS:295440944779286@1447450018770/Three-state-transition-diagram.png)

### Process Interrupt ###

To implement the process model, the operating system maintains a table (an array of structures), called the **process table**, with one entry per process.

Associated with each I/O class is a location (typically at a fixed location near the bottom of memory) called the **interrupt vector**. It contains the address of the interrupt service procedure. Suppose that user process 3 is running when a disk interrupt happens. User process 3’s program counter, program status word, and sometimes one or more registers are pushed onto the (current) stack by the interrupt hardware. The computer then jumps to the address specified in the interrupt vector. That is all the hardware does. From here on, it is up to the software, in particular, the interrupt service procedure.

**All** interrupts start by saving the registers, often in the process table entry for the current process. Then the information pushed onto the stack by the interrupt is removed and the stack pointer is set to point to a temporary stack used by the process handler.

Skeleton of what the lowest level of the operating system does when an interrupt occurs:

1. Hardware stacks program counter, etc.
2. Hardware loads new program counter from interrupt vector.
3. Assembly-language procedure saves registers.
4. Assembly-language procedure sets up new stack.
5. C interrupt service runs (typically reads and buffers input).
6. Scheduler decides which process is to run next.
7. C procedure returns to the assembly code.
8. Assembly-language procedure starts up new current process.

### Process Priority ###


## Thread ##

https://www.nixtutor.com/linux/changing-priority-on-linux-processes/

[Youtube Link](https://youtu.be/P8GrPOpD8Sk)