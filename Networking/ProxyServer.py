#Michael Gentile
#Connor Schmidt
#December 2nd 2017
#Project 02

# Does not work with HTTPS. All URLs provided for example were HTTP only.
# Some content doesn't display (especially at Yahoo). We are assuming this is because of timing/bandwidth issues with Python sockets.

#start imports
from socket import *
import sys
import thread
import urllib2
#end imports

def main():
	#start main
    serverSocket = socket(AF_INET, SOCK_STREAM)
    try:
		#start try
        PORT_NUMBER = int(raw_input("Enter a port number: "))
		#end try
    except ValueError:
		#start escape
        #print("Ports can only be numbers. The program will quit now.")
        sys.exit(1)
		#end escape

    #Prepare a sever socket
    try:
		#start try
        serverSocket.bind(('', PORT_NUMBER))
        serverSocket.listen(1)
		#end try
    except Exception:
		#start exception
        #print "failure"
        sys.exit(1)
		#end exception

    while True:
		#start while
        #Establish the connection
        connectionSocket, addr = serverSocket.accept()
        thread.start_new_thread(connThread, (connectionSocket, addr))
		#end while
    serverSocket.close()
    sys.exit()
	#end main
#end of program


def connThread(connectionSocket, addr):
	#start connThread
    failStrings=['Paris Hilton', 'SpongeBob', 'Britney Spears', 'Donald Trump']

    try:
		#start try
        #Get the HTTP request from the browser
        message = connectionSocket.recv(4096)
        # CONNECT was part of SSL requests.
        if 'CONNECT' not in message:
			#start if
            badContent=False
            badURL=False

            http_pos = message.find("://")  # find pos of ://

            if (http_pos == -1):
				#start if
                url = message
				#end if
            else:
				#start else
                url = message[(http_pos + 3):]  # beginning of the request URL
				#end else
            http_onePos=url.find(" HTTP/1.0") #end of the request URL
            http_elevenPos = url.find(" HTTP/1.1") #end of the request URL

            if (http_onePos == -1 and http_elevenPos== -1):
				#start if
                url=url
				#end if
            elif (not http_onePos==-1):
				#start elif
                url=url[:http_onePos]
				#end elif
            elif (not http_elevenPos==-1):
				#start elif
                url=url[:http_elevenPos]
				#end elif

            #make sure the URL is not null or 0 length
            if url and len(url) > 0:
				#start if
                if "https" in message:
					#start if
                    url = "https://" + url
					#end if
                else:
					#start else
                    url = "http://" + url # url doens't have HTTP declaration, so add one.
					#end else

                #download the content
                proxy_handler = urllib2.ProxyHandler({})
                opener = urllib2.build_opener(proxy_handler)
                opener.add_handler(urllib2.HTTPSHandler())
                urllib2.install_opener(opener)
                response = urllib2.urlopen(url)

                #check if any of the forbidden stuff is in the content
                fullResponse = response.read()
                for x in failStrings:
					#start for
                    if x.lower() in url.lower():
						#start if
                        badURL = True
						#end if
                        break
                    if x.lower() in fullResponse.lower():
						#start if 
                        badContent = True
						#end if
                        break
					#end for
                #check if any of the forbidden stuff is in the URL.

                if not badContent and not badURL:
					#start if
                    #print "GOOD"
                    #output normally

                    # Send one HTTP header line into socket
                    # Fill in start
                    connectionSocket.send("HTTP/1.1 200 OK\n".encode())

                    contentType = "html"
					#start of switching
                    if ".css" in url:
                        contentType = "css"
                    elif ".js" in url:
                        contentType = "javascript"
                    elif ".png" in url:
                        contentType = "image"
                    elif ".jpeg" in url:
                        contentType = "image"
                    elif ".jpg" in url:
                        contentType = "image"
					#end of switching
                    contentType = "Content-Type: text/" + contentType + "\n\n"
                    connectionSocket.send(contentType.encode())

                    response = urllib2.urlopen(url)
                    for line in response:
						#start for
                        connectionSocket.send(line)

						#end for
                    connectionSocket.send("\r\n".encode())
                    connectionSocket.close()
                elif badContent:
					#start elif
                    ##print "BAD CONTENT"
                    connectionSocket.send('HTTP/1.1 302 Found\nLocation: http://ceclnx01.eas.miamioh.edu/~gomezlin/error2.html\n\n'.encode())
                    connectionSocket.close()
					#end elif
                elif badURL:
					#start elif
                    ##print "BAD URL"

                    connectionSocket.send('HTTP/1.1 302 Found\nLocation: http://ceclnx01.eas.miamioh.edu/~gomezlin/error.html\n\n'.encode())
                    connectionSocket.close()
					#start elif

        connectionSocket.close()
		#end try
    except IOError:
		# start except
        #print "IO Error"
        
        # Send response message for file not found
        connectionSocket.send('HTTP/1.1 404 Not Found\r\n\r\n')
        # Close client socket
        connectionSocket.close()
        # end except
        # end while

#start program
if __name__ == '__main__':
    main()
#end program