**TCP**

Transmission Control Protocol (TCP)
TCP provides **reliable, ordered, and error-checked** delivery of a stream of octets (bytes) between applications running on hosts communicating via an IP network.

TCP segment structure (resource: [WiKi](https://en.wikipedia.org/wiki/Transmission_Control_Protocol#TCP_segment_structure)):

![Image of TCP segment structure](https://lh3.googleusercontent.com/proxy/LTeZc-aONTQahvqCRNU0cFu5MTdFEEDxBDCWBBeB9HFkXHZyoEU9KtEufLJ3OHQl7VIbNAMLRPKEVWgZLepl3RYfxmw9m0A8WSTg2xRcRjeBptYfcj0-2iXmXubYSA)
1. Source port (16 bits)
    Identifies the sending port.
2. Destination port (16 bits)
    Identifies the receiving port.
3. Sequence number (32 bits)
    as a dual role:
        If the SYN flag is set (1), then this is the initial sequence number. The sequence number of the actual first data byte and the acknowledged number in the corresponding ACK are then this sequence number plus 1.
        If the SYN flag is clear (0), then this is the accumulated sequence number of the first data byte of this segment for the current session.
4. Acknowledgment number (32 bits)
    If the ACK flag is set then the value of this field is the next sequence number that the sender of the ACK is expecting. This acknowledges receipt of all prior bytes (if any). The first ACK sent by each end acknowledges the other end's initial sequence number itself, but no data.
5. Data offset (4 bits)
    Specifies the size of the TCP header in 32-bit words. The minimum size header is 5 words and the maximum is 15 words thus giving the minimum size of 20 bytes and maximum of 60 bytes, allowing for up to 40 bytes of options in the header. This field gets its name from the fact that it is also the offset from the start of the TCP segment to the actual data.
6. Reserved (3 bits)
    For future use and should be set to **zero**.
7. Flags (9 bits)
    Contains 9 1-bit flags (control bits) as follows:
8. NS (1 bit): ECN-nonce - concealment protection[a]
9. CWR (1 bit): 
10. ECE (1 bit): 
11. URG (1 bit): Indicates that the Urgent pointer field is significant
12. ACK (1 bit): Indicates that the Acknowledgment field is significant. All packets after the initial SYN packet sent by the client should have this flag set.
13. PSH (1 bit): Push function. Asks to push the buffered data to the receiving application.
14. RST (1 bit): Reset the connection
15. SYN (1 bit): Synchronize sequence numbers. Only the first packet sent from each end should have this flag set. Some other flags and fields change meaning based on this flag, and some are only valid when it is set, and others when it is clear.
16. FIN (1 bit): Last packet from sender
17. Window size (16 bits)
18. Checksum (16 bits)
19. Urgent pointer (16 bits)

![TCP](https://docs.oracle.com/cd/E18752_01/html/816-4554/figures/ipov.fig88.png)

** TCP V.S. UDP**

|               | TCP           | UDP   |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |


TCP
UDP
Reliability
connection-oriented protocol
connectionless protocol
Ordered
Yes
No
Weight
Heavy
Light
Streaming
Data read as stream, one end one start
Datagrams Packets are sent individually
Example
TCP 80, SMTP 25, FTP 21
DNS 53, VoIP
