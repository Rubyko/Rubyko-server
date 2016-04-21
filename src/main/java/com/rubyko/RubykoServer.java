package com.rubyko;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import com.rubyko.rmi.RmiClient;
import com.rubyko.rmi.RmiServer;
import com.rubyko.server.login.LoginUserServiceImpl;
import com.rubyko.server.login.RegisterUserServiceImpl;
import com.rubyko.shared.boss.login.LoginUserService;
import com.rubyko.shared.boss.login.RegisterUserService;

public class RubykoServer {

	public static void main(String[] args) { 
		// create the RMI server
		RmiServer rpcServer = new RmiServer(6789); 
		// register a service under the name example
		// the service has to implement an interface for the magic to work
		rpcServer.registerService(LoginUserService.objectName1, new LoginUserServiceImpl());
		rpcServer.registerService(RegisterUserService.objectName1, new RegisterUserServiceImpl());
		// start the server at port 6789
		rpcServer.start();
	}
}
