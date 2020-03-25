# Linux Notes #

## Linux Process ##

- Each process has a process ID and has its parent process, excetpt process 1 (init process)
- Process 1 PPID(Parent Process ID) is 0, which is a Linux Kernel
- System can be broken into 2 pieces, Kernel space and User Space

### Fork() ###

#### What happens when type ls -l ####

The current process bash shell forks into two process. The copy of itself replaced by "ls" (Child process) and run. This called **fork** and **exec**

## Linux ##

## Linux Command ##
```bash
bobby@bobby-Lenovo-G470:~$ ps
  PID TTY          TIME CMD
22011 pts/7    00:00:00 bash
22028 pts/7    00:00:00 ps
```
Current process run on the shell

```
bobby@bobby-Lenovo-G470:~$ ps -f
UID        PID  PPID  C STIME TTY          TIME CMD
bobby    22011  3075  0 14:42 pts/7    00:00:00 bash
bobby    22029 22011  0 14:42 pts/7    00:00:00 ps -f
```
```
bobby@bobby-Lenovo-G470:~$ sleep 360
^Z
[1]+  Stopped                 sleep 360
bobby@bobby-Lenovo-G470:~$ jobs
[1]+  Stopped                 sleep 360
```

bobby@bobby-Lenovo-G470:~$ sleep 360
^Z
[1]+  Stopped                 sleep 360
bobby@bobby-Lenovo-G470:~$ jobs
[1]+  Stopped                 sleep 360
bobby@bobby-Lenovo-G470:~$ jobs
[1]+  Stopped                 sleep 360
bobby@bobby-Lenovo-G470:~$ fg
sleep 360
^Z
[1]+  Stopped                 sleep 360
bobby@bobby-Lenovo-G470:~$ bg
[1]+ sleep 360 &
bobby@bobby-Lenovo-G470:~$ ps f
  PID TTY      STAT   TIME COMMAND
14300 pts/6    Ss+    0:00 /bin/bash
22011 pts/7    Ss     0:00 bash
22390 pts/7    S      0:00  \_ sleep 360
22424 pts/7    R+     0:00  \_ ps f
 3082 pts/1    Ss+    0:00 bash


bobby@bobby-Lenovo-G470:~$ kill -l
 1) SIGHUP	 2) SIGINT	 3) SIGQUIT	 4) SIGILL	 5) SIGTRAP
 6) SIGABRT	 7) SIGBUS	 8) SIGFPE	 9) SIGKILL	10) SIGUSR1
11) SIGSEGV	12) SIGUSR2	13) SIGPIPE	14) SIGALRM	15) SIGTERM
16) SIGSTKFLT	17) SIGCHLD	18) SIGCONT	19) SIGSTOP	20) SIGTSTP
21) SIGTTIN	22) SIGTTOU	23) SIGURG	24) SIGXCPU	25) SIGXFSZ
26) SIGVTALRM	27) SIGPROF	28) SIGWINCH	29) SIGIO	30) SIGPWR
31) SIGSYS	34) SIGRTMIN	35) SIGRTMIN+1	36) SIGRTMIN+2	37) SIGRTMIN+3
38) SIGRTMIN+4	39) SIGRTMIN+5	40) SIGRTMIN+6	41) SIGRTMIN+7	42) SIGRTMIN+8
43) SIGRTMIN+9	44) SIGRTMIN+10	45) SIGRTMIN+11	46) SIGRTMIN+12	47) SIGRTMIN+13
48) SIGRTMIN+14	49) SIGRTMIN+15	50) SIGRTMAX-14	51) SIGRTMAX-13	52) SIGRTMAX-12
53) SIGRTMAX-11	54) SIGRTMAX-10	55) SIGRTMAX-9	56) SIGRTMAX-8	57) SIGRTMAX-7
58) SIGRTMAX-6	59) SIGRTMAX-5	60) SIGRTMAX-4	61) SIGRTMAX-3	62) SIGRTMAX-2
63) SIGRTMAX-1	64) SIGRTMAX	


bobby@bobby-Lenovo-G470:~$ ls -al
total 128
drwxr-xr-x 20 bobby bobby 4096 Mar 24 18:53 .
drwxr-xr-x  4 root  root  4096 May  9  2019 ..
-rw-------  1 bobby bobby  732 Mar 24 18:41 .bash_history
-rw-r--r--  1 bobby bobby  220 May  9  2019 .bash_logout
-rw-r--r--  1 bobby bobby 3771 May  9  2019 .bashrc
drwx------ 14 bobby bobby 4096 Jul  2  2019 .cache
drwx------  3 bobby bobby 4096 May  9  2019 .compiz
drwx------ 17 bobby bobby 4096 Mar 24 18:53 .config
drwxr-xr-x  2 bobby bobby 4096 May  9  2019 Desktop
-rw-r--r--  1 bobby bobby   25 May  9  2019 .dmrc
drwxr-xr-x  3 bobby bobby 4096 Mar 24 18:47 Documents
drwxr-xr-x  2 bobby bobby 4096 Mar 24 18:52 Downloads
-rw-r--r--  1 bobby bobby 8980 May  9  2019 examples.desktop
drwx------  2 bobby bobby 4096 May  9  2019 .gconf
drwx------  3 bobby bobby 4096 Mar 24 18:43 .gnome
drwx------  3 bobby bobby 4096 Mar 24 18:42 .gnupg
-rw-------  1 bobby bobby 2896 Mar 24 18:42 .ICEauthority
drwx------  3 bobby bobby 4096 May  9  2019 .local
drwx------  5 bobby bobby 4096 May  9  2019 .mozilla
drwxr-xr-x  2 bobby bobby 4096 May  9  2019 Music
drwxr-xr-x  2 bobby bobby 4096 May  9  2019 Pictures
drwx------  3 bobby bobby 4096 May  9  2019 .pki
-rw-r--r--  1 bobby bobby  655 May  9  2019 .profile
drwxr-xr-x  2 bobby bobby 4096 May  9  2019 Public
-rw-r--r--  1 bobby bobby    0 May  9  2019 .sudo_as_admin_successful
drwxr-xr-x  2 bobby bobby 4096 May  9  2019 Templates
drwxr-xr-x  2 bobby bobby 4096 May  9  2019 Videos
drwxrwxr-x  3 bobby bobby 4096 Mar 24 18:53 .vscode
-rw-------  1 bobby bobby   62 Mar 24 18:42 .Xauthority
-rw-------  1 bobby bobby   82 Mar 24 18:42 .xsession-errors
-rw-------  1 bobby bobby 1389 Mar 24 18:41 .xsession-errors.old
