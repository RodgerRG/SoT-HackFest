package database;

import java.util.Collection;

import models.EventModel;
import models.EventModel.EventType;
import models.UserModel;

public interface Database {
	
	public UserModel getUser(int userID);
	
	public void addUser(UserModel user);
	
	public EventModel getEvent(int userID, EventType type);
	
	public void addEvent(EventModel event);
	
}
