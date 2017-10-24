public class Observer {
	private int id;
	private Subject subject;

	public Observer(int id) {
		this.id = id;
	}

	public int getID(){
		return id;
	}
	
	public void subscribe(Subject sub) {
		this.subject = sub;
	}
	
	public void unsubscribe() {
		subject.unregister(this);
	}
	
	public void update(){
		// TODO: The observer will exit the queue 
		// once the notification has value >= this.id+7.
		// Don't forget they will leave if it is their number too.
		int ready=Integer.parseInt(subject.getMessage());
		System.out.println(String.format("%s is ready"
				, ready));
		if(ready>=this.id+7 || ready== this.id) {
			this.unsubscribe();
			System.out.println(String.format("%s is left"
					, this.id));
		}
	}
}
