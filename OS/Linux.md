# Linux Notes #

## Linux Process ##

- Each process has a process ID and has its parent process, excetpt process 1 (init process)
- Process 1 PPID(Parent Process ID) is 0, which is a Linux Kernel
- System can be broken into 2 pieces, Kernel space and User Space

### Fork() ###

In UNIX, there is only one system call to create a new process: **fork**. This call creates an exact clone of the calling process. After the fork, the two processes, the parent and the child, have the same memory image, the same environment strings, and the same open files. That is all there is. Usually, the child process then executes execve or a similar system call to change its memory image and run a new program. For example, when a user types a command, say, sort, to the shell, the shell forks off a child process and the child executes sort. The **reason** for this two-step process is to allow the child to manipulate its file descriptors after the fork but before the execve in order to accomplish redirection of standard input, standard output, and standard error.

#### What happens when type ls -l ####

The current process bash shell forks into two process. The copy of itself replaced by "ls" (Child process) and run. This called **fork** and **exec**

## Linux ##

## TBD ##