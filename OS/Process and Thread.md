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

![process states](https://www.google.com/url?sa=i&url=https%3A%2F%2Fcodescracker.com%2Foperating-system%2Fprocess-states.htm&psig=AOvVaw0tBV0ftxODzITjemR5-Tbj&ust=1585201861508000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMDx7ab3tOgCFQAAAAAdAAAAABAD)

### Process Priority ###
https://www.nixtutor.com/linux/changing-priority-on-linux-processes/

[Youtube Link](https://youtu.be/P8GrPOpD8Sk)