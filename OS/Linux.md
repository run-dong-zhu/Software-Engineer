# Linux Notes #

## Linux Process ##

- Each process has a process ID and has its parent process, excetpt process 1 (init process)
- Process 1 PPID(Parent Process ID) is 0, which is a Linux Kernel
- System can be broken into 2 pieces, Kernel space and User Space

### Fork() ###

#### What happens when type ls -l ####

The current process bash shell forks into two process. The copy of itself replaced by "ls" (Child process) and run. This called **fork** and **exec**

## Linux ##

## TBD ##