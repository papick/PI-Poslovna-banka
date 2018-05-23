package poslovna_banka.resource.response;

import java.util.ArrayList;

import poslovna_banka.model.Activity;

public class ResponseActivities {

	private ArrayList<Activity> activities;

	public ResponseActivities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseActivities(ArrayList<Activity> activities) {
		super();
		this.activities = activities;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
}
