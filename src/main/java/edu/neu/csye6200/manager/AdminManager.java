package edu.neu.csye6200.manager;

import edu.neu.csye6200.model.Teacher;

public enum AdminManager
{
	INSTANCE;
	public static AdminManager getInstance()
	{
		return INSTANCE;
	}

	public boolean isLoggedIn() {
		return loggedInTeacher != null;
	}
	public void logOut() { setLoggedInTeacher(null); }
	public Teacher getLoggedInTeacher() { return loggedInTeacher; }
	public void setLoggedInTeacher(Teacher loggedInTeacher) { this.loggedInTeacher = loggedInTeacher; }
	private Teacher loggedInTeacher;
}
