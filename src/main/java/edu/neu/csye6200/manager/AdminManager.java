package edu.neu.csye6200.manager;

public enum AdminManager
{
	INSTANCE;
	public static AdminManager getInstance()
	{
		return INSTANCE;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	private boolean loggedIn;
}
