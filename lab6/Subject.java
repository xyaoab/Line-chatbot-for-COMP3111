import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subject {
	private List<Observer> observers;
	private String message;
	private boolean changed;

	public Subject() {
		observers = new ArrayList<Observer>();
		message = null;
		changed = false;
	}

	public void register(Observer obj) {
		if ( !observers.contains(obj) ) observers.add(obj);
	}

	public void unregister(Observer obj) {
		observers.remove(obj);
	}

	/**
	 *  Previously u let the Subject to decide which observer should "unsubscribe"
	 *  yet this is not the reality:
	 *  it should be, you announce information to everyone
	 *  and let each observers to decide whether they want to quit or not;
	 *  
	 * */
	public void notifyObservers() {
		// TODO: notify every observers
		/*for (Observer observer: new ArrayList<>(observers)){
			observer.update();
		}*/
		for(Observer obj:observers) {
			obj.update();
		}	
	}

	public void setMessage(String msg) {
		this.message=msg; // save the current ready id to Class field "message" -. notifyObservers() can read it
		this.changed=true;
		notifyObservers();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	public List<Observer> getQueue() {
		return observers;
	}
}
