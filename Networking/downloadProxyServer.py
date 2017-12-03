#Michael Gentile
#October 16th 2017
#Project 01

from socket import *
import sys
import thread
import urllib2


def main():
    serverSocket = socket(AF_INET, SOCK_STREAM)
    try:
        PORT_NUMBER = int(raw_input("Enter a port number: "))
    except ValueError:
            print("Ports can only be numbers. The program will quit now.")
            sys.exit(1)

    #Prepare a sever socket
    try:
        serverSocket.bind(('', PORT_NUMBER))
        serverSocket.listen(1)
    except Exception:
        print "failure"
        sys.exit(1)
    #start while
    while True:
        #Establish the connection
        connectionSocket, addr = serverSocket.accept()
        thread.start_new_thread(connThread, (connectionSocket, addr))

    serverSocket.close()
    sys.exit()

#end of program


def connThread(connectionSocket, addr):
    failStrings=['Paris Hilton', 'SpongeBob', 'Britney Spears', 'Donald Trump']
    try:
        # start try
        message = connectionSocket.recv(4096)
        if 'CONNECT' not in message:
            badContent=False
            badURL=False
            #print "This is the message : ", message
            http_pos = message.find("://")  # find pos of ://
            # now trim to HTTP 1.0

            if (http_pos == -1):
                temp = message
            else:
                temp = message[(http_pos + 3):]  # get the rest of url

            http_onePos=temp.find(" HTTP/1.0")
            #now trim to HTTP 1.1
            http_elevenPos = temp.find(" HTTP/1.1")

            if (http_onePos == -1 and http_elevenPos== -1):
                temp=temp
            elif (not http_onePos==-1):
                temp=temp[:http_onePos]
            elif (not http_elevenPos==-1):
                temp=temp[:http_elevenPos]

            print "temp var", temp;

            #download the web page.


            if "https" in message:
                response = urllib2.urlopen("https://", temp)
                webContent = response.read()
            else:
                response = urllib2.urlopen("http://", temp)
                webContent = response.read()

            #check if any of the forbidden stuff is in the content
            for x in failStrings:
                if failStrings[x] in webContent:
                    badContent=True
                if failStrings[x] in temp:
                    badURL=True
            #check if any of the forbidden stuff is in the URL.

            if  not badContent and not badURL:
                #output normally
                v= 'fake to get rid of error'
            elif badContent:
                #output the error 2 screen
                filename = "error2.html"
                f = open(filename)
                outputdata = f.read()
                f.close()
                # Send one HTTP header line into socket
                # Must be encoded otherwise the first run makes it plain text.
                connectionSocket.send('HTTP/1.1 200 OK\r\n\r\n'.encode())
                # Send the content of the requested file to the client
                # start for
                for i in range(0, len(outputdata)):
                    # send each line of the file in an encoded format
                    connectionSocket.send(outputdata[i].encode())
                # end for
                # send the end of file so that it doesn't run over
                connectionSocket.send("\r\n".encode())
                connectionSocket.close()
                # end try
            elif badURL:
                # neither of these are testted.
                f = open('error1.html')
                outputdata = f.read()
                f.close()
                # Send one HTTP header line into socket
                # Must be encoded otherwise the first run makes it plain text.
                connectionSocket.send('HTTP/1.1 200 OK\r\n\r\n'.encode())
                # Send the content of the requested file to the client
                # start for
                for i in range(0, len(outputdata)):
                    # send each line of the file in an encoded format
                    connectionSocket.send(outputdata[i].encode())
                # end for
                # send the end of file so that it doesn't run over
                connectionSocket.send("\r\n".encode())
                connectionSocket.close()
        connectionSocket.close()
    except IOError:
        # start except
        # Send response message for file not found
        connectionSocket.send('HTTP/1.1 404 Not Found\r\n\r\n')
        # Close client socket
        connectionSocket.close()
        # end except
        # end while


if __name__ == '__main__':
    main()