""" Below, see a sample of /var/log/messages.

Jan 20 03:25:08 fakehost logrotate: ALERT exited abnormally with [1]
Jan 20 03:25:08 fakehost logrotate: ALERT exited abnormally with [1]
Jan 20 03:25:09 fakehost run-parts(/etc/cron.daily)[20447]: finished logrotate

Write a script which parses /var/log/messages and generates a
CSV with two columns: minute, number_of_messages in sorted time order.
---------- begin sample output ----------
minute, number_of_messages
Jan 20 03:25,2
Jan 20 03:26,2
Jan 20 03:30,2
Jan 20 05:03,1
Jan 20 05:20,1
Jan 20 05:22,6
---------- end sample output ------------
"""

import csv

def Parsing():
    logs = open("fakelog1.txt", "r")
    
    output = {}

    minute = len("Jan 20 03:25")

    for log in logs:
        k = log[:minute]
        v = output.get(k, 0) + 1
        output[k] = v

    print(output)

    with open("output.csv", "w") as f:
        for key in output.keys():
            f.write("%s, %s\n"%(key, output[key]))

Parsing()