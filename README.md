# client-server-chat-in-java
this is a basic application in java that allows the server and client to communcate with each other exchanging messages.
the server code creates a serverSocket on a specific port. the server socket listens for incoming client connections.
once a client connects, the server accepts the connection and creates a socket object to represent the communication channel with the client.
both the server and client create seperate threads to handle incoming and outgoing messsages.
The code includes basic error handling using try..catch blocks to catch potential IOExceptions that might occur during network operations.
This code provides a fundamental framework for a chat application.
