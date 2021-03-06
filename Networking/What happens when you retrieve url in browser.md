**Attention:** this is an extremely rough and oversimplified sketch, assuming the simplest possible HTTP request (no HTTPS, no HTTP2, no extras), simplest possible DNS, no proxies, single­stack IPv4, one HTTP request only, a simple HTTP server on the other end, and no problems in any step. This is, for most contemporary intents and purposes, an unrealistic scenario; all of these are far more complex in actual use, and the tech stack has become an order of magnitude more complicated since this was written. With this in mind, the following timeline is still somewhat valid:
1. browser checks cache; if requested object is in cache and is fresh, skip to #9
2. browser asks OS for server's IP address
3. OS makes a DNS lookup and replies the IP address to the browser
4. browser opens a TCP connection to server (this step is much more complex
with HTTPS)
5. browser sends the HTTP request through TCP connection
6. browser receives HTTP response and may close the TCP connection, or reuse
it for another request
7. browser checks if the response is a redirect or a conditional response (3xx
result status codes), authorization request (401), error (4xx and 5xx), etc.; these
are handled differently from normal responses (2xx)
8. if cacheable, response is stored in cache
9. browser decodes response (e.g. if it's gzipped)
10. browser determines what to do with response (e.g. is it a HTML page, is it an
image, is it a sound clip?)
11. browser renders response, or offers a download dialog for unrecognized types

Again, discussion of each of these points have filled countless pages; take this only as a summary, abridged for the sake of clarity. Also, there are many other things happening in parallel to this (processing typed­in address, speculative prefetching, adding page to browser history, displaying progress to user, notifying plugins and extensions, rendering the page while it's downloading, pipelining, connection tracking for keep­alive, cookie management, checking for malicious content etc.) ­ and the whole operation gets an order of magnitude more complex with HTTPS (certificates and ciphers and pinning, oh my!).
