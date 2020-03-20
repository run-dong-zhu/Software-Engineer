# Environment Variable #

## What is a Variable ##

In computer science, a variable is a location for storing a value which can be a filename, text, number or any other data.

The value thus stored can be displayed, deleted, edited and re-saved.

## What are Environment variables ##

Environment variables are **dynamic** values which affect the processes or programs on a computer. They exist in every operating system, but types may vary. Environment variables can be created, edited, saved, and deleted and give information about the system behavior.

Environment variables can change the way a software/programs behave.

### Platform = OS + processor ###

## How to set up an environment variable in Shell（Linux) ##

To set variable only for current shell:

```console
VARNAME="my value"
```

To set it for current shell and all processes started from current shell:

```console
export VARNAME="my value"      # shorter, less portable version
```

To set it permanently for all future bash sessions add such line to your **.bashrc** file in your $HOME directory.

To set it permanently, and system wide (all users, all processes) add set variable in **/etc/environment:**

```console
sudo -H gedit /etc/environment
```

This file only accepts variable assignments like: VARNAME="my value",
Do not use the export keyword here.

You need to logout from current user and login again so environment variables changes take place.

To see variable you set up:

```console
echo $VARIABLE
```

Delete Variable:

```console
unset VARIABLE
```
